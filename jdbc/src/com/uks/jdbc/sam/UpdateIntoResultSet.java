/**
 *
 */
package com.uks.jdbc.sam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.xml.internal.ws.util.StringUtils;

import Common.PropertyUtil;




public class UpdateIntoResultSet {

	Connection con;
	PropertyUtil objPropertyUtil = new PropertyUtil();

	//For Conneting to the DB
	void connect(){
		objPropertyUtil.readProperty();
		con = objPropertyUtil.connectToDatabse();
	}

	//For updation of records
	void updateInto(){
		try{
			//fire query for operations
			String query = "select * FROM employees";
			PreparedStatement  prepStmt = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = prepStmt.executeQuery();
			//For displaying records
			showRecords(rs);

			rs.first();
			System.out.println("Before Updating Records..................................!");
			while(rs.next()){
				//Updating Operation start
				//Getting first & last name
				String l_name = rs.getString("LastName");
		        String f_name = rs.getString("FirstName");

		        //Capitalizing first letter and update the records
				rs.updateString("FirstName", StringUtils.capitalize(f_name));
				rs.updateString("LastName", StringUtils.capitalize(l_name));
				rs.updateString("Title", "Asst. Manager");
				rs.updateRow();
			}
			//After updation show the data
			System.out.println("After Updating Records...................................!");
			rs.first();
			showRecords(rs);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	//For displaying the result set
	void showRecords(ResultSet rs){
		System.out.printf("%5s %15s %30s %40s %45s \n", "Employee ID", "Name", "Title", "Address", "HomePhone");
		System.out.println("==============================================================================================================================================================");
		//is executed until no more rows is there
		try {
			while(rs.next()){
				//Printing the Result in tabular format
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n",rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==============================================================================================================================================================");
	}

	//For disconneting to the DB
	void disconnect() throws Exception{
		objPropertyUtil.disconnect();
	}
}
