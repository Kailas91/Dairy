package com.uks.kailas.day4.action;
import java.io.File;
import java.io.IOException;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.uks.kailas.day4.common.util.Constants;
import com.uks.kailas.day4.logic.LoginLogic;

/**
 * @author kailas
 * Date :2019/9/3
 *  FileUploadAction class is used to get image data from jsp
 *
 */


public class FileUploadAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;
	private File toBeUploaded;
    private String toBeUploadedFileName;
    private String toBeUploadedContentType;
    LoginLogic loginLogic=new LoginLogic();


    // default method of struts
    public String execute()
    {
         String filePath = Constants.UPLOADPATH;
         File fileToCreate = new File(filePath, this.toBeUploadedFileName);

         try {

            FileUtils.copyFile(this.toBeUploaded, fileToCreate);
	        	 loginLogic.insertToDB(toBeUploadedFileName, toBeUploaded);
	               return SUCCESS;

         }catch (IOException e) {
             addActionError(e.getMessage());

         }
		return ERROR;

    }

// getter and setter method to get and set the image data
    @RequiredFieldValidator(message = Constants.SELECTIMAGE)
    public File getToBeUploaded() {
        return toBeUploaded;
    }
    public void setToBeUploaded(File toBeUploaded) {
        this.toBeUploaded = toBeUploaded;
    }
    public String getToBeUploadedFileName() {
        return toBeUploadedFileName;
    }
    public void setToBeUploadedFileName(String toBeUploadedFileName) {
        this.toBeUploadedFileName = toBeUploadedFileName;
    }
    public String getToBeUploadedContentType() {
        return toBeUploadedContentType;
    }
    public void setToBeUploadedContentType(
            String toBeUploadedFileNameContentType) {
        this.toBeUploadedContentType = toBeUploadedFileNameContentType;
    }

    @Override
    public void setServletRequest(HttpServletRequest servletRequest) {

    }

}