package com.uks.kailas.common;


// ass5
public class Constants {

	public static final String QUERY_ASS8 = "insert into DATA(URL) values (?)";
	public static final String PATHASS8="C:\\Users\\Kailas\\eclipse-workspace\\JSP\\WebContent\\file";
	public static final String UPLOADSUCCESS = "<script type=\"text/javascript\">"+"alert('Successfully Uploade !');"
			+"location='index.jsp';"+"</script>";
	public static final String DOWNSUCCESS = "<script type=\"text/javascript\">"+"alert('Successfully Download !');"
			+"location='CsvFileDownload.jsp';"+"</script>";
	public static final String UPLOADERROR = "<script type=\"text/javascript\">"+"alert('Please Contact Admin !');"
			+"location='index.jsp';"+"</script>";
	public static final String DOWNERROR = "<script type=\"text/javascript\">"+"alert('Please Contact Admin !');"
			+"location='CsvFileDownload.jsp';"+"</script>";
	public static final String PATTERNASS8="/ass8/upload";
	public static final String PATTERNASS9="/ass9/FileDownload";
	public static final String PATTERNASS10="/ass10/FileDownloadServlet";
	//ass9
	public static final String DOWNPATHASS9="C:\\Users\\Kailas\\eclipse-workspace\\JSP\\WebContent\\file\\" ;
	public static final String ASS9CONTENT="APPLICATION/OCTET-STREAM";

	public static final String QUERY_TWO = "insert into userdetails(UserId, Password, Salutation, FirstName, MiddleInitial,LastName,Sex,EmailId,BirthDate,Address,AreaOfInterest,OtherInterest,Category) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String QUERY_ASS_FOUR = "select * from userdetails where UserId=?";
	public static final String QUERY_ASS_FIVE = "select * from userdetails where UserId=? and Password=?";
	public static final String QUERY_ASS_SIX = "UPDATE userdetails SET UserId =?,Password = ? ,Salutation = ?,FirstName = ?,MiddleInitial= ?,LastName =?,Sex =?,EmailId = ?,BirthDate = ?,Address = ?,AreaOfInterest =?,OtherInterest =? WHERE UserId=?";
	public static final String QUERY_ASS_SEVEN = "select * from customers";

	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String SALUTATION = "scripts";
	public static final String FIRSTNAME = "firstname";
	public static final String MIDDLENAME = "middlename";
	public static final String LASTNAME = "lastname";
	public static final String SEX = "sex";
	public static final String EMAILID = "emailid";
	public static final String DATE = "day";
	public static final String MONTH = "month";
	public static final String YEAR = "year";
	public static final String ADDRESS = "Address";
	public static final String INTEREST = "web";
	public static final String OTHERINTEREST = "otherinterest";

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

	public static final String CONSOLE="<h1 align=\"center\"><b>User Details are printed on the console !</b></h1>";
	public static final String line="\n================================================";


	public static final String MESSAGE = "Hello World";
	public static final String LOGINID = "loginId";
	public static final String IDPASSWORD = "pwd";
	public static final String UTF = "UTF-8";
	public static final String H1 = "<h1>";
	public static final String USER = "UserID";
	public static final String ENTERUSERNAME = "Please Enter User Id";
	public static final String ENTERPASSWORD = "Please Enter Password";
	public static final String ADMIN = "Admin";
	public static final String ERRORFORLOGIN = "<script type=\"text/javascript\">"+"alert('UserId and Password Incorrect !');"
	+"location='LoginJsp.jsp';"+"</script>";
	public static final String ERRORFORDB = "<script type=\"text/javascript\">"+"alert('Please Contact Admin !');"
			+"location='LoginJsp.jsp';"+"</script>";

	public static final String PATTERNASS5="/ass5/LoginServlet";
	public static final String PATTERNASS1="/ass1/Userdetail";




	public static final String PATTERNASS6="/ass6/LoginServletTwo";
	public static final String PATTERNASS62="/ass6/EditUserDetailsServlet";
	public static final String PATTERNASS63="/ass6/UpdateUserDetailsServlet";

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
	public static final String REGISTERED = "Thank You !!! You are registered...";

	public static final String INVUSERPASS = "Invalid UserName or Password";

	public static final String RESULT = "result";

	public static final String DISPATCHER_TRUE_ASS1 = "/WEB-INF/jsp/ass1/Success.jsp";
	public static final String DISPATCHER_FALSE_ASS1 = "/WEB-INF/jsp/ass1/Userdetails.jsp";

	public static final String SUCCESS = "/WEB-INF/jsp/ass1/Success.jsp";
	public static final String DISPATCHERASS2 = "/WEB-INF/jsp/ass2/UserdetailsA.jsp";
	public static final String ERROR = "/WEB-INF/jsp/ass1/Error.jsp";

	public static final String DISPATCHER_ASS4_RES = "/ass5/Result.jsp";
	public static final String ATTRIBUTE_1ASS4 = "objUserDetailsBinSecond";
	public static final String DISPATCHER_ASS4 = "/ass5/LoginJsp.jsp";
	public static final String RESULT_ASS4 = "/ass4/Result.jsp";
	public static final String DISPATCHER_ASS5 = "/ass5/UserDetailsC.jsp";


	public static final String SUCCESSFULLY_UPDATED = "/ass6/SuccessfullyUpdated.jsp";
	public static final String UPDATE_ASS6_DISPATCHER = "/ass6/Userdetails.jsp";
	public static final String DISPATCHER_ASS6 = "/ass6/Userdetails.jsp";
	public static final String ASS6_RESULT = "/ass6/Resultone.jsp";
	public static final String ASS6_LOGIN = "/ass6/Login.jsp";

	public static final String PASS = "password";

	public static final String USERIDPASSWORDASS7 = "Admin";
	public static final String DISPATCHER_JSP_ASS7 = "/WEB-INF/jsp/ass7/UserList.jsp";
	public static final String LOGIN_JSP_ASS7 = "/WEB-INF/jsp/ass7/Login.jsp";
	public static final String OBJ_USERDETAILSBIN_SECOND = "objUserDetailsBinSecond";
	public static final String CHANGE_USERDETAILS_ASS7 = "/WEB-INF/jsp/ass7/ChangeUserdetails.jsp";
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
	public static final String FILEUPFAIL = "File Upload Failed due to ";
	public static final String ERRORMSGASS_SEVEN = "Sorry this Servlet only handles file upload request";
	public static final String RESULTJSPASS_EIGHT = "/WEB-INF/jsp/ass8/Result.jsp";

	// ass9

	public static final String FILEDOWNLOADJSPASS9 = "/ass9/file.jsp";
	public static final String LIST = "list";
	public static final String FILE = "file";
	public static final String MIMETYPE = "mimetype";
	public static final String CONTENTDISPOSITION = "Content-Disposition";
	public static final String ATTACHMENTFILENAME = "attachment; filename=\"";

	// ass10
	public static final String FILECREATEDMESSAGE = "File created Successfully";
	public static final String RESULTJSPASS10 = "/ass10/CsvFileDownload.jsp";

	// database related strings for connection and queries
	public static final String DRIVER = "driver";
	public static final String PATH = "path";
	public static final String MySQLUSERNAME = "userName";
	public static final String MYSQLPASSWORD = "password";
	public static final String MYSQLPROPERTIESPATH = "com.uks.kailas.resources.mysqlsettings";


	public static final String SPACE = "  ";
	public static final String ERRORMSG = "OPPS!!!!ERROR!!";
	public static final String LISTDATA = "listData";
	public static final String RESULTASS5 = "/WEB-INF/jsp/ass4/Resultinfo.jsp";
	public static final String SEMICOLON = " : ";
	public static final String LINESPACE = "\n";
	public static final String SLASH = "/";
	public static final String BLANKCHARACTER = "";
	public static final String COMMA = ",";
	public static final String DASH = "-";

	public static final String FILEUPLOADPATH = "D:/Upload/Data.txt";
	public static final String DISCONNETEDMSG = "DisConnected...";
	public static final String FILEDOWNLOADPATH = "D://Upload";

	public static final String DBUSERID = "UserId";
	public static final String DBPASSWORD = "Password";
	public static final String DBSALUTATION = "Salulation";
	public static final String DBFIRSTNAME = "FirstName";
	public static final String DBMIDDLENAME = "MiddleInitial";
	public static final String DBLASTNAME = "LastName";
	public static final String DBSEX = "gender";
	public static final String DBEMAILID = "Email";
	public static final String DBBIRTHDATE = "dob";
	public static final String DBADDRESS = "Address";
	public static final String DBINTERESTS = "AreaOfInterest";
	public static final String DBOTHERINTERESTS = "OtherInterest";
	public static final String CATEGORY = "category";
	public static final String DISPATCHSEVEN = "/WEB-INF/jsp/ass7/ChangeUserdetails.jsp";
	public static final String ERRORPAGE = "/Error.jsp";
	public static final String DETAILSEVEN = "/WEB-INF/jsp/ass7/Userdetails.jsp";

}
