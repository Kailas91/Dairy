package com.uks.kailas.ass10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.kailas.common.Constants;
import com.uks.kailas.common.DBLogicClass;

/**
 * This servlet is used to export table data into cvs file
 * 
 * @author kailas
 * @date 2019/8/22
 */
@WebServlet(Constants.PATTERNASS10)
public class CsvFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DBLogicClass objLogicClass = null;
		RequestDispatcher objRequestDispatcher = null;
	    
   	 PrintWriter out = response.getWriter();  
		try {
			request.setCharacterEncoding(Constants.UTF);
			// This function is called to export table to csv file
                        objLogicClass = new DBLogicClass();			
                        objLogicClass.selectForCSV();

			// It redirects to result page
                        out.println("<html><body onload=\"alert('Hello World')\"></body></html>");
           			 out.println(Constants.DOWNSUCCESS);
			request.getRequestDispatcher(Constants.RESULTJSPASS10).forward(
					request, response);
			
		} catch (Exception e) {
			 out.println(Constants.DOWNSUCCESS);
			e.printStackTrace();
		} finally {
                        objLogicClass = null;
		}
	}
}
