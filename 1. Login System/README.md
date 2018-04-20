You are required to write client-server programs which register a new user to a website, or allow an existing user to login, or send back a forgotten username or password.

On the client side, we require a JavaFX user interface by means of which a New User may be created, an existing user may be allowed to login, and an existing user may be sent back a forgotten User-name and/or Password. There are therefore three buttons on this page: “New User?”, “Lost Username/Password” and “Login”. Against the Login button there are two text-fields, one for a User name, and another for a password.

There are therefore three cases to consider, that of a New User, of a Returning User, and of a Lost Username and/or Password.

All communication is carried out between client and server over input/output channels you have to create, using Socket & ServerSocket.

Case New User

When the New User button is clicked, the existing screen is replaced by a screen which contains labels, text-fields and a Submit button. The labels and text-fields prompt the user to enter his/her first name, last name, date of birth, email-ID, chosen User-name and password. Immediately following the password field there’s a Confirm-password field, a secret question, and a secret answer field. The email-ID, the secret question and the secret answer help recover a lost username and password.

When the fields are filled in and the Submit button is clicked, the contents of the text-fields are sent to the server. When these contents are received by the server, they are stored in a table in a MySQL database on the server.

Before storing the data in the table the server verifies that the user-name has not been duplicated. If it has been duplicated, the server requests the client to send a different-user-name.

Case Returning User

A Returning User provides his/her user-name and password, and clicks the Login button, which is also on the front page. When the Login button is clicked, the user-name and password are sent to the server, and the server sends a Welcome message back to the user if the user-name and password match against the values stored in the table, or sends a “login failed/re-enter” message if the values do not match.

Case Lost or Forgotten User-name or Password

When this button is clicked, the user is prompted to send his/her email-id. If the email-id matches with one stored in the database table, the user is asked his/her secret question. The user sends his/her response. If the response matches with the answer stored in the database table, the user is sent his/her username and password.

----------------------------------------------------------------------------------------------------------
LoginSystem1 is created using IntelliJ Idea
	LoginSystem2 is created using TextPad
	
	
The Main objective of the project is to develp a Login and Sign up System where the usere register using Registration pane and logins using Login pane. 
In Case if he forgets the password he will be able to get the details by entering his email-id.
all these details will be stored in a database backend.