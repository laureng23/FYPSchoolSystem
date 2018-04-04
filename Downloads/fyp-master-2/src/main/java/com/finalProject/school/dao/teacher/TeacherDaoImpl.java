package com.finalProject.school.dao.teacher;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.finalProject.school.dao.AbstractDao;
import com.finalProject.school.model.User;

@Repository
public class TeacherDaoImpl extends AbstractDao<Integer, User> implements TeacherDao {

	private static final String LIST_ALL_TEACHERS =  "select * from APP_USER left join APP_USER_USER_PROFILE on APP_USER.id = APP_USER_USER_PROFILE.user_id where APP_USER_USER_PROFILE.user_profile_id = 4;";
	
	private static final String LIST_TEACHER_MATHS = "select * from APP_USER left join SUBJECT_TEACHER on APP_USER.id = SUBJECT_TEACHER.user_id where SUBJECT_TEACHER.subject_id = 1;";
	
	private static final String LIST_TEACHER_ENGLISH = "select * from APP_USER left join SUBJECT_TEACHER on APP_USER.id = SUBJECT_TEACHER.user_id where SUBJECT_TEACHER.subject_id = 2;";
	
	private static final String LIST_TEACHER_IRISH = "select * from APP_USER left join SUBJECT_TEACHER on APP_USER.id = SUBJECT_TEACHER.user_id where SUBJECT_TEACHER.subject_id = 3;";

	private static final String LIST_TEACHER_FRENCH = "select * from APP_USER left join SUBJECT_TEACHER on APP_USER.id = SUBJECT_TEACHER.user_id where SUBJECT_TEACHER.subject_id = 4;";

	private static final String LIST_TEACHER_SPANISH = "select * from APP_USER left join SUBJECT_TEACHER on APP_USER.id = SUBJECT_TEACHER.user_id where SUBJECT_TEACHER.subject_id = 5;";

	private static final String LIST_TEACHER_GERMAN = "select * from APP_USER left join SUBJECT_TEACHER on APP_USER.id = SUBJECT_TEACHER.user_id where SUBJECT_TEACHER.subject_id = 6;";

	private static final String LIST_TEACHER_BUSINESSSTUDIES = "select * from APP_USER left join SUBJECT_TEACHER on APP_USER.id = SUBJECT_TEACHER.user_id where SUBJECT_TEACHER.subject_id = 7;";

	private static final String LIST_TEACHER_GEOGRAPHY = "select * from APP_USER left join SUBJECT_TEACHER on APP_USER.id = SUBJECT_TEACHER.user_id where SUBJECT_TEACHER.subject_id = 8;";

	private static final String LIST_TEACHER_HISTORY = "select * from APP_USER left join SUBJECT_TEACHER on APP_USER.id = SUBJECT_TEACHER.user_id where SUBJECT_TEACHER.subject_id = 9;";

	
	@SuppressWarnings({ "unchecked" })
	public List<User> listAllTeachers() {
		return getSession().createSQLQuery(LIST_ALL_TEACHERS).addEntity(User.class).list();
    }

	@SuppressWarnings({ "unchecked" })
	public List<User> listMathsTeachers() {
		return getSession().createSQLQuery(LIST_TEACHER_MATHS).addEntity(User.class).list();
    }
	
	@SuppressWarnings({ "unchecked" })
	public List<User> listEnglishTeachers() {
		return getSession().createSQLQuery(LIST_TEACHER_ENGLISH).addEntity(User.class).list();
    }
	
	@SuppressWarnings({ "unchecked" })
	public List<User> listIrishTeachers() {
		return getSession().createSQLQuery(LIST_TEACHER_IRISH).addEntity(User.class).list();
    }
	
	@SuppressWarnings({ "unchecked" })
	public List<User> listFrenchTeachers() {
		return getSession().createSQLQuery(LIST_TEACHER_FRENCH).addEntity(User.class).list();
    }
	

	@SuppressWarnings({ "unchecked" })
	public List<User> listSpanishTeachers() {
		return getSession().createSQLQuery(LIST_TEACHER_SPANISH).addEntity(User.class).list();
    }
	
	@SuppressWarnings({ "unchecked" })
	public List<User> listGermanTeachers() {
		return getSession().createSQLQuery(LIST_TEACHER_GERMAN).addEntity(User.class).list();
    }
	
	@SuppressWarnings({ "unchecked" })
	public List<User> listBusinessStudiesTeachers() {
		return getSession().createSQLQuery(LIST_TEACHER_BUSINESSSTUDIES).addEntity(User.class).list();
    }
	
	@SuppressWarnings({ "unchecked" })
	public List<User> listGeographyTeachers() {
		return getSession().createSQLQuery(LIST_TEACHER_GEOGRAPHY).addEntity(User.class).list();
    }
	
	@SuppressWarnings({ "unchecked" })
	public List<User> listHistoryTeachers() {
		return getSession().createSQLQuery(LIST_TEACHER_HISTORY).addEntity(User.class).list();
    }
	
}
