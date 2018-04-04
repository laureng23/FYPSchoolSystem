package com.finalProject.school.dao;
import java.util.List;

import com.finalProject.school.model.Module;

public interface ModuleDao {
	
	Module findById(int id);
	
	Module findByCode(String code);
	
	void save(Module module);
	
	void deleteByCode(String code);
	
	List<Module> findAllModules();

}
