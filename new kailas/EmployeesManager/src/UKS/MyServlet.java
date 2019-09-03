package UKS;
/**
*
Day : 8
Assignment :2
Assignment :insert data using MyServlet servlet
Author : Kailas
Date   : 9/8/2019
*/


import java.io.*;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;
import UKS.DBConnection;
// Extend HttpServlet class to create Http Servlet


public class MyServlet extends HttpServlet {

   /**
	 *
	 */
	private static final long serialVersionUID = 1L;
Connection con;
   public void init() throws ServletException {

   }

   public void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException
   {

	   String name= request.getParameter("name");
	   String mobileno= request.getParameter("mn");
	   String role= request.getParameter("role");
      // Setting up the content type of webpage
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      // Initialize the database
      try {


		 con = DBConnection.initializeDatabase();
		 Statement statement=con.createStatement();
		 statement.executeUpdate("insert into employee values('"+name +"',"+mobileno+",'"+role+"')");

	     String filePath = "D:\\jvs_ws\\EmployeesManager\\WebContent\\file\\Employee.txt";

	     File outputFile = new File(filePath);
	     FileWriter fileWriter = new FileWriter(outputFile,true);
	     PrintWriter printWriter = new PrintWriter(fileWriter);
	     printWriter.println(name+","+mobileno+","+role+"kailas");
	     printWriter.close();

	     out.println("<script type=\"text/javascript\">");
		   out.println("alert('Employee details added successfully !');");
		   out.println("location='index.jsp';");
		   out.println("</script>");

	} catch (Exception e) {
		// TODO Auto-generated catch block

	}

   }
   public void destroy() {
      /* leaving empty for now this can be
       * used when we want to do something at the end
       * of Servlet life cycle
       */
   }
}