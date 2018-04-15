package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import controller.*;

public class LoginPage
{
	public GridPane pane;

	LoginPage()
	{
		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);

		TextField usernameField = new TextField();
		TextField passwordField = new TextField();

		Label loginStatus = new Label();
		loginStatus.setTextFill(Color.RED);
		loginStatus.setAlignment(Pos.CENTER);
		loginStatus.setPadding(new Insets(20));

		Label forgotPasswordLabel = new Label("Forgot Password");

		usernameField.setPromptText("User Name");
		passwordField.setPromptText("Password");

		Button loginButton = new Button("Login");

		pane.add(usernameField,0,0);
		pane.add(passwordField,0,1);
		pane.add(loginButton,0,2);
		pane.add(forgotPasswordLabel,0,3);

		loginButton.setOnAction(e->{
			String usrname = usernameField.getText();
			String password = passwordField.getText();
			String requestString = "L%%"+usrname+"%%"+password;
			String auth = new Client().loginAuth(requestString);

			if(auth.equals("ERROR"))
			{
				loginStatus.setText("Either your username or password is wrong!");
				Main.borderPane.setBottom(loginStatus);
			}
			else
			{
				GridPane gridPane = new GridPane();
				gridPane.setAlignment(Pos.CENTER);

				gridPane.add(new Label("First Name    : "),0,0);
				gridPane.add(new Label("Last Name     : "),0,1);
				gridPane.add(new Label("Email         : "),0,2);
				gridPane.add(new Label("User Name     : "),0,3);
				gridPane.add(new Label("Password      : "),0,4);
				gridPane.add(new Label("Secret Answer : "),0,5);

				String [] userData = auth.split("%%");

				for(int i = 0 ; i < userData.length ; i ++)
					gridPane.add(new Label(userData[i]),1,i);

				Main.borderPane.setCenter(gridPane);
			}

		});
		forgotPasswordLabel.setOnMouseClicked(e->{
			Main.borderPane.setCenter(new ForgotPasswordPage().pane);
		});
	}
}
