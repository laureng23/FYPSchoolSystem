package com.finalProject.school.model;
import java.io.Serializable;
import java.util.Date;
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
@Table(name="CLASS_GROUP")
public class ClassGroup implements Serializable{
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
 
    @NotEmpty
    @Column(name="group_code", unique=true, nullable=false)
    private String code;
     
    @NotEmpty
    @Column(name="title", nullable=false)
    private String title;
    
    
    @Column(name="SchoolYear", nullable=false)
    private Date schoolYear;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_CLASS_GROUPS", 
             joinColumns = { @JoinColumn(name = "USER_CLASSGROUP_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_ID") })
    private Set<User> userClassGroups = new HashSet<User>();
    
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
    
    public Date getSchoolYear() {
    		return schoolYear;
    }
    
    public void setSchoolYear(Date schoolYear) {
    		this.schoolYear = schoolYear;
    }
 
    public Set<User> getUserClassGroups(){
    		return userClassGroups;
    }
    
    public void setUserClassGroups(Set<User> userClassGroup) {
    		this.userClassGroups = userClassGroup;
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
        if (!(obj instanceof ClassGroup))
            return false;
        ClassGroup other = (ClassGroup) obj;
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
