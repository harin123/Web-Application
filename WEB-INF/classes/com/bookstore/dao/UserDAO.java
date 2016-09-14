package com.bookstore.dao;

// default package
// Generated 27 Feb, 2014 9:01:19 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookstore.data.User;

/**
 * Home object for domain model class User.
 * 
 * @see .User
 * @author Hibernate Tools
 */
@Repository
public class UserDAO {

	private static final Log log = LogFactory.getLog(UserDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) sessionFactory.getCurrentSession().get("User", id);
			System.out.println(instance.getUsername());
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

	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("User").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub

		log.debug("getting UserList");
		try {
			String queryName = "getMemberList";
			Query getUserList = sessionFactory.getCurrentSession().getNamedQuery(queryName);
			List<User> UserList = (List<User>) getUserList.list();
			return UserList;
		} catch (RuntimeException re) {
			log.error("getting UserList", re);
			throw re;
		}

	}

	public boolean authenticate(User user) {
		boolean valid = false;
		try {
			String queryName = "authenticateUser";
			Query query = sessionFactory.getCurrentSession().getNamedQuery(queryName);
			query.setString("name", user.getUsername());
			query.setString("pwd", user.getPassword());
			List<User> UserList = (List<User>) query.list();

			for (int i = 0; i < UserList.size(); i++) {
				User valid1 = UserList.get(i);
				valid = true;
			}
		} catch (RuntimeException re) {
			log.error("getting UserList", re);
			throw re;
		}
		return valid;
	}

}
