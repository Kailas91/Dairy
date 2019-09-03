/**
 *
 */
package com.uks.kailas.day1.logic;



import com.opensymphony.xwork2.ActionSupport;
import com.uks.kailas.day1.bean.WelcomeBean;
import com.uks.kailas.day1.common.Constants;

/**
 * @author Kailas
 * Date :2019/8/31
 * Description :  WelcomeLogic class contains logic of Welcome Action class
 */
public class WelcomeLogic extends ActionSupport  {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// initialize Bean class
	public WelcomeBean objbean = new WelcomeBean();

	/**
	 * Description : this method will call from WelcomeAction class to check name is empty or not
	 * @param name
	 * @return
	 */
	public String checkName(String name) {

		// check if the name is entered or not
		if (!name.isEmpty()) {

			return Constants.SUCCESS;
		}
			else{
				return Constants.ERROR;
		}
	}
}
