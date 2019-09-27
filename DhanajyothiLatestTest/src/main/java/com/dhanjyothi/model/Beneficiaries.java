package com.dhanjyothi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="BENEFICIARY")
public class Beneficiaries {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BEN_ID")
	private long beneficiaryId;
	@Column(name="OWNER_ID")
	private int userId;//FK on USER_ID of USER
	@Column(name="BEN_NICK_NAME")
	private String beneficiaryNickName;
	@Column(name="BEN_NAME")
	private String beneficiaryName;
	public long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}
	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public int getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(int beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	public String getBeneficiaryBank() {
		return beneficiaryBank;
	}
	public void setBeneficiaryBank(String beneficiaryBank) {
		this.beneficiaryBank = beneficiaryBank;
	}
	public long getBeneficiaryBankIfsc() {
		return beneficiaryBankIfsc;
	}
	public void setBeneficiaryBankIfsc(long beneficiaryBankIfsc) {
		this.beneficiaryBankIfsc = beneficiaryBankIfsc;
	}
	public String getBeneficiaryType() {
		return beneficiaryType;
	}
	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Column(name="BEN_ACC_NUM")
	private int beneficiaryAccountNumber;
	@Column(name="BEN_BANK")
	private String beneficiaryBank;
	@Column(name="BEN_BANK_IFSC")
	private long beneficiaryBankIfsc;
	@Column(name="BEN_TYPE")
	private String beneficiaryType;
	@ManyToOne
	private Account account;
	@ManyToOne
	private User user;
	@Override
	public String toString() {
		return "Beneficiaries [beneficiaryId=" + beneficiaryId + ", userId=" + userId + ", beneficiaryNickName="
				+ beneficiaryNickName + ", beneficiaryName=" + beneficiaryName + ", beneficiaryAccountNumber="
				+ beneficiaryAccountNumber + ", beneficiaryBank=" + beneficiaryBank + ", beneficiaryBankIfsc="
				+ beneficiaryBankIfsc + ", beneficiaryType=" + beneficiaryType + ", account=" + account + ", user="
				+ user + "]";
	}
	
	
	
	
}
