/*package org.dhanjyothibank.pojo;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
public class CustomerValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return Customer.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		Customer c=(Customer) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "firstName","required.firstName", "Field firstName Required");
		
	}

}
*/