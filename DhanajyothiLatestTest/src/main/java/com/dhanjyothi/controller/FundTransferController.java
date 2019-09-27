package com.dhanjyothi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.Beneficiaries;
import com.dhanjyothi.model.User;
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.util.DhanJyothiUtil;
import com.dhanjyothi.validator.BeneficiaryValidator;
import com.dhanjyothi.validator.FundTransferValidator;

@Controller
public class FundTransferController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private BeneficiaryValidator beneficiaryValidator;

	@Autowired
	private FundTransferValidator fundTransferValidator;

	@Autowired
	private DhanJyothiUtil dhanJyothiUtil;

	@GetMapping("/loadbeneficiary")
	public String loadBeneficiaryPage() {
		return "addbeneficiary";
	}

	@GetMapping("/loadtransfer")
	public String loadTransferPage(@ModelAttribute("transaction") Transaction transaction, Model model,
			HttpServletRequest request) {
		HttpSession ses = request.getSession();
		if (ses != null) {
			Account acc = (Account) ses.getAttribute("account");
			if (acc != null) {
				try {
					List<Beneficiaries> ben = accountService.getAllBeneficiaries(acc.getAccountId());
					model.addAttribute("beneficiariesList", ben);
					ses.setAttribute("beneficiariesList", ben);
					return "transfer";
				} catch (Exception e) {
					e.printStackTrace();
					return "error";
				}
			} else {
				return "redirect:login";
			}
		} else {
			return "redirect:login";
		}
	}

	@GetMapping("/beneficiarywithinbank")
	public String beneficiarywithinbank(@ModelAttribute("beneficiary") Beneficiaries beneficiary, Model model) {
		beneficiary.setBeneficiaryType("Internal");
		model.addAttribute("isTransferWithinBank", true);
		return "beneficiary";
	}

	@GetMapping("/beneficiaryotherbank")
	public String beneficiaryotherbank(@ModelAttribute("beneficiary") Beneficiaries beneficiary, Model model) {
		beneficiary.setBeneficiaryType("External");
		model.addAttribute("isTransferWithinBank", false);
		return "beneficiary";
	}

	@PostMapping("/savebeneficiary")
	public String saveBeneficiary(@ModelAttribute("beneficiary") Beneficiaries beneficiary, Model model,
			BindingResult bindingResult, HttpServletRequest request) {
		beneficiaryValidator.validate(beneficiary, bindingResult);
		if (bindingResult.hasErrors()) {
			if (beneficiary.getBeneficiaryType().equalsIgnoreCase("Internal")) {
				model.addAttribute("isTransferWithinBank", true);
			} else {
				model.addAttribute("isTransferWithinBank", false);
			}
			return "beneficiary";
		}
		System.out.println("Entered into other bank account");
		// Account account = null;
		User cust = null;
		HttpSession ses = request.getSession();
		// if (ses != null) {
		// Customer cust = (Customer) ses.getAttribute("cust");
		Account account = (Account) ses.getAttribute("account");
		try {
			System.out.println("beneficiary.getPayeeAccNum()==" + beneficiary.getBeneficiaryAccountNumber());
			// account =
			// accService.checkAccountExists(beneficiary.getPayeeAccNum());
			System.out.println("account.getCust().getId()===" + account.getUser().getUserId());
			cust = accountService.getUserById(beneficiary.getBeneficiaryAccountNumber());

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		if (cust != null && account != null) {
			try {
				beneficiary.setUser(cust);
				accountService.saveBeneficiaries(account, beneficiary);
			} catch (Exception e) {
				e.printStackTrace();
				return "error";

			}
			return "redirect:accsummary";
		} else {
			return "redirect:login";
		}
		/*
		 * } else { return "redirect:login";
		 * 
		 * }
		 */

	}

	@PostMapping("/transferamt")
	public String transferAmount(@ModelAttribute("transaction") Transaction transaction, Model model,
			BindingResult bindingResult, HttpServletRequest request) {
		fundTransferValidator.validate(transaction, bindingResult);
		if (bindingResult.hasErrors()) {
			return "transfer";
		}
		HttpSession ses = request.getSession();
		if (ses != null) {
			User cust = (User) ses.getAttribute("cust");
			Account fromAccount = (Account) ses.getAttribute("account");
			if (cust != null && fromAccount != null) {
				try {
					@SuppressWarnings("unchecked")
					Beneficiaries ben = dhanJyothiUtil.getBeneficiary(transaction.getBenificiary().getBeneficiaryId(),
							(List<Beneficiaries>) ses.getAttribute("beneficiariesList"));
					transaction.setBenificiary(ben);
					accountService.updateFromAccount(fromAccount, transaction.getTransactionAmount(), transaction);
					accountService.updateToAccount(transaction);
				} catch (Exception e) {
					System.out.println("Hellooooo");
					e.printStackTrace();
					return "error";

				}
				return "redirect:accsummary";
			} else {
				return "redirect:login";
			}
		} else {
			return "redirect:login";

		}
	}
}
