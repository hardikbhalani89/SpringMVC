package com.gogetters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gogetters.bean.UserBean;
import com.gogetters.dao.UserDAO;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	
	@Override
	@Transactional
	public int registerUser(UserBean userBeanObj) {
		
		int ans = userDao.registerUser(userBeanObj);
		return ans;
	}

	@Override
	@Transactional
	public UserBean signInUser(UserBean userBeanObj) {
		// TODO Auto-generated method stub
		return userDao.signInUser(userBeanObj);
	}
	
}
