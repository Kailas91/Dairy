<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Dstyle.css">
</head>
<body bgcolor="#9933FF"class="main">
<center>

	<h2><font color="white">Select File To Download</font></h2>
	<form action="FileDownload" method="post">
		<table  style="border:1px solid black" height="80%"width="30%" bgcolor="white" align="center"
			cellspacing="">
			<thead>
			<tr>	
			</tr>
			<tr >
				<th colspan=2><b>Sr. No.</b></th>
			<th></th>
				<th align="center"><b>File Name</b></th>
			</tr>
			</thead>
			 <tbody>
			 	<%
		File folder = new File("C:/Users/Kailas/eclipse-workspace/JSP/WebContent/file");
		File[] listOfFiles = folder.listFiles();
		List<File> fileList = new ArrayList<File>();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				fileList.add(listOfFiles[i]);
			}
		}
				if (fileList.size() > 0) {
					int srno;
					for (int i = 0; i < fileList.size(); i++) {
						srno = i + 1;
						out.print("<tr>	<td>" + srno
								+ "</td><td><input type=\"radio\" required=\"required\" name=\"file\" value=\""
								+ fileList.get(i).getName() + "\"></td><td class=\"file\">" + fileList.get(i).getName()
								+ "</td></tr>");
					}
				}
			%>
			 </tbody>
			</table>
			<br> <br>
			<input type="submit" name="submit" value="Download"
					class="btn" />
				<input type="reset" name="reset" class="btn" />
		
	</form>
	</center>
</body>
</html>