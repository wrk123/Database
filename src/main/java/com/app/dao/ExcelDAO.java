package com.app.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ExcelDAO {

	public Boolean readExcel(String fileName);
	
	public void writeExcel(List<?> dataWrite, String fileName);
	
	public void createTables(List<?> tableSchema);
	
	public void saveToDatabase(List<?> data);
	
	public void updateDatabase(List<?> data);
	
	
}
