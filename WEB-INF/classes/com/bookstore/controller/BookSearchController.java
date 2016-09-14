package com.bookstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.business.BusinessService;
import com.bookstore.data.Book;
import com.bookstore.data.User;
import com.bookstore.infra.misc.wrapper.ResponseMessageWrapper;
import com.bookstore.web.util.RESTUtil;

@Controller
public class BookSearchController {

	@Autowired
	BusinessService transactionService;
	
private static final Logger LOG = LoggerFactory.getLogger(BookSearchController.class);
	
	@Autowired
	private RESTUtil restUtil;
	
	
	@RequestMapping(value = "/booksearch", method = RequestMethod.GET)
	public String booksearch() {
		System.out.print("booksearch() called");
		return "booksearch";
	}
	
	/*@RequestMapping(value = "/searchsubmit", method = RequestMethod.GET)
	public @ResponseBody List<Book> signupsubmit(@ModelAttribute(value = "book") @Valid Book book,
			BindingResult result, HttpServletRequest request, Model model) {
		
		ResponseMessageWrapper responseMessageWrapper = new ResponseMessageWrapper();
		LOG.debug("saveTownMaster() called");  
		System.out.print("searchsubmit() called");
		List<Book> booklist=transactionService.booksearch(book);
		return booklist;
	}*/
	
	@RequestMapping(value = "/searchsubmit", method = RequestMethod.GET)
	public ModelAndView  signupsubmit(@ModelAttribute(value = "book") @Valid Book book,
			BindingResult result, HttpServletRequest request, Model model) {
		
		ResponseMessageWrapper responseMessageWrapper = new ResponseMessageWrapper();
		LOG.debug("saveTownMaster() called");  
		System.out.print("searchsubmit() called");
		List<Book> booklist=transactionService.booksearch(book);
		
		//responseMessageWrapper = restUtil.putData(townMasterDTO, EFMSWebConstants.TownMaster.SAVE_TOWNMASTER_PATH);

		return new ModelAndView("booksearch",
				"responseMessageWrapper", responseMessageWrapper);	}
}
