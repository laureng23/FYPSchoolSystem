package com.finalProject.school.service;

import java.util.List;

import com.finalProject.school.model.Subject;


public interface SubjectService {
	
	Subject findById(int id);
    
	Subject findByTitle(String title);
     
    void save(Subject subject);
     
    void update(Subject subject);
     
    void deleteByTitle(String title);
 
    List<Subject> findAllSubjects(); 
     
    boolean isSubjectTitleUnique(Integer id, String title);

}
