package com.assessment.bookStore.service;

import java.util.List;

import com.assessment.bookStore.model.User;


public interface UserService {
	
	User findById(int id);
	
	User findByCode(String code);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByCode(String code);

	List<User> findAllUsers(); 
	
	boolean isUserCodeUnique(Integer id, String code);

}