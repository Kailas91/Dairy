<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
Assignment :5
Assignment : Creating login screen using jsp and servelet
Author : Kailas
Date   : 20/8/2019
-->


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>

 <link href="style.css" type="text/css" rel="stylesheet"/>
 <script>
 function goToInfo(){
     window.location = 'LoginJsp.jsp';
 }
 </script>
</head>
<body bgcolor="#9933FF">
</br></br></br></br></br></br></br>
	<form action="Login" method="post" name="LoginForm">
		<table id="rcorners1"align="center">
			<tr>
				<td colspan=2>
					<center>
						<label>Login Details</label>
					</center>
				</td>
			</tr>

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

			<tr>
				<td><label>Login ID</label></td>
				<td><input type="text" id=loginid name="loginId"required placeholder="Enter LoginID"></td>
			</tr>

			<tr>
				<td><label>Password </label></td>
				<td><input type="password" id=password name="pwd"required placeholder="Enter Password"></td>
			</tr>
		   <tr>
              <td colspan =2>
                <center>
                  <input id="submit"type="submit" value="Submit" style ="background-color: #4ac290;color:#fafafc;">
                    <input id="clear"type="reset"value="Clear" onclick="goToInfo()" style ="background-color: #4ac290;color:#fafafc;" >
                    </center>
                  </td>
                </tr>
		</table>
	</form>
</body>
</html>