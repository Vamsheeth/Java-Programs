package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import controller.*;

public class ForgotPasswordPage
{

	public GridPane pane;

	ForgotPasswordPage()
	{
		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);

		TextField emailField = new TextField();
		TextField secretAns = new TextField();

		Label loginStatus = new Label();
		loginStatus.setTextFill(Color.RED);
		loginStatus.setAlignment(Pos.CENTER);
		loginStatus.setPadding(new Insets(20));

		emailField.setPromptText("Email Id");
		secretAns.setPromptText("What was your first pet's name?");

		Button getPasswordButton = new Button("Get Password");

		pane.add(emailField,0,0);
		pane.add(secretAns,0,1);
		pane.add(getPasswordButton,0,2);

		getPasswordButton.setOnAction(e->{
			String email = emailField.getText();
			String secret = secretAns.getText();
			String requestString = "F%%"+email+"%%"+secret;
			String auth = new Client().loginAuth(requestString);

			if(auth.equals("ERROR"))
			{
				loginStatus.setText("You have entered wrong details.");
			}
			else
			{
				GridPane gridPane = new GridPane();
				gridPane.setAlignment(Pos.CENTER);
				gridPane.add(new Label("Password :"),0,0);
				gridPane.add(new Label(auth),1,0);
				Main.borderPane.setCenter(gridPane);
			}
		});
	}
}
