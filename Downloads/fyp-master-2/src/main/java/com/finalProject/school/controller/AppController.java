package com.finalProject.school.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.finalProject.school.model.ClassGroup;
import com.finalProject.school.model.User;
import com.finalProject.school.model.UserProfile;
import com.finalProject.school.service.UserProfileService;
import com.finalProject.school.service.UserService;
import com.finalProject.school.service.student.StudentService;
import com.finalProject.school.service.ClassGroupService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;

	@Autowired
	UserService userService;
	
	@Autowired
	StudentService studentService;

	@Autowired
	UserProfileService userProfileService;

	@Autowired
	ClassGroupService classGroupService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		model.addAttribute("loggedinuser", getPrincipal());
		return "userlist";
	}

	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model/*
										 * , @RequestParam("ssoId") String username,
										 * 
										 * @RequestParam("password") String password, @RequestParam("email") String
										 * emailAddress
										 */) {

		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());

		/*
		 * String status = null;
		 * 
		 * try { MimeMessage message = mailSender.createMimeMessage(); MimeMessageHelper
		 * helper = new MimeMessageHelper(message,true,"UTF-8");
		 * helper.setFrom("Administrator"); helper.setTo(emailAddress);
		 * helper.setSubject("Registration confirmation");
		 * 
		 * Map<String, Object> params = new HashMap<String, Object>();
		 * params.put("ssoId", username); params.put("password", password);
		 * 
		 * String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
		 * "emailRegistration.vm", "UTF-8", params);
		 * 
		 * helper.setText(text, true); mailSender.send(message); status =
		 * "Confirmation email is sent to your address (" + emailAddress + ")"; } catch
		 * (MessagingException e) { status =
		 * "There was an error in email sending. Please check your email address: " +
		 * emailAddress; }
		 * 
		 * model.addAttribute("message", status);
		 */

		return "registration";
	}

	// List all class groups
	@RequestMapping(value = { "/classList" }, method = RequestMethod.GET)
	public String listClassGroup(ModelMap model2) {

		List<ClassGroup> classGroups = classGroupService.findAllClassGroups();
		model2.addAttribute("classGroups", classGroups);
		model2.addAttribute("loggedinuser", getPrincipal());
		return "classGroupList";
	}

	// provide medium to add new class group
	@RequestMapping(value = { "/newClassGroup" }, method = RequestMethod.GET)
	public String newClassGroup(ModelMap model2) {
		ClassGroup classGroup = new ClassGroup();
		model2.addAttribute("classGroup", classGroup);
		model2.addAttribute("edit", false);
		// model2.addAttribute("loggedinuser", getPrincipal());
		return "regNewClassGroup";
	}

	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		if (!userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
			FieldError ssoError = new FieldError("user", "ssoId", messageSource.getMessage("non.unique.ssoId",
					new String[] { user.getSsoId() }, Locale.getDefault()));
			result.addError(ssoError);
			return "registration";
		}

		userService.saveUser(user);

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		
		return "registrationsuccess";
	}

	@RequestMapping(value = { "/newClassGroup" }, method = RequestMethod.POST)
	public String saveClassGroup(@Valid ClassGroup classGroup, BindingResult result, ModelMap model2) {

		if (result.hasErrors()) {
			return "regNewClassGroup";
		}

		if (!classGroupService.isClassGroupCodeUnique(classGroup.getId(), classGroup.getCode())) {
			FieldError codeError = new FieldError("classGroup", "code", messageSource.getMessage("non.unique.code",
					new String[] { classGroup.getCode() }, Locale.getDefault()));
			result.addError(codeError);
			return "regNewClassGroup";
		}

		classGroupService.saveClassGroup(classGroup);

		model2.addAttribute("success",
				"ClassGroup " + classGroup.getCode() + ", " + classGroup.getTitle() + " registered successfully");
		model2.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}

	// medium to update class group
	@RequestMapping(value = { "/edit-classGroup-{code}" }, method = RequestMethod.GET)
	public String editClassGroup(@PathVariable String code, ModelMap model2) {

		model2.addAttribute("students", studentService.listAllStudents());
		ClassGroup classGroup = classGroupService.findByGroupCode(code);
		model2.addAttribute("classGroup", classGroup);
		model2.addAttribute("edit", true);
		model2.addAttribute("loggedinuser", getPrincipal());
		return "addStudentClassGroup";
	}

	@RequestMapping(value = { "/edit-classGroup-{code}" }, method = RequestMethod.POST)
	public String updateClassGroup(@Valid ClassGroup classGroup, User user, BindingResult result, ModelMap model2,
			@PathVariable String code) {

		if (result.hasErrors()) {
			return "addStudentClassGroup";
		}

		
		List<User> users = userService.findAllUsers();

		classGroupService.updateClassGroup(classGroup);
		
		//userService.saveUser(user);
		//model2.addAttribute("users", users);

		model2.addAttribute("success",
				"ClassGroup " + classGroup.getCode() + ", " + classGroup.getTitle() + " updated successfully");
		model2.addAttribute("loggedinuser", getPrincipal());
		userService.updateUser(user);
		return "registrationsuccess";
	}

	// delete class group by code
	@RequestMapping(value = { "/delete-classGroup-{code}" }, method = RequestMethod.GET)
	public String deleteClassGroup(@PathVariable String code) {
		classGroupService.deleteClassGroupByGroupCode(code);
		return "redirect:/classGroupList";
	}

	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		return "registration";
	}

	@RequestMapping(value = { "/edit-user-{ssoId}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String ssoId) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * //Uncomment below to allow updating Id
		 * if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){ FieldError
		 * ssoError =new
		 * FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new
		 * String[]{user.getSsoId()}, Locale.getDefault())); result.addError(ssoError);
		 * return "registration"; }
		 */

		userService.updateUser(user);

		model.addAttribute("success",
				"User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}

	@RequestMapping(value = { "/delete-user-{ssoId}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}

	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("loggedinuser", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		if (isCurrentAuthenticationAnonymous()) {
			return "login";
		} else {
			return "redirect:/list";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			// new SecurityContextLogoutHandler().logout(request, response, auth);
			persistentTokenBasedRememberMeServices.logout(request, response, auth);
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		return "redirect:/login?logout";
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	private boolean isCurrentAuthenticationAnonymous() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authenticationTrustResolver.isAnonymous(authentication);
	}

	/*
	 * @Autowired public void setMailSender(JavaMailSender mailSender) {
	 * this.mailSender = mailSender; }
	 * 
	 * @Autowired public void setVelocityEngine(VelocityEngine velocityEngine) {
	 * this.velocityEngine = velocityEngine; }
	 * 
	 */

}