package com.dhanjyothi.service;

import java.util.ArrayList;
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
import com.dhanjyothi.service.RegisterService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class RegisterServiceTest {

	@Autowired
	private RegisterService registerService;

	private User user;

	@Before
	public void setup() {
		System.out.println(" Before method..");
		user = new User();
	}

	@Test
	public void test_saveRegister() {
		
		
		//System.out.println("Save metho..");
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
        user.setUserName("laxman123");
        user.setPassword("Asdfasdf@1");

        registerService.saveRegister(user);
        List<User> userList = registerService.getAllUsers();
        for (User userObj : userList) {
                       Assert.assertNotSame(user, userObj);
               
        }

		/*
		System.out.println("Save method..");
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
		user.setUserName("laxman123");
		user.setPassword("Asdfasdf@1");

		registerService.saveRegister(user);
		List<User> userList = registerService.getAllUsers();
		for (User userObj : userList) {
			//Assert.assertEquals(user.getUserId(), userObj.getUserId());
			Assert.assertEquals(user.getFirstName(), userObj.getFirstName());
			Assert.assertEquals(user.getLastName(), userObj.getLastName());
			Assert.assertEquals(user.getDob(), userObj.getDob());
			Assert.assertEquals(user.getAddressLine1(), userObj.getAddressLine1());
			Assert.assertEquals(user.getAddressLine2(), userObj.getAddressLine2());
			Assert.assertEquals(user.getAadharId(), userObj.getAadharId());
			Assert.assertEquals(user.getCity(), userObj.getCity());
			Assert.assertEquals(user.getState(), userObj.getState());
			Assert.assertEquals(user.getEmailId(), userObj.getEmailId());
			Assert.assertEquals(user.getMobileNumber(), userObj.getMobileNumber());
			Assert.assertEquals(user.getPan(), userObj.getPan());
			Assert.assertEquals(user.getPin(), userObj.getPin());
			Assert.assertEquals(user.getUserName(), userObj.getUserName());
			Assert.assertEquals(user.getPassword(), userObj.getPassword());

		}
		//Assert.assertEquals(1, userList.size()); */

	}

	@Test
	public void test_GetAllUsers() {

		System.out.println("GetAll method..");

		user.setFirstName("doredla");
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
		user.setUserName("laxman123");
		user.setPassword("Asdfasdf@1");
		registerService.saveRegister(user);

		user.setFirstName("lucky");
		user.setLastName("dore");
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
		user.setUserName("laxman1234");
		user.setPassword("Asdfasdf@1");
		registerService.saveRegister(user);

		List<User> userList = registerService.getAllUsers();
		Assert.assertNotNull(userList);
		Assert.assertTrue(userList.size() > 0);

	}

	@After
	public void teardown() {
		System.out.println(" After method..");
		user = null;
	}

}
