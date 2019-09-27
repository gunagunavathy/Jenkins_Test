package com.dhanjyothi.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dhanjyothi.model.User;
import com.dhanjyothi.service.LoginService;
import com.dhanjyothi.service.RegisterService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class LoginServiceTest {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private RegisterService registerService;

	
	private User user;
	
	@Before
	public void setup() {
		System.out.println(" Before method..");
		user = new User();
	}
	
	@Test
	public void testValidateCustomer(){
		user.setFirstName("laxman");
		user.setLastName("rao");
		user.setAddressLine1("chn");
		user.setAddressLine2("sez");
		user.setAadharId("123412341234");
		user.setCity("chnn");
		user.setDob("10/06/1991");
		user.setEmailId("laxman@gmail.com");
		user.setMobileNumber("9999999999");
		user.setPan("ASDFG1234J");
		user.setPin("600042");
		user.setState("tamilnadu");
		user.setUserName("praveen");
		user.setPassword("qwerqwer$");
		registerService.saveRegister(user);
		int result=loginService.validateUser(user);
		Assert.assertEquals(1, result);
		
	}
	
	@After
	public void teardown() {
		System.out.println(" After method..");
		user=null;
	}
}
