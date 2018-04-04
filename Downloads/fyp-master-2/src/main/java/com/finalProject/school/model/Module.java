package com.finalProject.school.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name="MODULE")
public class Module implements Serializable{
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @NotEmpty
    @Column(name="module_code", unique=true, nullable=false)
    private String code;
     
    @NotEmpty
    @Column(name="title", nullable=false)
    private String title;
    
    @NotEmpty
    @Column(name="description", nullable=false)
    private String description;
    
    @NotNull
    @Column(name="capacity", nullable=false)
    private Integer capacity;
    
    @Column(name="SchoolYear")
    private Date schoolYear;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_MODULES", 
             joinColumns = { @JoinColumn(name = "USER_MODULE_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private Set<User> userModules = new HashSet<User>();
    
  //Teacher-->Modules
  	@ManyToOne(fetch = FetchType.EAGER)
  	@JoinColumn(name = "TeacherId")
  	private User teacher;
    
 
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Integer getCapacity() {
        return capacity;
    }
 
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    
    public User getTeacher() {
    		return teacher;
    }
    
    public void setTeacher(User teacher) {
    		this.teacher = teacher;
    }
    
    public Set<User> getUserModules(){
    		return userModules;
    }
    
    public void setUserModules(Set<User> userModules) {
    		this.userModules = userModules;
    }
    
    public Date getSchoolYear() {
		return schoolYear;
    }

    public void setSchoolYear(Date schoolYear) {
		this.schoolYear = schoolYear;
    }
   

 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Module))
            return false;
        Module other = (Module) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        return true;
    }
 
 
   @Override
    public String toString() {
        return "ClassGroup [id=" + id + ", code=" + code + ", title=" + title
                + ",]";
    }
 
 
     
}
