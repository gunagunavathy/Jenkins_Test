package com.dhanjyothi.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dhanjyothi.model.Account;
import com.dhanjyothi.service.AccountService;

@Component
public class TermAccountValidator implements Validator {
	
	@Autowired
	private AccountService accService;

	public boolean supports(Class<?> Aclass) {
		return Account.class.equals(Aclass);
	}

	public void validate(Object obj, Errors err) {
		Account acc = (Account) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "maturityAmount", "TermAmtEmptyMsg","Term Amount can not be Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "depositTenure", "TenureEmptyMsg","Tenure Can not be Empty");
		if(acc.getMaturityAmount() < 1000) {
			err.rejectValue("maturityAmount", "termAmtMinValue","Min Amount to open Term Account is 1000");
		}
		if(acc.getMaturityAmount() > 10000000) {
			err.rejectValue("maturityAmount", "termAmtMaxValue","Max Amount to open Term Account is 1 CR");
		}
		if(acc.getDepositTenure() < 1 && acc.getDepositTenure() > 5) {
			err.rejectValue("depositTenure", "tenureInvalidValue","Tenure Period is from 1 to 5 years");
		}
		try {
			System.out.println(accService.checkSavingsAccBalance(acc.getMaturityAmount()));
			if(!accService.checkSavingsAccBalance(acc.getMaturityAmount())) {
				err.rejectValue("maturityAmount", "termAmtBalValue","Insufficient Balance to open term account");
			}
		} catch (Exception e) {
			err.rejectValue("maturityAmount", "termAmtBalValue","Insufficient Balance to open term account");
		}
	}

}
