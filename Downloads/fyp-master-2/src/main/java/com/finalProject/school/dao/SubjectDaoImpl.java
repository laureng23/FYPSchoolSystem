package com.finalProject.school.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import com.finalProject.school.model.Subject;

@Repository("subjectDao")
public class SubjectDaoImpl extends AbstractDao<Integer, Subject> implements SubjectDao{

    static final Logger logger = LoggerFactory.getLogger(ModuleDaoImpl.class);
    
    public Subject findById(int id) {
    		Subject subject = getByKey(id);
    		if(subject!=null) {
    			Hibernate.initialize(subject);
    		}
    		return subject;
    }
    
    public Subject findByTitle(String title) {
    	logger.info("Title : {}", title);
    	Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("title", title));
        Subject subject = (Subject)crit.uniqueResult();
        if(subject!=null){
            Hibernate.initialize(subject);
        }
        return subject;
    }
    
    @SuppressWarnings("unchecked")
    public List<Subject> findAllSubjects() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("title"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Subject> subjects = (List<Subject>) criteria.list();
  
        return subjects;
    }
    
    public void save(Subject subject) {
        persist(subject);
    }
 
    public void deleteByTitle(String title) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("title", title));
        Subject subject = (Subject)crit.uniqueResult();
        delete(subject);
    }

	

}
