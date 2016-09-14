package com.bookstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookstore.business.BusinessService;
import com.bookstore.data.User;
import com.bookstore.data.UserInfo;
import com.bookstore.web.util.RESTUtil;

@PropertySource(value = { "classpath:application.properties" })
@Controller
public class UserLoginContoller {

	@Autowired
	BusinessService transactionService;
	private static final Logger LOG = LoggerFactory
			.getLogger(UserLoginContoller.class);

	@Autowired
	private RESTUtil restUtil;

	@Autowired
	private Environment env;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginVerify(Model model) {
		System.out.print("login() called");
		model.addAttribute("loginForm", new User());
		return "login";
	}

	@RequestMapping(value = { "/authenticate" }, method = RequestMethod.POST)
	public String authenticate(
			@ModelAttribute(value = "loginForm") @Valid User loginForm,
			BindingResult result, HttpServletRequest request, Model model) {
		System.out.print("loginVerify() called");
		// System.out.print("user "+user.getName() +" pass "+user.getPwd());
		UsernamePasswordToken token = new UsernamePasswordToken(
				loginForm.getUsername(), loginForm.getPassword());
		token.setRememberMe(true);
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.login(token);
			LOG.debug("User " + loginForm.getUsername()
					+ " has been authenticated");

		} catch (AuthenticationException ae) {
			LOG.error("User " + loginForm.getUsername() + " failed to login");
			loginForm.setErrorMsg("Incorrect username or password");
			return "login";
		}

		if (currentUser.isAuthenticated()) {
			return "afterlogin";
		} else {
			loginForm.setErrorMsg("Incorrect username or password");
			return "login";

		}

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		System.out.print("index() called");
		return "index";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cart() {
		System.out.print("booksearch() called");
		return "cart";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup() {
		System.out.print("signup() called");
		return "signup";
	}

	@RequestMapping(value = "/signupsubmit", method = RequestMethod.POST)
	public String signupsubmit(
			@ModelAttribute(value = "userInfo") @Valid UserInfo inputInfo,
			BindingResult result, HttpServletRequest request, Model model) {
		System.out.print("signupsubmit() called");
		User user = new User();
		user.setUsername(inputInfo.getUsername());
		user.setPassword(inputInfo.getPassword());

		UserInfo userInfo = new UserInfo();
		userInfo.setFname(inputInfo.getFname());
		userInfo.setLname(inputInfo.getLname());
		userInfo.setAddress(inputInfo.getAddress());
		userInfo.setPhone(inputInfo.getPhone());

		user.setUserInfo(userInfo);
		userInfo.setUser(user);

		System.out.println("User-->");
		System.out.println(user);
		System.out.println("UserInfo-->");
		System.out.println(userInfo);
		try {
			transactionService.signup(user);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "afterlogin";
	}

	@RequestMapping(value = "/giftcard", method = RequestMethod.POST)
	public @ResponseBody
	String giftcard() {
		System.out.print("booksearch() called");
		return "giftcard";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		System.out.print("home() called");
		return "home";
	}

}
