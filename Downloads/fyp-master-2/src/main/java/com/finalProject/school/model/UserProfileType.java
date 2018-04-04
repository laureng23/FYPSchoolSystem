package com.finalProject.school.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
    USER("STUDENT"),
    TEACHER("TEACHER"),
    ADMIN("ADMIN");
     
    String userProfileType;
     
    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
        return userProfileType;
    }
     
}