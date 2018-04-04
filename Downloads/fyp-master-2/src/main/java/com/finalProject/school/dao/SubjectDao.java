package com.finalProject.school.dao;
import java.util.List;

import com.finalProject.school.model.Subject;

public interface SubjectDao {
	
	Subject findById(int id);
	
	Subject findByTitle(String title);
	
	void save(Subject subject);
	
	void deleteByTitle(String title);
	
	List<Subject> findAllSubjects();

}
