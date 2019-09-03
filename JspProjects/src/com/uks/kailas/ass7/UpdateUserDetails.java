package com.uks.kailas.ass7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import com.uks.kailas.common.Constants;
import com.uks.kailas.common.DatabaseLogic;

/**
 * @auther kailas
 * Created Date:26/08/2019
 * Assignment:  Assignment 7
 * Task: 		Jsp & servlet
 *
 */

/**
 * Servlet implementation class UpdateUserDetails
 */
@WebServlet(Constants.PATTERNASS7UP)
public class UpdateUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Intializing the connection
	DatabaseLogic objDatabaseLogic = null;
	// Intializing the connection
		Connection connection;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
   	   // Initialization code...
     	   // Initialization code...
      	connection = null;
      	objDatabaseLogic = new DatabaseLogic();
     	// connecting to database and returning the con object

     	try {
     		connection = objDatabaseLogic.connect();
     	} catch (Exception e) {

     		System.out.println(e);
     	}
   	}

    /*
   	 * method getRowCount returns total number of rows in a table.
   	 * return type : int
   	 */
   	public int getRowCount(ResultSet resultSet){
   		int size = 0;
   		// calculating total resultset size
   		try {
   			resultSet.last();
   			size = resultSet.getRow();
   			resultSet.beforeFirst();

   		} catch (Exception ex) {
   			ex.printStackTrace();
   		}
   		return size;
   	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// For Japanese letter unicode
		request.setCharacterEncoding(Constants.UTF);
		response.setCharacterEncoding(Constants.UTF);
		RequestDispatcher objRequestDispatcher = null;
		ArrayList<User> users = new ArrayList<User>();
		HttpSession session = request.getSession();
				String userId = request.getParameter(Constants.USERID);

				// getting the user input data from jsp pages using PrintWriter
				PrintWriter out = response.getWriter();
				String salutation = request.getParameter(Constants.SAL1);
				String firstName = request.getParameter(Constants.DBFIRSTNAME);
				String middleName = request.getParameter(Constants.MIDDLENAME2);
				String lastName = request.getParameter(Constants.DBLASTNAME);
				String sex = request.getParameter(Constants.DBSEX);
				String email = request.getParameter(Constants.DBEMAILID2);
				String dobYear = request.getParameter(Constants.YEAR);
				String dobMonth = request.getParameter(Constants.MONTH);

				int month =1;

				switch(dobMonth){
				case Constants.JAN : month = 1;break;
				case Constants.FEB : month = 2;break;
				case Constants.MAR : month = 3;break;
				case Constants.APR : month = 4;break;
				case Constants.MAY : month =5;break;
				case Constants.JUN : month = 6;break;
				case Constants.JULY : month = 7;break;
				case Constants.AUG : month = 8;break;
				case Constants.SEP : month = 9;break;
				case Constants.OCT : month = 10;break;
				case Constants.NOV : month = 11;break;
				case Constants.DEC : month = 12;break;
				}
				String dobDay = request.getParameter(Constants.DATE);
				String dateOfBirth = dobYear+"-"+month+"-"+dobDay;

				DateFormat dateFormat = new SimpleDateFormat(Constants.DATEF);
				java.util.Date date = null;
				try {
				    date =  dateFormat.parse(dateOfBirth);
				    System.out.println(date.toString()); // Wed Dec 04 00:00:00 CST 2013

				    String output = dateFormat.format(date);
				    System.out.println(output); // 2013-12-04
				}
				catch (ParseException | java.text.ParseException e) {
				    e.printStackTrace();
				}


				final String stringDate= dateFormat.format(date);
				final java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);

				String address = request.getParameter(Constants.ADDRESS2);
				String userName = request.getParameter(Constants.UNAME);
				String password = request.getParameter(Constants.PASS2);

			//	Reader reader = new InputStreamReader(get.openStream(), "UTF-8");
				String[] interest = {};
				// Storing multiple interest in array
				if( request.getParameterValues(Constants.INTEREST2) != null){
					interest = request.getParameterValues(Constants.INTEREST2);

				}
				// Storing interest in local variable
				String allIneterest = "";

				if(interest.length != 0){

					for (int i = 0; i < interest.length; i++) {
						allIneterest += interest[i] + ",".trim();
					}

				}
				String othInterest = request.getParameter(Constants.OINTEREST);

				try {
					// Query fire for insertion operation with column name and values
					String query = Constants.QUERY_ASS_7;

					PreparedStatement preparedStatement = connection.prepareStatement(query);

					// Set all variable values in prepared statment
					preparedStatement.setString(1, salutation);
					preparedStatement.setString(2, firstName);
					preparedStatement.setString(3, middleName);
					preparedStatement.setString(4, lastName);
					preparedStatement.setString(5, sex);
					preparedStatement.setString(6, email);
					preparedStatement.setDate(7, sqlDate);
					preparedStatement.setString(8, address);
					preparedStatement.setString(9, userName);
					preparedStatement.setString(10, password);
					preparedStatement.setString(11, allIneterest);
					preparedStatement.setString(12, othInterest);
					preparedStatement.setString(13, userId);

					// executing the query
					int i = preparedStatement.executeUpdate();
					if (i > 0) {
						PreparedStatement preparedStatement2 = connection.prepareStatement(Constants.QUERY_ASS_SEVEN);
						// executing the query for prapared statment
						ResultSet resultSet = preparedStatement2.executeQuery();
						//User object to store users
						User user = null;
						while (resultSet.next()) {

							String uid = resultSet.getString(1);
							String sal = resultSet.getString(2);
							String fName = resultSet.getString(3);
							String mName = resultSet.getString(4);
							String lName = resultSet.getString(5);
							String gender = resultSet.getString(6);
							String emailid = resultSet.getString(7);
							String dateOBirth = resultSet.getString(8);
							String addresss = resultSet.getString(9);
							String username1 = resultSet.getString(10);
							String password1 = resultSet.getString(11);
							String interest1 = resultSet.getString(12);
							String otherInterest=resultSet.getString(13);

							user = new User(uid,sal,fName,mName,lName,gender,emailid
									,dateOBirth,addresss,username1,password1,interest1,otherInterest);
							users.add(user);

						}


						session.setAttribute(Constants.ULIST, users);

						objRequestDispatcher =request.getRequestDispatcher(Constants.DISPATCHER_JSP_ASS7);
						objRequestDispatcher.forward(request, response);


					} else {
						out.println(Constants.UPERROR);
					}


				} catch (Exception e) {
					objRequestDispatcher = request
							.getRequestDispatcher(Constants.ERRORPAGE);
					objRequestDispatcher.forward(request, response);
					System.out.print(e);
					System.out.println(e);


				}
				out.close();

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
