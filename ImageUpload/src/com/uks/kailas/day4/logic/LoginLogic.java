/**
 *
 */
package com.uks.kailas.day4.logic;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.uks.kailas.day4.common.DbLogic;
import com.uks.kailas.day4.common.util.Constants;

/**
 * @author kailas
 * Date :2019/9/3
 * To insert image data into database
 *
 */
public class LoginLogic {
	/*
	 * This class is using for the Login logic
	 * */
	DbLogic objDbLogic = new DbLogic();
	Connection con = null;

/**
 * Description : this method will get image name and image from FileUploadAction Class and save to database
 * @param Name
 * @param image
 */
	public void  insertToDB(String Name,File image){
		try {
			con = objDbLogic.connect();
			PreparedStatement preparedStatement = con.prepareStatement(Constants.QUERY_ASS4);
			preparedStatement.setString(1, Name);
			// for inserting image in database
			FileInputStream inputStream = new FileInputStream(image);
			preparedStatement.setBinaryStream(2, inputStream);
			int i = preparedStatement.executeUpdate();

			if (i > 0) {
				System.out.print(Constants.UPLOADSUCCESS);
			} else {
				System.out.print(Constants.UPLOADNOT);
			}
		} catch (Exception e) {
			System.out.print(e);
		}

	}
}
