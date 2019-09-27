package com.dhanjyothi.controller;

import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.model.Account;
import com.dhanjyothi.model.User;
import com.dhanjyothi.service.AccountService;
import com.dhanjyothi.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private AccountService accountService;
	private static final Logger logger = Logger.getLogger(LoginController.class);
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		logger.info("/Login  -> showRegister()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String validateUser(@ModelAttribute("user") User user, HttpServletRequest request, Model model) {
		HttpSession ses = request.getSession();
		User custObj = new User();
		logger.info("/submit -> Username in validateUser() :" + user.getUserName());
		int flag = loginService.validateUser(user);
		if (user.getUserName().equalsIgnoreCase("admin") || user.getUserName().startsWith("admin")) {
			model.addAttribute("userName", user.getUserName());
			return "adminSummary";
		} else {
			try {
				System.out.println("entered submit1");
				custObj = accountService.getUserDetails(user);
				ses.setAttribute("cust", custObj);
				return "redirect:accsummary";
			} catch (NoResultException ne) {
				System.out.println("entered submit2");
				model.addAttribute("userName",
						custObj.getFirstName().toUpperCase() + " " + custObj.getLastName().toUpperCase());
				model.addAttribute("isAccountExists", false);
				return "redirect:accsummary";
			} catch (Exception e) {
				System.out.println("entered submit3");
				e.printStackTrace();
				return "error";
			}
		}

		/*
		 * else { return "error"; }
		 */
	}

	@RequestMapping("/accsummary")
	public String loadAccSummary(HttpServletRequest request, Model model) {
		HttpSession ses = request.getSession();
		Account acc;
		List<Account> termAcc;
		if (ses != null) {
			User cust = (User) ses.getAttribute("cust");
			if (cust != null) {
				try {
					System.out.println("CusomerId11....." + cust.getFirstName());
					acc = accountService.getAccountDetails(cust.getUserId(), "SAVINGS");
					termAcc = accountService.getTermAccountDetails(cust.getUserId(), "TERM");

					model.addAttribute("userName", cust.getFirstName() + cust.getLastName());
					if (acc != null) {
						ses.setAttribute("account", acc);
						model.addAttribute("isSavingsAccountExists", true);
						model.addAttribute("savingsaccount", acc);
					} else {
						model.addAttribute("isSavingsAccountExists", false);
					}
					if (termAcc.size() > 0) {
						model.addAttribute("isTermAccountExists", true);
						model.addAttribute("termaccount", termAcc);
					} else {
						model.addAttribute("isTermAccountExists", false);
					}
					return "accountsummary";
				} catch (NoResultException ne) {
					System.out.println("CusomerId....." + cust.getFirstName());
					model.addAttribute("userName",
							cust.getFirstName().toUpperCase() + " " + cust.getLastName().toUpperCase());
					// model.addAttribute("isAccountExists", false);
					return "accountsummary";
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

	@RequestMapping("/adduser")
	public String addUser(HttpServletRequest request, Model model) {
		HttpSession ses = request.getSession();
		Account acc;
		List<Account> termAcc;
		User user = new User();
		user.setUserName("prabhu");
		User userSes = (User) ses.getAttribute("user");
		try {
			if (userSes != null) {
				acc = accountService.getAccountDetails(userSes.getUserId(), "SAVINGS");
				termAcc = accountService.getTermAccountDetails(userSes.getUserId(), "TERM");
				model.addAttribute("userName", userSes.getUserName());
				System.out.println(termAcc.size());
				if (acc != null) {
					model.addAttribute("isSavingsAccountExists", true);
					model.addAttribute("savingsaccount", acc);
				} else {
					model.addAttribute("isSavingsAccountExists", false);
				}
				if (termAcc.size() > 0) {
					model.addAttribute("isTermAccountExists", true);
					model.addAttribute("termaccount", termAcc);
				} else {
					model.addAttribute("isTermAccountExists", false);
				}
			} else {
				// accService.addUser(user);
				ses.setAttribute("user", user);
				acc = accountService.getAccountDetails(user.getUserId(), "SAVINGS");
				termAcc = accountService.getTermAccountDetails(user.getUserId(), "TERM");
				model.addAttribute("userName", user.getUserName());
				if (acc != null) {
					model.addAttribute("isSavingsAccountExists", true);
					model.addAttribute("savingsaccount", acc);
				} else {
					model.addAttribute("isSavingsAccountExists", false);
				}
				if (termAcc.size() > 0) {
					model.addAttribute("isTermAccountExists", true);
					model.addAttribute("termaccount", termAcc);
				} else {
					model.addAttribute("isTermAccountExists", false);
				}
			}
			System.out.println(acc.getAccountBalance() + "-" + acc.getAccountId() + "-" + acc.getAccountType());
			return "accountsummary";
		} catch (NoResultException ne) {
			model.addAttribute("userName", user.getUserName());
			model.addAttribute("isAccountExists", false);
			return "accountsummary";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request) {
		HttpSession ses = request.getSession();
		ses.invalidate();
		return "redirect:login";
	}
}
