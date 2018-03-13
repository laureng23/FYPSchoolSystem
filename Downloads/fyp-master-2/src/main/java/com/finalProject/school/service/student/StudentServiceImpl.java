package com.finalProject.school.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalProject.school.dao.student.StudentDao;
import com.finalProject.school.model.User;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<User> listAllStudents() {
		return studentDao.listAllStudents();
	}
}
