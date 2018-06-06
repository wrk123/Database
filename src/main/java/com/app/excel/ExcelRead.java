package com.app.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRead {

	private static List<StringBuilder> rowList;
	private static StringBuilder header, type, rows;

	ExcelRead() {
		rowList = new ArrayList<StringBuilder>();
	}

	public static void readXLSXFile(String fileName) throws IOException {

		InputStream ExcelFileToRead = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		header = new StringBuilder();

		/*
		 * headerRow = sheet.getRow(0); Iterator headerCells =
		 * headerRow.cellIterator(); while(headerCells.hasNext()){
		 * headerCell=(XSSFCell) headerCells.next();
		 * header.append(headerCell.getStringCellValue()+","); }
		 */

		for (int rowIndex = sheet.getFirstRowNum(); rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			if (row != null) {
				rows = new StringBuilder();
				type = new StringBuilder();

				for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
					cell = row.getCell(colIndex);
					if (rowIndex == 0) {
						header.append(cell.getRawValue() + ",");
					} else {
						if (rowIndex == 1) {
							createType(cell);
							createList(cell);
						} else {
							createList(cell);
						}
					}
				}
				System.out.println(rows.toString());
				rowList.add(rows);
			}
		}
	}

	public static void readXLSFile(String fileName) throws IOException {

		InputStream ExcelFileToRead = new FileInputStream(fileName);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		HSSFCell cell;

		header = new StringBuilder();

		for (int rowIndex = sheet.getFirstRowNum(); rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			if (row != null) {
				rows = new StringBuilder();
				type = new StringBuilder();

				for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
					cell = row.getCell(colIndex);
					if (rowIndex == 0) {
						header.append(cell.getStringCellValue() + ",");
					} else {
						if (rowIndex == 1) {
							createType(cell);
							createList(cell);
						} else {
							createList(cell);
						}
					}
				}
				System.out.println(rows.toString());
				rowList.add(rows);
			}
		}
	}

	private static void createList(Cell cellValue) {
		switch (cellValue.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			rows.append(cellValue.getStringCellValue() + ",");
			break;
		case Cell.CELL_TYPE_NUMERIC:
			rows.append(cellValue.getNumericCellValue() + ",");
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			rows.append(cellValue.getBooleanCellValue() + ",");
			break;
		case Cell.CELL_TYPE_BLANK:
			rows.append(cellValue.getErrorCellValue() + ",");
			break;
		case Cell.CELL_TYPE_ERROR:
			rows.append(cellValue.getErrorCellValue() + ",");
			break;
		case Cell.CELL_TYPE_FORMULA:
			rows.append(cellValue.getStringCellValue() + ",");
			break;
		default:
			break;
		}
	}

	private static void createType(Cell cellValue) {
		switch (cellValue.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			type.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_NUMERIC:
			type.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			type.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_BLANK:
			type.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_ERROR:
			type.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_FORMULA:
			type.append(cellValue.getCellTypeEnum() + ",");
			break;
		default:
			break;
		}
	}

	public static List<StringBuilder> getRowList() {
		return rowList;
	}

	public static StringBuilder getHeader() {
		return header;
	}

	public static StringBuilder getType() {
		return type;
	}

	public static StringBuilder getRows() {
		return rows;
	}

	public static void setRowList(List<StringBuilder> rowList) {
		ExcelRead.rowList = rowList;
	}

	public static void setHeader(StringBuilder header) {
		ExcelRead.header = header;
	}

	public static void setType(StringBuilder type) {
		ExcelRead.type = type;
	}

	public static void setRows(StringBuilder rows) {
		ExcelRead.rows = rows;
	}

}
