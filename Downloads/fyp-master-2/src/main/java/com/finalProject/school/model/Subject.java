package com.finalProject.school.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
import org.hibernate.validator.constraints.NotEmpty;
 @Entity
 @Table(name="SUBJECT")
public class Subject implements Serializable {

	 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	 
	 @NotEmpty
	 @Column(name="TITLE", unique=true, nullable=false)
	 private String title;
	 
	 
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "SUBJECT_TEACHER", 
	             joinColumns = { @JoinColumn(name = "SUBJECT_ID") }, 
	             inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
	    private Set<User> teacherSubjects = new HashSet<User>();
	 
	 public Integer getId() {
	        return id;
	    }
	 
	    public void setId(Integer id) {
	        this.id = id;
	    }
	 
	    public String getTitle() {
	        return title;
	    }
	 
	    public void setTitle(String title) {
	        this.title = title;
	    }
	 
	    public Set<User> getTeacherSubjects() {
	        return teacherSubjects;
	    }
	 
	    public void setTeacherSubjects(Set<User> teacherSubjects) {
	        this.teacherSubjects = teacherSubjects;
	    }
}
