package com.test.transerve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.test.transerve.service.UserService;

public class ServiceManager {
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
