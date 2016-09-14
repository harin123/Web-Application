package com.bookstore.controller;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookstore.business.BusinessService;
import com.bookstore.data.User;

@Controller
public class TestController {
	
	@Autowired
	BusinessService transactionService;

		@RequestMapping(value = "/books", method = RequestMethod.GET)
		public String showIssueLandingPage() {
			System.out.print("showBookPage() called");
			transactionService.validate();
			return "index";
		}
		
		/*@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String loginPage() {
			System.out.print("showBookPage() called");
			transactionService.validate();
			return "login";
		}*/
		
		/*@RequestMapping(value = "/loginverify", method = RequestMethod.PUT)
		public String loginVerify(@RequestBody User user) {
			System.out.print("loginVerify() called");
			//System.out.print("user "+Username +" pass "+Password);

			transactionService.validate();
			return "login";
		}*/
		/*@RequestMapping(value = { "/authenticate" }, method = RequestMethod.POST)
		public String authenticate(
				@ModelAttribute(value = "user") @Valid User user,
				BindingResult result, HttpServletRequest request, Model model) {
			System.out.print("loginVerify() called");
			System.out.print("user "+user.getName() +" pass "+user.getPwd());

					return null;
		
		}*/
}
