package com.uks.kailas.common;

/**
 * This is a bean class used to hold various details of the user data
 *
 * @author kishan
 *
 */
public class UserDetailsBean {

	private String userName = null;
	private String password = null;
	private String salutation = null;
	private String firstName = null;
	private String middlename = null;
	private String lastName = null;
	private String sex = null;
	private String emailId = null;
	private String day = null;
	private String month = null;
	private String year = null;
	private String address = null;
	private String[] interest = null;
	private String otherinterest = null;
	private String interstTwo = null;
	private String birthDate = null;
	private String web = null;
	private String database = null;
	private String swing = null;
	private String mobile = null;
	private String category = null;

	/**
	 * This method is used to return the category of the user set or fetched
	 *
	 * @return String
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * This method is used to set the category
	 *
	 * @param category
	 * @return void
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * This method is used to return the String web if user has selected this
	 * interest in the form
	 *
	 * @return String
	 */
	public String getWeb() {
		return web;
	}

	/**
	 * This method is used to set the web
	 *
	 * @param web
	 * @return void
	 */
	public void setWeb(String web) {
		this.web = web;
	}

	/**
	 * This method is used to return the String database if user has selected
	 * this interest in the form
	 *
	 * @return String
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * This method is used to set the database
	 *
	 * @param database
	 * @return void
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * This method is used to return the String swing if user has selected this
	 * interest in the form
	 *
	 * @return String
	 */
	public String getSwing() {
		return swing;
	}

	/**
	 * This method is used to set the swing
	 *
	 * @param swing
	 * @return void
	 */
	public void setSwing(String swing) {
		this.swing = swing;
	}

	/**
	 * This method is used to return the String mobile if user has selected this
	 * interest in the form
	 *
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * This method is used to set the mobile
	 *
	 * @param mobile
	 * @return void
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * This method is used to return the intersts of the user set or fetched
	 *
	 * @return String
	 */
	public String getInterstTwo() {
		return interstTwo;
	}

	/**
	 * This method is used to set the intersts
	 *
	 * @param interstTwo
	 * @return void
	 */
	public void setInterstTwo(String interstTwo) {
		this.interstTwo = interstTwo;
	}

	/**
	 * This method is used to return the birthDate of the user set or fetched
	 *
	 * @return String
	 */
	public String getBirthdate() {
		return birthDate;
	}

	/**
	 * This method is used to set the Birthdate
	 *
	 * @param Birthdate
	 * @return void
	 */
	public void setBirthdate(String Birthdate) {
		this.birthDate = Birthdate;
	}

	/**
	 * This method is used to return the userName of the user set or fetched
	 *
	 * @return String
	 */
	public String getUsername() {
		return userName;
	}

	/**
	 * This method is used to set the username
	 *
	 * @param username
	 * @return void
	 */
	public void setUsername(String username) {
		this.userName = username;
	}

	/**
	 * This method is used to return the password of the user set or fetched
	 *
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method is used to set the password
	 *
	 * @param password
	 * @return void
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method is used to return the salutation of the user set or fetched
	 *
	 * @return String
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * This method is used to set the salutation
	 *
	 * @param salutation
	 * @return void
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	/**
	 * This method is used to return the firstName of the user set or fetched
	 *
	 * @return String
	 */
	public String getFirstname() {
		return firstName;
	}

	/**
	 * This method is used to set the firstName
	 *
	 * @param firstName
	 * @return void
	 */
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * This method is used to return the middlename of the user set or fetched
	 *
	 * @return String
	 */
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * This method is used to set the middlename
	 *
	 * @param middlename
	 * @return void
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * This method is used to return the lastName of the user set or fetched
	 *
	 * @return String
	 */
	public String getLastname() {
		return lastName;
	}

	/**
	 * This method is used to set the lastname
	 *
	 * @param lastname
	 * @return void
	 */
	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	/**
	 * This method is used to return the sex of the user set or fetched
	 *
	 * @return String
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * This method is used to set the sex
	 *
	 * @param sex
	 * @return void
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * This method is used to return the emailId of the user set or fetched
	 *
	 * @return String
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * This method is used to set the emailId
	 *
	 * @param emailId
	 * @return void
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * This method is used to return the Birth day of the user set or fetched
	 *
	 * @return String
	 */
	public String getDay() {
		return day;
	}

	/**
	 * This method is used to set the day
	 *
	 * @param day
	 * @return void
	 */
	public void setDay(String day) {

		this.day = day;
	}

	/**
	 * This method is used to return the Birth month of the user set or fetched
	 *
	 * @return String
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * This method is used to set the month
	 *
	 * @param month
	 * @return void
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * This method is used to return the Birth year of the user set or fetched
	 *
	 * @return String
	 */
	public String getYear() {
		return year;
	}

	/**
	 * This method is used to set the year
	 *
	 * @param year
	 * @return void
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * This method is used to return the address of the user set or fetched
	 *
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method is used to set the address
	 *
	 * @param address
	 * @return void
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method is used to return the interest of the user set or fetched
	 *
	 * @return String
	 */
	public String[] getInterest() {
		return interest;
	}

	/**
	 * This method is used to set the interests
	 *
	 * @param String
	 *            [] interest
	 * @return void
	 */
	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	/**
	 * This method is used to return the otherinterest of the user set or
	 * fetched
	 *
	 * @return String
	 */
	public String getOtherinterest() {
		return otherinterest;
	}

	/**
	 * This method is used to set the Otherinterest
	 *
	 * @param setOtherinterest
	 * @return void
	 */
	public void setOtherinterest(String otherinterest) {
		this.otherinterest = otherinterest;
	}
}
