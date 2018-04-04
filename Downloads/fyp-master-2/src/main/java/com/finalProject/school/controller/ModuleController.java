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


import com.finalProject.school.model.Module;
import com.finalProject.school.model.User;
import com.finalProject.school.service.ModuleService;
import com.finalProject.school.service.UserService;
import com.finalProject.school.service.student.StudentService;
import com.finalProject.school.service.teacher.TeacherService;


@Controller
@SessionAttributes("students")
public class ModuleController {
	
	@Autowired
	ModuleService moduleService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	UserService userService;
	
	
	@Autowired
	MessageSource messageSource;
	
	//List all Modules
	@RequestMapping(value = {"/moduleList"}, method = RequestMethod.GET)
	public String listModule(ModelMap model) {
		List<Module> modules = moduleService.findAllModules();
		model.addAttribute("modules", modules);
		
		return "moduleList";
	}
	
	// provide medium to add new module
		@RequestMapping(value = { "/newModule" }, method = RequestMethod.GET)
		public String newModule(ModelMap model) {
			Module module = new Module();
			model.addAttribute("module", module);
			model.addAttribute("edit", false);
			
			return "addNewModule";
		}
		
		@RequestMapping(value = { "/newModule" }, method = RequestMethod.POST)
		public String save(@Valid Module module, BindingResult result, ModelMap model) {

			if (result.hasErrors()) {
				return "addNewModule";
			}

			if (!moduleService.isModuleCodeUnique(module.getId(), module.getCode())) {
				FieldError codeError = new FieldError("module", "code", messageSource.getMessage("non.unique.code",
						new String[] { module.getCode() }, Locale.getDefault()));
				result.addError(codeError);
				return "addNewModule";
			}

			moduleService.save(module);

			model.addAttribute("success",
					"Module " + module.getCode() + ", " + module.getTitle() + " registered successfully");
			
			return "moduleList";
		}
		
		// medium to update module
		@RequestMapping(value = { "/edit-module-{code}" }, method = RequestMethod.GET)
		public String editModule(@PathVariable String code, ModelMap model) {

			model.addAttribute("students", studentService.listAllStudents());
			model.addAttribute("teachers", teacherService.listAllTeachers());
			Module module = moduleService.findByCode(code);
			model.addAttribute("module", module);
			model.addAttribute("edit", true);
			
			return "addStudentToModule";
		}

		@RequestMapping(value = { "/edit-module-{code}" }, method = RequestMethod.POST)
		public String updateModule(@Valid Module module, BindingResult result, ModelMap model,
				@PathVariable String code) {

			if (result.hasErrors()) {
				return "addStudentToModule";
			}

			
			//List<User> users = userService.findAllUsers();

			moduleService.update(module);
			
			
			
			model.addAttribute("success",
					"Module " + module.getCode() + ", " + module.getTitle() + " updated successfully");
			
			return "redirect:/moduleList";
		}

		// delete module by code
		@RequestMapping(value = { "/delete-module-{code}" }, method = RequestMethod.GET)
		public String deleteModule(@PathVariable String code) {
			moduleService.deleteByCode(code);
			return "redirect:/moduleList";
		}
		
	/*	@ModelAttribute("students")
		public List<User> initializeModules(){
			return studentService.listAllStudents();
		}*/

}
