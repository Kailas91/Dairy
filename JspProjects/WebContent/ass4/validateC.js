// to validate all fields
 function goToInfo(){
       window.location = 'UserDetailsC.jsp';
   }
function validate(event)
{


	var name=document.getElementById('firstname').value;
	if(name==null||name=="")
	    {
		document.StudentRegistration.firstname.focus() ;
	      return false;
	    }

var sal=document.getElementById('scripts').value;
if((sal=="Mr")&&(StudentRegistration.sex[0].checked == false ) )
    {
	document.getElementById("error").innerHTML="Please choose your Gender Properly: Male or Female";
      return false;
    }
else if((sal=="Miss")&&(StudentRegistration.sex[0].checked == true ) ){
	document.getElementById("error").innerHTML="Please choose your Gender Properly: Male or Female";
  return false;
}

//email validation
var email = document.StudentRegistration.emailid.value;
atpos = email.indexOf("@");
dotpos = email.lastIndexOf(".");
if(email ==""||email==null){
	document.getElementById("error").innerHTML="Please enter email ID";
document.StudentRegistration.emailid.focus() ;
return false;
}
else if(email != "" )
	{
    if (atpos < 1 || ( dotpos - atpos < 2 ))
      {
    	document.getElementById("error").innerHTML="Please enter correct email ID";
          document.StudentRegistration.emailid.focus() ;
          return false;
      }
	}

// date of birth validation
   var year =document.getElementById('year').value;
   var month =document.getElementById('month').value;
   var day =document.getElementById('day').value;
     if( year == "select year" )
    {

    	 document.getElementById("error").innerHTML="Please select year";
    	 document.StudentRegistration.year.focus() ;
     return false;

    }
     if( month == "select month" )
     {
    	 document.getElementById("error").innerHTML="Please select month";
     	 document.StudentRegistration.month.focus() ;
      return false;

     }
     if( day == "select date" )
     {
    	 document.getElementById("error").innerHTML="Please select date";
     	 document.StudentRegistration.day.focus() ;
      return false;

     }

     var interest=document.getElementsByName('web[]')
     var otherinterest=document.forms[0].elements["otherinterest"].value;
 	otherinterest=otherinterest.trim();
 	if (otherinterest==""&& document.getElementById("web").checked == false && document.getElementById("database").checked == false &&document.getElementById("swing").checked==false &&document.getElementById("mobile").checked==false)

 	{
 		 document.getElementById("error").innerHTML='select any one interest or write into other interest';
 				return false;
 			}
 	else {
 				return true;
 			}

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
