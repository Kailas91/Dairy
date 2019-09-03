package com.uks.kailas.ass9;

/**
 * @author: kailas
 * Created Date:2019/8/26
 * Assignment: download file from server
 *
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.kailas.common.Constants;
import com.uks.kailas.common.DatabaseLogic;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet(Constants.PATTERNASS9)
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileDownload() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher objRequestDispatcher = null;
		DatabaseLogic dblogic=null;
		Connection con=null;
		// creating writer object
		PrintWriter out = response.getWriter();
		// getting the parameter of file name
		String filename = request.getParameter(Constants.FILE);
	 	String url=null;
		try{
		// getting the file from location

		 	dblogic=new DatabaseLogic();
		 	con=dblogic.connect();
		 	Statement stmt = con.createStatement();
		 	ResultSet rs = stmt.executeQuery(Constants.QUERY_ASS9);
		 	while (rs.next ()){
				//Add records into data list
				url=rs.getString("url");
			}
		String filepath =url+"\\"+ request.getParameter(Constants.FILE);

		response.setContentType(Constants.ASS9CONTENT);
		// setting the file content with the header and file name
		response.setHeader(Constants.CONTENTDISPOSITION, Constants.ATTACHMENTFILENAME + filename + "\"");

		// file input stream with file path
		FileInputStream fis = new FileInputStream(filepath);

		// Getting the file
		int i;
		while ((i = fis.read()) != -1) {
			out.write(i);
		}
		fis.close();
		out.close();

	}catch(Exception e){
		objRequestDispatcher = request
				.getRequestDispatcher(Constants.ERRORPAGE);
		objRequestDispatcher.forward(request, response);
		e.printStackTrace();
	}finally{
		con=null;
		dblogic=null;
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}
