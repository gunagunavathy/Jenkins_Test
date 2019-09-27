package com.dhanjyothi.dao.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.dhanjyothi.dao.RegisterDao;
import com.dhanjyothi.model.User;

@Repository("RegisterDao")
public class RegisterDaoImpl implements RegisterDao{
	
	@Autowired
	//@Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	
	public void saveRegister(User customer) {
		customer.setPassword(Base64.getEncoder().encodeToString(customer.getPassword().getBytes()));
		hibernateTemplate.save(customer);
	}

	public List<User> getAllUsers() {
		return hibernateTemplate.loadAll(User.class);
	}

	/*@Autowired
	@Qualifier("mySessionFactory")
	private SessionFactory sessionFactory;
	
	public void saveRegister(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}*/

}
