package com.finalProject.school.service;

import java.util.List;

import com.finalProject.school.model.ClassGroup;
 
 
public interface ClassGroupService {
     
    ClassGroup findById(int id);
     
    ClassGroup findByGroupCode(String group_code);
     
    void saveClassGroup(ClassGroup classGroup);
     
    void updateClassGroup(ClassGroup classGroup);
     
    void deleteClassGroupByGroupCode(String group_code);
 
    List<ClassGroup> findAllClassGroups();
     
    boolean isClassGroupCodeUnique(Integer id, String group_code);
 
}