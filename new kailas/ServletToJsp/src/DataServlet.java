import java.io.*;

import java.util.*;

import java.sql.*;

import javax.servlet.*;

import javax.servlet.http.*;



public class DataServlet extends HttpServlet{



  private ServletConfig config;

  //Setting JSP page

  String page="DataPage.jsp";



  public void init(ServletConfig config)

  throws ServletException{

 this.config=config;

 }

  public void doGet(HttpServletRequest request, HttpServletResponse response)

    throws ServletException,IOException
{



  PrintWriter out = response.getWriter();

  //Establish connection to MySQL database

  String connectionURL = "jdbc:mysql://172.16.1.15:3306/northwind_kailas";

  Connection connection
= null;

  ResultSet rs;

  response.setContentType("text/html");

  List dataList
= new ArrayList();

  try {

 // Load the database driver

  Class.forName("com.mysql.jdbc.Driver");

  // Get a Connection to the database

  connection = DriverManager.getConnection(connectionURL, "kailas", "kailas@523");

  //Select the data from the database

  String sql = "select * from employee";

  Statement s = connection.createStatement();

  s.executeQuery (sql);

  rs = s.getResultSet();

  while (rs.next ()){

  //Add records into data list

  dataList.add(rs.getString("name"));

  dataList.add(rs.getString("mobileno"));

  }

  rs.close ();

  s.close ();

  }catch(Exception e){

  System.out.println("Exception is ;"+e);

  }

  request.setAttribute("data",dataList);

  //Disptching request

  RequestDispatcher dispatcher = request.getRequestDispatcher(page);
  dispatcher.forward(request, response);
  out.print("<br><a href=\"DataPage.jsp\"><button type=\"button\">Back</button></a>");
  out.println("</html></body>");


  }

}