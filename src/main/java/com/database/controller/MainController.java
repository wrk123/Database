package com.database.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
	StringBuilder displayMessage = new StringBuilder();
	displayMessage.append("<br/><h2>Welcome to extensive database operations application </h2><br/>");
	displayMessage.append("<br/><h3>Below are operations supported based on user role</h3><br/>");  
    return displayMessage.toString();
  }

}
