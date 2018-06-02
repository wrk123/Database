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
	private static StringBuilder buildHeader, buildType, buildRow;

	ExcelRead() {
		rowList = new ArrayList<StringBuilder>();
	}

	public static void readXLSXFile(String fileName) throws IOException {

		InputStream ExcelFileToRead = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		XSSFCell cell;

		buildHeader = new StringBuilder();

		/*
		 * headerRow = sheet.getRow(0); Iterator headerCells =
		 * headerRow.cellIterator(); while(headerCells.hasNext()){
		 * headerCell=(XSSFCell) headerCells.next();
		 * buildHeader.append(headerCell.getStringCellValue()+","); }
		 */

		for (int rowIndex = sheet.getFirstRowNum(); rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			if (row != null) {
				buildRow = new StringBuilder();
				buildType = new StringBuilder();

				for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
					cell = row.getCell(colIndex);
					if (rowIndex == 0) {
						buildHeader.append(cell.getRawValue() + ",");
					} else {
						if (rowIndex == 1) {
							createType(cell);
							createList(cell);
						} else {
							createList(cell);
						}
					}
				}
				System.out.println(buildRow.toString());
				rowList.add(buildRow);
			}
		}
	}

	public static void readXLSFile(String fileName) throws IOException {

		InputStream ExcelFileToRead = new FileInputStream(fileName);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);

		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow row;
		HSSFCell cell;

		buildHeader = new StringBuilder();

		for (int rowIndex = sheet.getFirstRowNum(); rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);
			if (row != null) {
				buildRow = new StringBuilder();
				buildType = new StringBuilder();

				for (int colIndex = 0; colIndex < row.getLastCellNum(); colIndex++) {
					cell = row.getCell(colIndex);
					if (rowIndex == 0) {
						buildHeader.append(cell.getStringCellValue() + ",");
					} else {
						if (rowIndex == 1) {
							createType(cell);
							createList(cell);
						} else {
							createList(cell);
						}
					}
				}
				System.out.println(buildRow.toString());
				rowList.add(buildRow);
			}
		}
	}

	private static void createList(Cell cellValue) {
		switch (cellValue.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			buildRow.append(cellValue.getStringCellValue() + ",");
			break;
		case Cell.CELL_TYPE_NUMERIC:
			buildRow.append(cellValue.getNumericCellValue() + ",");
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			buildRow.append(cellValue.getBooleanCellValue() + ",");
			break;
		case Cell.CELL_TYPE_BLANK:
			buildRow.append(cellValue.getErrorCellValue() + ",");
			break;
		case Cell.CELL_TYPE_ERROR:
			buildRow.append(cellValue.getErrorCellValue() + ",");
			break;
		case Cell.CELL_TYPE_FORMULA:
			buildRow.append(cellValue.getStringCellValue() + ",");
			break;
		default:
			break;
		}
	}

	private static void createType(Cell cellValue) {
		switch (cellValue.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			buildType.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_NUMERIC:
			buildType.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			buildType.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_BLANK:
			buildType.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_ERROR:
			buildType.append(cellValue.getCellTypeEnum() + ",");
			break;
		case Cell.CELL_TYPE_FORMULA:
			buildType.append(cellValue.getCellTypeEnum() + ",");
			break;
		default:
			break;
		}
	}

	public static List<StringBuilder> getRowList() {
		return rowList;
	}

	public static StringBuilder getBuildHeader() {
		return buildHeader;
	}

	public static StringBuilder getBuildType() {
		return buildType;
	}

	public static StringBuilder getBuildRow() {
		return buildRow;
	}

	public static void setRowList(List<StringBuilder> rowList) {
		ExcelRead.rowList = rowList;
	}

	public static void setBuildHeader(StringBuilder buildHeader) {
		ExcelRead.buildHeader = buildHeader;
	}

	public static void setBuildType(StringBuilder buildType) {
		ExcelRead.buildType = buildType;
	}

	public static void setBuildRow(StringBuilder buildRow) {
		ExcelRead.buildRow = buildRow;
	}

}
