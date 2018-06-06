package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.service.ExcelService;

@Controller
public class MainController {

	@Autowired
	ExcelService excel;
	
	private final Logger LOG = LogManager.getLogger(this.getClass().getName());
	
	@RequestMapping("/")
	public @ResponseBody String index() {
		StringBuilder displayMessage = new StringBuilder();
		displayMessage.append("<br/><h2>Welcome to extensive database operations application </h2><br/>");
		displayMessage.append("<br/><h3>Below are operations supported based on user role</h3><br/>");
		return displayMessage.toString();
	}

	@RequestMapping(value = "/readExcel", method = RequestMethod.POST )
	public String readExcel(@PathParam("filePath") String filePath) {
		System.out.println("----- File path obtained from URL is ----" + filePath);
		if(excel.readExcel(filePath)){
			LOG.info("-- SUCCESSFULLY COMPLETED --");
			return "Completion of excel read and insertion in database done.";
		}
		LOG.info("-- UNSUCCESSFULL COMPLETION --");
		return "Problem occurred while inserting the excel records in the database.";
	}
	
	@RequestMapping(value ="/error", method = RequestMethod.GET)
	public @ResponseBody String errorPage(){
		return "<br/><h2> Exception occurred !!! </h2><br/>";
	}

}
