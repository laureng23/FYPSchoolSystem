package com.finalProject.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.finalProject.school.model.Module;

@Repository("moduleDao")
public class ModuleDaoImpl extends AbstractDao<Integer, Module> implements ModuleDao{

    static final Logger logger = LoggerFactory.getLogger(ModuleDaoImpl.class);
    
    public Module findById(int id) {
    		Module module = getByKey(id);
    		if(module!=null) {
    			Hibernate.initialize(module);
    		}
    		return module;
    }
    
    public Module findByCode(String code) {
    	logger.info("Code : {}", code);
    	Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("code", code));
        Module module = (Module)crit.uniqueResult();
        if(module!=null){
            Hibernate.initialize(module);
        }
        return module;
    }
    
    @SuppressWarnings("unchecked")
    public List<Module> findAllModules() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Module> modules = (List<Module>) criteria.list();
  
        return modules;
    }
    
    public void save(Module module) {
        persist(module);
    }
 
    public void deleteByCode(String code) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("code", code));
        Module module = (Module)crit.uniqueResult();
        delete(module);
    }

	

}
