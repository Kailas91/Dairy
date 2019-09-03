
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<html>
<head>
<title>Display Users</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="css/table.css" />
</head>
<body>

	<div class="navbar"
		style="background-color: #333; position: fixed; left: 0; overflow: hidden; white-space: nowrap; top: 0; width: 100%">


		<c:choose>
			<c:when test="${sessionScope.isUpdated == 'true'}">
				<h3 style="float: left; color: gold; position: absolute; left: 40%;">Data
					Updated Successfully</h3>
			</c:when>

		</c:choose>

		<a type="button" class="button" href="Logout"
			style="text-decoration: none; position: relative; float: right; background: coral; padding: 1em 2em; color: #fff; border: 0; margin: 20px; text-decoration: none; display: inline-block;">Logout</a>
	</div>

	<div style="margin-left: 0; margin-top: 100px; left: 0; clear: both"
		class="table-wrapper">
		<table class="fl-table">
			<thead>
				<tr>
					<th>Salutation</th>
					<th>FirstName</th>
					<th>MiddleName</th>
					<th>LastName</th>
					<th>Gender</th>
					<th>Email</th>
					<th>Date Of Birth</th>
					<th>Address</th>
					<th>Username</th>

					<th>Interest</th>
					<th>OtherInterest</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.usersList}" var="user">
					<tr>
						<td>${user.salutation }</td>

						<td>${user.firstName }</td>

						<td>${user.middleName }</td>

						<td>${user.lastName }</td>

						<td>${user.gender }</td>

						<td>${user.email }</td>

						<td>${user.dateOfBirth }</td>

						<td>${user.address }</td>

						<td>${user.username }</td>



						<td>${user.interest }</td>
						<td>${user.otherInterest }</td>

						<td><a type="button" class="button"
							href="EditUserDetails?uid=${user.uid }"
							style="text-decoration: none; float: right; background: green; color: fff; padding: 1em 2em; border: 0;">Edit</a>
						</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>

</body>

</html>