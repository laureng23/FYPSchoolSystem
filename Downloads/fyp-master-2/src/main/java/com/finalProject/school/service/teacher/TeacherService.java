package com.finalProject.school.service.teacher;

import java.util.List;
import com.finalProject.school.model.User;

public interface TeacherService {
	
	List<User> listAllTeachers();
	
	List<User> listMathsTeachers();
	
	List<User> listEnglishTeachers();
	

	List<User> listIrishTeachers();
	
	List<User> listFrenchTeachers();
	
	List<User> listSpanishTeachers();
	
	List<User> listGermanTeachers();
	
	List<User> listBusinessStudiesTeachers();
	
	List<User> listGeographyTeachers();
	
	List<User> listHisotryTeachers();


}
