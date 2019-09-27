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

import com.dhanjyothi.dao.AccountDao;
import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.service.RegisterService;
import com.dhanjyothi.util.DhanJyothiUtil;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestBeanConfig.class })
public class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private DhanJyothiUtil djUtil;

	private User user;
	private Account account;
	private Transaction transaction;
	private Beneficiaries beneficiaries;

	@Before
	public void setup() {
		System.out.println(" Before method..");
		user = new User();
		account = new Account();
		transaction = new Transaction();
		beneficiaries = new Beneficiaries();
	}

	@Test
	public void test_getAccountDetails() throws Exception {
		System.out.println("GetAccountDetails method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		Account accountObj = accountService.getAccountDetails(user.getUserId(), account.getAccountType());
		System.out.println("Account ::" + accountObj);

		Assert.assertEquals(123, accountObj.getAccountBalance());
		Assert.assertEquals(account.getAccountType(), accountObj.getAccountType());
		Assert.assertEquals(account.getAccountId(), accountObj.getAccountId());
		Assert.assertEquals(account.getAccountCreatedDate(), accountObj.getAccountCreatedDate());

		Assert.assertEquals(account.getUser().getUserId(), accountObj.getUser().getUserId());
		Assert.assertEquals(account.getUser().getFirstName(), accountObj.getUser().getFirstName());
		Assert.assertEquals(account.getUser().getLastName(), accountObj.getUser().getLastName());
		Assert.assertEquals(account.getUser().getDob(), accountObj.getUser().getDob());
		Assert.assertEquals(account.getUser().getEmailId(), accountObj.getUser().getEmailId());
		Assert.assertEquals(account.getUser().getAddressLine1(), accountObj.getUser().getAddressLine1());
		Assert.assertEquals(account.getUser().getAddressLine2(), accountObj.getUser().getAddressLine2());
		Assert.assertEquals(account.getUser().getCity(), accountObj.getUser().getCity());
		Assert.assertEquals(account.getUser().getState(), accountObj.getUser().getState());
		Assert.assertEquals(account.getUser().getAadharId(), accountObj.getUser().getAadharId());
		Assert.assertEquals(account.getUser().getMobileNumber(), accountObj.getUser().getMobileNumber());
		Assert.assertEquals(account.getUser().getPin(), accountObj.getUser().getPin());
		Assert.assertEquals(account.getUser().getPan(), accountObj.getUser().getPan());
		Assert.assertEquals(account.getUser().getUserName(), accountObj.getUser().getUserName());
		Assert.assertEquals(account.getUser().getPassword(), accountObj.getUser().getPassword());
		Assert.assertNotSame(account.getUser(), accountObj.getUser());
		Assert.assertTrue("success", true);

	}

	@Test
	public void test_openSavingsAccount() throws Exception {
		System.out.println("OpenSavingsAccount method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setUser(user);

		accountDao.openSavingsAccount(account, false);

		accountService.openSavingsAccount(user);
		Account accountObj = accountService.checkAccountExists(account.getAccountId());

		System.out.println("Account ::" + accountObj);

		Assert.assertEquals(account.getAccountBalance(), accountObj.getAccountBalance());
		Assert.assertEquals(account.getAccountType(), accountObj.getAccountType());
		Assert.assertEquals(account.getAccountId(), accountObj.getAccountId());
		Assert.assertEquals(account.getAccountCreatedDate(), accountObj.getAccountCreatedDate());

		Assert.assertEquals(account.getUser().getUserId(), accountObj.getUser().getUserId());
		Assert.assertEquals(account.getUser().getFirstName(), accountObj.getUser().getFirstName());
		Assert.assertEquals(account.getUser().getLastName(), accountObj.getUser().getLastName());
		Assert.assertEquals(account.getUser().getDob(), accountObj.getUser().getDob());
		Assert.assertEquals(account.getUser().getEmailId(), accountObj.getUser().getEmailId());
		Assert.assertEquals(account.getUser().getAddressLine1(), accountObj.getUser().getAddressLine1());
		Assert.assertEquals(account.getUser().getAddressLine2(), accountObj.getUser().getAddressLine2());
		Assert.assertEquals(account.getUser().getCity(), accountObj.getUser().getCity());
		Assert.assertEquals(account.getUser().getState(), accountObj.getUser().getState());
		Assert.assertEquals(account.getUser().getAadharId(), accountObj.getUser().getAadharId());
		Assert.assertEquals(account.getUser().getMobileNumber(), accountObj.getUser().getMobileNumber());
		Assert.assertEquals(account.getUser().getPin(), accountObj.getUser().getPin());
		Assert.assertEquals(account.getUser().getPan(), accountObj.getUser().getPan());
		Assert.assertEquals(account.getUser().getUserName(), accountObj.getUser().getUserName());
		Assert.assertEquals(account.getUser().getPassword(), accountObj.getUser().getPassword());
		Assert.assertNotSame(account.getUser(), accountObj.getUser());
		Assert.assertTrue("success", true);

	}

	@Test
	public void test_openTermAccount() throws Exception {
		System.out.println("OpenTermAccount method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(50000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getMaturityAmount());

		// accountDao.openTermAccount(account);
		accountService.openTermAccount(account, user);
		List<Account> accountList = accountService.getTermAccountDetails(user.getUserId(), account.getAccountType());

		for (Account accountObj : accountList) {
			System.out.println("Account ::" + accountObj);

			Assert.assertEquals(account.getDepositTenure(), accountObj.getDepositTenure());
			Assert.assertEquals(account.getMaturityAmount(), accountObj.getMaturityAmount());
			Assert.assertEquals(account.getAccountBalance(), accountObj.getAccountBalance());
			Assert.assertEquals(account.getAccountType(), accountObj.getAccountType());
			Assert.assertEquals(account.getAccountId(), accountObj.getAccountId());
			Assert.assertEquals(account.getAccountCreatedDate(), accountObj.getAccountCreatedDate());

			Assert.assertEquals(account.getUser().getUserId(), accountObj.getUser().getUserId());
			Assert.assertEquals(account.getUser().getFirstName(), accountObj.getUser().getFirstName());
			Assert.assertEquals(account.getUser().getLastName(), accountObj.getUser().getLastName());
			Assert.assertEquals(account.getUser().getDob(), accountObj.getUser().getDob());
			Assert.assertEquals(account.getUser().getEmailId(), accountObj.getUser().getEmailId());
			Assert.assertEquals(account.getUser().getAddressLine1(), accountObj.getUser().getAddressLine1());
			Assert.assertEquals(account.getUser().getAddressLine2(), accountObj.getUser().getAddressLine2());
			Assert.assertEquals(account.getUser().getCity(), accountObj.getUser().getCity());
			Assert.assertEquals(account.getUser().getState(), accountObj.getUser().getState());
			Assert.assertEquals(account.getUser().getAadharId(), accountObj.getUser().getAadharId());
			Assert.assertEquals(account.getUser().getMobileNumber(), accountObj.getUser().getMobileNumber());
			Assert.assertEquals(account.getUser().getPin(), accountObj.getUser().getPin());
			Assert.assertEquals(account.getUser().getPan(), accountObj.getUser().getPan());
			Assert.assertEquals(account.getUser().getUserName(), accountObj.getUser().getUserName());
			Assert.assertEquals(account.getUser().getPassword(), accountObj.getUser().getPassword());
			Assert.assertNotSame(account.getUser(), accountObj.getUser());
			Assert.assertTrue("success", true);
		}

		Assert.assertEquals(1, accountList.size());

	}

	@Test
	public void test_getTermAccountDetails() throws Exception {
		System.out.println("GetTermAccountDetails method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(50000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getMaturityAmount());

		// accountService.openTermAccount(account, user);

		List<Account> accountList = accountService.getTermAccountDetails(user.getUserId(), account.getAccountType());

		for (Account accountObj : accountList) {
			System.out.println("Account ::" + accountObj);

			Assert.assertEquals(account.getDepositTenure(), accountObj.getDepositTenure());
			Assert.assertEquals(account.getMaturityAmount(), accountObj.getMaturityAmount());
			Assert.assertEquals(account.getAccountBalance(), accountObj.getAccountBalance());
			Assert.assertEquals(account.getAccountType(), accountObj.getAccountType());
			Assert.assertEquals(account.getAccountId(), accountObj.getAccountId());
			Assert.assertEquals(account.getAccountCreatedDate(), accountObj.getAccountCreatedDate());

			Assert.assertEquals(account.getUser().getUserId(), accountObj.getUser().getUserId());
			Assert.assertEquals(account.getUser().getFirstName(), accountObj.getUser().getFirstName());
			Assert.assertEquals(account.getUser().getLastName(), accountObj.getUser().getLastName());
			Assert.assertEquals(account.getUser().getDob(), accountObj.getUser().getDob());
			Assert.assertEquals(account.getUser().getEmailId(), accountObj.getUser().getEmailId());
			Assert.assertEquals(account.getUser().getAddressLine1(), accountObj.getUser().getAddressLine1());
			Assert.assertEquals(account.getUser().getAddressLine2(), accountObj.getUser().getAddressLine2());
			Assert.assertEquals(account.getUser().getCity(), accountObj.getUser().getCity());
			Assert.assertEquals(account.getUser().getState(), accountObj.getUser().getState());
			Assert.assertEquals(account.getUser().getAadharId(), accountObj.getUser().getAadharId());
			Assert.assertEquals(account.getUser().getMobileNumber(), accountObj.getUser().getMobileNumber());
			Assert.assertEquals(account.getUser().getPin(), accountObj.getUser().getPin());
			Assert.assertEquals(account.getUser().getPan(), accountObj.getUser().getPan());
			Assert.assertEquals(account.getUser().getUserName(), accountObj.getUser().getUserName());
			Assert.assertEquals(account.getUser().getPassword(), accountObj.getUser().getPassword());
			Assert.assertNotSame(account.getUser(), accountObj.getUser());
			Assert.assertTrue("success", true);
		}
	}

	@Test
	public void test_checkSavingsAccBalance() throws Exception {
		System.out.println("CheckSavingsAccBalance method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);

		account.setMaturityAmount(500000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);

		// accountDao.openSavingsAccount(account, false);
		accountService.openTermAccount(account, user);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getMaturityAmount());
		transaction.setAccount(account);
		transaction.setTransactionDescription("debit");
		transaction.setBenificiary(beneficiaries);
		System.out.println("=" + transaction.getTransactionAmount());

		accountService.saveBeneficiaries(account, beneficiaries);

		// accountDao.openTermAccount(account);
		// accountService.openTermAccount(account, user);
		List<Beneficiaries> beneficiariesList = accountService.getAllBeneficiaries(account.getAccountId());
		System.out.println("Beneficiaries list :" + beneficiariesList);
		for (Beneficiaries beneficiariesObj : beneficiariesList) {
			System.out.println(beneficiariesObj.getAccount().getMaturityAmount());
			boolean flag = accountService.checkSavingsAccBalance(beneficiariesObj.getAccount().getMaturityAmount());
			System.out.println("Flag value :" + flag);
			Assert.assertFalse(flag);
		}
	}

	@Test
	public void test_updateSavingsAccount() throws Exception {
		System.out.println("UpdateSavingsAccount method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(50000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);

		accountService.openSavingsAccount(user);
		accountService.updateSavingsAccount(account, user);

		Account accountObj = accountService.getAccountDetails(user.getUserId(), account.getAccountType());
		System.out.println("Account ::" + accountObj);

		Assert.assertEquals(account.getAccountBalance(), accountObj.getAccountBalance());
		Assert.assertEquals(account.getAccountType(), accountObj.getAccountType());
		Assert.assertEquals(account.getAccountId(), accountObj.getAccountId());
		Assert.assertEquals(account.getAccountCreatedDate(), accountObj.getAccountCreatedDate());

		Assert.assertEquals(account.getUser().getUserId(), accountObj.getUser().getUserId());
		Assert.assertEquals(account.getUser().getFirstName(), accountObj.getUser().getFirstName());
		Assert.assertEquals(account.getUser().getLastName(), accountObj.getUser().getLastName());
		Assert.assertEquals(account.getUser().getDob(), accountObj.getUser().getDob());
		Assert.assertEquals(account.getUser().getEmailId(), accountObj.getUser().getEmailId());
		Assert.assertEquals(account.getUser().getAddressLine1(), accountObj.getUser().getAddressLine1());
		Assert.assertEquals(account.getUser().getAddressLine2(), accountObj.getUser().getAddressLine2());
		Assert.assertEquals(account.getUser().getCity(), accountObj.getUser().getCity());
		Assert.assertEquals(account.getUser().getState(), accountObj.getUser().getState());
		Assert.assertEquals(account.getUser().getAadharId(), accountObj.getUser().getAadharId());
		Assert.assertEquals(account.getUser().getMobileNumber(), accountObj.getUser().getMobileNumber());
		Assert.assertEquals(account.getUser().getPin(), accountObj.getUser().getPin());
		Assert.assertEquals(account.getUser().getPan(), accountObj.getUser().getPan());
		Assert.assertEquals(account.getUser().getUserName(), accountObj.getUser().getUserName());
		Assert.assertEquals(account.getUser().getPassword(), accountObj.getUser().getPassword());
		Assert.assertNotSame(account.getUser(), accountObj.getUser());
		Assert.assertTrue("success", true);

	}

	@Test
	public void testGetUserDetails() throws Exception {
		System.out.println("GetCustomerDetails method..");

		user.setFirstName("ram");
		user.setLastName("raju");
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
		user.setUserName("lucky1234");
		user.setPassword("qwerqwer@1");
		registerService.saveRegister(user);

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(500000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getMaturityAmount());
		transaction.setAccount(account);
		transaction.setBenificiary(beneficiaries);

		accountService.saveBeneficiaries(account, beneficiaries);
		List<Beneficiaries> beneficiariesList = accountService.getAllBeneficiaries(account.getAccountId());

		for (Beneficiaries beneficiariesObj : beneficiariesList) {
			User userObj = accountService.getUserDetails(beneficiariesObj.getUser());
			System.out.println("User :" + userObj);
			Assert.assertNotSame(user, userObj);
			Assert.assertEquals(user.getUserId(), userObj.getUserId());
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

	}

	@Test
	public void test_saveBeneficiaries() throws Exception {

		System.out.println("SaveBeneficiaries method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(50000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());
		// accountService.openTermAccount(account, user);

		accountService.saveBeneficiaries(account, beneficiaries);
		List<Beneficiaries> beneficiariesList = accountService.getAllBeneficiaries(account.getAccountId());

		for (Beneficiaries beneficiariesObj : beneficiariesList) {
			Assert.assertEquals(beneficiaries.getBeneficiaryId(), beneficiariesObj.getBeneficiaryId());
			Assert.assertEquals(beneficiaries.getBeneficiaryBank(), beneficiariesObj.getBeneficiaryBank());
			Assert.assertEquals(beneficiaries.getBeneficiaryBankIfsc(), beneficiariesObj.getBeneficiaryBankIfsc());
			Assert.assertEquals(beneficiaries.getBeneficiaryName(), beneficiariesObj.getBeneficiaryName());
			Assert.assertEquals(beneficiaries.getBeneficiaryNickName(), beneficiariesObj.getBeneficiaryNickName());
			Assert.assertEquals(beneficiaries.getBeneficiaryType(), beneficiariesObj.getBeneficiaryType());
			Assert.assertEquals(beneficiaries.getBeneficiaryAccountNumber(),
					beneficiariesObj.getBeneficiaryAccountNumber());
			System.out.println(
					"Account address not same :" + beneficiaries.getAccount() + ":" + beneficiariesObj.getAccount());
			Assert.assertNotSame(beneficiaries.getAccount(), beneficiariesObj.getAccount());
			Assert.assertEquals(beneficiaries.getAccount().getAccountId(),
					beneficiariesObj.getAccount().getAccountId());
			Assert.assertEquals(beneficiaries.getAccount().getAccountBalance(),
					beneficiariesObj.getAccount().getAccountBalance());
			Assert.assertEquals(beneficiaries.getAccount().getAccountType(),
					beneficiariesObj.getAccount().getAccountType());
			Assert.assertEquals(beneficiaries.getAccount().getMaturityAmount(),
					beneficiariesObj.getAccount().getMaturityAmount());
			Assert.assertEquals(beneficiaries.getAccount().getAccountCreatedDate(),
					beneficiariesObj.getAccount().getAccountCreatedDate());
			Assert.assertEquals(beneficiaries.getAccount().getAccountUpdatedDate(),
					beneficiariesObj.getAccount().getAccountUpdatedDate());
			Assert.assertEquals(beneficiaries.getAccount().getDepositTenure(),
					beneficiariesObj.getAccount().getDepositTenure());
			Assert.assertEquals(beneficiaries.getUserId(), beneficiariesObj.getUserId());
			System.out.println(
					"beneficiaries address not same :" + beneficiaries.getUser() + ":" + beneficiariesObj.getUser());
			Assert.assertNotSame(beneficiaries.getUser(), beneficiariesObj.getUser());
			Assert.assertEquals(beneficiaries.getUser().getUserId(), beneficiariesObj.getUser().getUserId());
			Assert.assertEquals(beneficiaries.getUser().getFirstName(), beneficiariesObj.getUser().getFirstName());
			Assert.assertEquals(beneficiaries.getUser().getLastName(), beneficiariesObj.getUser().getLastName());
			Assert.assertEquals(beneficiaries.getUser().getAddressLine1(),
					beneficiariesObj.getUser().getAddressLine1());
			Assert.assertEquals(beneficiaries.getUser().getAddressLine2(),
					beneficiariesObj.getUser().getAddressLine2());
			Assert.assertEquals(beneficiaries.getUser().getCity(), beneficiariesObj.getUser().getCity());
			Assert.assertEquals(beneficiaries.getUser().getState(), beneficiariesObj.getUser().getState());
			Assert.assertEquals(beneficiaries.getUser().getPin(), beneficiariesObj.getUser().getPin());
			Assert.assertEquals(beneficiaries.getUser().getPan(), beneficiariesObj.getUser().getPan());
			Assert.assertEquals(beneficiaries.getUser().getAadharId(), beneficiariesObj.getUser().getAadharId());
			Assert.assertEquals(beneficiaries.getUser().getEmailId(), beneficiariesObj.getUser().getEmailId());
			Assert.assertEquals(beneficiaries.getUser().getMobileNumber(),
					beneficiariesObj.getUser().getMobileNumber());
			Assert.assertEquals(beneficiaries.getUser().getUserName(), beneficiariesObj.getUser().getUserName());
			Assert.assertEquals(beneficiaries.getUser().getPassword(), beneficiariesObj.getUser().getPassword());
		}
		Assert.assertEquals(1, beneficiariesList.size());
	}

	@Test
	public void test_checkAccountExists() throws Exception {

		System.out.println("CheckAccountExists method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(500000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		// System.out.println(account.getAccountId()+":"+user.getUserId());
		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());
		// accountService.openTermAccount(account, user);
		accountService.saveBeneficiaries(account, beneficiaries);

		List<Beneficiaries> beneficiariesList = accountService.getAllBeneficiaries(account.getAccountId());
		System.out.println("Beneficiaries list :" + beneficiariesList);
		for (Beneficiaries beneficiariesObj : beneficiariesList) {
			boolean flag = accountService.checkAccountExists(beneficiariesObj);
			System.out.println("Flag value :" + flag);
			Assert.assertTrue(flag);
		}

	}

	@Test
	public void test_getAllBeneficiaries() throws Exception {
		System.out.println("GetAllBeneficiaries method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(500000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());
		accountService.saveBeneficiaries(account, beneficiaries);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("Jyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("bharath ram");
		beneficiaries.setBeneficiaryNickName("bharath");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());

		accountService.saveBeneficiaries(account, beneficiaries);

		List<Beneficiaries> beneficiariesList = accountService.getAllBeneficiaries(account.getAccountId());
		Assert.assertNotNull(beneficiariesList);
		Assert.assertTrue(beneficiariesList.size() > 0);
	}

	@Test
	public void test_updateFromAccount() throws Exception {
		System.out.println("UpdateFromAccount method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(500000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getMaturityAmount());
		transaction.setAccount(account);
		transaction.setBenificiary(beneficiaries);

		accountService.saveBeneficiaries(account, beneficiaries);
		accountService.updateFromAccount(account, transaction.getTransactionAmount(), transaction);
		Account accountObj = accountService.checkAccountExists(account.getAccountId());
		System.out.println("Account ::" + accountObj);
		Assert.assertEquals(account.getAccountBalance(), accountObj.getAccountBalance());
		Assert.assertEquals(account.getAccountType(), accountObj.getAccountType());
		Assert.assertEquals(account.getAccountId(), accountObj.getAccountId());
		Assert.assertEquals(account.getAccountCreatedDate(), accountObj.getAccountCreatedDate());
		Assert.assertEquals(account.getUser().getUserId(), accountObj.getUser().getUserId());
		Assert.assertEquals(account.getUser().getFirstName(), accountObj.getUser().getFirstName());
		Assert.assertEquals(account.getUser().getLastName(), accountObj.getUser().getLastName());
		Assert.assertEquals(account.getUser().getDob(), accountObj.getUser().getDob());
		Assert.assertEquals(account.getUser().getEmailId(), accountObj.getUser().getEmailId());
		Assert.assertEquals(account.getUser().getAddressLine1(), accountObj.getUser().getAddressLine1());
		Assert.assertEquals(account.getUser().getAddressLine2(), accountObj.getUser().getAddressLine2());
		Assert.assertEquals(account.getUser().getCity(), accountObj.getUser().getCity());
		Assert.assertEquals(account.getUser().getState(), accountObj.getUser().getState());
		Assert.assertEquals(account.getUser().getAadharId(), accountObj.getUser().getAadharId());
		Assert.assertEquals(account.getUser().getMobileNumber(), accountObj.getUser().getMobileNumber());
		Assert.assertEquals(account.getUser().getPin(), accountObj.getUser().getPin());
		Assert.assertEquals(account.getUser().getPan(), accountObj.getUser().getPan());
		Assert.assertEquals(account.getUser().getUserName(), accountObj.getUser().getUserName());
		Assert.assertEquals(account.getUser().getPassword(), accountObj.getUser().getPassword());
		System.out.println("Object address not same :" + account + "=" + accountObj);
		Assert.assertNotSame(account.getUser(), accountObj.getUser());
		Assert.assertTrue("success", true);

	}

	@Test
	public void test_updateToAccount() throws Exception {
		System.out.println("UpdateToAccount method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(500000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getMaturityAmount());
		transaction.setAccount(account);
		transaction.setBenificiary(beneficiaries);

		accountService.saveBeneficiaries(account, beneficiaries);
		accountService.updateToAccount(transaction);
		Account accountObj = accountService.checkAccountExists(account.getAccountId());
		System.out.println("Account ::" + accountObj);
		// Assert.assertEquals(account.getAccountBalance(),
		// acc.getAccountBalance());
		Assert.assertEquals(account.getAccountType(), accountObj.getAccountType());
		Assert.assertEquals(account.getAccountId(), accountObj.getAccountId());
		Assert.assertEquals(account.getAccountCreatedDate(), accountObj.getAccountCreatedDate());
		Assert.assertEquals(account.getUser().getUserId(), accountObj.getUser().getUserId());
		Assert.assertEquals(account.getUser().getFirstName(), accountObj.getUser().getFirstName());
		Assert.assertEquals(account.getUser().getLastName(), accountObj.getUser().getLastName());
		Assert.assertEquals(account.getUser().getDob(), accountObj.getUser().getDob());
		Assert.assertEquals(account.getUser().getEmailId(), accountObj.getUser().getEmailId());
		Assert.assertEquals(account.getUser().getAddressLine1(), accountObj.getUser().getAddressLine1());
		Assert.assertEquals(account.getUser().getAddressLine2(), accountObj.getUser().getAddressLine2());
		Assert.assertEquals(account.getUser().getCity(), accountObj.getUser().getCity());
		Assert.assertEquals(account.getUser().getState(), accountObj.getUser().getState());
		Assert.assertEquals(account.getUser().getAadharId(), accountObj.getUser().getAadharId());
		Assert.assertEquals(account.getUser().getMobileNumber(), accountObj.getUser().getMobileNumber());
		Assert.assertEquals(account.getUser().getPin(), accountObj.getUser().getPin());
		Assert.assertEquals(account.getUser().getPan(), accountObj.getUser().getPan());
		Assert.assertEquals(account.getUser().getUserName(), accountObj.getUser().getUserName());
		Assert.assertEquals(account.getUser().getPassword(), accountObj.getUser().getPassword());
		System.out.println("Object address not same :" + account + "=" + accountObj);
		Assert.assertNotSame(account.getUser(), accountObj.getUser());
		Assert.assertTrue("success", true);

	}

	@Test
	public void test_loadAllTransactions() throws Exception {
		System.out.println("LoadAllTransactions method..");

		user.setFirstName("pawan");
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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(200000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getAccountBalance());
		transaction.setAccount(account);
		transaction.setBenificiary(beneficiaries);

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getAccountBalance());
		transaction.setAccount(account);
		transaction.setBenificiary(beneficiaries);

		accountService.saveBeneficiaries(account, beneficiaries);

		System.out.println("Ben :" + beneficiaries);
		Account accountObj = accountService.getAccountDetails(user.getUserId(), account.getAccountType());
		System.out.println("User id :" + user.getUserId());
		System.out.println("Account id testing :" + accountObj.getAccountId());
		List<Transaction> transactionList = accountService.loadAllTransactions(accountObj.getAccountId());
		System.out.println("TransactionList testing :" + transactionList.size());

	}

	@Test
	public void test_isUserNameExists() throws Exception {
		System.out.println("IsUserNameExists method..");

		user.setFirstName("jason");
		user.setLastName("denial");
		user.setAddressLine1("chn");
		user.setAddressLine2("sez");
		user.setAadharId("123412341234");
		user.setCity("chnn");
		user.setDob("10/06/1991");
		user.setEmailId("jason@gmail.com");
		user.setMobileNumber("9999999999");
		user.setPan("ASDFG1234J");
		user.setPin("600042");
		user.setState("tamilnadu");
		user.setUserName("jason");
		user.setPassword("trytry@1");
		registerService.saveRegister(user);

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(3);
		account.setMaturityAmount(600000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("jason");
		beneficiaries.setBeneficiaryNickName("denial");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());

		transaction.setTransactionType("Debit");
		transaction.setTransactionDescription("Amount Debited for Term Account");
		transaction.setTransactionDate(djUtil.getCurrentDate());
		transaction.setTransactionAmount(account.getMaturityAmount());
		transaction.setAccount(account);
		transaction.setBenificiary(beneficiaries);

		accountService.saveBeneficiaries(account, beneficiaries);
		List<Beneficiaries> beneficiariesList = accountService.getAllBeneficiaries(account.getAccountId());

		for (Beneficiaries beneficiariesObj : beneficiariesList) {
			boolean flag = accountService.isUserNameExists(beneficiariesObj.getUser().getUserName());
			Assert.assertTrue(flag);

		}

	}

	@Test
	public void test_checkAccountExist() throws Exception {
		System.out.println("CheckAccountExist method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(500000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());

		accountService.saveBeneficiaries(account, beneficiaries);

		List<Beneficiaries> beneficiariesList = accountService.getAllBeneficiaries(account.getAccountId());
		System.out.println("Beneficiaries list :" + beneficiariesList);
		for (Beneficiaries beneficiariesObj : beneficiariesList) {
			System.out.println("Beneficiarie :" + beneficiariesObj);
			Account accountObj = accountService.checkAccountExists(beneficiariesObj.getAccount().getAccountId());
			System.out.println("Account :" + accountObj);
			Assert.assertEquals(account.getDepositTenure(), accountObj.getDepositTenure());
			Assert.assertEquals(account.getMaturityAmount(), accountObj.getMaturityAmount());
			Assert.assertEquals(account.getAccountBalance(), accountObj.getAccountBalance());
			Assert.assertEquals(account.getAccountType(), accountObj.getAccountType());
			Assert.assertEquals(account.getAccountId(), accountObj.getAccountId());
			Assert.assertEquals(account.getAccountCreatedDate(), accountObj.getAccountCreatedDate());

			Assert.assertEquals(account.getUser().getUserId(), accountObj.getUser().getUserId());
			Assert.assertEquals(account.getUser().getFirstName(), accountObj.getUser().getFirstName());
			Assert.assertEquals(account.getUser().getLastName(), accountObj.getUser().getLastName());
			Assert.assertEquals(account.getUser().getDob(), accountObj.getUser().getDob());
			Assert.assertEquals(account.getUser().getEmailId(), accountObj.getUser().getEmailId());
			Assert.assertEquals(account.getUser().getAddressLine1(), accountObj.getUser().getAddressLine1());
			Assert.assertEquals(account.getUser().getAddressLine2(), accountObj.getUser().getAddressLine2());
			Assert.assertEquals(account.getUser().getCity(), accountObj.getUser().getCity());
			Assert.assertEquals(account.getUser().getState(), accountObj.getUser().getState());
			Assert.assertEquals(account.getUser().getAadharId(), accountObj.getUser().getAadharId());
			Assert.assertEquals(account.getUser().getMobileNumber(), accountObj.getUser().getMobileNumber());
			Assert.assertEquals(account.getUser().getPin(), accountObj.getUser().getPin());
			Assert.assertEquals(account.getUser().getPan(), accountObj.getUser().getPan());
			Assert.assertEquals(account.getUser().getUserName(), accountObj.getUser().getUserName());
			Assert.assertEquals(account.getUser().getPassword(), accountObj.getUser().getPassword());
			Assert.assertNotSame(account.getUser(), accountObj.getUser());

		}

	}

	@Test
	public void test_getCustomerById() throws Exception {
		System.out.println("GetCustomerById method..");

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

		account.setAccountType("SAVINGS");
		account.setAccountBalance(10000);
		account.setDepositTenure(2);
		account.setMaturityAmount(500000);
		account.setAccountCreatedDate(djUtil.getCurrentDate());
		account.setInterestRate(djUtil.getInterstDate(account.getDepositTenure(), account.getMaturityAmount()));
		account.setUser(user);
		accountDao.openSavingsAccount(account, false);

		beneficiaries.setAccount(account);
		beneficiaries.setBeneficiaryAccountNumber(account.getAccountId());
		beneficiaries.setBeneficiaryBank("DhanJyothi Bank");
		beneficiaries.setBeneficiaryBankIfsc(1234);
		beneficiaries.setBeneficiaryName("laxman rao");
		beneficiaries.setBeneficiaryNickName("lucky");
		beneficiaries.setBeneficiaryType("WITHIN");
		beneficiaries.setUser(user);
		beneficiaries.setUserId(user.getUserId());

		accountService.saveBeneficiaries(account, beneficiaries);

		List<Beneficiaries> beneficiariesList = accountService.getAllBeneficiaries(account.getAccountId());
		System.out.println("Beneficiaries list :" + beneficiariesList);
		for (Beneficiaries beneficiariesObj : beneficiariesList) {
			System.out.println("Beneficiarie :" + beneficiariesObj);
			User userObj = accountService.getUserById(beneficiariesObj.getUserId());
			System.out.println("User :" + userObj);
			Assert.assertEquals(user.getUserId(), userObj.getUserId());
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

	}

	@After
	public void teardown() {
		System.out.println(" After method..");
		user = null;
		account = null;
		beneficiaries = null;
		transaction = null;
	}

}
