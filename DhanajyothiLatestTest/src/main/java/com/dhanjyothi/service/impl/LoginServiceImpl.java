package com.dhanjyothi.service.impl;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanjyothi.dao.impl.LoginDaoImpl;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.LoginService;

@Service("LoginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDaoImpl loginDaoImpl;

	public int validateUser(User user) {
		System.out.println("Inside Validate user ");
		user.setPassword(Base64.getEncoder().encodeToString(
				user.getPassword().getBytes()));
		return loginDaoImpl.validateUser(user);
	}

}
