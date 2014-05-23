package com.gogetters.dao;

import com.gogetters.bean.UserBean;


public interface UserDAO {

	public int registerUser(UserBean UserBean);

	public UserBean signInUser(UserBean userBeanObj);
	
}
