package com.finalProject.school.dao.teacher;

import java.util.List;
import com.finalProject.school.model.User;

public interface TeacherDao {

	List<User> listAllTeachers();
	
	List<User> listMathsTeachers();
	
	List<User> listEnglishTeachers();
	
	List<User> listIrishTeachers();
	
	List<User> listFrenchTeachers();
	
	List<User> listSpanishTeachers();
	
	List<User> listGermanTeachers();
	
	List<User> listBusinessStudiesTeachers();
	
	List<User> listGeographyTeachers();
	
	List<User> listHistoryTeachers();

}
