package com.finalProject.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.finalProject.school.dao.SubjectDao;
import com.finalProject.school.model.Subject;

@Service("subjectervice")
@Transactional

public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	private SubjectDao dao;
	
	public Subject findById(int id) {
		return dao.findById(id);
	}
	
	 public Subject findByTitle(String title) {
		 	Subject subject = dao.findByTitle(title);
	        return subject;
	    }
	 
	    public void save(Subject subject) {
	        dao.save(subject);
	    }
	    
	    public void update(Subject subject) {
	    		Subject entity = dao.findById(subject.getId());
	    		if(entity!=null) {
	    			
	    			entity.setTitle(subject.getTitle());
	    			
	    			entity.setTeacherSubjects(subject.getTeacherSubjects());
	    		}
	    }
	    
	    public void deleteByTitle(String title) {
	        dao.deleteByTitle(title);
	    }
	 
	    public List<Subject> findAllSubjects() {
	        return dao.findAllSubjects();
	    }
	 
	    public boolean isSubjectTitleUnique(Integer id, String title) {
	    		Subject subject = findByTitle(title);
	        return ( subject == null || ((id != null) && (subject.getId() == id)));
	    }

		
	 

}
