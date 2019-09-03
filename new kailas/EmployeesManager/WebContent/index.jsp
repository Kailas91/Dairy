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
<%@ page import="java.io.*"%>
<html>

<style>
body {
	background: linear-gradient(to bottom, #003366 0%, #ffffff 100%)
}

div {
	width: 40px background: white
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
.button3 {
	background-color: #e7e7e7;
	color: black;
} /* Gray */
.button4 {
	background-color: #555555;
} /* Black */
</style>
<script type="text/javascript">
	function show() {
		window.location.replace("display.jsp");
	}
	function show2() {
<%PrintWriter pw = new PrintWriter("D:\\jvs_ws\\EmployeesManager\\WebContent\\file\\Employee.txt");
			pw.close();%>
	alert("sucessfully Cleared");
	}
	function Confirm(form) {

		alert("Record insert successfully!");

	}
</script>
<body>
	<div align="center">
		<form name="form" action="HelloForm" method="GET"">
			<h1 align="center">
				<font color="white">Employee Registration</font>
			</h1>
			<table bgcolor="white" width="30%" height="30%"
				style="border: 1px solid black" align="center">
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name" required
						placeholder="Enter first name"></td>
				</tr>
				<tr>
					<td>Mobile No :</td>
					<td><input type="number" name="mn" required
						placeholder="Enter number only" maxlength="10"></td>
				</tr>
				<tr>
					<td>Role :</td>
					<td><input type="text" name="role" required
						placeholder="Enter Role"></td>
				</tr>
			</table>
			<br>
			<br>
			<button class="button" type="submit" value="submit">Add
				Details</button>
			<button class="button button3" onclick="show()">Get Details</button>
			<button class="button button2" onclick="show2()">Clear
				Details</button>
		</form>
	</div>
</body>
</html>