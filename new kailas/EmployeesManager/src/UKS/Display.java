package UKS;
/**
 *
Day : 8
Assignment :2
Assignment :display data using display servlet
Author : Kailas
Date   : 9/8/2019
 */

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.Scanner;

public class Display extends HttpServlet {


	Connection con;
	  public void init() throws ServletException {

	   }

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter out = res.getWriter();
        out.println("<center>");
        res.setContentType("text/html");
        out.println("<h1>" +"Employee Details"+ "</h1>");

        try {

        	con = DBConnection.initializeDatabase();
        	String name=req.getParameter("name1");
            Statement stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employee where name='"+name+"'");
            out.println("<table border=1 width=30% height=10%>");
            out.println("<tr><th>Name </th><th>Mobile No</th><th>Role</th><tr>");
            while (rs.next()) {
                String n = rs.getString("name");
                String nm = rs.getString("mobileno");
                String s = rs.getString("role");
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");
            }
            out.println("</table>");
            out.print("<br><a href=\"display.jsp\"><button type=\"button\">Back</button></a>");
            out.println("</html></center></body>");
            con.close();
           }
            catch (Exception e) {
            	String name=req.getParameter("name1");
                String fName = "D:\\jvs_ws\\EmployeesManager\\WebContent\\file\\Employee.txt";
                File file = new File(fName);
                Scanner scanner = new Scanner(file);
            	 String[] line;
                 out.println("<table border=1 width=30% height=10%>");
                 out.println("<tr><th>Name </th><th>Mobile No</th><th>Role</th><tr>");
                while (scanner.hasNextLine())
                {
                	  line = scanner.nextLine().split(",");

                if(line[0].equalsIgnoreCase(name)){
                	  String n = line[0];
                      String nm = line[1];
                      String s = line[2];
                      out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");
                }

         }
                out.println("</table>");
                out.print("<br><a href=\"display.jsp\"><button type=\"button\">Back</button></a>");
                out.println("</html></center></body>");

         scanner.close();
        }
    }
	  public void destroy() {
	      /* leaving empty for now this can be
	       * used when we want to do something at the end
	       * of Servlet life cycle
	       */
	   }
}