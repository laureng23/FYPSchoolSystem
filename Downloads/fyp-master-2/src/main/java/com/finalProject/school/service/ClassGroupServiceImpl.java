package com.finalProject.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.finalProject.school.dao.ClassGroupDao;
import com.finalProject.school.model.ClassGroup;
 
 
@Service("classGroupService")
@Transactional
public class ClassGroupServiceImpl implements ClassGroupService{
 
    @Autowired
    private ClassGroupDao dao;
 

     
    public ClassGroup findById(int id) {
        return dao.findById(id);
    }
 
    public ClassGroup findByGroupCode(String code) {
        ClassGroup classGroup = dao.findByGroupCode(code);
        return classGroup;
    }
 
    public void saveClassGroup(ClassGroup classGroup) {
       // user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(classGroup);
    }
 
  
    public void updateClassGroup(ClassGroup classGroup) {
        ClassGroup entity = dao.findById(classGroup.getId());
        if(entity!=null){
            entity.setCode(classGroup.getCode());
          /*  if(!user.getPassword().equals(entity.getPassword())){
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }*/
            entity.setTitle(classGroup.getTitle());
            
            
        }
    }
 
     
    public void deleteClassGroupByGroupCode(String code) {
        dao.deleteByGroupCode(code);
    }
 
    public List<ClassGroup> findAllClassGroups() {
        return dao.findAllClassGroups();
    }
 
    public boolean isClassGroupCodeUnique(Integer id, String code) {
        ClassGroup classGroup = findByGroupCode(code);
        return ( classGroup == null || ((id != null) && (classGroup.getId() == id)));
    }
     
}

