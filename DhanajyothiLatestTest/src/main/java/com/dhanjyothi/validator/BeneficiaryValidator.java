package com.dhanjyothi.validator;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.service.AccountService;

@Component
public class BeneficiaryValidator implements Validator {
	
	@Autowired
	private AccountService accService;

	public boolean supports(Class<?> clazz) {
		return Beneficiaries.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Beneficiaries ben = (Beneficiaries) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "beneficiaryNickName",
				"NickNameEmptyMsg", "Nick Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "beneficiaryName",
				"PayeeNameEmptyMsg", "Payee Name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "beneficiaryAccountNumber",
				"PayeeAccNumEmptyMsg", "Acc Num is required");

		if (ben.getBeneficiaryNickName().length() > 100) {
			errors.rejectValue("beneficiaryNickName", "payeeNickNameLength",
					"Max length allowed is 100");
		}
		if (ben.getBeneficiaryName().length() > 100) {
			errors.rejectValue("beneficiaryName", "payeeNameLength",
					"Max length allowed is 100");
		}
		if (ben.getBeneficiaryAccountNumber() == 0) {
			errors.rejectValue("beneficiaryAccountNumber", "payeeAccNumMsg",
					"Invalid Acc Revathi Num");
		}

		if (ben.getBeneficiaryType().equalsIgnoreCase("External")) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "beneficiaryBank",
					"BankNameEmptyMsg", "Bank Name is required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "beneficiaryBankIfsc",
					"IfscEmptyMsg", "Ifsc Code is required");
			if (ben.getBeneficiaryBank().length() > 100) {
				errors.rejectValue("beneficiaryBank", "bankNameMsg",
						"Max length allowed is 100");
			}
			if (ben.getBeneficiaryBankIfsc() == 0) {
				errors.rejectValue("beneficiaryBankIfsc", "ifscCodeMsg",
						"Invalid IFSC Code");
			}
		}
		System.out.println("BenType"+ben.getBeneficiaryType());
		if (ben.getBeneficiaryType().equalsIgnoreCase("Internal")) {
		try {
			System.out.println(accService.checkAccountExists(ben));
			if(!accService.checkAccountExists(ben)) {
				errors.rejectValue("beneficiaryAccountNumber", "payeeAccNumMsg","Invalid Account Revathi1 Num");
			}
		} catch (Exception e) {
			errors.rejectValue("beneficiaryAccountNumber", "payeeAccNumMsg","Invalid Account Revathi2 Num");
		}
		}
	}

}
