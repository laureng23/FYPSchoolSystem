package com.assessment.bookStore.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	CUSTOMER("CUSTOMER"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
