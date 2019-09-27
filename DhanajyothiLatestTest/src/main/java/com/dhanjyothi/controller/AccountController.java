package com.dhanjyothi.controller;

import java.util.List;
import java.util.Map;

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
import com.dhanjyothi.model.Transaction;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.validator.TermAccountValidator;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private TermAccountValidator termAccValidator;

	@GetMapping("/createsavingsaccount")
	public String loadAccountCreationPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session != null) {
			User user = (User) session.getAttribute("cust");
			if (user != null) {
				try {
					accountService.openSavingsAccount(user);
					session.setAttribute("account", accountService.getAccountDetails(user.getUserId(), "SAVINGS"));
				} catch (Exception e) {
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

	// loadtermaccount
	@GetMapping("/loadtermaccount")
	public String loadTermAccount(@ModelAttribute("account") Account account, Model model) {
		Map<Integer, String> map = accountService.getTenureDetails();
		model.addAttribute("tenureList", map);
		return "createtermaccount";
	}

	@PostMapping("/createtermaccount")
	public String createTermAccount(@ModelAttribute("account") Account account, Model model, HttpServletRequest request,
			BindingResult bindingResult) {
		termAccValidator.validate(account, bindingResult);
		if (bindingResult.hasErrors()) {
			Map<Integer, String> map = accountService.getTenureDetails();
			model.addAttribute("tenureList", map);
			return "createtermaccount";
		}
		HttpSession ses = request.getSession();
		if (ses != null) {
			User user = (User) ses.getAttribute("cust");
			if (user != null) {
				try {
					accountService.updateSavingsAccount(account, user);
					accountService.openTermAccount(account, user);
				} catch (Exception e) {
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

	@GetMapping("/viewtransactions")
	public String loadTransactionDetails(Model model, HttpServletRequest request) {
		HttpSession ses = request.getSession();
		if (ses != null) {
			Account account = (Account) ses.getAttribute("account");
			if (account != null) {
				try {
					List<Transaction> trans = accountService.loadAllTransactions(account.getAccountId());
					if (trans.size() > 0) {
						model.addAttribute("transactionsExists", true);
						model.addAttribute("transactionsList", trans);
					} else {
						model.addAttribute("transactionsExists", false);
					}

				} catch (Exception e) {
					e.printStackTrace();
					return "error";

				}
				return "viewtransactions";
			} else {
				return "redirect:login";
			}
		} else {
			return "redirect:login";
		}
	}
}
