package com.database.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * This class reads the excel file and updates the database.
 * The program is divided into three parts. 
 * First half reads the header values and creates the pojo class to map class object with table values. 
 * Second half checks the existence of table in the database.
 * Third half updates the table values in the database.
 */

public class ExcelUpdate {
	
	public static boolean readXLSXFile(String fileName) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(fileName);
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row, headerRow; 
		XSSFCell cell, headerCell;
		
		// first half, read the header values and create a pojo which will map with the base table in the database  
		StringBuilder buildHeader = new StringBuilder();
		headerRow = sheet.getRow(0);

		Iterator headerCells = headerRow.cellIterator(); 
		while(headerCells.hasNext()){
			headerCell=(XSSFCell) headerCells.next();
			buildHeader.append(headerCell.getStringCellValue()+",");
		}
		System.out.println(buildHeader.toString());
		Object classObject = buildClassObject(buildHeader);
		
		// checking the existence of the tabel in the respective database entered by the user.
		boolean isTablePresent = checkTableExistance(classObject);
	
		// create / updating the records in the table.
		boolean updateRecords =  false;
		if(isTablePresent){
			updateRecords = updateTable(classObject);
		} else {
			updateRecords = createTable(classObject);
		}
		return updateRecords;		
	}
	
	private static Object buildClassObject(StringBuilder columnHeaders){
		Object obj = null;
		
		return obj;
	}
	
	private static boolean checkTableExistance(Object tableHeaders){
		
		return false;
	}

	//updates an existing table
	private static boolean updateTable(Object tableHeaders){
		
		return false;
	}

	//creates a table and inserts the value into the table.
	private static boolean createTable(Object tableHeaders){
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		String fileName = "C:/test/Test_1.xlsx";
		
		if(readXLSXFile(fileName)){
			System.out.println("--- Create/ Update finished without any issues -----");
		} else{
			System.out.println("--- Could not finish update due to some -----");
		}
	}
}
