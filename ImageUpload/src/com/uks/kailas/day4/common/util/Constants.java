/**
 *
 */
package com.uks.kailas.day4.common.util;

/**
 * @author kailas
 *
 */
public class Constants {

	// ass2
	public static final String ERRORM = "Please Enter Name ";
	public static final String WEL = "WelCome  ";
	public static final String ERROR = "ERROR";
	public static final String SUCCESS = "SUCCESS";
	//Static final String variables
	public static final String DB_DriverName = "DBname";
	public static final String DB_URL="URL";
	public static final String DB_username  = "Username" ;
	public static final String Db_password = "Password";




	//path
	public static final String PATH="com.uks.kailas.day4.common.util.database";
	public static final String UPLOADPATH="D:\\jvs_ws\\ImageUpload\\WebContent\\WEB-INF\\files";

	// login page
	public static final String ERRORIUP = "Please Enter Username and password";
	public static final String RP="Password is required";
	public static final String RU="username is required";
	public static final String ADMIN="admin";
	public static final String IUP="Username and password is incorrect";
	public static final String ERR="error";
	public static final String LOGIN="login";
	public static final String CATEGORY="Cattegory";
	public static final String CON="Database Connected !!!!";
	public static final String DCON="Database Disonnected !!!!";
	public static final String LOGINSUCCESS="Log in successful !!!!!";



	// user details data

	public static final String FIRSTNAME = "firstname";
	public static final String MIDDLENAME = "middleinitial";
	public static final String LASTNAME = "lastname";
	public static final String SEX = "gender";
	public static final String EMAILID = "email";
		public static final String ADDRESS2 = "address";

		// upload image

		public static final String UPLOADSUCCESS = "Image Upload successfully to database";
		public static final String UPLOADNOT = "Image Not Upload to database";
		public static final String SELECTIMAGE = "Please select image";

	// query
	public static final String QUERY_ASS_TWO = "select * from userdetails";
	public static final String QUERY_ASS_TWO_TWO="SELECT firstname,middleinitial,lastname,gender,email,address FROM userdetails where userid = '";
	public static final String QUERY_ASS_TWO_THREE = "select * from userdetails where UserId=? and Password=?";

	public static final String QUERY_ASS4="INSERT INTO images(NAME,IMAGE) VALUES(?,?)";



}
