package com.dhanjyothi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhanjyothi.dao.impl.RegisterDaoImpl;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.RegisterService;

@Service("RegisterService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterDaoImpl registerDaoImpl;

	@Transactional
	public void saveRegister(User customer) {
		registerDaoImpl.saveRegister(customer);
	}

	public List<User> getAllUsers() {
		return registerDaoImpl.getAllUsers();
	}

}
