/**
 *
 */
package com.uks.shubham.struts.day1.a1.logic;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.day1.a1.bean.WelcomeBean;

/**
 * @author Shubham
 *
 */
public class WelcomeLogic extends ActionSupport  {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	// Initializing username and message variables
	public WelcomeBean objbean = new WelcomeBean();

	public String login(String loggedUsername,Map<String, Object> sessionMap) {

		// check if the userName is already stored in the session
		if (!loggedUsername.isEmpty()) {
			sessionMap.put("username", loggedUsername);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
