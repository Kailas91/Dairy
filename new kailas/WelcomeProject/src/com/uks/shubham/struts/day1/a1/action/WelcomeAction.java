/**
 *
 */
package com.uks.shubham.struts.day1.a1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.shubham.struts.day1.a1.bean.WelcomeBean;
import com.uks.shubham.struts.day1.a1.logic.WelcomeLogic;

/**
 * @author Shubham
 *
 */
public class WelcomeAction extends ActionSupport implements SessionAware {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Map<String, Object> sessionMap;
	// Initializing username and message variables
	public WelcomeBean objbean = new WelcomeBean();
	public WelcomeLogic objLogic = new WelcomeLogic();

	// String method of the class
	public String execute() {
		String loggedUsername = objbean.getUsername();
		//String loggedPassword = objbean.getPassword();
		objLogic.login(loggedUsername,sessionMap);

		objbean.setMessage("Hello " + loggedUsername);
		String str = loggedUsername;
		if (!str.isEmpty())
			return "success";
		else
			return "error";
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
