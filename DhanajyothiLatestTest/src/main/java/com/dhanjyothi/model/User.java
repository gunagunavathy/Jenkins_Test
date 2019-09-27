package com.dhanjyothi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "USER_ROLE")
	private String userRole;

	@Column(name = "USER_STATUS")
	private String userStatus;

	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "DOB")
	private String dob;
	@Column(name = "ADD_LINE1")
	private String addressLine1;
	@Column(name = "ADD_LINE2")
	private String addressLine2;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	/*
	 * @NotEmpty
	 * 
	 * @Size(max=6)
	 */@Column(name = "PIN")
	private String pin;
	/*
	 * @NotEmpty
	 * 
	 * @Size(max=10)
	 */@Column(name = "MOBILE_NUMBER")
	private String mobileNumber;
	/*
	 * @NotEmpty
	 * 
	 * @Size(min=10,max=50)
	 */@Column(name = "EMAIL_ID")
	private String emailId;
	/*
	 * @NotEmpty
	 * 
	 * @Size(max=12)
	 */@Column(name = "AADHAR_ID")
	private String aadharId;

	/*
	 * @NotEmpty
	 * 
	 * @Size(max=10)
	 */@Column(name = "PAN")
	private String pan;
	/*
	 * @NotEmpty
	 * 
	 * @Size(min=8,max=15)
	 */@Column(name = "USER_NAME")
	private String userName;

	/*
	 * @NotEmpty
	 * 
	 * @Size(min=8,max=15)
	 */@Column(name = "PASSWORD")
	private String password;
	@Transient
	private String confirmPassword;

	@Transient
	private MultipartFile dobProof;
	@Transient
	private MultipartFile addressProof;
	@Transient
	private MultipartFile aadharProof;
	@Transient
	private MultipartFile panProof;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<KYC> kycDetails;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public MultipartFile getDobProof() {
		return dobProof;
	}

	public void setDobProof(MultipartFile dobProof) {
		this.dobProof = dobProof;
	}

	public MultipartFile getAddressProof() {
		return addressProof;
	}

	public void setAddressProof(MultipartFile addressProof) {
		this.addressProof = addressProof;
	}

	public MultipartFile getAadharProof() {
		return aadharProof;
	}

	public void setAadharProof(MultipartFile aadharProof) {
		this.aadharProof = aadharProof;
	}

	public MultipartFile getPanProof() {
		return panProof;
	}

	public void setPanProof(MultipartFile panProof) {
		this.panProof = panProof;
	}

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAadharId() {
		return aadharId;
	}

	public void setAadharId(String aadharId) {
		this.aadharId = aadharId;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<KYC> getKycDetails() {
		return kycDetails;
	}

	public void setKycDetails(List<KYC> kycDetails) {
		this.kycDetails = kycDetails;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userRole=" + userRole + ", userStatus=" + userStatus + ", firstName="
				+ firstName + ", lastName=" + lastName + ", dob=" + dob + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", pin=" + pin
				+ ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ", aadharId=" + aadharId + ", pan=" + pan
				+ ", userName=" + userName + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", dobProof=" + dobProof + ", addressProof=" + addressProof + ", aadharProof=" + aadharProof
				+ ", panProof=" + panProof + ", kycDetails=" + kycDetails + "]";
	}

}
