package com.dhanjyothi.validator;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;

@Component
public class RegistrationValidator implements Validator {

	@Autowired
	private AccountService accService;

	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		System.out.println("Inside Validate Method");
		final String onlyAlphabetsRegex = "[a-zA-Z]+";
		final String onlyAlphaNumericRegex = "^[a-zA-Z0-9]*$";
		final String addressRegex = "^[a-zA-Z0-9\\S,]*$";
		final String onlyNumericRegex = "[0-9]+";
		final String VALID_EMAIL_ADDRESS_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		final String passwordRegex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

		User cus = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"firstNameEmpty", "First Name is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"lastNameEmpty", "Last Name is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob",
				"dateOfBirthEmpty", "DOB is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1",
				"addressLine1Empty", "Address is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "cityEmpty",
				"City is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state",
				"stateEmpty", "State is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pin", "pinEmpty",
				"PIN is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNumber",
				"mobileNumberEmpty", "Mobile is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId",
				"emailEmpty", "Email is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"userNameEmpty", "User Name is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"passwordEmpty", "Password is mandatory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"confirmPasswordEmpty", "Confirm Password is mandatory");
		/*ValidationUtils.rejectIfEmpty(errors, "dobProof", "dobErr","DOB Proof is Mandatory");
		ValidationUtils.rejectIfEmpty(errors, "addressProof", "addErr","Address Proof is Mandatory");
		ValidationUtils.rejectIfEmpty(errors, "aadharProof", "aadErr","Aadhar is Mandatory");
		ValidationUtils.rejectIfEmpty(errors, "panProof", "panErr","Pan is Mandatory");*/

		if (cus.getFirstName().length() > 100) {
			errors.rejectValue("firstName", "firstNameLen",
					"Max Chars allowed is 100");
		}

		if (cus.getLastName().length() > 100) {
			errors.rejectValue("lastName", "lastNameeLen",
					"Max Chars allowed is 100");
		}

		if (cus.getAddressLine1().length() > 200) {
			errors.rejectValue("addressLine1", "addressLine1Len",
					"Max Chars allowed is 200");
		}

		if (null != cus.getAddressLine2()
				&& cus.getAddressLine2().length() > 200) {
			errors.rejectValue("addressLine2", "addressLine2Len",
					"Max Chars allowed is 200");
		}

		if (cus.getCity().length() > 50) {
			errors.rejectValue("city", "cityLen", "Max Chars allowed is 50");
		}

		if (cus.getState().length() > 50) {
			errors.rejectValue("state", "stateLen", "Max Chars allowed is 50");
		}

		if (cus.getPin().length() != 6) {
			errors.rejectValue("pin", "pinLen", "Max Chars allowed is 6");
		}

		if (cus.getMobileNumber().length() != 10) {
			errors.rejectValue("mobileNumber", "mobileNumberLen",
					"Max Chars allowed is 10");
		}

		if (cus.getEmailId().length() > 50) {
			errors.rejectValue("emailId", "emailLen", "Max Chars allowed is 50");
		}

		if (null != cus.getAadharId() && cus.getAadharId().length() != 12) {
			errors.rejectValue("aadharId", "aadharLen", "Invalid Aadhar Number");
		}

		if (null != cus.getPan() && cus.getPan().length() != 10) {
			errors.rejectValue("pan", "panLen", "Invalid Pan Number");
		}

		if (cus.getUserName().length() < 8 || cus.getUserName().length() > 15) {
			errors.rejectValue("userName", "userNameLen",
					"User Name Should be between 8 - 15 Characters");
		}

		if (cus.getPassword().length() < 8 || cus.getPassword().length() > 15) {
			errors.rejectValue("password", "passwordLen",
					"Password Should be between 8 - 15 Characters");
		}

		if (!cus.getPassword().equals(cus.getConfirmPassword())) {
			errors.rejectValue("password", "passwordMismatch",
					"Passwords Doesn't Match");
		}

		if (!cus.getFirstName().trim().matches(onlyAlphabetsRegex)) {
			errors.rejectValue("firstName", "firstNameReg",
					"Only Alphabets allowed");
		}

		if (!cus.getLastName().trim().matches(onlyAlphabetsRegex)) {
			errors.rejectValue("lastName", "lastNameReg",
					"Only Alphabets allowed");
		}

		if (!cus.getAddressLine1().trim().matches(onlyAlphaNumericRegex)) {
			errors.rejectValue("addressLine1", "addressLine1Reg",
					"Only Alpha Numeric allowed");
		}

		if (!cus.getAddressLine2().trim().matches(onlyAlphaNumericRegex)) {
			errors.rejectValue("addressLine2", "addressLine1Re2",
					"Only Alpha Numeric allowed");
		}

		if (!cus.getCity().trim().matches(onlyAlphabetsRegex)) {
			errors.rejectValue("city", "cityReg", "Only Alphabets allowed");
		}

		if (!cus.getState().trim().matches(onlyAlphabetsRegex)) {
			errors.rejectValue("state", "stateReg", "Only Alphabets allowed");
		}

		if (!cus.getPin().trim().matches(onlyNumericRegex)
				|| cus.getPin().equals("000000")) {
			errors.rejectValue("pin", "pinReg", "Invalid Pin Number");
		}

		if (!cus.getMobileNumber().trim().matches(onlyNumericRegex)
				|| cus.getPin().equals("0000000000")) {
			errors.rejectValue("mobileNumber", "mobileNumberReg",
					"Invalid Mobile Number");
		}

		if (!cus.getEmailId().trim().matches(VALID_EMAIL_ADDRESS_REGEX)) {
			errors.rejectValue("emailId", "emailReg", "Invalid Email");
		}

		if (!cus.getAadharId().trim().matches(onlyNumericRegex)
				|| cus.getAadharId().equals("0000000000000000")) {
			errors.rejectValue("aadharId", "aadharReg", "Invalid Aadhar Number");
		}

		if (!cus.getPan().trim().matches(onlyAlphaNumericRegex)) {
			errors.rejectValue("pan", "panrReg", "Invalid Pan Number");
		}
		
		if (!cus.getUserName().trim().matches(onlyAlphaNumericRegex)) {
			errors.rejectValue("", "Reg", "Invalid User name");
		}

		if (!cus.getPassword().matches(passwordRegex)) {
			errors.rejectValue(
					"password",
					"passwordReg",
					"Password Should Contain atleast One Upper Case One Digit One Special Character");
		}
		
		try {
			System.out.println("User Name Check"+accService.isUserNameExists(cus.getUserName()));
			/*if(!accService.isUserNameExists(cus.getUserName())) {
				errors.rejectValue("userName", "userNameAlreadyExists","User Name Already Exists");
			}*/
		} catch (NoResultException e) {
		} catch (Exception e) {
			//errors.rejectValue("userName", "userNameAlreadyExists","User Name Already Exists");
		}
		//System.out.println("Content Type"+cus.get.getContentType());
		/*if(null == cus.getDobProof() || !(cus.getDobProof().getContentType().equalsIgnoreCase("application/pdf") 
				|| cus.getDobProof().getContentType().equalsIgnoreCase("image/jpeg") 
				|| cus.getDobProof().getContentType().equalsIgnoreCase("image/jpg"))) {
			errors.rejectValue("dobProof", "dobErr","Invalid File Type");
		}
		
		if(null == cus.getAddressProof() || !(cus.getAddressProof().getContentType().equalsIgnoreCase("application/pdf") 
				&& !cus.getAddressProof().getContentType().equalsIgnoreCase("image/jpeg") 
				&& !cus.getAddressProof().getContentType().equalsIgnoreCase("image/jpg"))) {
			errors.rejectValue("addressProof", "addErr","Invalid File Type");
		}
		
		if(null == cus.getAadharProof() || !(cus.getAadharProof().getContentType().equalsIgnoreCase("application/pdf") 
				&& !cus.getAadharProof().getContentType().equalsIgnoreCase("image/jpeg") 
				&& !cus.getAadharProof().getContentType().equalsIgnoreCase("image/jpg"))) {
			errors.rejectValue("aadharProof", "aadErr","Invalid File Type");
		}
		
		if(null == cus.getPanProof() || !(cus.getPanProof().getContentType().equalsIgnoreCase("application/pdf") 
				&& !cus.getPanProof().getContentType().equalsIgnoreCase("image/jpeg") 
				&& !cus.getPanProof().getContentType().equalsIgnoreCase("image/jpg"))) {
			errors.rejectValue("panProof", "panErr","Invalid File Type");
		}*/

	}
}
