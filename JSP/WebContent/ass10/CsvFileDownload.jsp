<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Download File</title>
</head>
<script type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="FileDownload.css">
<body class="main">
	<form action="FileDownloadServlet" method="get"
		enctype="multipart/form-data">
		<center>
			<div id="result">
				<h1><font color="white">Click Download File button to download the file</font></h1>
			</div>
			 <input type="submit"value="Download File"class="button" />
		</center>
	</form>
	
</body>
</html>