<%--
<!--
Day : 8
Assignment :2
Assignment :Write a HTML page which displays the Name, Phone No. and Role of Employee.
Create a database Employees.db in the local storage in order to work offline with data.
Author : Kailas
Date   : 9/8/2019
-->

--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
 <%@page import="java.io.*"%>
<%
Class.forName("com.mysql.jdbc.Driver");

String name=request.getParameter("name");
Long mobileno=Long.parseLong(request.getParameter("mn"));
String role=request.getParameter("role");
Connection connection = DriverManager.getConnection("jdbc:mysql://172.16.1.15:3306/northwind_kailas","kailas","kailas@523");
Statement statement=connection.createStatement();
statement.executeUpdate("insert into employee values('"+name +"',"+mobileno+",'"+role+"')");

%>
<%
 //File creation and add data to local storage
 String strPath = "D:\\jvs_ws\\EmployeesManager\\WebContent\\Employee.txt";
 File strFile = new File(strPath);
 boolean fileCreated = strFile.createNewFile();
 //File appending
 Writer objWriter = new BufferedWriter(new FileWriter(strFile));
 objWriter.write(name+",");
 objWriter.write(mobileno+",");
 objWriter.write(role);
 objWriter.flush();
 objWriter.close();
%>
<script type="text/javascript">
alert("sucessfully entered");
window.location.replace("Emplyees.jsp");
</script>
</body>
</html>