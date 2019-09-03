package com.uks.kailas.ass10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.kailas.common.Constants;
import com.uks.kailas.common.DBLogicClass;
import com.uks.kailas.common.DatabaseLogic;

/**
 * This servlet is used to export table data into cvs file
 *
 * @author kailas
 * @date 2019/8/26
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

		Connection connection = null;
		DatabaseLogic objDatabaseLogic = null;
		ResultSet objResultSet = null;
		Statement objStatement = null;
		FileWriter objFileWriter = null;// used to write the data into the file
		try {
			objDatabaseLogic = new DatabaseLogic();
			connection = objDatabaseLogic.connect();
			objStatement = connection.createStatement();
			// object of file writer created to write file
			objFileWriter = new FileWriter(Constants.FILEUPLOADPATH);

			// new file is created at this location

				objResultSet = objStatement.executeQuery(Constants.QUERY_ASS_SEVEN);
				ResultSetMetaData rsmd = objResultSet.getMetaData();
				int columnCount = rsmd.getColumnCount();

				for (int i = 1; i <= columnCount; i++ ) {
					  objFileWriter.append( rsmd.getColumnName(i));
					  objFileWriter.append(Constants.COMMA);
					  // Do stuff with name
					}

				objFileWriter.append(String.format("\n"));

			while (objResultSet.next()) {
				// data fetched is written into the file
				objFileWriter.append(objResultSet.getString(1));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(2));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(3));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(4));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(5));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(6));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(7));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(8));
				objFileWriter.append(Constants.COMMA);
				String address=objResultSet.getString(9);
		    	objFileWriter.append("\"" + address + "\"");
				objFileWriter.append(Constants.COMMA);

				objFileWriter.append(objResultSet.getString(10));
				objFileWriter.append(Constants.COMMA);
				objFileWriter.append(objResultSet.getString(11));
				objFileWriter.append(Constants.COMMA);
				String interest=objResultSet.getString(12);

				objFileWriter.append("\"" + interest + "\"");
				objFileWriter.append(Constants.COMMA);

				if(!(objResultSet.getString(13)==null)){
				String ointerest=objResultSet.getString(13);
				objFileWriter.append("\"" + ointerest + "\"");
				}
				objFileWriter.append(Constants.SPACE);
				objFileWriter.append(String.format("%n"));
			}
			request.setCharacterEncoding(Constants.UTF);
			// This function is called to export table to csv file

                		// getting the file from location
                		String filepath =Constants.FILEUPLOADPATH;
                		response.setContentType(Constants.ASS9CONTENT);
                		// setting the file content with the header and file name
                		response.setHeader(Constants.CONTENTDISPOSITION, Constants.ATTACHMENTFILENAME + Constants.CSVNAME + "\"");
                		File file = new File(filepath);
                		// file input stream with file path
                		FileInputStream fis = new FileInputStream(file);
                		// Getting the file
                		int i;
                		while ((i = fis.read()) != -1) {
                			out.write(i);
                		}
                		fis.close();
                		out.close();

		} catch (Exception e) {
		  	objRequestDispatcher = request
					.getRequestDispatcher(Constants.ERRORPAGE);
			objRequestDispatcher.forward(request, response);
			System.out.print(e);
			e.printStackTrace();

		} 	finally {
			objFileWriter.flush();
			objFileWriter.close();
			objResultSet = null;
			objStatement = null;
			if (connection != null) {

			}
	}
	}
}
