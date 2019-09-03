package com.uks.kailas.ass4;

/**
*
Assignment :4
Assignment :get data from jsp and print on console
Author : Kailas
Date   : 16/8/2019
*/
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.kailas.common.Constants;
import com.uks.kailas.common.DBLogicClass;
import com.uks.kailas.common.DatabaseLogic;
import com.uks.kailas.common.UserDetailsBean;

@WebServlet(Constants.PATTERNASS4)
public class UserDetailsC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	DatabaseLogic objDatabaseLogic = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsC() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void init() throws ServletException {
    	   // Initialization code...
     	connection = null;

    	try {
    		objDatabaseLogic = new DatabaseLogic();
			connection = objDatabaseLogic.connect();
		} catch (Exception e) {

    	}
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String allIneterest = "";
		PreparedStatement preparedstmt = null;
		RequestDispatcher objRequestDispatcher = null;
		ResultSet rs = null;
		DBLogicClass objLogicClass = null;
		UserDetailsBean objUserDetailsBean = null;
		// For Japanese letter unicode

		request.setCharacterEncoding(Constants.UTF);
		response.setCharacterEncoding(Constants.UTF);
		response.setContentType(Constants.CTYPPE);

			// getting the user input data from jsp pages using PrintWriter

			String sal = request.getParameter(Constants.SALUTATION);
			String fname = request.getParameter(Constants.FIRSTNAME);

			String mname = request.getParameter(Constants.MIDDLENAME);
			String lname = request.getParameter(Constants.LASTNAME);
			String sex =  request.getParameter(Constants.SEX);
			String email = request.getParameter(Constants.EMAILID);
			String year = request.getParameter(Constants.YEAR);
			String month = request.getParameter(Constants.MONTH);
			String day = request.getParameter(Constants.DATE);
			String address = request.getParameter(Constants.ADDRESS);
			String uname = request.getParameter(Constants.USERNAME);
			String pass = request.getParameter(Constants.PASSWORD);
			// Storing multiple interest in array
			String[] interest = request.getParameterValues(Constants.INTEREST);
			String othInterest = request.getParameter(Constants.OTHERINTEREST);

			String dob=year+":"+month+":"+day;

					// Printing all the Interest one by one
					if(interest.length != 0){

						for (int i = 0; i < interest.length; i++) {
							allIneterest += interest[i] + ",".trim();
						}

					}



		    		try {
		    			objLogicClass = new DBLogicClass();
						  String query = Constants.QUERY_ASS_FOUR;

						  preparedstmt = connection.prepareStatement(query);
						  preparedstmt.setString(1, uname);
						    rs = preparedstmt.executeQuery();

						    if(rs.next()) {

						    	objRequestDispatcher = request
										.getRequestDispatcher(Constants.DISPATCHERASS4);
								request.setAttribute(Constants.RESULT, Constants.ERRORFORASS4);
								objRequestDispatcher.forward(request, response);
						    }
						    else{
						    	// Query fire for insertion operation with column name and values
						    	PreparedStatement prepStmt = connection.prepareStatement(Constants.QUERY_ASSTWO);	// Set all variable values in prepared statment
								prepStmt.setString(1, sal);
								prepStmt.setString(2, fname);
								prepStmt.setString(3, mname);
								prepStmt.setString(4, lname);
								prepStmt.setString(5, sex);
								prepStmt.setString(6, email);
								prepStmt.setString(7, dob);
								prepStmt.setString(8, address);
								prepStmt.setString(9, uname);
								prepStmt.setString(10, pass);
								prepStmt.setString(11, allIneterest);
								prepStmt.setString(12, othInterest);

								// executing the query
								int i = prepStmt.executeUpdate();
								if (i > 0) {

								try{

									objUserDetailsBean = objLogicClass.checkUserIdPassword(
											uname, pass);
									request.setCharacterEncoding(Constants.UTF);
									response.setCharacterEncoding(Constants.UTF);
									// redirecting to Resultone.jsp page which display user Data
									objRequestDispatcher = request
											.getRequestDispatcher(Constants.ASS4_RESULT);
									request.setAttribute(Constants.LISTDATA, objUserDetailsBean);

									objRequestDispatcher.forward(request, response);
									}catch(Exception e){

										e.printStackTrace();
									}



								}
						    }

					} catch (Exception e) {
						// TODO Auto-generated catch block
						objRequestDispatcher = request
								.getRequestDispatcher(Constants.ERRORPAGE);
						objRequestDispatcher.forward(request, response);
							   System.out.println(e);
							   e.printStackTrace();
					}
	}
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
