package com.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.app.dao.UserDAO;
import com.app.model.User;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public Boolean createUser(User userDetails){
		User user=null; 
		user = userDAO.findByEmail(userDetails.getEmail());
		if(user == null){
			try{
				user = new User(userDetails.getFirstName(), userDetails.getLastName(),userDetails.getEmail(),userDetails.getCity());
				userDAO.save(user);
				LOG.debug("-------- Successful [SAVING USER] -------");
			}catch(Exception e){
				LOG.debug("-------- Exception occured [SAVING USER]----"+e);
				return false;
			}
		}
		return true;
	}
	
	public User getUserDetails(User userDetails){
		User user = null;
		try{
			user = userDAO.findByEmail(userDetails.getEmail());
		}catch(Exception e){
			LOG.debug("-------- Exception occured [FETCHING USER DETAILS]----"+e);
			user = null;
		}
		return user;
	}
	
	public List<User> getAllDetails(){
		List<User> users = null;
		try{
			users = userDAO.findAll();
		}catch(Exception e){
			LOG.debug("-------- Exception occured [FETCHING ALL USER DETAILS]----"+e);	
		}
		return users;
	}
	
}
