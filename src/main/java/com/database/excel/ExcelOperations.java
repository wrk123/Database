package com.database.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class reads the excel file and updates the database.
 * The program is divided into three parts. 
 * First half reads the header values and creates the pojo class to map class object with table values. 
 * Second half checks the existence of table in the database.
 * Third half updates the table values in the database.
 */

public class ExcelOperations {
	
	private static Map<String,ClassObject> rowRecords = null;
	// create a classObject with respect to mapping for pojo
	
	//send the filename, read the execel data and return the read data in the hashmap
	public static Map<String, ClassObject> readXLSXFile(String fileName) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(fileName);
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		rowRecords = new HashMap<String,ClassObject>();
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
		
		// first half, read the header values and create a pojo which will map with the base table in the database  
		StringBuilder buildHeader = new StringBuilder();
		headerRow = sheet.getRow(0);

		Iterator headerCells = headerRow.cellIterator(); 
		while(headerCells.hasNext()){
			headerCell=(XSSFCell) headerCells.next();
			buildHeader.append(headerCell.getStringCellValue()+",");
		}
		
		ClassObject classObjects = buildClassObject(buildHeader);
		
		int firstRow = sheet.getFirstRowNum();
		int lastRow = sheet.getLastRowNum();
		String key= new String();
		
		for (int i = firstRow + 1; i <= lastRow; i++) {
			//create new object of the pojo class everytime
			row = wb.getSheetAt(0).getRow(i);
			
			cell = row.getCell(0);			
			//Use setter to set the first cell in the first row
			
			cell = row.getCell(1);
			//Use setter to set the second cell in the first row
			
			cell = row.getCell(2);
			//Use setter to set the third cell in the first row
			
			//perform the same steps with other cells and set them to respective pojo values.
			rowRecords.put(key, records);
		} 
		
		return rowRecords;
	}
	
	
	private static Object buildClassObject(StringBuilder columnHeaders){
		Object obj = null;
		
		return obj;
	}

	//updates an existing table
	private static boolean updateTable(Object tableHeaders){
		
		return false;
	}
		
	public static void main(String[] args) throws IOException {
		
		String fileName = "C:/test/Test_2.xlsx";
		System.out.println(readXLSXFile(fileName).size()); 
		
	}
}
