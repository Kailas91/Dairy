// to validate all fields
function myFunction() {
  var x = document.getElementById("myRadio").required;
  document.getElementById("demo").innerHTML = x;
  var selSex=document.getElementById('myRadio').value;

}
function validate()
{

var sal=document.getElementById('scripts').value;
if((sal=="Mr")&&(StudentRegistration.sex[0].checked == false ) )
    {
      alert ( "Please choose your Gender Properly: Male or Female" );
      return false;
    }
else if((sal=="Miss")&&(StudentRegistration.sex[0].checked == true ) ){
  alert ( "Please choose your Gender Properly: Male or Female" );
  return false;
}

// email validation
   var email = document.StudentRegistration.emailid.value;
   atpos = email.indexOf("@");
   dotpos = email.lastIndexOf(".");

   if(email != "" )
	{
       if (atpos < 1 || ( dotpos - atpos < 2 ))
         {
             alert("Please enter correct email ID")
             document.StudentRegistration.emailid.focus() ;
             return false;
         }
	}

// date of birth validation
     if( document.StudentRegistration.year.value == "select year" )
    {
     alert( "Please provide year!" );
    document.StudentRegistration.City.focus() ;
     return false;
    }

   if( document.StudentRegistration.month.value == "select month" )
   {
     alert( "Please provide month!" );
   document.StudentRegistration.City.focus() ;
     return false;
   }

  if( document.StudentRegistration.day.value == "select date" )
   {
     alert( "Please provide date!" );
     document.StudentRegistration.City.focus() ;
     return false;
   }

	var interest=document.getElementsByName('interest[]')
    var otherinterest=document.forms[0].elements["otherinterest"].value;
	otherinterest=otherinterest.trim();


	  if(!valthisform())
	   {
          if( otherinterest==""||otherinterest==null)
		   {
          alert('select any one interest or write into other interest');
		  return false;
           }
	   }

   alert('Successfully Registered');
   return( true );

}
// reset all text fields
function clearText()
{

	document.getElementById('StudentRegistration').reset();
}

// check all fields are filled then return true  then submit form
function valthisform() {
    var chkd = document.StudentRegistration.web.checked || document.StudentRegistration.database.checked||  document.StudentRegistration.swing.checked|| document.StudentRegistration.mobile.checked

    if (chkd)
	{
      return true; //Submit the form
    } else {

      return false; //not submitted
    }
  }
