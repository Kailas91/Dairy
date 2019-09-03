<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%--
<!--
Day : 8
Assignment :3
Assignment :Write a HTML Page which uploads a file to the server and prints the progress on the browser.
Write a JSP code to which actuals contains the logic of upload and responds the progress to the HTML page.
Author : Kailas
Date   : 12/8/2019
-->

--%>
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

/*
function cancel is used to cancel the upload operation
return type:void
*/

function validateForm()
{
           if(document.getElementById('fileData').value.length == 0){
        		alert("Please select a file to upload");
        		event.preventDefault();
           }else{
        	   document.getElementById("progressBar").style.display = "block";
        	   alert("Upload Successfully");
           }


}

	/*
	function alertFileSize alerts user if size limit is reached !
	return type:void
	*/
	function alertFileSize(){
		var inpFiles = document.getElementById('fileData');
		for (var i = 0; i < inpFiles.files.length; ++i) {
		    var size = inpFiles.files.item(i).size;

		    if(size > 20971520){
		    	alert('File size exceeded ! Size Limit is 20MB');
		    	location='index.jsp';
		    }
		}
	}
function cancel() {
	if(isCompleted == false){
		document.getElementById("fileData").value="";
	}
	else{
		alert("Upload completed!");
	}

}



/*
function error displays errors
return type:void
*/
function error(){

	var progressBar = document.getElementById('progressBar');
	var status = document.getElementById('status');

	status.innerHTML = "Error occurred while uploading file!";
	progressBar.style.width = 0+"%";

}


/*
function operationCompleted is called upon file uploaded to show total bytes uploaded
return type:void
*/
function operationCompleted(){

	console.log(size);

	var displaySize = document.getElementById('totalSize');

	displaySize.innerHTML = "Total Bytes Read " + size;

	isCompleted = true;

	var progressBar = document.getElementById('progressBar');
	progressBar.innerHTML = "100%";

}
var counter = 0;


/*
function incrementNumber displays progress
return type:void
*/
function incrementNumber() {
	  setTimeout(function(){
		  var progressBar = document.getElementById('progressBar');
		var i =   parseInt(progressBar.innerHTML);
		counter +=10;
		i = counter + i;
		i=i+85;
		console.log(i);
		progressBar.innerHTML = i.toString()+"%";
	  }, 500);
	}


/*
function window.onload called upon window loading
return type:void
*/
window.onload = function () {
	  document.getElementById("progressBar").style.display = "none";
	var progressBar = document.getElementById('progressBar');
	var status = document.getElementById('status');
	status.innerHTML = "Uploading File";


	progressBar.style.width ="5%";

	incrementNumber();
	var i=0;


	for(i=0;i<=100;i++){

		progressBar.style.width = i+"%";

	}

	status.innerHTML = "File Uploaded!"




	}
</script>

</head>



<body>

<div class="container">

           <main role="main">

        <div class="jumbotron">
           <h2 class="display-3">Upload Your Files</h2>
          <form id="myForm" action="UploadFiles" ENCTYPE="multipart/form-data" method="post">
            <div class="form-group">
              <label>Select Your File</label>
              <input type="file" name="fileData" class="form-control" onchange="alertFileSize();" id="fileData" value="" placeholder="select file">
              <br>
            <button type="submit" class="btn btn-primary" onclick="validateForm()">Upload</button>  <button type="reset" onclick="cancel()" class="btn btn-danger">Clear</button>

            </div>

          </form>

            <div class="form-group">
              <label id="status">Upload Progress </label>

   <!-- PRogress Bar -->
             <div class="progress" style="margin-bottom:50px;">
             <div id="progressBar" class='progress-bar progress-bar-striped active' style='width:5%;'>
				5%
			</div>

			</div>

            </div>
        </div>
      </main>

    </div> <!-- /container -->


</body>
</html>