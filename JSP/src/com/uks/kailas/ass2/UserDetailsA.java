package com.uks.kailas.ass2;

/**
*
Assignment :1
Assignment :get data from jsp and print on console
Author : Kailas
Date   : 16/8/2019
*/
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.kailas.DBConnection;

@WebServlet("/ass2/UserdetailsA")
public class UserDetailsA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsA() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void init() throws ServletException {
    	   // Initialization code...
    	connection = null;
    	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String intrest=null;
		PreparedStatement preparedstmt = null;
		ResultSet rs = null;

		// getting the user input data from jsp pages using PrintWriter
				PrintWriter out = response.getWriter();
				String sal = request.getParameter("scripts");
				String fname = request.getParameter("firstname");

				String mname = request.getParameter("middlename");
				String lname = request.getParameter("lastname");
				String sex = request.getParameter("sex");
				String email = request.getParameter("emailid");
				String year = request.getParameter("year");
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String address = request.getParameter("Address");
				String uname = request.getParameter("username");
				String pass = request.getParameter("password");

				// Storing multiple interest in array
				String[] interest = request.getParameterValues("web");
				String othInterest = request.getParameter("otherinterest");




				// Printing all user inputs data on console
				System.out.println();
				System.out.println("================================================\n");
				System.out.println("Personal Details :\n");
				System.out.println("Salutation is : " + sal+"\n");
				System.out.println("First Name is : " + fname+"\n");
				System.out.println("Middle Initial is : " + mname+"\n");
				System.out.println("Lastname is : " + lname+"\n");
				System.out.println("Sex is : " + sex+"\n");
				System.out.println("Email Id is : " + email+"\n");
				System.out.println("Birth Date is : " + year+":"+month+":"+day+"\n");
				System.out.println("Address is : " + address+"\n");
				System.out.println("Username is : " + uname+"\n");
				System.out.println("Password is : " + pass+"\n");

				// Printing all the Interest one by one
				if (interest != null) {

					for (String inter : interest) {
						intrest= inter+",";
						System.out.println("Interests are :\t" + intrest);
					}
					System.out.println("\n");
				}
				System.out.println("Other Interest is : " + othInterest+"\n");
				System.out.println("\n================================================");

				try {
					String dob=year+":"+month+":"+day;
					connection = DBConnection.initializeDatabase();
					  String query = "SELECT userid FROM userdetails where userid=?";

					  preparedstmt = connection.prepareStatement(query);
					  preparedstmt.setString(1, uname);
					    rs = preparedstmt.executeQuery();

					    if(rs.next()) {

					    	 out.println("<script type=\"text/javascript\">");
							   out.println("alert('UserId Already Exists !');");
							   out.println("location='UserDetailsA.jsp';");
							   out.println("</script>");
					    }
					    else{
					    	// Query fire for insertion operation with column name and values
							PreparedStatement prepStmt = connection.prepareStatement(
									"insert into userdetails(salulation,firstname,middleinitial,lastname,gender,email,dob,address,userid,password,areaofinterest,otherinterest) values(?,?,?,?,?,?,?,?,?,?,?,?)");
							// Set all variable values in prepared statment
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
							prepStmt.setString(11, intrest);
							prepStmt.setString(12, othInterest);

							// executing the query
							int i = prepStmt.executeUpdate();
							if (i > 0) {

								out.println("<h1 align=\"center\"><b>You are successfully registered</b></h1>");
							}
					    }

				} catch (Exception e) {

					 out.println("<script type=\"text/javascript\">");
					 	out.println("<h1 align=\"center\"><b>You are successfully registered</b></h1>");
						   out.println("location='UserDetailsA.jsp';");
						   out.println("</script>");
						   System.out.println("Error is :"+e);
				}

				out.print("<h1 align=\"center\"><b>User Details are printed on the console !</b></h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
