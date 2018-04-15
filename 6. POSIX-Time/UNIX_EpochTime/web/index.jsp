<%-- 
    Document   : info
    Created on : 13 March, 2018, 23:19:53 PM
    Author     : Vamsheeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Info</title>
    </head>
    <body>
        <form action="allinfo.jsp">
            
            First Name:<input type="text" name="fname"  placeholder="First Name">
            <br><br>
            Last Name:<input type="text" name="lname"  placeholder="Last Name">
            <br><br>
            DOB Name:<input type="text" name="dyear"  placeholder="year" style="width: 35px;">
            <input type="text" name="dmonth"  placeholder="month" style="width: 35px;">
          <input type="text" name="ddate"  placeholder="date" style="width: 35px;"><br>
          <br>Height :&nbsp;&nbsp;&nbsp; <input type="text" name="heightm"  placeholder="m" style="width: 35px;"> <input type="text" name="heightcm"  placeholder="cm" style="width: 35px;">
         <br><br> Weight :&nbsp;&nbsp;&nbsp;<input type="text" name="weightkg"  placeholder="kg" style="width: 35px;"><input type="text" name="weightgm"  placeholder="gm" style="width: 35px;">
           <br><br>
     
           <button style="color: green; font-size: 15px; font-family: sans-serif " type="submit">Submit</button> 
            
            
        </form>
    
    </body>
</html>
