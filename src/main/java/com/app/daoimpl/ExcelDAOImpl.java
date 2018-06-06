package com.app.daoimpl;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.dao.ExcelDAO;
import com.app.excel.ExcelRead;
import com.app.util.CommonUtil;

@Component
@Repository
public class ExcelDAOImpl implements ExcelDAO {

	private final Logger LOG = LogManager.getLogger(this.getClass().getName());
	
	@Override
	public Boolean readExcel(String fileName) {
		try{
			if(fileName.endsWith(".xlsx")){
				ExcelRead.readXLSXFile(fileName);
			}else{
				ExcelRead.readXLSFile(fileName);
			}
			
			String[] excelHeader = CommonUtil.stringBuilderParser(ExcelRead.getHeader().toString());
			String[] colType =  CommonUtil.stringBuilderParser(ExcelRead.getType().toString());
			List<StringBuilder> excelRows = ExcelRead.getRowList();
			
			printLog(excelHeader, colType, excelRows);
			
			if(excelHeader.length == colType.length){
				
				//generate the POJO class and create tables
				
				//dump the data read from excel into database 
				
				
			}else{
				System.out.println("---- Length of column header field and type mismatch ----");
				LOG.info("---- Length of column header field and type mismatch ----");
				return false;
			}
			
		}catch(IOException e){
			LOG.error("-- Exception occurred while reading the excel file --" + e);
			return false;
		}catch(Exception e){
			LOG.error("-- Exception occurred --" + e);
			return false;
		}
		return true;
		 
	}

	@Override
	public void writeExcel(List<?> dataWrite, String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTables(List<?> tableSchema) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveToDatabase(List<?> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDatabase(List<?> data) {
		// TODO Auto-generated method stub
		
	}
	
	public void printLog(String[] headerValues, String[] cellType, List<StringBuilder> values){
		LOG.info("-- Header value is --");
		for(int index =  0; index < headerValues.length ; index++){
			LOG.info(headerValues[index] + " , ");
		}
		
		LOG.info("-- Cell type value is --");
		for(int index =  0; index < cellType.length ; index++){
			LOG.info(cellType[index] + " , ");
		}
		
		LOG.info("-- Excel value is --");
		for(int index =  0; index < values.size() ; index++){
			LOG.info(values.get(index).toString() + " , ");
		}
	}
	
}
