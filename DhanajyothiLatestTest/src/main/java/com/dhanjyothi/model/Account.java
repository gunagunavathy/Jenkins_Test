package com.dhanjyothi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCT_ID")
	private int accountId;
	@Column(name = "ACC_TYPE")
	private String accountType;
	@Column(name = "ACC_BALANCE")
	private long accountBalance;
	@Column(name = "DEPOSIT_TENURE")
	private int depositTenure;
	@Column(name = "INT_RATE")
	private float interestRate;

	@Column(name = "ACCOUNT_CREATED_DATE")
	private Date accountCreatedDate;
	@Column(name = "ACCOUNT_UPDATED_DATE")
	private Date accountUpdatedDate;
	@Column(name = "MATURITY_AMT")
	private long maturityAmount;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getDepositTenure() {
		return depositTenure;
	}
	public void setDepositTenure(int depositTenure) {
		this.depositTenure = depositTenure;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public Date getAccountCreatedDate() {
		return accountCreatedDate;
	}
	public void setAccountCreatedDate(Date accountCreatedDate) {
		this.accountCreatedDate = accountCreatedDate;
	}
	public Date getAccountUpdatedDate() {
		return accountUpdatedDate;
	}
	public void setAccountUpdatedDate(Date accountUpdatedDate) {
		this.accountUpdatedDate = accountUpdatedDate;
	}
	public long getMaturityAmount() {
		return maturityAmount;
	}
	public void setMaturityAmount(long maturityAmount) {
		this.maturityAmount = maturityAmount;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", accountBalance=" + accountBalance
				+ ", depositTenure=" + depositTenure + ", interestRate=" + interestRate + ", accountCreatedDate="
				+ accountCreatedDate + ", accountUpdatedDate=" + accountUpdatedDate + ", maturityAmount="
				+ maturityAmount + ", user=" + user + "]";
	}
	

}