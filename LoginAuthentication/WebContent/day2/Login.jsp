<%@ taglib uri="/struts-tags" prefix="s"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>



<style>
.content {
  max-width: 500px;
  margin: auto;
}


/* 'Open Sans' font from Google Fonts */
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);

body {
  background: #456;
  font-family: 'Open Sans', sans-serif;
}

.login {
  width: 400px;
  margin: 16px auto;
  font-size: 16px;
}

/* Reset top and bottom margins from certain elements */
.login-header,
.login p {
  margin-top: 0;
  margin-bottom: 0;
}

/* The triangle form is achieved by a CSS hack */
.login-triangle {
  width: 0;
  margin-right: auto;
  margin-left: auto;
  border: 12px solid transparent;
  border-bottom-color: #28d;
}

.login-header {
  background: #28d;
  padding: 20px;
  font-size: 1.4em;
  font-weight: normal;
  text-align: center;
  text-transform: uppercase;
  color: #fff;
}

.login-container {
  background: #ebebeb;
  padding: 12px;
}

/* Every row inside .login-container is defined with p tags */
.login p {
  padding: 12px;
}

.login input {
  box-sizing: border-box;
  display: block;
  width: 100%;
  border-width: 1px;
  border-style: solid;
  padding: 16px;
  outline: 0;
  font-family: inherit;
  font-size: 0.95em;
}

.login input[type="email"],
.login input[type="password"] {
  background: #fff;
  border-color: #bbb;
  color: #555;
}

/* Text fields' focus effect */
.login input[type="email"]:focus,
.login input[type="password"]:focus {
  border-color: #888;
}

.login input[type="submit"] {
  background: #28d;
  border-color: transparent;
  color: #fff;
  cursor: pointer;
}

.login input[type="submit"]:hover {
  background: #17c;
}

/* Buttons' focus effect */
.login input[type="submit"]:focus {
  border-color: #05a;
}
</style>
<script>
	function clearErrorMessage() {
		//alert(getElementById("clear"));
		window.location.href = "Login.jsp";
	}
</script>
</head>
<body>

	<!-- <input type="button" name="name" class="btn btn-success" value="Submit"/> -->
	<div class="login">

  <h2 class="login-header">Log in</h2>

	<div class="login-container ">
	<s:form action="login" method="post" theme="simple">

			<s:textfield name="objbean.username"
				placeholder="Enter Username" class="form-control" />
		<br>
			<s:password  name="objbean.password"
			placeholder="Enter Password" class="form-control" />

		<br>
		<s:submit class="btn btn-success" />
		<br>
		<s:reset value="Reset" onclick="clearErrorMessage();" />
	</s:form>

	<s:if test="hasActionErrors()">
		<div class="errors">
			<span style="color: red"><s:actionerror id="clear" /></span> <span
				style="color: red"><s:actionmessage /></span>
		</div>
	</s:if>
	</div>
	</div>

</body>
</html>