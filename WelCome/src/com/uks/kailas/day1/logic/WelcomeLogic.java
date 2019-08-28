/**
 *
 */
package com.uks.kailas.day1.logic;



import com.opensymphony.xwork2.ActionSupport;
import com.uks.kailas.day1.bean.WelcomeBean;

/**
 * @author kailas
 *
 */
public class WelcomeLogic extends ActionSupport  {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	// Initializing name and message variables
	public WelcomeBean objbean = new WelcomeBean();

	public String CheckString(String name) {

		// check value is empty or not
		if (!name.isEmpty()) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
