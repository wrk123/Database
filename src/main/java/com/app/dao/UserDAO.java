package com.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.model.User;


public interface UserDAO extends CrudRepository<User, Long>{

	List<User> findAll();
	
	User findByEmail(String email);
	
		
}
