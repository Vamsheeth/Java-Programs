import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.sql.*;

class server_s 
{
	  
	 
	 public static void main(String [] args) throws ClassNotFoundException, IOException
	 {
		 ServerSocket ss = new ServerSocket(5000);
		 while(true)
		 {
	 Socket s = ss.accept();
	 ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
	 ObjectOutputStream outs = new ObjectOutputStream(s.getOutputStream());
	 int chck = Integer.parseInt(ois.readObject().toString());
	 
	 if(chck == 1)
	 {
	 
	 String username = (String) ois.readObject();
	 String password = (String) ois.readObject();
	 //System.out.println("the supplied username is :" + username);
	 
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
       Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT EXISTS(" + "SELECT * FROM  u_detail WHERE username = " + "'" + username + "'" + "AND" + " " + "pssword =" + "'" + password + "'" + ")");
		 rs.next();
		 int val = Integer.parseInt(rs.getObject(1).toString());
		 if(val == 1)
			 outs.writeObject(1);
		 else
			 outs.writeObject(0);
		 
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	 
	 
	 ois.close();
	 outs.close();
	 s.close();
	 }	 
	 
	 else if(chck==2)
	 {
		 String f_name = (String) ois.readObject();
	     String l_name = (String) ois.readObject();
		 String u_name = (String) ois.readObject();
		 Object dob = ois.readObject();
		 String pword = (String) ois.readObject();
		 String que = (String) ois.readObject();
		 String ans = (String) ois.readObject();
	 //System.out.println("the supplied username is :" + username);
	 
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
       Statement st = con.createStatement();
        boolean rs = st.execute("insert into u_detail values(" + "'" + f_name + "'" + "," + "'" + l_name + "'" + "," + "'" + u_name + "'" + "," + "'" + dob + "'" + "," + "'" + pword + "'" + "," + "'" + que + "'" + "," + "'" + ans + "'" + ")" );
		 
		 if(rs == true)
			 outs.writeObject(1);
		 else
			 outs.writeObject(0);
		 
	    }
		catch(Exception e)
		{
			outs.writeObject(e.getMessage());
			e.printStackTrace();
		}
	 }
	 
	 else if(chck==3)
	 {
		 String fname = (String) ois.readObject();
	     String lname = (String) ois.readObject();
		 Object d_ob = ois.readObject();
		 String ques = (String) ois.readObject();
		 String answ = (String) ois.readObject();
	 //System.out.println("the supplied username is :" + username);
	 
	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdata","root","");
       Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select username,pssword from u_detail where firstname = " + "'" + fname + "'" + " AND " + " lastname=" + "'" + lname + "'" + " AND" + " dob=" + "'" + d_ob + "'" + " AND " + "clue_q =" + "'" + ques + "'" + " AND " + "ans="+ "'" + answ + "'" );
		 rs.next();
			 outs.writeObject(rs.getString(1));
		
			 outs.writeObject(rs.getString(2));
		 
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		} 
	 }
	     }
	 }
	 
	 
}