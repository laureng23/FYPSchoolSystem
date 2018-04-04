package com.finalProject.school.dao;

import java.util.List;

import com.finalProject.school.model.ClassGroup;
 
 
public interface ClassGroupDao {
 
    ClassGroup findById(int id);
     
    ClassGroup findByGroupCode(String group_code);
     
    void save(ClassGroup classGroup);
     
    void deleteByGroupCode(String group_code);
     
    List<ClassGroup> findAllClassGroups();
    
    
 
}