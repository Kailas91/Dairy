/**
 *
 */
package com.uks.kailas.day1.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.kailas.day1.bean.WelcomeBean;
import com.uks.kailas.day1.logic.WelcomeLogic;

/**
 * @author kailas
 *
 */
public class WelcomeAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// Initializing user name and message variables
	public WelcomeBean objbean = new WelcomeBean();
	public WelcomeLogic objLogic = new WelcomeLogic();

	// String method of the class
	public String execute() {
		String name = objbean.getUsername();
		//String loggedPassword = objbean.getPassword();
		objLogic.CheckString(name);

		objbean.setMessage("Please enter name");
		String str = name;
		if (!str.isEmpty())
			return "success";
		else
			return "error";
		
	}
}
