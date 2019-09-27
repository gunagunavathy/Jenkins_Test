package com.dhanjyothi.dao.impl;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.dhanjyothi.dao.LoginDao;
import com.dhanjyothi.model.User;

@Repository("LoginDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	// @Qualifier("hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@SuppressWarnings("unused")
	public int validateUser(User user) {
		int valid = 0;
		System.out.println("Inside Validate Customer Dao");
		System.out.println(user.getUserName() + "-" + user.getPassword());
		// List<Customer> list=(List<Customer>) hibernateTemplate.find("from
		// Customer where username=? and password=?",
		// customer.getUsername(),customer.getPassword());
		List<User> list = hibernateTemplate.loadAll(User.class);
		System.out.println("List Size" + list.size());

		for (User c : list) {
			System.out.println(user.getUserName() + "-" + user.getPassword());
			System.out.println(c.getUserName() + "-" + c.getPassword());

			Base64.Decoder decoder = Base64.getDecoder();
			byte[] decodedByteArray = decoder.decode(user.getPassword());
			// Verify the decoded string
			System.out.println("New Password" + new String(decodedByteArray));
			if (user.getUserName().equals(c.getUserName())
					&& new String(decodedByteArray).equals(c.getPassword())) {

				if (user.getUserName().equals("admin123") && new String(decodedByteArray).equals("Admin123$")) {
					System.out.println("Validate Data");
					valid = 0;
					return valid;
				}
				

				else {
					valid = 1;
					return valid;
				}
			}
			
		}
		return valid;

		/*
		 * if (list!=null && list.size()>0) { return true; } else { return
		 * false; }
		 */
	}

	/*
	 * @Autowired
	 * 
	 * @Qualifier("mySessionFactory") private SessionFactory sessionFactory;
	 * 
	 * public boolean validateCustomer(Customer customer) {
	 * 
	 * List<Customer> list = (List<Customer>)
	 * sessionFactory.getCurrentSession().createQuery("from Customer"); if (list
	 * != null && list.size() > 0) { return true; } else { return false; } }
	 */

}
