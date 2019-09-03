/**
 *
 */
package com.uks.kailas.day4.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.uks.kailas.day4.common.util.Constants;

/**
 * @author kailas
 * Date :2019/8/31
 * Common Database class and returing the connection object
 *
 */
public class DbLogic {

	Connection con = null;

	@SuppressWarnings("finally")
	public Connection connect(){
		try{

			// get values from property file to connect database

			ResourceBundle myBundle = ResourceBundle.getBundle(Constants.PATH);
			String URL = myBundle.getString(Constants.DB_URL);
			String Driver = myBundle.getString(Constants.DB_DriverName);
			String db_username = myBundle.getString(Constants.DB_username);
			String db_password = myBundle.getString(Constants.Db_password);

			Class.forName(Driver);

			con = DriverManager.getConnection(URL,db_username,db_password);
			System.out.println(Constants.CON);

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return con;

		}
	}

	//Disconnecting database
	public void disconnect(){
		try {
			System.out.println(Constants.DCON);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
