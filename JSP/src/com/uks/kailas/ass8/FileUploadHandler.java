package com.uks.kailas.ass8;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.uks.kailas.DBConnection;
import com.uks.kailas.common.Constants;
 
/**
 * Servlet to handle File upload request from Client
 * @author Javin Paul
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
    
    	 PrintWriter out = response.getWriter();
    	 String name="";
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
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
                connection = DBConnection.initializeDatabase(); 
            
                PreparedStatement prepStmt = connection.prepareStatement(Constants.QUERY_ASS8);
                prepStmt.setString(1, url);
                
            	// executing the query
				int i = prepStmt.executeUpdate();
				if (i > 0) {

					 out.println(Constants.UPLOADSUCCESS);
				}
       
            } catch (Exception ex) {
            	
            	 out.println(Constants.UPLOADERROR);
            }          
          
        }
     
      
    }
   
}