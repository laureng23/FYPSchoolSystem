package com.finalProject.school.dao;

import java.util.List;

import com.finalProject.school.model.UserProfile;
 
 
public interface UserProfileDao {
 
    List<UserProfile> findAll();
     
    UserProfile findByType(String type);
     
    UserProfile findById(int id);
}