/**
 *
 */
package com.uks.kailas.day2.action;
import com.opensymphony.xwork2.ActionSupport;
import com.uks.kailas.day2.bean.LoginBean;

import com.uks.kailas.day2.common.util.Constants;
import com.uks.kailas.day2.logic.LoginLogic;;

/**
 * @author kailas
 * Date :2019/8/31
 * To check login details are valid or not to  user
 *
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// Creating object

	LoginLogic objLogic = new LoginLogic();


	public LoginBean objbean;

	//  array list of UserDataBean class
	public LoginBean getObjbean() {
		return objbean;
	}

	public void setObjbean(LoginBean objbean) {
		this.objbean = objbean;
	}

	// execute() is the default method
	public String execute() {


		// checking user name and password
		if (objbean.getPassword().length() == 0 && objbean.getUsername().length() == 0) {
			addActionError(Constants.ERRORIUP);

		}

		else if (objbean.getPassword().length() == 0) {
			addActionError(Constants.RP);
		}


		else if (objbean.getUsername().length() == 0) {
			addActionError(Constants.RU);
		}
		else if (!objbean.equals(null)) {

			String category;
			try {
				category = objLogic.validateUser(objbean);

				if (objbean.getCategory() != null) {
					if (category.equalsIgnoreCase(Constants.ADMIN)) {


						return Constants.SUCCESS;
					} else {

						return Constants.SUCCESS;
					}

				}
				 else {

						addActionError(Constants.IUP);
					}
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println(e);
				return Constants.ERR;
			}

		}
		// return login if user unable to login into the system
		return Constants.LOGIN;
	}
}
