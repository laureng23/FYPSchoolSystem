package com.assessment.bookStore.dao;

import java.util.List;

import com.assessment.bookStore.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
