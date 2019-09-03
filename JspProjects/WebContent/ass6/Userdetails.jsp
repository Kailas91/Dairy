<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<script type="text/javascript" src="validate_ass6.js"></script>
<link rel="stylesheet" type="text/css" href="userscss.css">
</head>
<body bgcolor=white onload=" load()">
	<form action="UpdateUserDetailsServlet" method="post"
		name="StudentRegistration">
	<div style="text-align: center;">
    <span align="center" id="error"style="color:red"></span>

	</div>

	<table  style="border:1px solid black"cellpadding="5" width="40%" bgcolor="white" align="center"
			cellspacing="">

			<tr>
				<td style="border:1px solid black"colspan=2><legend align="left"> Personal Details</legend></td>
			</tr>
			<tr>
				<td colspan=2><font color="Red"> <c:out
							value="${result}" />
				</font></td>
			</tr>
			<tr>
				<td><label>User Id <span style="color: red;">*</span></label></td>
				<td><input type=text name="username" id="username" size="20"
					value="${objUserDetailsBinSecond.username}" pattern=".{4,}" required
					placeholder="Enter User name"maxlength="8"title="4 or more characters"></td>
			</tr>
			<tr>
				<td><label>Password<span style="color: red;">*</span></label></td>
				<td><input type=password name="passward" id="passward"
					size="20" value="${objUserDetailsBinSecond.password}"
					 pattern=".{6,}" required
						placeholder="Enter Password" title="Six or more characters"size="20" maxlength="12"></td>
			</tr>
			<tr>
				<td><label>Salutation :</label></td>


				<td>

				 <input list="sal" name="scripts" id="scripts" placeholder="Select salutation" value="${objUserDetailsBinSecond.salutation}">
          						<datalist id="sal">
          							<option value="Mr.">
          							<option value="Miss">
          							<option value="Dr">
          						</datalist>
				</td>
			</tr>
			<tr>
				<td><label>First Name <span style="color: red;">*</span></label></td>
				<td><input type=text name="firstname" id="firstname" size="20"
					value="${objUserDetailsBinSecond.firstname}" maxlength="50"required
					placeholder="Enter first name">
				</td>
			</tr>

			<tr>
				<td><label>Middle Initial</label></td>
				<td><input type="text" name="middlename" id="middlename"
					size="20" value="${objUserDetailsBinSecond.middlename}"
					maxlength="1"></td>
			</tr>

			<tr>
				<td><label>Last Name <span style="color: red;">*</span></label></td>
				<td><input type="text" name="lastname" id="lastname" size="20"
					value="${objUserDetailsBinSecond.lastname}" maxlength="50"required
					 placeholder="Enter last name"></td>
			</tr>
			<tr>
				<td><label>Sex <span style="color: red;">*</span></label></td>
				<td><c:if test="${objUserDetailsBinSecond.sex == 'male'}">
						<input type="radio" name="sex" value="male" id="male" size="10"
							checked="checked">
						<label>Male</label>
						<input type="radio" name="sex" value="female" id="female"
							size="10">
						<label>Female</label>

					</c:if> <c:if test="${objUserDetailsBinSecond.sex == 'female'}">
						<input type="radio" name="sex" value="male" id="myRadio"size="10">
						<label>Male</label>

						<input type="radio" name="sex" value="female" id="myRadio"
							size="10" checked="checked">
						<label>Female</label>
					</c:if></td>
			</tr>
			<tr>
				<td><label>EmailId<span style="color: red;">*</span></label></td>
				<td><input type="text" name="emailid" id="emailid"size="20"
					value="${objUserDetailsBinSecond.emailId }" maxlength="50"></td>
			</tr>


			<tr>
				<td><label> BirthDay <span style="color: red;">*</span></label></td>
				<td><select name="year" id="year" size="1" onchange="resetMonthDay();">

						<c:forEach var="i" begin="1961" end="2014">
							<option value="<c:out value="${i}"/>"><c:out
									value="${i}" /></option>
						</c:forEach>
				</select> <select name="month" id="month" size="1"  onchange=" populateDays();">

							<c:forEach var="i" begin="1" end="12">
							<option value="<c:out value="${i}"/>"><c:out
									value="${i}" /></option>
						</c:forEach>
				</select> <select name="day" id="day" size="1">

						<c:forEach var="i" begin="1" end="31">
							<option value="<c:out value="${i}"/>"><c:out
									value="${i}" /></option>
						</c:forEach>
				</select> <input type="hidden" id=hiddenyear name="hiddenyear"
					value="${objUserDetailsBinSecond.year}" /> <input type="hidden"
					id=hiddenmonth name="hiddenmonth"
					value="${objUserDetailsBinSecond.month}" /> <input type="hidden"
					id=hiddenDay name="hiddenDay"
					value="${objUserDetailsBinSecond.day}" /></td>
			</tr>

			<tr>
				<td><label>Address</label></td>
				<td>
				<textarea rows="4" cols="20" name="Address" id="Address">${objUserDetailsBinSecond.address}</textarea>
				</td>
			</tr>
				<tr>
				<td style="border:1px solid black"colspan=2><legend>
						Area Of Interest <span style="color: red;">*</span>
					</legend></td>
			</tr>
			<tr>
				<td colspan=2><c:if
						test="${objUserDetailsBinSecond.web == null}">
						<input type="checkbox" name="interest" id="web" value="web">
						<label>Web Programming</label>
						<br>
					</c:if> <c:if test="${objUserDetailsBinSecond.web != null}">
						<input type="checkbox" name="interest" id="web" value="web"
							checked="checked">
						<label>Web Programming</label>
						<br>
					</c:if> <c:if test="${objUserDetailsBinSecond.database == null}">
						<input type="checkbox" name="interest" id="database"
							value="database">
						<label>Database Programming</label>
						<br>
					</c:if> <c:if test="${objUserDetailsBinSecond.database != null}">
						<input type="checkbox" name="interest" id="database"
							value="database" checked="checked">
						<label>Database Programming</label>
						<br>
					</c:if> <c:if test="${objUserDetailsBinSecond.swing == null}">
						<input type="checkbox" name="interest" id="swing" value="swing">
						<label>Swing Programming</label>
						<br>
					</c:if> <c:if test="${objUserDetailsBinSecond.swing != null}">
						<input type="checkbox" name="interest" id="swing" value="swing"
							checked="checked">
						<label>Swing Programming</label>
						<br>
					</c:if> <c:if test="${objUserDetailsBinSecond.mobile == null}">
						<input type="checkbox" name="interest" id="mobile" value="mobile">
						<label>Mobile Programming</label>
					</c:if> <c:if test="${objUserDetailsBinSecond.mobile != null}">
						<input type="checkbox" name="interest" id="mobile" value="mobile"
							checked="checked">
						<label>Mobile Programming</label>
					</c:if></td>
			</tr>
			<tr>
				<td colspan=2><legend align="left">Other Interest</legend></td>
			</tr>
			<tr>
				<td style="border:1px solid black"colspan=2><textarea rows="4" cols="20" name="otherinterest"
						id="otherinterest">${objUserDetailsBinSecond.otherinterest}</textarea></td>
			</tr>
			<tr>
				<td colspan=2><center>
						<input type="submit" name="submit" value="Update"
							onClick="return validate();" />
							<a href="LoginJsp.jsp"  target=""><input type="button" value="Logout"onclick="goToInfo()"></a>
					</center></td>
			</tr>
		</table>
	</form>
</body>
</body>
</html>