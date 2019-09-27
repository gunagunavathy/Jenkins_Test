package com.dhanjyothi.service;

import java.util.List;
import java.util.Map;

import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;

public interface AccountService {

	User getUserDetails(User user) throws Exception;

	Account getAccountDetails(int userId, String accountType) throws Exception;

	void openSavingsAccount(User user) throws Exception;

	void openTermAccount(Account account, User user) throws Exception;

	List<Account> getTermAccountDetails(int userId, String accountType)
			throws Exception;

	Map<Integer, String> getTenureDetails();

	boolean checkSavingsAccBalance(long termAmt) throws Exception;

	void updateSavingsAccount(Account account, User user) throws Exception;
	
	void saveBeneficiaries(Account account,Beneficiaries beneficiaries) throws Exception;
	
	boolean checkAccountExists(Beneficiaries beneficiaries) throws Exception;
	
	List<Beneficiaries> getAllBeneficiaries(int accountId) throws Exception;
	
	void updateFromAccount(Account account,long transAmt,Transaction transaction) throws Exception;
	
	void updateToAccount(Transaction transaction) throws Exception;
	
	List<Transaction> loadAllTransactions(int accId) throws Exception;
	
	boolean isUserNameExists(String name) throws Exception;
	
	Account checkAccountExists(int accountId) throws Exception;
	
	User getUserById(int userId) throws Exception;
	
	
}
