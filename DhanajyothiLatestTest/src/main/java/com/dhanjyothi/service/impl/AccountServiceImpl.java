package com.dhanjyothi.service.impl;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanjyothi.dao.AccountDao;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.User;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.util.DhanJyothiUtil;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private DhanJyothiUtil djUtil;

	public Account getAccountDetails(int userId, String accountType) throws Exception {
		return accountDao.getAccountDetails(userId, accountType);
	}

	public void openSavingsAccount(User user) throws Exception {
		Account acc = new Account();
		acc.setAccountType("SAVINGS");
		acc.setAccountBalance(10000);
		acc.setAccountCreatedDate(djUtil.getCurrentDate());
		acc.setUser(user);
		accountDao.openSavingsAccount(acc, false);
	}

	public void openTermAccount(Account account, User user) throws Exception {
		account.setAccountType("TERM");
		account.setUser(user);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		// account.setMatureDate(djUtil.getTermMaturityDate(account.getDeposit_tenure()
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		Transaction transaction = new Transaction();
		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getMaturityAmount());
		accountDao.openTermAccount(account);
	}

	public List<Account> getTermAccountDetails(int userId, String accountType) throws Exception {
		return accountDao.getTermAccountDetails(userId, accountType);
	}

	public Map<Integer, String> getTenureDetails() {
		return djUtil.getTenureDetails();
	}

	public boolean checkSavingsAccBalance(long termAmt) throws Exception {
		HttpSession ses = request.getSession();
		User cust = (User) ses.getAttribute("cust");
		if (cust != null) {
			Account savingsAcc = accountDao.getAccountDetails(cust.getUserId(), "SAVINGS");
			if (savingsAcc != null) {
				if (savingsAcc.getAccountBalance() >= termAmt) {
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void updateSavingsAccount(Account account, User cust) throws Exception {
		long savingsAccBalance = 0;
		account.setAccountType("SAVINGS");
		account.setUser(cust);
		account.setAccountUpdatedDate(djUtil.getCurrentDate());
		Account savingsAcc = accountDao.getAccountDetails(cust.getUserId(), "SAVINGS");
		if (savingsAcc != null) {
			savingsAccBalance = djUtil.getAccountBalance(savingsAcc.getAccountBalance(), account.getMaturityAmount());
			account.setAccountBalance(savingsAccBalance);
			account.setAccountId(savingsAcc.getAccountId());
			account.setAccountCreatedDate(savingsAcc.getAccountCreatedDate());
			accountDao.openSavingsAccount(account, true);
			Transaction trans = new Transaction();
			trans.setTransactionType("Debit");
			trans.setTransactionDate(djUtil.getCurrentDate());
			trans.setTransactionDescription("Self Transfer Term Account Creation");
			trans.setTransactionAmount(account.getMaturityAmount());
			trans.setAccount(account);
			accountDao.updateTransactionDetails(trans);
		} else {
			throw new Exception();
		}

	}

	public User getUserDetails(User user) throws Exception {
		return accountDao.getUserDetails(user);
	}

	public void saveBeneficiaries(Account account, Beneficiaries beneficiaries) throws Exception {
		beneficiaries.setAccount(account);
		accountDao.saveBeneficiaries(beneficiaries);
	}

	public boolean checkAccountExists(Beneficiaries beneficiaries) throws Exception {
		Account account;
		System.out.println("Payee Acc Num:" + beneficiaries.getBeneficiaryAccountNumber());
		if (beneficiaries.getBeneficiaryAccountNumber() != 0) {
			account = accountDao.checkAccountExists(beneficiaries.getBeneficiaryAccountNumber());
			System.out.println("Account" + account);
		} else {
			return false;
		}
		if (account.getAccountId() != 0 && account.getAccountType().equalsIgnoreCase("Savings")) {
			System.out.println("Entered inti second block of code");
			return true;
		} else {
			return false;
		}
	}

	public List<Beneficiaries> getAllBeneficiaries(int accountId) throws Exception {
		return accountDao.getAllBeneficiaries(accountId);
	}

	public void updateFromAccount(Account account, long transAmt, Transaction transaction) throws Exception {
		long savingsAccBalance = 0;
		System.out.println("Entered into fromaccount");
		savingsAccBalance = djUtil.getAccountBalance(account.getAccountBalance(), transAmt);
		account.setAccountBalance(savingsAccBalance);
		account.setAccountUpdatedDate(djUtil.getCurrentDate());
		accountDao.openSavingsAccount(account, true);
		Beneficiaries beneficiaries = transaction.getBenificiary();
		System.out.println("Beneficiary Type" + beneficiaries.getBeneficiaryType());
		transaction.setTransactionType("Debit");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setAccount(account);
		accountDao.updateTransactionDetails(transaction);

	}

	public void updateToAccount(Transaction transaction) throws Exception {
		System.out.println(
				"trans.getBenificiary().getPayeeAccNum()===" + transaction.getBenificiary().getBeneficiaryAccountNumber());
		Account acc = accountDao.getAccountDetails(transaction.getBenificiary().getUser().getUserId(), "SAVINGS");
		System.out.println("Payee acc ==" + acc.getAccountId());
		long savingsAccBalance = 0;
		savingsAccBalance = djUtil.addAccountBalance(acc.getAccountBalance(), transaction.getTransactionAmount());
		System.out.println("Balance Update" + acc.getAccountBalance() + " " + transaction.getTransactionAmount() + " "
				+ savingsAccBalance);
		acc.setAccountBalance(savingsAccBalance);
		acc.setAccountUpdatedDate(djUtil.getCurrentDate());
		accountDao.openSavingsAccount(acc, true);
		Beneficiaries beneficiaries = transaction.getBenificiary();
		System.out.println("Beneficiary Type" + beneficiaries.getBeneficiaryType());
		transaction.setTransactionType("Credit");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setAccount(acc);
		accountDao.updateTransactionDetails(transaction);
	}

	public List<Transaction> loadAllTransactions(int accId) throws Exception {
		return accountDao.loadAllTransactions(accId);
	}

	public boolean isUserNameExists(String name) throws Exception {
		User cust = accountDao.isUserNameExists(name);
		if (null == cust) {
			return false;
		} else {
			return true;
		}
	}

	public Account checkAccountExists(int accountId) throws Exception {
		return accountDao.checkAccountExists(accountId);

	}

	public User getUserById(int userId) throws Exception {
		return accountDao.getUserById(userId);
	}
}
