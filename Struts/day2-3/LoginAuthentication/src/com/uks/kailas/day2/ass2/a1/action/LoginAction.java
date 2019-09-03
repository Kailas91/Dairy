/**
 *
 */
package com.uks.kailas.day2.ass2.a1.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.uks.kailas.day2.ass2.a1.bean.LoginBean;
import com.uks.kailas.day2.ass2.a1.bean.UserDataBean;
import com.uks.kailas.day2.ass2.a1.logic.LoginLogic;
import com.uks.kailas.day2.common.util.Constants;;

/**
 * @author kailas
 * Date :2019/9/2
 * To check login details are valid or not or their category user or admin
 *
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// Creating object
	UserDataAction objFetch = new UserDataAction();
	LoginLogic objLogic = new LoginLogic();

	public UserDataBean objuser;
	public LoginBean objbean;





	//  array list of UserDataBean class

	public ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();

	// Getter and Setter method for UserDataBean and LoginBean
	public UserDataBean getObjuser() {
		return objuser;
	}

	public void setObjuser(UserDataBean objuser) {
		this.objuser = objuser;
	}

	public LoginBean getObjbean() {
		return objbean;
	}

	public void setObjbean(LoginBean objbean) {
		this.objbean = objbean;
	}

	// execute() is the default starting method to be execute first
	public String execute() {

		System.out.println("In execute");

		// checking username and password
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
				System.out.println(Constants.CATEGORY + category);
				if (objbean.getCategory() != null) {
					if (objbean.getPassword().equalsIgnoreCase(Constants.ADMIN)&&objbean.getUsername().equalsIgnoreCase(Constants.ADMIN) ) {

						// fetch single user data
						objuser = objFetch.fetchUserData(objbean.getUsername());

						// fetch all  user data and store to list
						list = objFetch.fetchAllUserData();
						return Constants.SUCCESS;
					} else {
						// fetch single user data
						objuser = objFetch.fetchUserData(objbean.getUsername());
						// Returning the list of objects
						return Constants.SUCCESS;
					}

				}
				 else {
					 System.out.println("In else");
						addActionError(Constants.IUP);
					}
			} catch (SQLException | IOException e) {
				//e.printStackTrace();
				System.out.println(e);
				return Constants.ERR;
			}
			/*
			 * list = objFetch.fetchAllUserData(); return "success";
			 */

		}

		// return login if user unable to login into the system
		return Constants.LOGIN;
	}
}
