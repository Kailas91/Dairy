/**
 *
 */
package com.uks.kailas.day2.common.db_logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.uks.kailas.day2.common.util.Constants;

/**
 * @author kailas
 * Date :2019/9/2
 * Common Database class and returing the connection object
 *
 */
public class DbLogic {

	Connection con = null;

	@SuppressWarnings("finally")
	public Connection connect(){
		try{

			// Passing the property file location

			ResourceBundle myBundle = ResourceBundle.getBundle(Constants.PATH);
			String URL = myBundle.getString(Constants.DB_URL);
			String Driver = myBundle.getString(Constants.DB_DriverName);
			String db_username = myBundle.getString(Constants.DB_username);
			String db_password = myBundle.getString(Constants.Db_password);

			//finding the class
			Class.forName(Driver);
			con = DriverManager.getConnection(URL,db_username,db_password);
			System.out.println(Constants.CON);

		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return con;
			//returing connection object
		}
	}

	//Disconneting the connection of database
	public void disconnect(){
		try {
			System.out.println(Constants.DCON);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
