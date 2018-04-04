package com.database.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.database.model.User;


public interface UserDAO extends CrudRepository<User, Long>{

	List<User> findAll();
	
	User findByEmail(String email);
	
		
}
