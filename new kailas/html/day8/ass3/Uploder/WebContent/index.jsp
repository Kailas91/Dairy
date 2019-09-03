<%--
<!--
Day : 8
Assignment :3
Assignment : Write a HTML Page which uploads a file to the server and prints the progress on the browser.
Write a JSP code to which actuals contains the logic of upload and responds the progress to the HTML page.
Author : Kailas
Date   : 12/8/2019
-->

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.io.*"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=U  TF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>JSP Page</title>


    <link href="css/bootstrap.min.css" rel="stylesheet">    <link href="css/style.css" rel="stylesheet">

<script language="javascript" type="text/javascript">
	function validateForm()
{
           if(document.getElementById('fileData').value.length == 0){
        		alert("Please select a file to upload");
        		event.preventDefault();
           }


}
</script>
    </head>

  <body>

    <div class="container">
      <header class="header clearfix">

      </header>
      <main role="main">
        <div class="jumbotron">
          <form id="myForm" action="UploadFile.jsp" ENCTYPE="multipart/form-data" method="post">
            <div class="form-group">
              <label>Select Your File</label>
              <input type="file" name="fileData" class="form-control" id="fileData" value="" placeholder="select file">
            <button type="submit" class="btn btn-primary" onclick="validateForm()">Upload</button>
            </div>
          </form>
        </div>
      </main>
    </div> <!-- /container -->
    </body>
</html>
