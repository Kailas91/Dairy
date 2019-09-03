package com.uks.kailas.day2.ass2.a1.logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.uks.kailas.day2.common.db_logic.DbLogic;
import com.uks.kailas.day2.common.util.Constants;
import com.uks.kailas.day2.ass2.a1.bean.UserDataBean;
/**
 * @author kailas
 * Date :2019/9/2
 *  user logic class to fetch users data from database
 *
 */
public class UserLogic {
	//Initilizing the objects
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	UserDataBean objuser = new UserDataBean();

	public UserDataBean fetchUser(String userid) throws SQLException {
		System.out.println("In fetchUser from user logic");
		// UserDataBean objuser=null;
		try{
		con = objDbLogic.connect();
		Statement stmt = con.createStatement();
		//Executing the query
		ResultSet rs = stmt.executeQuery(Constants.QUERY_ASS_TWO_TWO	+ userid + "'");

		//cheking records are available or not
		while (rs.next()) {
			//Setting the value through the setter method
			// objuser = new UserDataBean();
			objuser.setFirstName(rs.getString(1));
			objuser.setMiddleName(rs.getString(2));
			objuser.setLastName(rs.getString(3));
			objuser.setGender(rs.getString(4));
			objuser.setEmailId(rs.getString(5));
			objuser.setDob(rs.getString(6));
			objuser.setAddress(rs.getString(7));
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		//retuns the object of UserDataBean class
		return objuser;
	}


	public ArrayList<UserDataBean> fetchAllUsers() throws SQLException {
		ArrayList<UserDataBean> list = new ArrayList<UserDataBean>();

		Statement stmt = con.createStatement();
		//Executin gthe query
		ResultSet rs = stmt.executeQuery(Constants.QUERY_ASS_TWO);

		//cheking records are available or not
		while (rs.next()) {
			//Creating object here for storing multiple objects and returns it
			UserDataBean objuser = new UserDataBean();
			//Setting the value through the setter method
			objuser.setAddress(rs.getString(Constants.ADDRESS2));
			objuser.setDob(rs.getString(Constants.DOB));
			objuser.setEmailId(rs.getString(Constants.EMAILID));
			objuser.setFirstName(rs.getString(Constants.FIRSTNAME));
			objuser.setGender(rs.getString(Constants.SEX));
			objuser.setLastName(rs.getString(Constants.LASTNAME));
			objuser.setMiddleName(rs.getString(Constants.MIDDLENAME));

			//Adding data into the arraylist
			list.add(objuser);
		}

		//Returning the arraylist of objects
		return list;
	}
}
