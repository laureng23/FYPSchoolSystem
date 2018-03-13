package com.finalProject.school.dao;

import java.util.List;

import com.finalProject.school.model.ClassGroup;
 
 
public interface ClassGroupDao {
 
    ClassGroup findById(int id);
     
    ClassGroup findByGroupCode(String code);
     
    void save(ClassGroup classGroup);
     
    void deleteByGroupCode(String code);
     
    List<ClassGroup> findAllClassGroups();
    
    
 
}