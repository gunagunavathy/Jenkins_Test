package com.dhanjyothi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "KYC")
public class KYC {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "KYC_ID")
	private long kyc_id;
	@Column(name = "KYC_TYPE")
	private String kyc_type;
	@Column(name = "DOC_DECRIPTION")
	private String doc_description;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;

	public long getKyc_id() {
		return kyc_id;
	}

	public void setKyc_id(long kyc_id) {
		this.kyc_id = kyc_id;
	}

	public String getKyc_type() {
		return kyc_type;
	}

	public void setKyc_type(String kyc_type) {
		this.kyc_type = kyc_type;
	}

	public String getDoc_description() {
		return doc_description;
	}

	public void setDoc_description(String doc_description) {
		this.doc_description = doc_description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
