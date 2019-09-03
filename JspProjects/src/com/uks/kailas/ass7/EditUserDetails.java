package com.uks.kailas.ass7;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

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
 * Servlet implementation class EditUserDetails
 */
@WebServlet(Constants.PATTERNASS7ED)
public class EditUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Intializing the connection
			Connection connection;
			DatabaseLogic objDatabaseLogic = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserDetails() {
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

		// Getting data from user inputs and stored in local variables
		PrintWriter out = response.getWriter();

		String userId = (String)request.getParameter(Constants.UID);

		//checking is user already logged in
		HttpSession session = request.getSession();


		// For Japanese letter unicode


		try {
			request.setCharacterEncoding(Constants.UTF);
			response.setCharacterEncoding(Constants.UTF);
			// Query fire for insertion operation with column name and values
			PreparedStatement preparedStatement = connection.prepareStatement(Constants. QUERY_ASS_SEVEN_UID);

			preparedStatement.setString(1, userId);
			// executing the query for prapared statment
			ResultSet resultSet = preparedStatement.executeQuery();

			if(getRowCount(resultSet) == 0){
				//wrong user id
				request.getSession().setAttribute(Constants.ATTRI, Constants.ATTRI2);
				response.sendRedirect(request.getContextPath() + Constants.LOGINJSP);

			}


			//entering user information into session variables
			while (resultSet.next()) {
			session.setAttribute(Constants.USERID, userId);
			session.setAttribute(Constants.UNAME, resultSet.getString(Constants.USERID));
			session.setAttribute(Constants.PASSWORD,resultSet.getString(Constants.PASSWORD));
			session.setAttribute(Constants.SAL2, resultSet.getString(Constants.DBSALUTATION));
			session.setAttribute(Constants.FNAME, resultSet.getString(Constants.DBFIRSTNAME));
			session.setAttribute(Constants.MIDDLE, resultSet.getString(Constants.DBMIDDLENAME));
			session.setAttribute(Constants.LNAME, resultSet.getString(Constants.DBLASTNAME));
			session.setAttribute(Constants.DBSEX, resultSet.getString(Constants.DBSEX));
			session.setAttribute(Constants.DBEMAILID, resultSet.getString(Constants.DBEMAILID.trim()));

			String dateOfBirth = resultSet.getString(Constants.DBBIRTHDATE);

			String dateNumbers[] = dateOfBirth.split("-|/");

			System.out.println(dateNumbers[1]);

			session.setAttribute(Constants.YEAR, dateNumbers[0]);


			int m = Integer.parseInt(dateNumbers[1]);
			String month = null;


			switch(m){
			case 1: month = Constants.JAN;break;
			case 2 : month  =  Constants.FEB;break;
			case 3 :  month  =  Constants.MAR;break;
			case 4 :  month  =  Constants.APR;break;
			case 5 : month  =  Constants.MAY;break;
			case 6 :month  =  Constants.JUN;break;
			case 7 : month  =  Constants.JULY;break;
			case 8 :month  =  Constants.AUG;break;
			case 9 :month  =  Constants.SEP;break;
			case 10 :month  =  Constants.OCT;break;
			case 11 : month  =  Constants.NOV;break;
			case 12 :month  = Constants.DEC;break;
			default:month  = Constants.DEC;break;
			}

			session.setAttribute(Constants.MONTH, month);
			session.setAttribute(Constants.DATE, dateNumbers[2]);
			session.setAttribute(Constants.BIRTH, resultSet.getString(Constants.DBBIRTHDATE));
			session.setAttribute(Constants.ADDRESS2, resultSet.getString(Constants.DBADDRESS));

			String areaOfInterestsArray  = resultSet.getString(Constants.DBINTERESTS);
			String[] areaOfInterests = areaOfInterestsArray.split(",");

			session.setAttribute(Constants.INTERESTS, areaOfInterests);
			session.setAttribute(Constants.OIN, resultSet.getString(Constants.DBOTHERINTERESTS));

			RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constants.CHANGE_USERDETAILS_ASS7);
			requestDispatcher.forward(request, response);
			}

		} catch (Exception e) {
			out.print(Constants.ERRORFORDB);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding(Constants.UTF);
		response.setCharacterEncoding(Constants.UTF);
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
