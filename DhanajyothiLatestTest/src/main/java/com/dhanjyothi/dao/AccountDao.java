package com.dhanjyothi.dao;

import java.util.List;

import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;

public interface AccountDao {
	
	User getUserDetails(User user) throws Exception;
	
	Account getAccountDetails(int userId, String accountType) throws Exception;
	
	void openSavingsAccount(Account account,boolean isSavingsAccountExists) throws Exception;
	
	void openTermAccount(Account account) throws Exception;
	
	List<Account> getTermAccountDetails(int userId, String accountType) throws Exception;
	
	void saveBeneficiaries(Beneficiaries beneficiaries) throws Exception;
	
	Account checkAccountExists(int accountId) throws Exception;
	
	List<Beneficiaries> getAllBeneficiaries(int accountId) throws Exception;
	
	void updateTransactionDetails(Transaction transaction) throws Exception;
	
	List<Transaction> loadAllTransactions(int accountId) throws Exception;
	
	User isUserNameExists(String name) throws Exception;
	
	User getUserById(int userId) throws Exception;

}
