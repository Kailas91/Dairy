package com.uks.kailas.ass7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class Login
 */
@WebServlet(Constants. PATTERNASS7LOGIN)
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseLogic objDatabaseLogic = null;
	// Intializing the connection
		Connection connection;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
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
		//checking is user already logged in
		HttpSession session = request.getSession();


		//List Of Users
		ArrayList<User> users = new ArrayList<User>();
		// For Japanese letter unicode
		request.setCharacterEncoding(Constants.UTF);
		response.setCharacterEncoding(Constants.UTF);
		RequestDispatcher requetsDispatcherObj;

		// Getting data from user inputs and stored in local variables
				PrintWriter out = response.getWriter();
				String username = null;
				String password = null;

					 username = request.getParameter(Constants.LOGINID);
					 password = request.getParameter(Constants.IDPASSWORD);


				try {

					//displaying user information

					if(username.equalsIgnoreCase(Constants.USERIDPASSWORDASS7) && password.equalsIgnoreCase(Constants.USERIDPASSWORDASS7)){

						// Query fire for insertion operation with column name and values
						PreparedStatement preparedStatement = connection.prepareStatement(Constants.QUERY_ASS_SEVEN);

						// executing the query for prapared statment
						ResultSet resultSet = preparedStatement.executeQuery();

						if(getRowCount(resultSet) == 0){


							// * If UserId and Password is correct Not correct: It
							// redirects to Login.jsp page with error message

							requetsDispatcherObj = request
									.getRequestDispatcher(Constants.ASS7_LOGIN);

							request.setAttribute(Constants.RESULT,
									Constants.INVUSERPASS);
							requetsDispatcherObj.forward(request, response);

						}

						//User object to store users
						User user = null;
						while (resultSet.next()) {

							String uid = resultSet.getString(1);
							String salutation = resultSet.getString(2);
							String firstName = resultSet.getString(3);
							String middleName = resultSet.getString(4);
							String lastName = resultSet.getString(5);
							String gender = resultSet.getString(6);
							String email = resultSet.getString(7);
							String dateOfBirth = resultSet.getString(8);
							String address = resultSet.getString(9);
							String username1 = resultSet.getString(10);
							String password1 = resultSet.getString(11);
							String interest = resultSet.getString(12);
							String otherInterest=resultSet.getString(13);

							user = new User(uid,salutation,firstName,middleName,lastName,gender,email.trim()
									,dateOfBirth,address,username1,password1,interest,otherInterest);

							users.add(user);

						}
						session.setAttribute(Constants.LOGEDIN, Constants.TRUE);
						request.getSession().setAttribute(Constants.ATTRI, Constants.ATTRI2);

						session.setAttribute(Constants.ULIST, users);

						 requetsDispatcherObj =request.getRequestDispatcher(Constants.DISPATCHER_JSP_ASS7);
						requetsDispatcherObj.forward(request, response);
					}else{

						// Query fire for insertion operation with column name and values
						PreparedStatement preparedStatement = connection.prepareStatement(Constants.QUERY_ASS_FOUR);

						preparedStatement.setString(1, username);

						// executing the query for prapared statment
						ResultSet resultSet = preparedStatement.executeQuery();
						//User object to store users
						User user = null;

					while (resultSet.next()) {
						if (username.equals(resultSet.getString(10)) && password.equals(resultSet.getString(11))) {

							String uid = resultSet.getString(1);
							String salutation = resultSet.getString(2);
							String firstName = resultSet.getString(3);
							String middleName = resultSet.getString(4);
							String lastName = resultSet.getString(5);
							String gender = resultSet.getString(6);
							String email = resultSet.getString(7);
							String dateOfBirth = resultSet.getString(8);
							String address = resultSet.getString(9);
							String username1 = resultSet.getString(10);
							String password1 = resultSet.getString(11);
							String interest = resultSet.getString(12);
							String otherInterest="";
								session.setAttribute(Constants.OINTEREST, resultSet.getString(13));
								 otherInterest= resultSet.getString(13);

							user = new User(uid,salutation,firstName,middleName,lastName,gender,email.trim()
									,dateOfBirth,address,username1,password1,interest,otherInterest);
							users.add(user);
							session.setAttribute(Constants.ULIST, users);
						 requetsDispatcherObj =request.getRequestDispatcher(Constants.DISPATCHER_JSP_ASS72);
							requetsDispatcherObj.forward(request, response);

						} else {
							// wrong password but right user id
							requetsDispatcherObj = request
									.getRequestDispatcher(Constants.ASS7_LOGIN);

							request.setAttribute(Constants.RESULT,
									Constants.INVUSERPASS);
							requetsDispatcherObj.forward(request, response);
						}
					}

				}
			} catch (Exception e) {
				requetsDispatcherObj = request
						.getRequestDispatcher(Constants.ERRORPAGE);
				requetsDispatcherObj.forward(request, response);
					System.out.println(e);
					e.printStackTrace();


				}
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
