package com.bookstore.business;

import java.util.List;

import com.bookstore.data.Book;
import com.bookstore.data.User;

public interface BusinessService {

	public String validate();

	public boolean authenticate(User user);

	public boolean signup(User user);

	public List<Book> booksearch(Book book);

	boolean userSignUp(User user);
}
