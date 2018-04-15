package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import controller.*;

public class SignupPage
{
	public GridPane pane;

	SignupPage()
	{
		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);

		TextField firstNameField = new TextField();
		TextField lastNameField = new TextField();
		TextField emailField = new TextField();
		TextField userNameField = new TextField();
		TextField passwordField = new TextField();
		TextField secretQues = new TextField();

		Label loginStatus = new Label();
		loginStatus.setTextFill(Color.RED);
		loginStatus.setAlignment(Pos.CENTER);
		loginStatus.setPadding(new Insets(20));

		firstNameField.setPromptText("First Name");
		lastNameField.setPromptText("Last Name");
		emailField.setPromptText("Email");
		userNameField.setPromptText("User Name");
		passwordField.setPromptText("Password");
		secretQues.setPromptText("What was your first pet's name?");

		Button signup = new Button("SignUp");

		pane.add(firstNameField,0,0);
		pane.add(lastNameField,0,1);
		pane.add(emailField,0,2);
		pane.add(userNameField,0,3);
		pane.add(passwordField,0,4);
		pane.add(secretQues,0,5);
		pane.add(signup,0,6);

		signup.setOnAction(e->{
			String firstName = firstNameField.getText(),
				   lastName = lastNameField.getText(),
				   email = emailField.getText(),
				   userName = userNameField.getText(),
				   secret = secretQues.getText(),
				   password = passwordField.getText();

			String requestString = "S%%"+firstName+"%%"+lastName+"%%"+email+"%%"+userName+"%%"+password+"%%"+secret;
			String auth = new Client().loginAuth(requestString);
			if(auth.equals("ERROR"))
			{
				System.out.println("email/username already in use.");
				Main.borderPane.setBottom(loginStatus);
			}
			else
			{
				loginStatus.setText("successfull!");
				Main.borderPane.setBottom(loginStatus);
			}
		});
	}
}
