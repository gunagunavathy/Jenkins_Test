package com.dhanjyothi.util;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dhanjyothi.model.Beneficiaries;

@Component
public class DhanJyothiUtil {

	public Map<Integer, String> getTenureDetails() {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "One Year");
		map.put(2, "Two Year");
		map.put(3, "Three Year");
		map.put(4, "Four Year");
		map.put(5, "Five Year");
		return map;
	}

	public Date getCurrentDate() {
		Date date = java.util.Calendar.getInstance().getTime();
		return date;
	}

	public Date getTermMaturityDate(int year) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, year);
		Date maturityDate = c.getTime();
		return maturityDate;
	}

	public float getInterstDate(int tenure, long amount) {
		float interest = 0.0f;
		if (tenure == 1) {
			if (amount <= 100000) {
				interest = 5.75f;
			} else if (amount <= 1000000) {
				interest = 6.00f;
			} else if (amount >= 1000000 && amount <= 10000000) {
				interest = 6.25f;
			} else {
				interest = 0.0f;
			}

		} else if (tenure == 2) {
			if (amount <= 100000) {
				interest = 5.75f;
			} else if (amount <= 1000000) {
				interest = 6.00f;
			} else if (amount >= 1000000 && amount <= 10000000) {
				interest = 6.50f;
			} else {
				interest = 0.0f;
			}

		} else if (tenure == 3) {
			if (amount <= 100000) {
				interest = 5.75f;
			} else if (amount <= 1000000) {
				interest = 6.25f;
			} else if (amount >= 1000000 && amount <= 10000000) {
				interest = 6.75f;
			} else {
				interest = 0.0f;
			}

		} else if (tenure == 4) {
			if (amount <= 100000) {
				interest = 6.00f;
			} else if (amount <= 1000000) {
				interest = 6.25f;
			} else if (amount >= 1000000 && amount <= 10000000) {
				interest = 6.75f;
			} else {
				interest = 0.0f;
			}

		} else if (tenure == 5) {
			if (amount <= 100000) {
				interest = 6.00f;
			} else if (amount <= 1000000) {
				interest = 6.50f;
			} else if (amount >= 1000000 && amount <= 10000000) {
				interest = 7.00f;
			} else {
				interest = 0.0f;
			}

		} else {
			interest = 0.0f;
		}
		
		return interest;
	}
	
	public long getAccountBalance (long balance, long termAmount) {
		return balance-termAmount;
	}
	
	public long addAccountBalance(long balance, long termAmount) {
		return balance +termAmount;
	}
	
	public Beneficiaries getBeneficiary(long id,List<Beneficiaries> beneficiaries) {
		
		for(Beneficiaries benObj : beneficiaries) {
			if(id == benObj.getBeneficiaryId()) {
				return benObj;
			} 
		}
		return null;
	}

}
