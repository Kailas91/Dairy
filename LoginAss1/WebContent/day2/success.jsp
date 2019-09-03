<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.content {
  max-width: 500px;
  margin: auto;

}
a.button {
    -webkit-appearance: button;
    -moz-appearance: button;
    appearance: button;

    text-decoration: none;
    color: initial;
}
</style>
<script>
function myFunction() {
	window.location = 'day2/Login.jsp';
}
</script>
<body>
<center>

	<div class="content">
		<s:form >

		<h2>
			Wel Come User :
			<s:property value="objbean.username" />
		</h2>

		</s:form>
		<h3>

		<a href="Login.jsp"class="button">Back</a>
	</h3>
	</div>
	</center>
</body>
</html>