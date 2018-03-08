package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application
{
	public static BorderPane borderPane = new BorderPane();

	@Override
	public void start(Stage primaryStage) throws Exception
	{

		Button loginPageButton = new Button("Login");
		Button signupPageButton = new Button("Signup");


		Label loginStatus = new Label();
		loginStatus.setTextFill(Color.RED);
		loginStatus.setAlignment(Pos.CENTER);
		loginStatus.setPadding(new Insets(20));

		HBox topPane = new HBox(10);
		topPane.setAlignment(Pos.CENTER);
		topPane.setPadding(new Insets(20,10,20,10));

		topPane.getChildren().addAll(loginPageButton,signupPageButton);

		loginPageButton.setOnAction(e->{
			borderPane.setCenter(new LoginPage().pane);
			borderPane.setBottom(loginStatus);
		});
		signupPageButton.setOnAction(e->{
			borderPane.setCenter(new SignupPage().pane);
			borderPane.setBottom(loginStatus);
		});

		borderPane.setTop(topPane);
		borderPane.setCenter(new LoginPage().pane);
		borderPane.setBottom(loginStatus);

		primaryStage.setScene(new Scene(borderPane,500,500));
		primaryStage.show();
	}
}
