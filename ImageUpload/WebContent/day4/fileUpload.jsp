<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
       <link href="style.css" type="text/css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>file upload page</title>
</head>
<style>
.errorMessage {
  color: white;
}
</style>
<script>
	function clearErrorMessage() {
		//alert(getElementById("clear"));
		window.location.href = "fileUpload.jsp";
	}

</script>
<body>
<div>
<center>
<s:form action="fileUpload" method="post" enctype="multipart/form-data" >
     <table id="rcorners1"align="center">
            <tr>
            <td colspan=2>
                 <s:file name="toBeUploaded" accept=".png, .jpg, .jpeg" label="Choose file " />
                </td></tr>
                <tr><td align="center"> <input type="submit"value="Upload" align="center"/></td><td>
                <input type="reset" value="Clear" onclick="clearErrorMessage()" /></td></tr>
                </table>

</s:form>
</center>
</div>
</body>
</html>