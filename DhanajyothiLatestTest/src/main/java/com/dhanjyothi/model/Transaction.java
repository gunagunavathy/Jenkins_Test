package com.dhanjyothi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "TRN_ID")
	private int transactionId;
	@Column(name = "TRANS_TYPE")
	private String transactionType;
	@Column(name = "TRN_AMT")
	private long transactionAmount;
	@Column(name = "TRN_DT_TIME")
	private Date transactionDate;
	@Column(name = "TRN_DESC")
	private String transactionDescription;
	@ManyToOne
	private Account account;
	@OneToOne
	private Beneficiaries benificiary;
	@Transient
	private List<Beneficiaries> beneficiaries;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionDescription() {
		return transactionDescription;
	}

	public void setTransactionDescription(String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Beneficiaries getBenificiary() {
		return benificiary;
	}

	public void setBenificiary(Beneficiaries benificiary) {
		this.benificiary = benificiary;
	}

	public List<Beneficiaries> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiaries> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

}
