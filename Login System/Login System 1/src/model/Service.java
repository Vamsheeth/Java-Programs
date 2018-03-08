package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;
import java.util.Arrays;

public class Service extends  Thread
{
	private  Socket socket;
	public Service(Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(),true);

			String requestString = "";

			while (true) {

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginSignup","root","root");

				requestString = input.readLine();

				String [] usrdet = requestString.split("%%");

				System.out.println(requestString);

				if(usrdet[0].equals("L"))
				{
					Statement stmt = con.createStatement();
					System.out.println(Arrays.toString(usrdet));
					String query = "SELECT * FROM userDetails WHERE userName='"+usrdet[1]+"'";

					boolean flag =false;

					System.out.println(query);

					ResultSet rs = stmt.executeQuery(query);

					System.out.println("stmt executed"+rs);

					inner: while(rs.next())
					{
						String pass = rs.getString("password");

						if(pass.equals(usrdet[2]))
						{
							flag = true;
							break inner;
						}
					}
					if (flag)
					{
						output.println(rs.getString(1)+"%%" +
								               rs.getString(2)+"%%"+
								               rs.getString(3)+"%%"+
						                       rs.getString(4)+"%%"+
								               rs.getString(5)+"%%"+
								               rs.getString(6));
					}
					else
						output.println("ERROR");

				}
				else if (usrdet[0].equals("S"))
				{
					Statement stmt = con.createStatement();
					String query = "SELECT * FROM userDetails WHERE userName='"+usrdet[3]+"' OR email='"+usrdet[2]+"'";
					ResultSet rs = stmt.executeQuery(query);

					if(rs.getRow()>0)
					{
						output.println("ERROR");
					}
					else
					{
						String insquery = "INSERT INTO userDetails VALUES (?,?,?,?,?,?)";
						PreparedStatement ps = con.prepareStatement(insquery);
						ps.setString(1,usrdet[1]);
						ps.setString(2,usrdet[2]);
						ps.setString(3,usrdet[3]);
						ps.setString(4,usrdet[4]);
						ps.setString(5,usrdet[5]);
						ps.setString(6,usrdet[6]);

						ps.executeUpdate();
						ps.close();
						output.println("OK");
					}
				}
				else if (usrdet[0].equals("F"))
				{

					Statement stmt = con.createStatement();
					String query = "SELECT * FROM userDetails WHERE email='"+usrdet[1]+"' OR userName='"+usrdet[1]+"'";
					ResultSet rs = stmt.executeQuery(query);
					System.out.println(usrdet[1]+"    "+rs.getRow());

					boolean flag =false;

					System.out.println(query);

					inner: while(rs.next())
					{
						String secret = rs.getString("secretAns");

						if(secret.equals(usrdet[2]))
						{
							flag = true;
							break inner;
						}
					}
					if (flag)
					{
						output.println(rs.getString("password"));
					}
					else
					{
						output.println("ERROR");
					}

				}
				con.close();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}