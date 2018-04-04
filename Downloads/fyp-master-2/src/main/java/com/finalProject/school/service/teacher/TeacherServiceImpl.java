package com.finalProject.school.service.teacher;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.school.dao.teacher.TeacherDao;
import com.finalProject.school.model.User;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherDao teacherDao;
	
	@Override
	public List<User> listAllTeachers(){
		return teacherDao.listAllTeachers();
	}
	
	@Override
	public List<User> listMathsTeachers(){
		return teacherDao.listMathsTeachers();
	}

	@Override
	public List<User> listEnglishTeachers(){
		return teacherDao.listEnglishTeachers();
	}
	
	@Override
	public List<User> listIrishTeachers(){
		return teacherDao.listIrishTeachers();
	}
	
	@Override
	public List<User> listFrenchTeachers(){
		return teacherDao.listFrenchTeachers();
	}
	
	@Override
	public List<User> listSpanishTeachers(){
		return teacherDao.listSpanishTeachers();
	}
	
	@Override
	public List<User> listGermanTeachers(){
		return teacherDao.listGermanTeachers();
	}
	
	@Override
	public List<User> listBusinessStudiesTeachers(){
		return teacherDao.listBusinessStudiesTeachers();
	}
	
	@Override
	public List<User> listGeographyTeachers(){
		return teacherDao.listGeographyTeachers();
	}

	@Override
	public List<User> listHisotryTeachers(){
		return teacherDao.listHistoryTeachers();
	}

}
