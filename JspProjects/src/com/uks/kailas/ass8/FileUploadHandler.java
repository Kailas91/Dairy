package com.uks.kailas.ass8;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.uks.kailas.common.DatabaseLogic;
import com.uks.kailas.common.Constants;

/**
 * Servlet to handle File upload request from Client
 * @author kailas Landge
 * Date :2019/8/26
 */

 @WebServlet(Constants.PATTERNASS8)
public class FileUploadHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
		Connection connection;
    private final String UPLOAD_DIRECTORY =Constants.PATHASS8;

    public void init() throws ServletException {
    	   // Initialization code...
    	connection = null;
    	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	RequestDispatcher objRequestDispatcher = null;
    	Connection connection = null;
		DatabaseLogic objDatabaseLogic = null;
    	 PrintWriter out = response.getWriter();
    	 String name="";
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {

            	objDatabaseLogic = new DatabaseLogic();
    			// connect to the database

    			connection = objDatabaseLogic.connect();

                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);

                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }

               //File uploaded successfully
                String url=UPLOAD_DIRECTORY + File.separator + name;


                PreparedStatement prepStmt = connection.prepareStatement(Constants.QUERY_ASS8);
                prepStmt.setString(1, name);
                prepStmt.setString(2,Constants.PATHASS8);

            	// executing the query
				int i = prepStmt.executeUpdate();
				if (i > 0) {

					// It display successful message on screen
					objRequestDispatcher = request
							.getRequestDispatcher(Constants.ASS8_FILEUP);

					request.setAttribute(Constants.RESULT,
							Constants.FILEUPSUCCESS);
					objRequestDispatcher.forward(request, response);
				}
				objRequestDispatcher.forward(request, response);
            } catch (Exception ex) {

            	objRequestDispatcher = request
						.getRequestDispatcher(Constants.ERRORPAGE);
				objRequestDispatcher.forward(request, response);
            }
            finally{
            	connection=null;
            	objDatabaseLogic = null;
            }

        }


    }

}