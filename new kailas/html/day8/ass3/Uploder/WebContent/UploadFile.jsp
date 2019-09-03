<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=U  TF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Progress</title>



    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

<script>

var isCompleted = false;

function cancel() {
	if(isCompleted == true){
		alert("Back");
		  window.history.back();

	}
	else{
		alert("Upload completed!");
	}

}


function error(){

	var progressBar = document.getElementById('progressBar');
	var status = document.getElementById('status');

	status.innerHTML = "Error occurred while uploading file!";
	progressBar.style.width = 0+"%";

}

function operationCompleted(size){

	console.log(size);

	var displaySize = document.getElementById('totalSize');

	displaySize.innerHTML = "Total Bytes Read " + size;

	isCompleted = true;
}


window.onload = function () {

	var progressBar = document.getElementById('progressBar');
	var status = document.getElementById('status');
	status.innerHTML = "Uploading File";


	progressBar.style.width ="20%";


	var i=0;


	for(i=0;i<=100;i++){
		progressBar.innerHTML = i+"%";
		progressBar.style.width = i+"%";

	}
	status.innerHTML = "File Uploaded!"




	}
</script>

</head>



<body>

<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page import = "javax.servlet.http.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
<%@ page import = "org.apache.commons.io.output.*" %>

<div class="container">
      <header class="header clearfix">
        <nav>

        </nav>
        <h3 class="text-muted">


        File Uploader</h3>
      </header>

<%
   File file = null ;
	List fileItems=null;
	long sizeInBytes=0;
   int maxFileSize = 5000 * 1024;
   int maxMemSize = 5000 * 1024;
   ServletContext context = pageContext.getServletContext();
   String filePath = "D:\\jvs_ws\\Uploder\\WebContent\\files\\";

   // Verify the content type
   String contentType = request.getContentType();

   if ((contentType.indexOf("multipart/form-data") >= 0)) {
      DiskFileItemFactory factory = new DiskFileItemFactory();
      // maximum size that will be stored in memory
      factory.setSizeThreshold(maxMemSize);

      // Location to save data that is larger than maxMemSize.
      factory.setRepository(new File("c:\\temp"));

      // Create a new file upload handler
      ServletFileUpload upload = new ServletFileUpload(factory);

      // maximum file size to be uploaded.
      upload.setSizeMax( maxFileSize );

      try {
         // Parse the request to get file items.
          fileItems = upload.parseRequest(request);

         // Process the uploaded file items
         Iterator i = fileItems.iterator();


         %>
           <main role="main">

        <div class="jumbotron">

            <div class="form-group">
              <label id="status">Upload Progress </label>


   <!-- PRogress Bar -->
             <div class="progress" style="margin-bottom:50px;">
             <div id="progressBar" class='progress-bar progress-bar-striped active' style='width:5%;'>
				5%
			</div>

			</div>

         	<button type="reset" onclick="cancel()" class="btn btn-danger">Cancel</button>

			<span id="totalSize"></span>

         <%
         while ( i.hasNext () ) {
%>
			<%


            FileItem fi = (FileItem)i.next();
            if ( !fi.isFormField () ) {
               // Get the uploaded file parameters
               String fieldName = fi.getFieldName();
               String fileName = fi.getName();
               boolean isInMemory = fi.isInMemory();
                sizeInBytes = fi.getSize();

               // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( filePath +
                  fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( filePath +
                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
               fi.write( file ) ;

            }
         }


         %>
         <script>
			operationCompleted(<%=sizeInBytes %>);
         </script>
     <%

      }
      catch(Exception ex) {
          System.out.println(ex);
          %>
          <script>
          error();
          </script>
      <%
       }

      %>


<%
   } else {
	   %>
       <script>
       error();
       </script>
   <%
    }
%>
            </div>
        </div>

        <div class="row marketing">
          <div class="col-lg-6">
            <div id="bookmarksResults">


            </div>

            </div>
        </div>

      </main>

    </div> <!-- /container -->


</body>
</html>