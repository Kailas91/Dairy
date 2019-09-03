<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<center>
	<h4><font color="red">
		<s:property value="objbean.message"></s:property></font>
	</h4>

<h1> Wel Come Project</h1>

	<s:form action="Welcome">
		<s:textfield name="objbean.name" label="Enter Your Name "
			placeholder="Enter name" class="form-control" />

		<s:submit />

	</s:form>
	</center>
</body>
</html>