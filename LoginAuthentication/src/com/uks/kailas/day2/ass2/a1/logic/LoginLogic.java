/**
 *
 */
package com.uks.kailas.day2.ass2.a1.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.uks.kailas.day2.common.db_logic.DbLogic;
import com.uks.kailas.day2.common.util.Constants;
import com.uks.kailas.day2.ass2.a1.bean.LoginBean;

/**
 * @author kailas
 * Date :2019/9/2
 * To check login details with database
 *
 */
public class LoginLogic {
	/*
	 * This class is using for the Login logic
	 * */
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;
	LoginBean objbean = new LoginBean();

	//This methods validate user is prasent in your system or not
	public String validateUser(LoginBean objbean) throws SQLException {
		PreparedStatement objPreparedStatement = null;
		ResultSet objResultSet = null;

		//String category = null;
		try {
			con = objDbLogic.connect();

			//Executing the query
			objPreparedStatement = con
					.prepareStatement(Constants.QUERY_ASS_TWO_THREE);

			objPreparedStatement.setString(1,objbean.getUsername() );
			objPreparedStatement.setString(2, objbean.getPassword() );

			// execute the query
			objResultSet = objPreparedStatement.executeQuery();

			//checks records available or not
			if (objResultSet.next()) {
				objbean.setCategory(objbean.getUsername());

				System.out.print(Constants.LOGINSUCCESS);
				System.out.print(objbean.getCategory());

				return objbean.getCategory();
			}
			else if(objbean.getUsername().equals(Constants.ADMIN)&&objbean.getPassword().equals(Constants.ADMIN)){
				objbean.setCategory(Constants.ADMIN);
				System.out.print(Constants.LOGINSUCCESS);
				return objbean.getCategory();
			}
			else{
				return "LOGIN";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		//returning the boolean
		return objbean.getCategory();
	}
}
