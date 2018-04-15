import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;

public class assign_1 extends Application
{
	 
  public void start(Stage mystage)
  {
    TextField tf = new TextField();
     Label lb = new Label("Username :");
     Label lb_1 = new Label("Password :");    
    PasswordField pf = new PasswordField(); 
   
    Button bn1 = new Button("New User?");    
    Button bn2 = new Button("Login");
    Button bn3 = new Button("Forgot Uname/pword?"); 

    GridPane pn = new GridPane();
    pn.setHgap(20);
    pn.setVgap(20);
    pn.setConstraints(lb,4,1);
    pn.setConstraints(tf,5,1);
    pn.setConstraints(lb_1,4,2);
    pn.setConstraints(pf,5,2);
    pn.setConstraints(bn1,2,3);
    pn.setConstraints(bn2,5,3);
    pn.setConstraints(bn3,7,3);    

    pn.getChildren().addAll(tf,lb,lb_1,pf,bn1,bn2,bn3);

   Scene sn = new Scene(pn,650,300);

   mystage.setScene(sn);
   mystage.setTitle("USER END");

   //REGISTRATION WINDOW

   Stage st_1 = new Stage();

   GridPane gp1 = new GridPane();

   Label l1 = new  Label("First Name:");
   TextField tf1 = new TextField();
   Label l6 = new  Label("Last Name:");
   TextField tf4 = new TextField();
   Label l7 = new  Label("Date of Birth:");
   TextField tf5 = new TextField();
   tf5.setPromptText("in yyyy-mm-dd format");
   Label lu = new Label("Username:");
   TextField tu = new TextField();
   Label l2 = new Label("Password:");
   TextField tf2 = new TextField();
   Label l3 = new Label("Confirm Password:");
   PasswordField p1 = new PasswordField();

   Label l4 = new Label("Clue Question:");
   TextArea ta = new TextArea();
   ta.setPrefHeight(50);
   ta.setPrefWidth(200);
   Label l5 = new Label("Answer:");
   TextField tf3 = new TextField(); 
   Button b2 = new Button("Register");  

   gp1.setHgap(20);
    gp1.setVgap(20);
    gp1.setConstraints(l1,3,1);
    gp1.setConstraints(tf1,4,1);
    gp1.setConstraints(l6,3,2);
    gp1.setConstraints(tf4,4,2);
    gp1.setConstraints(l7,3,3);
    gp1.setConstraints(tf5,4,3);
	gp1.setConstraints(lu,3,4);
	gp1.setConstraints(tu,4,4);
    gp1.setConstraints(l2,3,5);
    gp1.setConstraints(tf2,4,5);
    gp1.setConstraints(l3,3,6);
    gp1.setConstraints(p1,4,6);
    gp1.setConstraints(l4,3,7);
    gp1.setConstraints(ta,4,7);
    gp1.setConstraints(l5,3,8);
    gp1.setConstraints(tf3,4,8);
    gp1.setConstraints(b2,4,9);

   gp1.getChildren().addAll(l1,tf1,l2,tf2,l3,p1,l4,ta,l5,tf3,b2,l6,l7,tf5,tf4,lu,tu);

   Scene sn2 = new  Scene(gp1,500,500);

   st_1.setTitle("REGISTER");
   st_1.setScene(sn2);     

  //FORGOT UNAME PWORD 

  Stage st_2 = new Stage();

  GridPane gp_2 = new GridPane();

   Label lb1 = new  Label("First Name :");
   TextField t1 = new TextField();
   Label lb2 = new  Label("Last Name :");
   TextField t2 = new TextField();
   Label lb3 = new  Label("Date of Birth :");
   TextField t3 = new TextField();
   t3.setPromptText("in yyyy-mm-dd format");   
   Label lb4 = new Label("Clue Question :");
   TextArea t_1 = new TextArea();
   t_1.setPrefHeight(50);
   t_1.setPrefWidth(200);
   Label lb5 = new Label("Answer :");
   TextField t4 = new TextField(); 
   Button b_2 = new Button("Submit"); 

    gp_2.setHgap(20);
    gp_2.setVgap(20);
   gp_2.add(lb1,3,1);
   gp_2.add(t1,4,1);
   gp_2.add(lb2,3,2);
   gp_2.add(t2,4,2);
   gp_2.add(lb3,3,3);
   gp_2.add(t3,4,3);
   gp_2.add(lb4,3,4);
   gp_2.add(t_1,4,4);
   gp_2.add(lb5,3,5);
   gp_2.add(t4,4,5);
   gp_2.add(b_2,4,6);

   //gp_2.addAll(lb1,t1,lb2,t2,lb3,t3,lb4,t4,t_1,lb5,t4,b_2);
   
  Scene sn3 = new Scene(gp_2,400,400);

  st_2.setScene(sn3);
  st_2.setTitle("FORGOT USERNAME/PASSWORD");

   mystage.show();

   //successful login
   
   Stage sr = new Stage();
   
   GridPane gr = new GridPane();
   Label lr = new Label("You have successfully logged in!!");
   gr.add(lr,4,4);
   Scene scr = new Scene(gr,200,200);
   sr.setScene(scr);
   
   //invalid login
   
   Stage sw = new Stage();
   
   GridPane gw = new GridPane();
   Label lw = new Label("Invalid Login credentials");
   gw.add(lw,3,3);
   Scene scw = new Scene(gw,150,150);
   sw.setScene(scw);
   
   //successful registration
   Stage reg = new Stage();
   
   GridPane geg = new GridPane();
   
   
   //unsuccessful registration
    Stage regn = new Stage();
   
   GridPane gregn = new GridPane();
  
   
   
  bn1.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
       st_1.show();
    }
   });

   bn3.setOnAction((ActionEvent ae) -> {
       st_2.show();
    });
   
   bn2.setOnAction((ActionEvent ae) -> {
       try{
           InetAddress ina = InetAddress.getLocalHost();
           Socket s = new Socket(ina.getHostName(),5000);
           ObjectOutputStream oinp = new ObjectOutputStream(s.getOutputStream());
           ObjectInputStream is = new ObjectInputStream(s.getInputStream());
           oinp.writeObject(1);
           
           oinp.writeObject(tf.getText());
           oinp.writeObject(pf.getText());
           
           int var = Integer.parseInt(is.readObject().toString());
           
           if(var == 1)
               sr.show();
           else
               sw.show();
           
           
           //oinp.close();
           //s.close();
       }
       catch(IOException | ClassNotFoundException | NumberFormatException e)
       {
       }
    });
	
	 b2.setOnAction((ActionEvent ae) -> {
             try{
                 InetAddress ina = InetAddress.getLocalHost();
                 Socket s = new Socket(ina.getHostName(),5000);
                 ObjectOutputStream oinp = new ObjectOutputStream(s.getOutputStream());
                 ObjectInputStream is = new ObjectInputStream(s.getInputStream());
                 oinp.writeObject(2);
                 
                 oinp.writeObject(tf1.getText());
                 oinp.writeObject(tf4.getText());
                 oinp.writeObject(tu.getText());
                 oinp.writeObject(tf5.getText());
                 oinp.writeObject(tf2.getText());
                 oinp.writeObject(ta.getText());
                 oinp.writeObject(tf3.getText());
                 
                 String var = is.readObject().toString();
                 
                 
                 if(var != null )
                 {
                     if(Integer.parseInt(var) == 0)
                     {
                         Label leg = new Label("You have successfully registered!");
                         geg.add(leg,4,4);
                         Scene sceg = new Scene(geg,200,200);
                         reg.setScene(sceg);
                         reg.show();
                     }
                     else{
                         Label lregn = new Label(var);
                         gregn.add(lregn,3,3);
                         Scene sregn = new Scene(gregn,300,300);
                         regn.setScene(sregn);
                         regn.show();
                     }
                 }
                 
                 
                 //oinp.close();
                 //s.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
    });
   
   
   
   b_2.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent ae){
		try{
		InetAddress ina = InetAddress.getLocalHost();
       Socket s = new Socket(ina.getHostName(),5000);
	   ObjectOutputStream oinp = new ObjectOutputStream(s.getOutputStream());
	   ObjectInputStream is = new ObjectInputStream(s.getInputStream());
	   oinp.writeObject(3);
	   
	   oinp.writeObject(t1.getText());
	   oinp.writeObject(t2.getText());
	   oinp.writeObject(t3.getText());
	   oinp.writeObject(t_1.getText());
	   oinp.writeObject(t4.getText());
	   
	    Stage f = new Stage();
     Label fu;
	 Label fp;
	 Label fl = new Label("Your username and password are:");
	 GridPane fg = new GridPane();
	 fg.add(fl,1,1);
	 
	    fu = new Label (is.readObject().toString());
	    fp = new Label (is.readObject().toString());
	   
	   fg.add(fu,2,2);
	   fg.add(fp,2,3);
	   
	   Scene fc = new Scene(fg,300,300);
	   
	   f.setScene(fc);
	   
	   f.show();
	   
	   //oinp.close();
	   //s.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
	
   });
  }
 }