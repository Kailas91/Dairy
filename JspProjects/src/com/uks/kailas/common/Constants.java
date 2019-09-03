package com.uks.kailas.common;


// ass5
public class Constants {

	public static final String QUERY_ASS8 = "insert into DATA(name,URL) values (?,?)";
	public static final String QUERY_ASS9 = "select url from data";

	public static final String PATHASS8="D:\\jvs_ws\\JspProjects\\WebContent\\files";

	public static final String UPLOADSUCCESS = "<script type=\"text/javascript\">"+"alert('Successfully Uploade !');"
			+"location='index.jsp';"+"</script>";

	public static final String DOWNSUCCESS = "<script type=\"text/javascript\">"+"alert('Successfully Download in D:/upload path !');"
			+"location='CsvFileDownload.jsp';"+"</script>";

	public static final String UPLOADERROR = "<script type=\"text/javascript\">"+"alert('Please Contact Admin !');"
			+"location='index.jsp';"+"</script>";
	public static final String DOWNERROR = "<script type=\"text/javascript\">"+"alert('Please Contact Admin !');"
			+"location='CsvFileDownload.jsp';"+"</script>";

	public static final String PATTERNASS8="/ass8/upload";
	public static final String PATTERNASS9="/ass9/FileDownload";
	public static final String PATTERNASS10="/ass10/FileDownloadServlet";
	public static final String FILE = "file";
	//ass9
	public static final String DOWNPATHASS9="D:\\jvs_ws\\JspProjects\\WebContent\\files\\" ;
	public static final String DOWNPATHASS10="D:\\upload\\filesData.csv" ;
	public static final String ASS9CONTENT="APPLICATION/OCTET-STREAM";

	public static final String MYSQLPROPERTIESPATH = "com.uks.kailas.resources.mysqlsettings";
	public static final String QUERY_ASSTWO="insert into userdetails(salulation,firstname,middleinitial,lastname,gender,email,dob,address,userid,password,areaofinterest,otherinterest) values(?,?,?,?,?,?,?,?,?,?,?,?)";

	public static final String QUERY_ASS_FOUR = "select * from userdetails where UserId=?";

	public static final String QUERY_ASS_FIVE = "select * from userdetails where UserId=? and Password=?";

	public static final String QUERY_ASS_SIX = "UPDATE userdetails SET  Salulation = ?,FirstName = ?,MiddleInitial= ?,LastName =?,gender =?,Email = ?,dob = ?,Address = ?,userid=?,AreaOfInterest =?,OtherInterest =? WHERE UserId=?";
	public static final String QUERY_ASS_SEVEN = "select * from userdetails";
	public static final String QUERY_ASS_SEVEN_UID="SELECT * from userdetails where uid =?";
	public static final String QUERY_ASS_7="UPDATE userdetails SET salulation=?,firstname=?,middleinitial=?,lastname=?,gender=?,email=?,dob=?,address=?,userid=?,password=?,areaofinterest=?,otherinterest=? WHERE uid=?";
	public static final String LOGINJSP="/ass7/LoginJsp.jsp";



	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String PASSWARD = "passward";
		public static final String UNAME = "uname";
			public static final String USERID = "userId";
			public static final String UID = "uid";
	public static final String PASS2 = "pass";
	public static final String DATEF="yyyy-MM-dd";
	public static final String SALUTATION = "scripts";
	public static final String SAL1 = "sal1";
	public static final String SAL2 = "salutation";

	public static final String FIRSTNAME = "firstname";
	public static final String FNAME = "fname";
	public static final String MIDDLENAME = "middlename";
	public static final String MIDDLENAME2="middleName";
	public static final String MIDDLE="middle";
	public static final String LASTNAME = "lastname";
	public static final String LNAME = "lname";
	public static final String SEX = "sex";
	public static final String EMAILID = "emailid";
	public static final String DATE = "day";
	public static final String MONTH = "month";
	public static final String YEAR = "year";
	public static final String ADDRESS = "Address";
		public static final String ADDRESS2 = "address";
	public static final String INTEREST = "web";
	public static final String INTEREST2 = "interests";
	public static final String OTHERINTEREST = "otherinterest";
	public static final String OINTEREST = "otherInterest";
	public static final String USERNAMEP = "User Name : ";
	public static final String PASSWORDP = "Password : ";
	public static final String SALUTATIONP = "Salutation : ";
	public static final String FIRSTNAMEP = "First Name : ";
	public static final String MIDDLENAMEP = "Middle Name : ";
	public static final String LASTNAMEP = "Last Name : ";
	public static final String SEXP = "Gender : ";
	public static final String EMAILIDP = "Email Id : ";
	public static final String DATEP = "Birth Date : ";
	public static final String ADDRESSP = "Address : ";
	public static final String INTERESTP = "Interest : ";
	public static final String OTHERINTERESTP = "Other Interest : ";
	public static final String ULIST="usersList";
	public static final String BIRTH="birth";
	public static final String INTERESTS="interest";
	public static final String OIN="othinterest";







	public static final String CONSOLE="<h1 align=\"center\"><b>User Details are printed on the console !</b></h1>";
	public static final String BROWSER="<h1 align=\"center\"><b> User Details  !</b></h1>";
	public static final String line="\n================================================";

	public static final String TABLE="<table border=1 width=30% height=10%>";
	public static final String SALTR="<tr><td>Salutation is : </td><td>" ;
	public static final String TD="</td></tr>";
	public static final String FNAMETR="<tr><td>First Name is : </td><td>";
	public static final String MNAMETR="<tr><td>Middle Initial is : </td><td>";
	public static final String LNAMETR="<tr><td>Last Name is : </td><td>";
	public static final String SEXTR="<tr><td>Gender : </td><td>";
	public static final String EMAILTR="<tr><td>Email Id : </td><td>";
	public static final String BIRTHTR="<tr><td>Birth Date : </td><td>";
	public static final String ADDRESSTR="<tr><td>Address is : </td><td>";
	public static final String UNAMETR="<tr><td>User Name is : </td><td>";
	public static final String PASSTR="<tr><td>Password is : </td><td>";
	public static final String INTTR="<tr><td>Interest is : </td><td>";
	public static final String OTHERTR="<tr><td>Other Interest is : </td><td>";
	public static final String CTABLE="</table>";
	public static final String CHTML="</html></center></body>";


	public static final String JAN="January";
	public static final String FEB="February";
	public static final String MAR="March";
	public static final String APR="April";
		public static final String MAY="May";
			public static final String JUN="June";
				public static final String JULY="July";
					public static final String AUG="August";
						public static final String SEP="September";
							public static final String OCT="October";
								public static final String NOV="November";
								public static final String DEC="December";


	public static final String MESSAGE = "Hello World";
	public static final String LOGINID = "loginId";
	public static final String IDPASSWORD = "pwd";
	public static final String UTF = "UTF-8";
	public static final String H1 = "<h1>";
	public static final String CENETR = "<center>";
	public static final String CTYPPE="text/html;charset=UTF-8";
	public static final String USER = "UserID";
	public static final String ENTERUSERNAME = "Please Enter User Id";
	public static final String ENTERPASSWORD = "Please Enter Password";
	public static final String ADMIN = "Admin";
	public static final String ERRORFORLOGIN = "<script type=\"text/javascript\">"+"alert('UserId and Password Incorrect !');"
	+"location='LoginJsp.jsp';"+"</script>";
	public static final String ERRORFORDB = "<script type=\"text/javascript\">"+"alert('Please Contact Admin !');"
			+"location='LoginJsp.jsp';"+"</script>";


				public static final String ERRORFORASS3 = "UserId already exists !!!";
				public static final String ERRORFORASS4 = "UserId already exists !!!";
				public static final String ERRORFORASS2 = "UserId already exists !!!";


				public static final String ERRORFORDBASS2 = "<script type=\"text/javascript\">"+"alert('Please Contact Admin !');"
			+"location='UserDetailsA.jsp';"+"</script>";
				public static final String ERRORFORDBASS3 = "<script type=\"text/javascript\">"+"alert('Please Contact Admin !');"
		+"location='UserDetailsB.jsp';"+"</script>";
				public static final String ERRORFORDBASS4 = "<script type=\"text/javascript\">"+"alert('Please Contact Admin !');"
						+"location='UserDetailsC.jsp';"+"</script>";

						public static final String UPSUCCESS = "<script type=\"text/javascript\">"+"alert('Details Update Successfully !');"
	+"location='LoginJsp.jsp';"+"</script>";

	public static final String UPERROR = "<script type=\"text/javascript\">"+"alert('Can not  Update Details Error Occured !');"
	+"location='LoginJsp.jsp';"+"</script>";

	public static final String PATTERNASS5="/ass5/LoginServlet";
	public static final String PATTERNASS51="/ass6/LoginServlet";
	public static final String PATTERNASS1="/ass1/Userdetail";
	public static final String PATTERNASS2="/ass2/UserdetailsA";
	public static final String PATTERNASS3="/ass3/UserdetailsB";
	public static final String PATTERNASS4="/ass4/UserdetailsC";

	public static final String ATTRI="authentication" ;
	public static final String ATTRI2="authenticated";
	public static final String LOGEDIN="loggedIn";
	public static final String TRUE="true";


	public static final String PATTERNASS6="/ass6/LoginServletTwo";
	public static final String PATTERNASS62="/ass6/EditUserDetailsServlet";
	public static final String PATTERNASS63="/ass6/UpdateUserDetailsServlet";
	public static final String PATTERNASS7LOGIN="/ass7/Login";
	public static final String PATTERNASS7ED="/ass7/EditUserDetails";
	public static final String PATTERNASS7UP="/ass7/UpdateUserDetails";
	public static final String LOGOUT="/ass7/Logout";


// ass6
	public static final String ENTERFIRSTNAME = "Please Enter First Name";
	public static final String ENTERLASTNAME = "Please  Enter Last Name";
	public static final String ENTERSEX = "Please Select Sex : Male or Female";
	public static final String ENTERBIRTHDATE = "Please Select Birth Date";
	public static final String ENTERBIRTHMONTH = "Please Select Birth Month";
	public static final String ENTERBIRTHYEAR = "Please Select Birth Year";
	public static final String VALIDATEFIRSTNAME = "First name contain characters only";
	public static final String VALIDATEMIDDLENAME = "middle name contain characters only";
	public static final String VALIDATELASTNAME = "Last name contain characters only";

	public static final String VALIDATEEMAILID = "Invalide emailId !!!Please Enter carrect email Id";
	public static final String VALIDATEADDRESS = "Address contain numbers and characters  only";
	public static final String VALIDATEOTHERINTEREST = "Other interest contain numbers and characters  only";
	public static final String VALIDATEDATE = "Invalid Birth Date..!! Plz Select Correct Date";
	public static final String VALIDATEINTEREST = "Plz Select Any One interset or Write into other interest ";
	public static final String USERIDPASSNOTSAME = "User Id and password can't be same";
	public static final String LESSSIZEOFUSERNAME = "Size of username is less than 6";
	public static final String LESSSIZEOFPASSWORD = "Size of passward is less";
	public static final String VALIDATEPASS = "Password size should be between 6 to 15,contain 1 small letter,1 capital letter,some  special character ,1 digit ";
	public static final String REGISTERED = "You are successfully registered Details print on Console";

	public static final String INVUSERPASS = "Invalid UserName or Password";

	public static final String RESULT = "result";

	public static final String DISPATCHER_TRUE_ASS1 = "/WEB-INF/jsp/ass1/Success.jsp";
	public static final String DISPATCHER_FALSE_ASS1 = "/ass1/UserDetails.jsp";

	public static final String SUCCESS = "/WEB-INF/jsp/ass1/Success.jsp";
	public static final String DISPATCHERASS2 = "/ass2/UserDetailsA.jsp";
	public static final String DISPATCHERASS3 = "/ass3/UserDetailsB.jsp";
	public static final String DISPATCHERASS4 = "/ass4/UserDetailsC.jsp";
	public static final String ERROR = "/WEB-INF/jsp/ass1/Error.jsp";

	public static final String DISPATCHER_ASS4_RES = "/ass5/Result.jsp";
	public static final String ATTRIBUTE_1ASS4 = "objUserDetailsBinSecond";

	public static final String DISPATCHER_ASS4 = "/ass5/LoginJsp.jsp";

	public static final String RESULT_ASS4 = "/ass4/Result.jsp";
	public static final String DISPATCHER_ASS5 = "/ass5/UserDetailsC.jsp";


	public static final String SUCCESSFULLY_UPDATED = "/ass6/success.jsp";

	public static final String SUCCESSFULLY_UPDATED7 = "/ass7/success.jsp";
	public static final String UPDATE_ASS6_DISPATCHER = "/ass6/Userdetails.jsp";
	public static final String DISPATCHER_ASS6 = "/ass6/Userdetails.jsp";

	public static final String ASS6_RESULT = "/ass6/Resultone.jsp";
	public static final String ASS6_RESULT2 = "/ass6/Result.jsp";
	public static final String ASS4_RESULT = "/ass4/Resultone.jsp";

	public static final String ASS6_LOGIN = "/ass6/LoginJsp.jsp";
	public static final String ASS7_LOGIN = "/ass7/LoginJsp.jsp";
	public static final String ASS8_FILEUP= "/ass8/index.jsp";
	public static final String ASS10_FILEDN= "/ass10/CsvFileDownload.jsp";
	public static final String PASS = "password";

	public static final String USERIDPASSWORDASS7 = "Admin";
	public static final String LOGJSP="LoginJsp.jsp";
	public static final String DISPATCHER_JSP_ASS7 = "UserList.jsp";
	public static final String DISPATCHER_JSP_ASS72 = "UserListUser.jsp";
	public static final String LOGIN_JSP_ASS7 = "/ass7/LoginJsp.jsp";
	public static final String OBJ_USERDETAILSBIN_SECOND = "objUserDetailsBinSecond";
	public static final String CHANGE_USERDETAILS_ASS7 = "/ass7/EditUserDetails.jsp";
	public static final String SUCESSFULLYUPDATEASS7 = "/ass6/SuccessfullyUpdated.jsp";
	public static final String ID = "id";
	public static final String WEB = "web";
	public static final String DATABASE = "database";
	public static final String SWING = "swing";
	public static final String MOBILE = "mobile";

	// ass8

	public static final String UPLOAD_DIRECTORY = "D:/Upload/";
	public static final String MESSAGEONE = "message";
	public static final String FILEUPSUCCESS = "File Uploaded Successfully";
	public static final String DATAUPDATESUCCESS = "Data Updated Successfully !!";
	public static final String FILEUPFAIL = "File Upload Failed due to ";
	public static final String ERRORMSGASS_SEVEN = "Sorry this Servlet only handles file upload request";
	public static final String RESULTJSPASS_EIGHT = "/ass8/Result.jsp";

	// ass9
	public static final String DIRECTORYPATH = "D:/Upload";
	public static final String FILEDOWNLOADJSPASS9 = "/ass9/FileDownload.jsp";
	public static final String LIST = "list";
	public static final String FILEPATH = "filePath";
	public static final String MIMETYPE = "mimetype";
	public static final String CONTENTDISPOSITION = "Content-Disposition";
	public static final String ATTACHMENTFILENAME = "attachment; filename=\"";

	// ass10
	public static final String FILEDN = "File Download Successfully";

	public static final String RESULTJSPASS10 = "/ass10/CsvFileDownload.jsp";

	// database related strings for connection and queries
	public static final String DRIVER = "driver";
	public static final String PATH = "path";

	public static final String MySQLUSERNAME = "userName";
	public static final String MYSQLPASSWORD = "password";



	public static final String SPACE = "  ";
	public static final String ERRORMSG = "OPPS!!!!ERROR!!";
	public static final String LISTDATA = "listData";
	public static final String SEMICOLON = " : ";
	public static final String LINESPACE = "\n";
	public static final String SLASH = "/";
	public static final String BLANKCHARACTER = "";
	public static final String COMMA = ",";
	public static final String DASH = "-";

	public static final String FILEUPLOADPATH = "filesData.csv";
	public static final String FILEDOWNLOADPATH = "D://upload";

	public static final String CSVNAME="filesData.csv";

	public static final String DBUSERID = "UserId";
	public static final String DBPASSWORD = "Password";
	public static final String DBSALUTATION = "Salulation";
	public static final String DBFIRSTNAME = "firstName";
	public static final String DBMIDDLENAME = "MiddleInitial";
	public static final String DBLASTNAME = "lastName";
	public static final String DBSEX = "gender";
	public static final String DBEMAILID = "email";
		public static final String DBEMAILID2 = "emailId";
	public static final String DBBIRTHDATE = "dob";
	public static final String DBADDRESS = "Address";
	public static final String DBINTERESTS = "AreaOfInterest";
	public static final String DBOTHERINTERESTS = "OtherInterest";
	public static final String CATEGORY = "category";
	public static final String DISPATCHSEVEN = "/ass7/ChangeUserdetails.jsp";
	public static final String ERRORPAGE = "/Error.jsp";
	public static final String DETAILSEVEN = "/ass7/Userdetails.jsp";

}
