package com.bookstore.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.data.Book;


@Repository

public class BookDAO {
	private static final Log log = LogFactory.getLog(BookDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void persist(Book transientInstance) {
		log.debug("persisting Book instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Book instance) {
		log.debug("attaching dirty Book instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Book instance) {
		log.debug("attaching clean Book instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Book persistentInstance) {
		log.debug("deleting Book instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Book merge(Book detachedInstance) {
		log.debug("merging Book instance");
		try {
			Book result = (Book) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Book findById(java.lang.Integer id) {
		log.debug("getting Book instance with id: " + id);
		try {
			Book instance = (Book) sessionFactory.getCurrentSession().get("Book", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Book instance) {
		log.debug("finding Book instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("Book").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Book> bookSearch(Book book) {
		// TODO Auto-generated method stub

		log.debug("getting BookList");
		try {
			String queryName = "getBooksOnTitleAndAuthor";
			Query getBookList = sessionFactory.getCurrentSession().getNamedQuery(queryName);
			getBookList.setString("title", "%"+book.getTitle()+"%");
			getBookList.setString("author","%"+ book.getAuthor()+"%");
			List<Book> BookList = (List<Book>) getBookList.list();
			return BookList;
		} catch (RuntimeException re) {
			log.error("getting BookList", re);
			System.out.print("exception "+re.getMessage());
			throw re;
		}

	}
}