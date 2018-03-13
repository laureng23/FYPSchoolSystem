package com.finalProject.school.model.dao;

import java.util.ArrayList;
import java.util.Collection;

public enum UserProfileIds {

	USER(1), ADMIN(2), TEACHER(4);
	
	private Integer value;

	private UserProfileIds(Integer id) {
		this.value = id;
	}
	
	public Collection<Integer> toCollection() {
		ArrayList<Integer> ids =  new ArrayList<Integer>();
		ids.add(value);
		return ids;
	}
}
