<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result One</title>
<link rel="stylesheet" type=text/css
	href="userdetailscss.css">

</head>
<script type="text/javascript" src="validate_ass6.js"></script>
<body>
	<form action="EditUserDetailsServlet" method="post" name="LoginForm">
	<c:if test="${not empty result}">
				<tr>
					<td colspan=2>
						<center>
							<font color="white"> <c:out value="${result}" />
							</font>
						</center>
					</td>
				</tr>
			</c:if>
		<table>
			<tr>
				<td colspan=2><b>Details : </b></td>
			</tr>
			<c:set value="${listData}" var="user" scope="request" />
				<tr>
					<td><label>User ID: </label></td>
					<td><c:out value="${user.username}"></c:out></td>
				</tr>
				<tr>
					<td><label>Password: </label></td>
					<td><c:out value="${user.password}"></c:out></td>
				</tr>
				<tr>
					<td><label> Salutation : </label></td>
					<td><c:out value="${user.salutation}"></c:out></td>
				</tr>
				<tr>
					<td><label>First Name: </label></td>
					<td><c:out value="${user.firstname}"></c:out></td>
				</tr>
				<tr>
					<td><label>Middle Initial:</label></td>
					<td><c:out value="${user.middlename}"></c:out></td>
				</tr>
				<tr>
					<td><label>Last Name: </label></td>
					<td><c:out value="${user.lastname}"></c:out></td>
				</tr>
				<tr>
					<td><label>Sex : </label></td>
					<td><c:out value="${user.sex}"></c:out></td>

				</tr>
				<tr>
					<td><label>Email Id : </label></td>
					<td><c:out value="${user.emailId}"></c:out></td>
				</tr>
				<tr>
					<td><label>Birth Date : </label></td>
					<td><c:out value="${user.birthdate}"></c:out></td>
				</tr>
				<tr>
					<td><label>Address : </label></td>
					<td><c:out value="${user.address}"></c:out></td>
				</tr>

				<tr>
					<td><label>Interest : </label></td>
					<td><c:out value="${user.interstTwo}"></c:out></td>
				</tr>
				<tr>
					<td><label>Other Interest : </label></td>
					<td><c:out value="${user.otherinterest}"></c:out></td>
				</tr>
				<tr>
					<td colspan=2><center>
							<input type="submit" name="Edit" value="Edit">
							<a href="LoginJsp.jsp" target=""><input
								type="button" value="Logout"onclick="goToInfo()"></a>
						</center></td>
				</tr>

		</table>
	</form>
</body>
</html>