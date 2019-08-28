<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome User</title>
</head>
<body align="center">
<center>

	<h1>
		Welcome<br>
		<s:property value="objbean.username"></s:property>
	</h1>
	
	<h3>
		<a href="/WelCome/WebContent/index.jsp"target="">Logout</a>
	</h3>
	</center>
</body>
</html>