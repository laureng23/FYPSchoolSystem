package com.finalProject.school.dao.student;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.finalProject.school.dao.AbstractDao;
import com.finalProject.school.model.User;
import com.finalProject.school.model.dao.UserProfileIds;

@Repository
public class StudentDaoImpl extends AbstractDao<Integer, User> implements StudentDao {
	
	private static final String LIST_ALL_STUDENTS = "select * from APP_USER left join APP_USER_USER_PROFILE on APP_USER.id = APP_USER_USER_PROFILE.user_id where APP_USER_USER_PROFILE.user_profile_id = 1;";
	
	@SuppressWarnings({ "unchecked" })
	public List<User> listAllStudents() {
		return getSession().createSQLQuery(LIST_ALL_STUDENTS).addEntity(User.class).list();
    }
}
