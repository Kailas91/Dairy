<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Struts2 JSP Example</title>
   </head>
   <body>
      <h1>Struts2 Hello World Example</h1>
      <s:form action="Welcome">
         <s:textfield name="user_name" label="Username" />
         <s:password name="password" label="Password" />
         <s:submit />
      </s:form>
   </body>
</html>