package com.finalProject.school.controller;
import java.util.List;
import java.util.Locale;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.school.model.Subject;
import com.finalProject.school.model.User;
import com.finalProject.school.service.SubjectService;
import com.finalProject.school.service.teacher.TeacherService;

@Controller
@SessionAttributes("subject")
public class SubjectController {

	@Autowired
	SubjectService subjectService;

	@Autowired
	TeacherService teacherService;

	//List all subjects
	@RequestMapping(value= {"/subjectList"}, method = RequestMethod.GET)
	public String listSubject(ModelMap model) {
		List<Subject> subjects = subjectService.findAllSubjects();
		model.addAttribute("subjects", subjects);

		return "subjectList";
	}

	//medium to add new subject
	@RequestMapping(value = { "/newSubject" }, method = RequestMethod.GET)
	public String newSubject(ModelMap model) {
		Subject subject = new Subject();
		model.addAttribute("subject", subject);
		model.addAttribute("edit", false);

		return "addNewSubject";
	}

	@RequestMapping(value = { "/newSubject" }, method = RequestMethod.POST)
	public String save(@Valid Subject subject, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "addNewSubject";
		}

		if (!subjectService.isSubjectTitleUnique(subject.getId(), subject.getTitle())) {
			/*FieldError titleError = new FieldError("subject", "title", messageSource.getMessage("non.unique.code",
					new String[] { module.getCode() }, Locale.getDefault()));
			result.addError(codeError);*/
			return "addNewSubject";
		}

		subjectService.save(subject);

		model.addAttribute("success",
				"Subject " + subject.getTitle() + " registered successfully");

		return "subjectList";
	}

	// medium to update module
	@RequestMapping(value = { "/edit-subject-{title}" }, method = RequestMethod.GET)
	public String editSubject(@PathVariable String title, ModelMap model) {
		
		if(title.equals("Maths")) {
			model.addAttribute("teachers", teacherService.listMathsTeachers());
		}else if(title.equals("English")) {
			model.addAttribute("teachers", teacherService.listEnglishTeachers());
		}else if(title.equals("Irish")) {
			model.addAttribute("teachers", teacherService.listIrishTeachers());
		}else if(title.equals("French")) {
			model.addAttribute("teachers", teacherService.listFrenchTeachers());
		}else if(title.equals("Spanish")) {
			model.addAttribute("teachers", teacherService.listSpanishTeachers());
		}else if(title.equals("German")) {
			model.addAttribute("teachers", teacherService.listGermanTeachers());
		}else if(title.equals("Business Studies")) {
			model.addAttribute("teachers", teacherService.listBusinessStudiesTeachers());
		}else if(title.equals("Geography")) {
			model.addAttribute("teachers", teacherService.listGeographyTeachers());
		}else {
			model.addAttribute("teachers", teacherService.listAllTeachers());
		}
		
		
		
		//model.addAttribute("teachers", teacherService.listAllTeachers());
		Subject subject = subjectService.findByTitle(title);
		model.addAttribute("subject", subject);
		model.addAttribute("edit", true);

		return "addTeacherToSubject";
	}

	@RequestMapping(value = { "/edit-subject-{title}" }, method = RequestMethod.POST)
	public String updateSubject(@Valid Subject subject, BindingResult result, ModelMap model,
			@PathVariable String title) {

		if (result.hasErrors()) {
			return "addTeacherToSubject";
		}


		//List<User> users = userService.findAllUsers();

		subjectService.update(subject);



		model.addAttribute("success",
				"Subject " + subject.getTitle() + " updated successfully");

		return "redirect:/subjectList";
	}

	// delete module by code
	@RequestMapping(value = { "/delete-subject-{title}" }, method = RequestMethod.GET)
	public String deleteSubject(@PathVariable String title) {
		subjectService.deleteByTitle(title);
		return "redirect:/subjectList";
	}
	
	@ModelAttribute("subject")
	public List<Subject> initializeSubjectss(){
		return subjectService.findAllSubjects();
	}



}
