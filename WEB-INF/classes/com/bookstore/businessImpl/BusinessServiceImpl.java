package com.bookstore.businessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.business.BusinessService;
import com.bookstore.dao.BookDAO;
import com.bookstore.dao.UserDAO;
import com.bookstore.dao.UserInfoDAO;
import com.bookstore.data.Book;
import com.bookstore.data.User;

@Transactional
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserInfoDAO userInfoDAO;

	@Autowired
	private BookDAO bookDAO;

	@Override
	public String validate() {

		// User user=userDAO.findById(1);
		// System.out.println(user.getName());
		userDAO.getUserList();
		return null;
	}

	@Override
	public boolean authenticate(User user) {
		// TODO Auto-generated method stub
		boolean auth = userDAO.authenticate(user);

		return auth;
	}

	@Override
	public boolean signup(User user) {
		try {
			userDAO.persist(user);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Book> booksearch(Book book) {
		List<Book> booklist = null;
		if (book.getAuthor() != null && book.getTitle() != null) {
			booklist = bookDAO.bookSearch(book);
		}
		return booklist;
	}

	@Override
	public boolean userSignUp(User user) {
		try {
			userDAO.persist(user);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		// TODO Auto-generated method stub
		return false;
	}

}
