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

h1{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}
table{
  width:100%;
  table-layout: fixed;
}
.tbl-header{
  background-color: rgba(255,255,255,0.3);
 }
.tbl-content{
  height:300px;
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 15px;
  text-align: left;
  font-weight: 500;
  font-size: 12px;
  color: #fff;
  text-transform: uppercase;
}
td{
  padding: 15px;
  text-align: left;
  vertical-align:middle;
  font-weight: 300;
  font-size: 12px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}


/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Roboto', sans-serif;
}
section{
  margin: 50px;
}


/* follow me template */
.made-with-love {
  margin-top: 40px;
  padding: 10px;
  clear: left;
  text-align: center;
  font-size: 10px;
  font-family: arial;
  color: #fff;
}
.made-with-love i {
  font-style: normal;
  color: #F50057;
  font-size: 14px;
  position: relative;
  top: 2px;
}
.made-with-love a {
  color: #fff;
  text-decoration: none;
}
.made-with-love a:hover {
  text-decoration: underline;
}


/* for custom scrollbar for webkit browser*/

::-webkit-scrollbar {
    width: 6px;
}
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
}
::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
}
</style>
<script>
function myFunction() {
	window.location = 'Login.jsp';
}
</script>
<body>
<section>
  <!--for demo wrap-->
  <h1>User Details</h1>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
          <th>First Name</th>
          <th>Middle Name</th>
          <th>Last Name</th>
          <th>Gender</th>
          <th>Email Id</th>
            <th>DOB</th>
              <th>Address</th>
        </tr>
      </thead>
    </table>
  </div>
 <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
        <tr>
          <td><s:property value="objuser.FirstName"/></td>
          <td><s:property value="objuser.MiddleName"/></td>
          <td><s:property value="objuser.LastName"/></td>
          <td><s:property value="objuser.Gender"/></td>
          <td><s:property value="objuser.EmailId"/></td>
          <td><s:property value="objuser.dob"/>  </td>
          <td> <s:property value="objuser.Address"/> </td>
        </tr>
        <s:iterator value="list">
			<tr>
				<td><s:property value="FirstName" /></td>
				<td><s:property value="MiddleName" /></td>
				<td><s:property value="LastName" /></td>
				<td><s:property value="Gender" /></td>
				<td><s:property value="EmailId" /></td>
				<td><s:property value="dob" /></td>
				<td><s:property value="Address" /></td>
			</tr>
			</s:iterator>
     </tbody>
    </table>
  </div>
</section>

	<div class="content">
		<s:form action="loginSuccess" method="post">
		<s:if test="objbean.category == 'admin'">
		</s:if>

		</s:form>
			<center>
		<h3>

<a href="logout">Logout</a>
	</h3>
	</center>
	</div>
</body>
</html>