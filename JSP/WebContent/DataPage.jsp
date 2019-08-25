<%@page language="java" import="java.util.*" %>
<html>
<head>
<title>Data Page</title>
</head>
<style>
 th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
td, th {
  border: 1px solid #ddd;
  padding: 8px;
}
 tr:nth-child(even){background-color: #f2f2f2;}

 tr:hover {background-color: #ddd;}
</style>
<body bgcolor="white"> 
	<form action="dataservlet" method="get">
	<table >
	  <tr>
		<th width="119"><b>ID</b></th>
		<th width="168"><b>Message</b></th>
	  </tr>
	<%Iterator itr;%>
	<% List data= (List)request.getAttribute("data");
		for (itr=data.iterator(); itr.hasNext(); )
		{
	%>
	<tr>
		<td width="119"><%=itr.next()%></td>
		<td width="168"><%=itr.next()%></td>
	</tr>
	<%}%>
	</table>
	</form>
</body>
</html>
