package com.finalProject.school.service;

import java.util.List;

import com.finalProject.school.model.Module;
 

public interface ModuleService {
	
	Module findById(int id);
    
    Module findByCode(String code);
     
    void save(Module module);
     
    void update(Module module);
     
    void deleteByCode(String code);
 
    List<Module> findAllModules(); 
     
    boolean isModuleCodeUnique(Integer id, String code);

}
