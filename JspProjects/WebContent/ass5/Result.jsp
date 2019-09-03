<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Display Page</title>
<link rel="stylesheet" type=text/css
	href="userdetailscss.css">
</head>
<body>

	<br>
	<table class="tab">
		<tr>
			<td colspan=2>
				<center>User Details</center>
			</td>
		</tr>

		<c:set value="${listData}" var="user" scope="request" />
		<tr>
			<td>Salutation</td>
			<td><c:out value="${user.salutation}"></c:out></td>
		</tr>

		<tr>
			<td>UserId</td>
			<td><c:out value="${user.username}"></c:out></td>
		</tr>

		<tr>
			<td>Password</td>
			<td><c:out value="${user.password}"></c:out></td>
		</tr>

		<tr>
			<td>FirstName</td>
			<td><c:out value="${user.firstname}"></c:out></td>
		</tr>

		<tr>
			<td>Middle Initial</td>
			<td><c:out value="${user.middlename}"></c:out></td>
		</tr>

		<tr>
			<td>LastName</td>
			<td><c:out value="${user.lastname}"></c:out></td>
		</tr>

		<tr>
			<td>Sex</td>
			<td><c:out value="${user.sex}"></c:out></td>
		</tr>

		<tr>
			<td>EmailId</td>
			<td><c:out value="${user.emailId}"></c:out></td>
		</tr>

		<tr>
			<td>BirthDate</td>
			<td><c:out value="${user.birthdate}"></c:out></td>
		</tr>


		<tr>
			<td>Address</td>
			<td><c:out value="${user.address}"></c:out></td>
		</tr>

		<tr>
			<td>Interest</td>
			<td><c:out value="${user.interstTwo}"></c:out></td>
		</tr>

		<tr>
			<td>OtherInterest</td>
			<td><c:out value="${user.otherinterest}"></c:out></td>
		</tr>
		<tr>

		<td colspan=2 ><a href="LoginJsp.jsp" target=""><input type="button" value="Logout"></a></td>
		</tr>
	</table>
</body>
</html>
