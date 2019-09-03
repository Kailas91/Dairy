<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="style.css" type="text/css" rel="stylesheet"/>

    </head>
  <script type="text/javascript">
  function goToInfo(){
	     window.location = 'index.jsp';
	 }
  </script>
 <body bgcolor="#9933FF">
<br><br><br><br><br><br><br>
    <center>
    	<c:if test="${not empty result}">
				<tr>
					<td colspan=2>
						<center>
							<font color="white"> <c:out value="${result}" />
							</font>
						</center>
					</td>
				</tr>
			</c:if>
        <div>
            <h3> <label>Choose File to Upload in Server</label> </h3>
            <form action="upload" method="post" enctype="multipart/form-data">
            <table id="rcorners1"align="center">
            <tr>
            <td colspan=2>
                <input type="file" name="file" required placeholder="Please choose file"/>
                </td></tr>
                <tr><td align="center"><input type="submit" value="Upload" /></td><td><input type="reset" value="Clear" onclick="goToInfo()" /></td></tr>

                </table>
            </form>
        </div>
       </center>
    </body>
</html>