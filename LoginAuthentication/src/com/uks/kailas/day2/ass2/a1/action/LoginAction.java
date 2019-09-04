/**
 *
 */
package com.uks.kailas.day2.ass2.a1.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

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
public class LoginAction extends ActionSupport implements SessionAware{
	private SessionMap<String, Object> sessionMap;
	private static final long serialVersionUID = 1L;

	// Creating object
	UserDataAction objFetch = new UserDataAction();
	LoginLogic objLogic = new LoginLogic();

	public UserDataBean objuser;
	public LoginBean objbean;
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}


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
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		System.out.println("In execute");

		try {
		if(!(session.getAttribute("userId")==null)) {
			String getSessionAttr = (String) session.getAttribute("userId");
			System.out.println("AAAAA "+getSessionAttr);
		// checking username and password
				if (getSessionAttr != null&&getSessionAttr.equalsIgnoreCase(Constants.ADMIN)) {
					
				return "SUCCESS";
				}
			else if(getSessionAttr != null&&!getSessionAttr.equalsIgnoreCase(Constants.ADMIN)) {
				
				System.out.print("user session"+session.getAttribute("userId"));
				objuser = objFetch.fetchUserData(objbean.getUsername());
				return "SUCCESS";
				
				}
			else {
				return "LOGIN";
			}
			}
				String category;
				category = objLogic.validateUser(objbean);
				System.out.println(Constants.CATEGORY + category);
				
				 if (objbean.getPassword().equalsIgnoreCase(Constants.ADMIN)&&objbean.getUsername().equalsIgnoreCase(Constants.ADMIN) )
					{
						sessionMap.put("userId", objbean.getUsername());
						// fetch single user data
						objuser = objFetch.fetchUserData(objbean.getUsername());

						// fetch all  user data and store to list
						list = objFetch.fetchAllUserData();
						return Constants.SUCCESS;
					}else if(objbean.getCategory() != null){
						// fetch single user data
						sessionMap.put("userId", objbean.getUsername());
						objuser = objFetch.fetchUserData(objbean.getUsername());
						System.out.print("user session"+session.getAttribute("userId"));
						// Returning the list of objects
						return Constants.SUCCESS;
					}else {
						return "LOGIN";
					}
			}
			catch(Exception e) {
				
			}
		return "login";
	}
	public String logout() {
		
		sessionMap.remove("userId");
		sessionMap.invalidate();
		
		return "LOGOUT";
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
}
