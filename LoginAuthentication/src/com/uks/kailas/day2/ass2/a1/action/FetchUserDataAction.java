package com.uks.kailas.day2.ass2.a1.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.uks.kailas.day2.common.db_logic.DbLogic;
import com.uks.kailas.day2.ass2.a1.bean.LoginBean;
import com.uks.kailas.day2.ass2.a1.bean.UserDataBean;

/**
 * @author kailas
 * Date :2019/9/2
 * Fetch user data from database
 *
 */
public class FetchUserDataAction {

	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	UserDataBean objuser = new UserDataBean();
	LoginBean objbean = new LoginBean();

	public UserDataBean fetchData(UserDataBean objuser_old, LoginBean objbean) throws SQLException, IOException {
		System.out.println("In fetchData");
	//	UserDataBean objuser=null;
		try{
		con = objDbLogic.connect();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM userdetails where userid = '"
				+ objbean.getUsername() + "' and password ='" + objbean.getPassword() + "'");
<<<<<<< HEAD
		objbean.setCategory(objbean.getUsername());
=======

>>>>>>> 6d909fdd434d8d32e1476833688a79634a105f57
		while (rs.next()) {
		//objuser = new UserDataBean();

			objuser.setFirstName(rs.getString(2));
			objuser.setMiddleName(rs.getString(3));
			objuser.setLastName(rs.getString(4));
			objuser.setGender(rs.getString(5));
			objuser.setEmailId(rs.getString(6));
			objuser.setAddress(rs.getString(7));
			objuser.setAddress(rs.getString(8));

		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return objuser;
	}
}
