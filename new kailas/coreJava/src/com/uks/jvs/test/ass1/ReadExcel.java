package com.uks.jvs.test.ass1;


/**
 * Date:5/07/2019
 * Assignment: 1 Evaluation test
 * Task: Read data from excel file
 *
 * @author Kailas
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

/**
 * Description : read excel method contains file path as a string parameter
 * @param filePath
 */

	public void readExcel(String filePath){

		Workbook wwb = null;
		FileInputStream fs = null;
		Sheet sh=null;
		// check workbook present or not
		try {
			fs = new FileInputStream(filePath);
			wwb = Workbook.getWorkbook(fs);

		} catch (BiffException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// check sheet present or not
		try{
		 sh = wwb.getSheet("Sheet1");
		}catch(Exception e){
			System.out.println("Sheet not present in excel file");
		}

		int totalNoOfRows = sh.getRows();
		int totalNoOfCols = sh.getColumns();

		// for printing data by rows and columns
		for (int row = 0; row < totalNoOfRows; row++) {

			for (int col = 0; col < totalNoOfCols; col++) {

				System.out.print(sh.getCell(col, row).getContents() + "  ");

			}
			// System.out.println("\n");
			System.out.println("\n--------------------------------------\n");
		}
	}

// main method
	public static void main(String arsg[]) {


		File file = new File(arsg[0]);
		// check file is excel format or not
		if (file.exists()&&file.getName().endsWith(".xls")) {
			try {
				ReadExcel dt = new ReadExcel();
				dt.readExcel(arsg[0]);
			} catch (Exception e) {
				System.out.println("enter proper file path in command line arguments");
			}
		} else {
			System.out.println("file not present or invalid file format");
		}

	}
}