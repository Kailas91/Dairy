package com.uks.kailas.day2.ass2.a1.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.uks.kailas.day2.common.db_logic.DbLogic;
import com.uks.kailas.day2.ass2.a1.bean.LoginBean;
import com.uks.kailas.day2.ass2.a1.bean.UserDataBean;
import com.uks.kailas.day2.ass2.a1.logic.UserLogic;


/**
 * @author kailas
 * Date :2019/9/2
 * To fetch data from UserDataBean class
 *
 */
public class UserDataAction {

	//Initializing the objects
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	UserDataBean objuser = new UserDataBean();
	LoginBean objbean = new LoginBean();
	UserLogic objLogic = new UserLogic();

	/**
	 * Description : get username from UserDataBean and call fetchUser method
	 * @param username
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public UserDataBean fetchUserData(String username) throws SQLException, IOException {
		System.out.println("In fetchuserData");

		UserDataBean objBean;
		//calling fetchUser method by passing usernmae as parameter
		objBean = objLogic.fetchUser(username);
		return objBean;
	}

	/**
	 * Description : it will fetch all user data and store to ArrayList
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<UserDataBean> fetchAllUserData() throws SQLException{
		System.out.println("In fetchAllUserData");
		//Calling method that return the arraylist of objects
		ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();
		list = objLogic.fetchAllUsers();

		//returning list
		return list;
	}
}
