package com.uks.kailas.common;


import java.io.FileWriter;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;





public class DBLogicClass {


	/**
	 * This method is used to executes query on database and returns the object
	 * of the class UserDetailsbean if the enntered value match with that from
	 * database
	 *
	 * @param userName
	 *            - holds the value of inputted username
	 * @param password
	 *            - holds the name of the inputted password
	 * @return UserDetailsBean- contains the data about the user who username
	 *         and password are passed
	 * @throws SQLException
	 *             - Thrown when there is database access error or other errors.
	 * @throws Exception
	 *             - this is to handle all unknown exception
	 */




	public UserDetailsBean checkUserIdPassword(String userName, String password)
			throws SQLException, Exception {
		Connection connection = null;
		DatabaseLogic objDatabaseLogic = null;
		ResultSet objResultSet = null;
		PreparedStatement objPreparedStatement = null;
		UserDetailsBean objUserDetailsBean = null;

		try {
			objDatabaseLogic = new DatabaseLogic();
			// connect to the database
			connection = objDatabaseLogic.connect();
			objUserDetailsBean = new UserDetailsBean();
			objPreparedStatement = connection
					.prepareStatement(Constants.QUERY_ASS_FIVE);
			objPreparedStatement.setString(1, userName);
			objPreparedStatement.setString(2, password);
			// execute the query
			objResultSet = objPreparedStatement.executeQuery();
			while (objResultSet.next()) {
				// load the fetched data in UserDetailsBean object
				objUserDetailsBean.setUsername(objResultSet
						.getString(Constants.DBUSERID));
				objUserDetailsBean.setPassword(objResultSet
						.getString(Constants.DBPASSWORD));
				objUserDetailsBean.setSalutation(objResultSet
						.getString(Constants.DBSALUTATION));
				objUserDetailsBean.setFirstname(objResultSet
						.getString(Constants.DBFIRSTNAME));
				objUserDetailsBean.setMiddlename(objResultSet
						.getString(Constants.DBMIDDLENAME));
				objUserDetailsBean.setLastname(objResultSet
						.getString(Constants.DBLASTNAME));
				objUserDetailsBean.setSex(objResultSet
						.getString(Constants.DBSEX));
				objUserDetailsBean.setEmailId(objResultSet
						.getString(Constants.DBEMAILID));
				objUserDetailsBean.setBirthdate(objResultSet
						.getString(Constants.DBBIRTHDATE));
				objUserDetailsBean.setAddress(objResultSet
						.getString(Constants.DBADDRESS));
				objUserDetailsBean.setInterstTwo(objResultSet
						.getString(Constants.DBINTERESTS));
				objUserDetailsBean.setOtherinterest(objResultSet
						.getString(Constants.DBOTHERINTERESTS));
				objUserDetailsBean.setCategory(objResultSet
						.getString(Constants.CATEGORY));
			}
		}catch(Exception e){
			e.printStackTrace();
		}


		finally {
			if (objPreparedStatement != null) {
				objPreparedStatement.close();
				objPreparedStatement = null;
			}
			if (objResultSet != null) {
				objResultSet.close();
				objResultSet = null;
			}
			if (connection != null) {
				objDatabaseLogic.disconnect(connection);
			}
		}
		// return the loaded object
		return objUserDetailsBean;
	}

	/**
	 * This method is used to select values from databse and set into
	 * objUserDetailsBean
	 *
	 * @param objUserDetailsBin
	 * @return UserDetailsBean
	 * @throws SQLException
	 *             - Thrown when there is database access error or other errors
	 * @throws ClassNotFoundException
	 *             -Thrown when there is no definition of the class
	 * @throws Exception
	 *             - handles all the general exceptions
	 *
	 */
	public UserDetailsBean selectValues(UserDetailsBean objUserDetailsBin)
			throws SQLException, ClassNotFoundException, Exception {
		Connection connection = null;
		ResultSet objResultSet = null;
		PreparedStatement objPreparedStatement = null;
		UserDetailsBean objUserDetailsBean = null;
		DatabaseLogic objDatabaseLogic = null;
		try {
			objDatabaseLogic = new DatabaseLogic();
			objUserDetailsBean = new UserDetailsBean();
			// connect to the database
			connection = objDatabaseLogic.connect();
			objPreparedStatement = connection
					.prepareStatement(Constants.QUERY_ASS_FOUR);
			objPreparedStatement.setString(1, objUserDetailsBin.getUsername());
			// execute the query to fetch the data of the username given
			objResultSet = objPreparedStatement.executeQuery();
			while (objResultSet.next()) {
				// load the data fetched into the object of class
				// UserDetailsBean
				objUserDetailsBean.setUsername(objResultSet
						.getString(Constants.DBUSERID));
				objUserDetailsBean.setPassword(objResultSet
						.getString(Constants.DBPASSWORD));
				objUserDetailsBean.setSalutation(objResultSet
						.getString(Constants.DBSALUTATION));
				objUserDetailsBean.setFirstname(objResultSet
						.getString(Constants.DBFIRSTNAME));
				objUserDetailsBean.setMiddlename(objResultSet
						.getString(Constants.DBMIDDLENAME));
				objUserDetailsBean.setLastname(objResultSet
						.getString(Constants.DBLASTNAME));
				objUserDetailsBean.setSex(objResultSet
						.getString(Constants.DBSEX));
				objUserDetailsBean.setEmailId(objResultSet
						.getString(Constants.DBEMAILID));
				objUserDetailsBean.setBirthdate(objResultSet
						.getString(Constants.DBBIRTHDATE));
				objUserDetailsBean.setAddress(objResultSet
						.getString(Constants.DBADDRESS));
				objUserDetailsBean.setInterstTwo(objResultSet
						.getString(Constants.DBINTERESTS));
				objUserDetailsBean.setOtherinterest(objResultSet
						.getString(Constants.DBOTHERINTERESTS));
			}
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			if (objResultSet != null) {
				objResultSet.close();
				objResultSet = null;
			}
			if (objPreparedStatement != null) {
				objPreparedStatement.close();
				objPreparedStatement = null;
			}
			if (connection != null) {
				objDatabaseLogic.disconnect(connection);
			}
			objDatabaseLogic = null;
		}// return the loaded object
		return objUserDetailsBean;
	}

	/**
	 * This method is used to select values from database and check user id and
	 * password and Updates the data if required
	 *
	 * @param objUserDetailsBean
	 *            - contains the updated data of the user
	 * @param userID
	 *            - hold the userid who's data needs to be updated
	 * @throws SQLException
	 *             -Thrown when there is database access error or other errors
	 * @throws ClassNotFoundException
	 *             -Thrown when there is no definition of the class
	 * @throws IOException
	 *             - is thrown when there is some error in I/O
	 * @throws Exception
	 *             - This is thrown to handle all general exception conditions
	 * @return void
	 */
	public void update(UserDetailsBean objUserDetailsBean, String userID)
			throws SQLException, ClassNotFoundException, IOException, Exception {
		Connection connection = null;
		DatabaseLogic objDatabaseLogic = null;
		String interests = null;// used to hold the value of the concatinated
								// string of the interests selected
		String strDate = null;// used to hold the value of concatinated date
		PreparedStatement objPreparedStatement = null;
		StringBuilder objStringBuilder = null; // used to concatinate strings as
												// required(Date and Interests )
		try {
			objDatabaseLogic = new DatabaseLogic();
			connection = objDatabaseLogic.connect();
			// StringBuilder is used to convert the date in the required format
			objStringBuilder = new StringBuilder();
			objStringBuilder.append(objUserDetailsBean.getYear());
			objStringBuilder.append(Constants.SLASH);
			objStringBuilder.append(objUserDetailsBean.getMonth());
			objStringBuilder.append(Constants.SLASH);
			objStringBuilder.append(objUserDetailsBean.getDay());
			strDate = objStringBuilder.toString();
			// concatinate the interests selected into a string to add into
			// database
			objStringBuilder = new StringBuilder();
			if (objUserDetailsBean.getInterest() != null) {
				for (String lang : objUserDetailsBean.getInterest()) {
					objStringBuilder.append(lang);
					objStringBuilder.append(",");
				}
			}
			interests = objStringBuilder.toString();
			// insert the data to be updated into prepared statement one by one
			// respectively
			String id=userID;
			objPreparedStatement = connection
					.prepareStatement(Constants.QUERY_ASS_SIX);

			objPreparedStatement.setString(9, objUserDetailsBean.getUsername());
			objPreparedStatement.setString(1,objUserDetailsBean.getSalutation());
			objPreparedStatement
					.setString(2, objUserDetailsBean.getFirstname());
			objPreparedStatement.setString(3,
					objUserDetailsBean.getMiddlename());
			objPreparedStatement.setString(4, objUserDetailsBean.getLastname());
			objPreparedStatement.setString(5, objUserDetailsBean.getSex());
			objPreparedStatement.setString(6, objUserDetailsBean.getEmailId());
			objPreparedStatement.setString(7, strDate);
			objPreparedStatement.setString(8, objUserDetailsBean.getAddress());
			objPreparedStatement.setString(10, interests);
			objPreparedStatement.setString(11,
					objUserDetailsBean.getOtherinterest());
			objPreparedStatement.setString(12,
					userID);
			// execute the update query

			objPreparedStatement.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}

		finally {
			objStringBuilder = null;
			strDate = null;
			if (objPreparedStatement != null) {
				objPreparedStatement.close();
				objPreparedStatement = null;
			}
			if (connection != null) {
				objDatabaseLogic.disconnect(connection);
			}
			objDatabaseLogic = null;
		}
	}

	/**
	 * This is used to export database table data to csv file
	 *
	 * @throws Exception
	 *             - Thrown to handle all the general exception conditions
	 * @return void
	 */
	public void selectForCSV() throws Exception {
		Connection connection = null;
		DatabaseLogic objDatabaseLogic = null;
		ResultSet objResultSet = null;
		Statement objStatement = null;
		FileWriter objFileWriter = null;// used to write the data into the file
		try {
			objDatabaseLogic = new DatabaseLogic();
			connection = objDatabaseLogic.connect();
			objStatement = connection.createStatement();
			// object of file writer created to write file
			objFileWriter = new FileWriter(Constants.FILEUPLOADPATH);



			// new file is created at this location


				objResultSet = objStatement.executeQuery(Constants.QUERY_ASS_SEVEN);
				ResultSetMetaData rsmd = objResultSet.getMetaData();
				int columnCount = rsmd.getColumnCount();

				for (int i = 1; i <= columnCount; i++ ) {
					  objFileWriter.append( rsmd.getColumnName(i));
					  objFileWriter.append(Constants.COMMA);
					  // Do stuff with name
					}

				objFileWriter.append(String.format("\n"));

			while (objResultSet.next()) {
				// data fetched is written into the file
				objFileWriter.append(objResultSet.getString(1));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(2));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(3));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(4));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(5));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(6));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(7));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(8));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(10));
				objFileWriter.append(Constants.COMMA);
				String[] interest=objResultSet.getString(11).split(",");
				 String inter = String.join(" ", interest);
				objFileWriter.append(inter);
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(12));
				objFileWriter.append(Constants.SPACE);
				objFileWriter.append(String.format("%n"));

			}
		}catch(Exception e){
			e.printStackTrace();
		}

		finally {
			objFileWriter.flush();
			objFileWriter.close();
			objResultSet = null;
			objStatement = null;
			if (connection != null) {
				objDatabaseLogic.disconnect(connection);
			}
		}
	}
}