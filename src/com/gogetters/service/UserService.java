package com.gogetters.service;

import org.springframework.stereotype.Service;

import com.gogetters.bean.UserBean;


public interface UserService {

	public int registerUser(UserBean userBeanObj);
	public UserBean signInUser(UserBean userBeanObj);
	
}
