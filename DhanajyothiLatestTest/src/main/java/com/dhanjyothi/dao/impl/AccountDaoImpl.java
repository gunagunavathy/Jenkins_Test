package com.dhanjyothi.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhanjyothi.dao.AccountDao;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;

@Repository
public class AccountDaoImpl implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Account getAccountDetails(int userId, String accountType) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<Account> typedQuery = session
				.createQuery("from Account WHERE user.userId = :userId AND acc_type = :accType");
		typedQuery.setParameter("userId", userId);
		typedQuery.setParameter("accType", accountType);
		Account account = typedQuery.getSingleResult();

		session.close();
		return account;
	}

	public void openSavingsAccount(Account account, boolean isSavingsAccountExists) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		if (isSavingsAccountExists) {
			session.update(account);
		} else {
			session.save(account);
		}
		session.getTransaction().commit();
		session.close();

	}

	public void openTermAccount(Account account) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
		session.close();
	}

	public List<Account> getTermAccountDetails(int userId, String accountType) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<Account> typedQuery = session
				.createQuery("from Account WHERE user.userId = :userId AND acc_type = :accType");
		typedQuery.setParameter("userId", userId);
		typedQuery.setParameter("accType", accountType);
		List<Account> accounts = typedQuery.getResultList();
		session.close();
		return accounts;
	}

	public User getUserDetails(User user) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("username and password" + user.getUserName() + " " + user.getPassword());
		TypedQuery<User> typedQuery = session.createQuery("from User WHERE user_name = :userName AND password = :password");
		typedQuery.setParameter("userName", user.getUserName());
		typedQuery.setParameter("password", user.getPassword());
		User userResult = typedQuery.getSingleResult();
		session.close();
		return userResult ;
	}

	public void saveBeneficiaries(Beneficiaries beneficiaries) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(beneficiaries);
		session.getTransaction().commit();
		session.close();
	}

	public Account checkAccountExists(int accountId) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<Account> typedQuery = session.createQuery("from Account WHERE accountId = :accId");
		typedQuery.setParameter("accId", accountId);
		Account account = typedQuery.getSingleResult();
		session.close();
		return account;
	}

	public List<Beneficiaries> getAllBeneficiaries(int accountId) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<Beneficiaries> typedQuery = session.createQuery("from Beneficiaries WHERE account.accountId = :accId");
		typedQuery.setParameter("accId", accountId);
		List<Beneficiaries> beneficiaries = typedQuery.getResultList();
		session.close();
		return beneficiaries;
	}

	public void updateTransactionDetails(Transaction transaction) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(transaction);
		session.getTransaction().commit();
		session.close();

	}

	public List<Transaction> loadAllTransactions(int accountId) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<Transaction> typedQuery = session.createQuery("from Transaction WHERE account.accountId = :accId");
		System.out.println(":" + typedQuery.getFirstResult());
		typedQuery.setParameter("accId", accountId);
		List<Transaction> transactions = typedQuery.getResultList();
		System.out.println("List Transaction : " + transactions);
		session.close();
		return transactions;
	}

	public User isUserNameExists(String userName) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		TypedQuery<User> typedQuery = session.createQuery("from User WHERE userName = :name");
		typedQuery.setParameter("name", userName);
		User user = typedQuery.getSingleResult();
		System.out.println("User : " + user.getUserName());
		session.close();
		return user;
	}

	public User getUserById(int userId) throws Exception {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("Customer IdRev1" + userId);
		TypedQuery<User> typedQuery = session.createQuery("from User WHERE userId = :userID");
		typedQuery.setParameter("userID", userId);
		User user = typedQuery.getSingleResult();
		session.close();
		return user;
	}

}
