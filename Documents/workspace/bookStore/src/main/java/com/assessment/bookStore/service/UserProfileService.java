package com.assessment.bookStore.service;

import java.util.List;

import com.assessment.bookStore.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
