

function myFunction() {
  var x = document.getElementById("myRadio").required;
  document.getElementById("demo").innerHTML = x;
  var selSex=document.getElementById('myRadio').value;

}
// for drag event
function drag(ev) {
  //set dragging data
  ev.dataTransfer.setData("text", ev.target.id);
}

function allowDrop(ev) {
  ev.preventDefault();
}

function drop(ev) {
  ev.preventDefault();
  var data = ev.dataTransfer.getData("text");
  //appen data to drop
  ev.target.appendChild(document.getElementById(data));
}

// to validate all fields
function validate()
{
var sal=document.getElementById('sal1').value;
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
 if(email ==""||email==null){
  alert("Please enter email ID")
  document.StudentRegistration.emailid.focus() ;
  return false;
   }
   else if(email != "" )
	{
       if (atpos < 1 || ( dotpos - atpos < 2 ))
         {
             alert("Please enter correct email ID")
             document.StudentRegistration.emailid.focus() ;
             return false;
         }
	}

// date of birth validation
var chkd = document.StudentRegistration.web.checked || document.StudentRegistration.database.checked||  document.StudentRegistration.swing.checked|| document.StudentRegistration.mobile.checked

if (chkd)
{
  alert('Successfully Registered');
  return true; //Submit the form
} else {
 alert ("please select any one Interest")
  return false; //not submitted
}
}
// reset all text fields
function clearText()
{
	document.getElementById('StudentRegistration').reset();
}

// check all fields are filled then return true  then submit form
