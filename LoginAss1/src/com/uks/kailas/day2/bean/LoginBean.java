/**
 *
 */
package com.uks.kailas.day2.bean;

/**
 * @author kailas
 * Date :2019/8/31
 * Description : getter and setter methods
 */
public class LoginBean {

	//Getter and Setter Methods
	String username,password,category,message;


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
