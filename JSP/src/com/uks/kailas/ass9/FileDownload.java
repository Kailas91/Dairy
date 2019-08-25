package com.uks.kailas.ass9;

/**
 * @author: kailas
 * Created Date:2019/8/22
 * Assignment: 9
 * 
 *
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.kailas.common.Constants;

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
		
		// creating writer object
		PrintWriter out = response.getWriter();
		// getting the parameter of file name
		String filename = request.getParameter(Constants.FILE);
		
		// getting the file from location
		String filepath =Constants.DOWNPATHASS9+ request.getParameter(Constants.FILE);

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
