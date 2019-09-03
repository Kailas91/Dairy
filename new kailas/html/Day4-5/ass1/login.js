
// this function will used to validate all the fields in login form
function validateForm()
  {
	  // get loginid and password values from login forms
    var id = document.forms["myForm"]["loginid"].value;
    var pass = document.forms["myForm"]["password"].value;

// user enetr correct userid and password then this condition execute
    if (id=="kailas" && pass=="kailas")
       {
            alert("Login Successfully ");
       }
// user enetr incorrect userid and password then this condition execute
      else
       {
		 alert("Invalid UserName and Password");
       }
   }

   // this function will used to clear the loginid  and password fields value
     function clearText()
      {
	    document.getElementById('loginid').value = '';
	    document.getElementById('password').value = '';
      }
