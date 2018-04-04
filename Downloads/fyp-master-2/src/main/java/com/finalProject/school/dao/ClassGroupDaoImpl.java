package com.finalProject.school.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.finalProject.school.model.ClassGroup;
 
 
 
@Repository("classGroupDao")
public class ClassGroupDaoImpl extends AbstractDao <Integer, ClassGroup> implements ClassGroupDao {
 
    static final Logger logger = LoggerFactory.getLogger(ClassGroupDaoImpl.class);
     
    public ClassGroup findById(int id) {
        ClassGroup classGroup = getByKey(id);
        if(classGroup!=null){
            Hibernate.initialize(classGroup);
        }
        return classGroup;
    }
 
    public ClassGroup findByGroupCode(String group_code) {
        logger.info("Code : {}", group_code);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("code", group_code));
        ClassGroup classGroup = (ClassGroup)crit.uniqueResult();
        if(classGroup!=null){
            Hibernate.initialize(classGroup);
        }
        return classGroup;
    }
 
    @SuppressWarnings("unchecked")
    public List<ClassGroup> findAllClassGroups() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("code"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<ClassGroup> classGroup = (List<ClassGroup>) criteria.list();
       
        
        return classGroup;
    }
 
    public void save(ClassGroup classGroup) {
        persist(classGroup);
    }
 
    public void deleteByGroupCode(String group_code) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("code", group_code));
        ClassGroup classGroup = (ClassGroup)crit.uniqueResult();
        delete(classGroup);
    }
 
}