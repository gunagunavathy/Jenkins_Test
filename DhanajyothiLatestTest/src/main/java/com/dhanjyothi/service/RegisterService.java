package com.dhanjyothi.service;

import java.util.List;

import com.dhanjyothi.model.User;



public interface RegisterService {

	public void saveRegister(User user);
	public List<User> getAllUsers();
}
