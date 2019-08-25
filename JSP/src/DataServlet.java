

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/dataservlet")
public class DataServlet extends HttpServlet{

	private ServletConfig config;
	//Setting JSP page
	String page="DataPage.jsp";

	public void init(ServletConfig config)
	  throws ServletException{
		 this.config=config;
	   }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		PrintWriter out = response.getWriter();
		//Establish connection to MySQL database
		String connectionURL = "jdbc:mysql://localhost:3306/northwind?autoReconnect=true&useSSL=false";
		Connection connection=null;
		ResultSet rs;
		response.setContentType("text/html");
		List dataList=new ArrayList(); 
			try {
			 // Load the database driver
			Class.forName("com.mysql.jdbc.Driver");
			// Get a Connection to the database
			connection = DriverManager.getConnection(connectionURL, "root", ""); 
			//Select the data from the database
			String sql = "select * from employees";
			Statement s = connection.createStatement();
			s.executeQuery (sql);
			rs = s.getResultSet();
			while (rs.next ()){
				//Add records into data list
				dataList.add(rs.getInt("Employeeid"));
				dataList.add(rs.getString("FirstName"));
			}
			rs.close ();
			s.close ();
			}catch(Exception e){
			System.out.println("Exception is ;"+e);
			}
			request.setAttribute("data",dataList);
			//Disptching request
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			if (dispatcher != null){
				dispatcher.forward(request, response);
			} 
	}
}