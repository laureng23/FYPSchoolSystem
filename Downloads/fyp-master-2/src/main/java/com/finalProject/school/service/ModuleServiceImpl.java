package com.finalProject.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.finalProject.school.dao.ModuleDao;
import com.finalProject.school.model.Module;

@Service("moduleService")
@Transactional

public class ModuleServiceImpl implements ModuleService{
	
	@Autowired
	private ModuleDao dao;
	
	public Module findById(int id) {
		return dao.findById(id);
	}
	
	 public Module findByCode(String code) {
	        Module module = dao.findByCode(code);
	        return module;
	    }
	 
	    public void save(Module module) {
	        dao.save(module);
	    }
	    
	    public void update(Module module) {
	    		Module entity = dao.findById(module.getId());
	    		if(entity!=null) {
	    			entity.setCode(module.getCode());
	    			entity.setTitle(module.getTitle());
	    			entity.setDescription(module.getDescription());
	    			entity.setCapacity(module.getCapacity());
	    			entity.setTeacher(module.getTeacher());
	    			entity.setUserModules(module.getUserModules());
	    		}
	    }
	    
	    public void deleteByCode(String code) {
	        dao.deleteByCode(code);
	    }
	 
	    public List<Module> findAllModules() {
	        return dao.findAllModules();
	    }
	 
	    public boolean isModuleCodeUnique(Integer id, String code) {
	        Module module = findByCode(code);
	        return ( module == null || ((id != null) && (module.getId() == id)));
	    }

		
	 

}
