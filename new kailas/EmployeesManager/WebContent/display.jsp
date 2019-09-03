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
function show(){
	window.location.replace("index.jsp");
}
</script>
</head>
<style>

div {
   width:40px
    background: white
}
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button2 {
  background-color: #f44336;
  } /* Red */
.button3 {background-color: #e7e7e7; color: black;} /* Gray */
.button4 {background-color: #555555;} /* Black */
</style>
<body>
<div align="cenetr">
<form action="Display"method="GET"">
<center>
<h1 align="center">Employee Details</h1>
	Enter Employee Name <br><br>
<input type="text" name="name1" required placeholder="Enter first name">
<br><br><br><br><br><br>
<input type="submit" class="button "value="search">
<input type="submit" class="button button2"value="Back"onclick="show()">
</center>



</form>
</div>
</body>
</html>