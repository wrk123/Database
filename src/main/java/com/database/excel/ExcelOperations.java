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

import com.database.model.ProductionCapability;

/**
 * This class reads the excel file and updates the database.
 * The program is divided into three parts. 
 * First half reads the header values and creates the pojo class to map class object with table values. 
 * Second half checks the existence of table in the database.
 * Third half updates the table values in the database.
 */

public class ExcelOperations {
	
	private static Map<String,ProductionCapability> rowRecords = null;
	private static ProductionCapability records = null;
	
	//send the filename, read the execel data and return the read data in the hashmap
	public static Map<String, ProductionCapability> readXLSXFile(String fileName) throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream(fileName);
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		rowRecords = new HashMap<String,ProductionCapability>();
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;
		
		// first half, read the header values and create a pojo which will map with the base table in the database  
		/*StringBuilder buildHeader = new StringBuilder();
		headerRow = sheet.getRow(0);

		Iterator headerCells = headerRow.cellIterator(); 
		while(headerCells.hasNext()){
			headerCell=(XSSFCell) headerCells.next();
			buildHeader.append(headerCell.getStringCellValue()+",");
		}
		System.out.println(buildHeader.toString());
		Object classObject = buildClassObject(buildHeader);
		boolean updateRecords = updateTable(classObject);
	*/
		
		int firstRow = sheet.getFirstRowNum();
		int lastRow = sheet.getLastRowNum();
		String key= new String();
		
		for (int i = firstRow + 1; i <= lastRow; i++) {
			records = new ProductionCapability();
			row = wb.getSheetAt(0).getRow(i);
			
			cell = row.getCell(0);			
			records.setId((int) cell.getNumericCellValue());
			
			cell = row.getCell(1);
			records.setEquipmentID((int) cell.getNumericCellValue());
			
			cell = row.getCell(2);
			records.setMaterialID((String) cell.getStringCellValue());
			
			cell = row.getCell(3);
			records.setMaterialRev((String) cell.getStringCellValue());
			
			cell = row.getCell(4);
			records.setIdealRate((int) cell.getNumericCellValue());
			
			cell = row.getCell(5);
			records.setIdealRateUnits((String) cell.getStringCellValue());
			
			cell = row.getCell(6);
			records.setPreferredAssignOrder((int) cell.getNumericCellValue());
			
			cell = row.getCell(7);
			records.setStatus((int) cell.getNumericCellValue());
			
			//check the comments column
			cell = row.getCell(8);
			records.setComment((String) " ");
			
			/*  check this again for reading the comments value
			if(cell.getStringCellValue() == null){
				records.setComment((String) "");
			}else{
				records.setComment((String) cell.getStringCellValue());
			}*/
			//records.setComment((String)((cell.getStringCellValue() == null)? " " : cell.getStringCellValue()));
			
			cell = row.getCell(9);
			records.setEnabled((byte) cell.getNumericCellValue());
			
			cell = row.getCell(10);
			records.setLastEditBy((String) cell.getStringCellValue());
			
			cell = row.getCell(11);
			records.setLastEditAt((Date) cell.getDateCellValue());
		
			// merge equipment id, material id and material rev for further analysis 
			key = records.getEquipmentID()+"_"+records.getMaterialID()+"_"+records.getMaterialRev();
			rowRecords.put(key, records);
		} 
		System.out.println(rowRecords.toString());
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
