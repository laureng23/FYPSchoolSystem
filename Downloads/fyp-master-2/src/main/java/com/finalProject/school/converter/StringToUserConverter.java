package com.finalProject.school.converter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.finalProject.school.model.User;
import com.finalProject.school.service.UserService;

@Component
public class StringToUserConverter implements Converter<String, User>{
	
	@Autowired
	private UserService userService;

	@Override
	public User convert(String text) {
		List<User> users = userService.findAllUsers();
		for(User user : users) {
			if(user.getId().toString().equalsIgnoreCase(text)) {
				return user;
			}
		}
		return null;
	}

}
