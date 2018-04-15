<%-- 
    Document   : info
    Created on : 13 Mar, 2018, 23:10:53 PM
    Author     : Vamsheeth
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Info</title>
    </head>
    <body>
        
        <%
        String fName = request.getParameter("fname"); 
        String lName = request.getParameter("lname"); 
        int dobyear = Integer.parseInt(request.getParameter("dyear")); 
        int dobmonth = Integer.parseInt(request.getParameter("dmonth")); 
        int dobday = Integer.parseInt(request.getParameter("ddate")); 
        int heightm = Integer.parseInt(request.getParameter("heightm")); 
        int heightcm = Integer.parseInt(request.getParameter("heightcm")); 
        int weightkg = Integer.parseInt(request.getParameter("weightkg")); 
        int weightgm = Integer.parseInt(request.getParameter("weightgm")); 
        
        double height = (double)heightm + (double)heightcm/(double)100 ;
        double weight = (double)weightkg + (double)weightgm/(double)1000;
        
        String myDate = dobyear+"/"+dobmonth+"/"+dobday;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = sdf.parse(myDate);
        long millis = date.getTime();
        
        long birthtocurrent = System.currentTimeMillis();
        
        long diff = birthtocurrent - millis;
        Random rand = new Random();
        int randomin[]= new int[10];
        
        for(int i = 0; i<=9; i++)
        {
        randomin[i] = rand.nextInt(98)+1;
        }
        
        for(int i =0; i<=9; i++)
        {
        
            
        }
        int max=randomin[0];
        for(int i=0; i<=9; i++)
        {
        if(max<randomin[i])
        {max=randomin[i];}
        
        }

        long millisecond = diff%max;

        
        %>
        
        First Name :<%=fName%>
        <br>
        Last Name :<%=lName%>
        <br>
        Height : <%=height%>
        <br>
        Weight : <%=weight%>
        <br>
        Time in millis from Unix epoch time to DOB : <%=millis%>
        
        <br>
        Time from birth to current time : <%=diff%>
        <br>
        <%if(millisecond==0)
        {out.print("Wow! Wonderful!");}
        else
        {out.print("Good");}%>
        
    </body>
</html>
