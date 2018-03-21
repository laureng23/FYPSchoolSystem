package com.assessment.bookStore.dao;

import java.util.List;

import com.assessment.bookStore.model.User;


public interface UserDao {

	User findById(int id);
	
	User findByCode(String code);
	
	void save(User user);
	
	void deleteByCode(String code);
	
	List<User> findAllUsers();

}

