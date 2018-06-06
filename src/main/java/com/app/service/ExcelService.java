package com.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ExcelDAO;

@Service
public class ExcelService {

	@Autowired
	ExcelDAO excelDAO;
	
	private final Logger LOG = LogManager.getLogger(this.getClass().getName());
	
	public Boolean readExcel(String filePath){
		if(!(filePath == null || filePath.equals(null))){
			LOG.info("-- Returning true --");
			return excelDAO.readExcel(filePath);
		}
		LOG.info("-- Returning false --");
		return false;
	}
	
}
