<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<body>

	<h2>Struts2 login & logout example with Session Management</h2>

	Hello,	<s:property value="#session.userId" /> |	<a href="logout">Logout</a>
	
</body>
</html>
