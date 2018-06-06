package com.app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository
public interface UserDAO extends CrudRepository<User, Long>{

	List<User> findAll();
	
	User findByEmail(String email);
	
		
}
