import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class register extends HttpServlet  {
	public void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException, ServletException {
	 response.setContentType("text/html;charset=UTF-8 ");
     PrintWriter pw = response.getWriter();
		String First_Name = request.getParameter("First_Name");
		
		String Last_Name = request.getParameter("Last_Name");
		
		String Birthday_day = request.getParameter("Birthday_day");
		String Birthday_Month = request.getParameter("Birthday_Month");
		String Birthday_Year = request.getParameter("Birthday_Year");
		
		String pob = request.getParameter("pob");
		String email= request.getParameter("Email");
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		String sques= request.getParameter("squestion");
		String sans = request.getParameter("sans");
		

  try{

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost/register?useSSL=false","root","");				
		Statement statement = (Statement) conn.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * from user1 where username='" + username + "'");
        
        String duplicate = null;

         while(rs.next()){
                duplicate = rs.getString(1);
                   }
		if(duplicate == null){
	       
			    
				PreparedStatement ps = conn.prepareStatement("insert into user1 values(?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,First_Name);
				
				ps.setString(2,Last_Name);
				
				ps.setString(3,Birthday_day);
				ps.setString(4,Birthday_Month);
				ps.setString(5,Birthday_Year);
			
				ps.setString(6,pob);
				ps.setString(7,email);
				ps.setString(8,username);
				ps.setString(9,password);
				ps.setString(10,sques);
				ps.setString(11,sans);
				
				int i = ps.executeUpdate();
				
				if(i>0)
				{request.getRequestDispatcher("form.html").include(request, response);
		     HttpSession session=request.getSession();
					pw.println("sucessfully registered");
				}
		   }
		   else
		{    request.getRequestDispatcher("form.html").include(request, response);
		     HttpSession session=request.getSession();
			pw.println("Registation failed ,Please choose a different username..:");
		}
  }
		   catch(Exception se)
		   {
			   se.printStackTrace();
		   }
		
		
	}
}
				
			    
			   