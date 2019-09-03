/**
 *
 */
package com.uks.kailas.day1.action;



import com.opensymphony.xwork2.ActionSupport;
import com.uks.kailas.day1.bean.WelcomeBean;
import com.uks.kailas.day1.logic.WelcomeLogic;
import com.uks.kailas.day1.common.Constants;
/**
 * @author Kailas
 * Date :2019/8/31
 * Description : main Action class that is used to pass result to struts.xml
 */
public class WelcomeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;

	// Initializing name and message variables
	public WelcomeBean objbean = new WelcomeBean();
	public WelcomeLogic objLogic = new WelcomeLogic();


	/**
	 * Description : this method will name is empty or not
	 */
	public String execute() {
		String name = objbean.getName();

		objLogic.checkName(name);

		if(name.equals("")){
			objbean.setMessage(Constants.ERRORM);
		}else{
			objbean.setMessage(Constants.WEL + name);
		}

		String str = name;
		if (!str.isEmpty())
			return Constants.SUCCESS;
		else
			return Constants.ERROR;
	}


}
