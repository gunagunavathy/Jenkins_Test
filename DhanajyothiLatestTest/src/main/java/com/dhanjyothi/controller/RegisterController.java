package com.dhanjyothi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dhanjyothi.model.User;
import com.dhanjyothi.service.RegisterService;
import com.dhanjyothi.validator.RegistrationValidator;

@Controller
public class RegisterController {

	@Autowired
	private RegistrationValidator registrationValidator;

	@Autowired
	private RegisterService registerService;

	@Value("${filePath}")
	private String fileUploadPath;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showRegister() {
		System.out.println("Hello Register form");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("signup");
		return modelAndView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveRegister(@ModelAttribute("user") User user, BindingResult bindingResult) {
		System.out.println("File Upload Path:" + fileUploadPath);
		System.out.println(user);
		registrationValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("signup");
		}

		System.out.println(user);
		/*
		 * Map<String, MultipartFile> filesMap = new HashMap<String,
		 * MultipartFile>(); List<KYC> kycDetails = new ArrayList<KYC>();
		 * filesMap.put("DOB",
		 * cust.getKycDetails().get(0).getUser().getDobProof());
		 * filesMap.put("ADDRESS",
		 * cust.getKycDetails().get(0).getUser().getAddressProof());
		 * filesMap.put("AADHAR",
		 * cust.getKycDetails().get(0).getUser().getAadharProof());
		 * filesMap.put("PAN",
		 * cust.getKycDetails().get(0).getUser().getPanProof());
		 * 
		 * for (Map.Entry<String, MultipartFile> entry : filesMap.entrySet()) {
		 * KYC kyc = new KYC(); MultipartFile mf = entry.getValue(); String
		 * fileName = cust.getUserName() + "_" + mf.getOriginalFilename();
		 * String docType = entry.getKey(); System.out.println("FileName" +
		 * fileName); File uploadFile = new File(fileUploadPath, fileName); try
		 * { mf.transferTo(uploadFile); } catch (Exception e) {
		 * e.printStackTrace(); } kyc.setDoc_description(fileName);
		 * kyc.setKyc_type(docType);
		 * //kyc.setLocation(uploadFile.getAbsolutePath()); kycDetails.add(kyc);
		 * } cust.setKycDetails(kycDetails);
		 */
		if (user.getUserName().startsWith("admin")) {
			user.setUserStatus("A");
			user.setUserRole("M");
		} else {
			user.setUserStatus("N");
			user.setUserRole("C");
		}
		registerService.saveRegister(user);
		return new ModelAndView("redirect:login");
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ModelAndView getAllUsers() {
		List<User> customers = registerService.getAllUsers();
		System.out.println(customers);
		// return new ModelAndView("getall_customers", "customers", customers);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("customers", customers);
		modelAndView.setViewName("getall_customers");
		return modelAndView;
	}

}
