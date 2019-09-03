<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*"%>
    <%@ page import="java.sql.*"  %>
    <%@ page import="java.util.Scanner"  %>
<%@ page import="javax.sql.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
<script type="text/javascript">

</script>
</head>
<style>
</style>
<body>
<div align="cenetr">
<form action="display.jsp">
<center>
<h1 align="center">Employee Details</h1>
Enter Employee Name :<input type="text" name="name1">
<input type="submit" value="search">
</center>

<%
try
{
	Class.forName("com.mysql.jdbc.Driver");
	String name=request.getParameter("name1");
	Connection connection = DriverManager.getConnection("jdbc:mysql://172.16.1.15:3306/northwind_kailas","kailas","kailas@523");
	Statement statement=connection.createStatement();
	ResultSet rs=statement.executeQuery("select * from employee where name='"+name+"'");
	 while (rs.next()) {
	%>
	<br><br>
	<table cellpadding="5"width="35%"height="40%"align="center" style="border:1px solid black">

	<tr><td>Name :</td><td><%out.println(rs.getString("name")); %></td></tr>
	<tr><td>Mobile No :</td><td><%out.println(rs.getString("mobileno")); %></td></tr>
	<tr><td>Role :</td><td><%out.println(rs.getString("role")); %></td></tr>

	 </table>
	 <%
	 }
	 %>

	 <%
}
catch(Exception e)
{
	String name=request.getParameter("name1");
    String fName = "D:\\jvs_ws\\EmployeesManager\\WebContent\\Employee.txt";
    File file = new File(fName);
    Scanner scanner = new Scanner(file);
	 String[] line;

    while (scanner.hasNextLine())
    {  %>
    <br><br>
    	   <table cellpadding="5"width="35%"height="40%"align="center" style="border:1px solid black">
    	    <tr>
    	    <td>Name </td><td>Mobile No </td><td>Role </td>
    	    </tr>
    	    <%
    	   line = scanner.nextLine().split(",");
           if(line[0].equalsIgnoreCase(name)){
        	   out.print("<td> " +line[0]+ "</td>");
        	   out.print("<td> " +line[1]+ "</td>");
        	   out.print("<td> " +line[2]+ "</td>");
           }
    }
    scanner.close();
    %>
    </table>
    <%
}
%>
</form>
</div>
</body>
</html>