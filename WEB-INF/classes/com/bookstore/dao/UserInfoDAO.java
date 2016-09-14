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

import com.bookstore.data.UserInfo;

/**
 * Home object for domain model class UserInfo.
 * 
 * @see .User
 * @author Hibernate Tools
 */
@Repository
public class UserInfoDAO {

	private static final Log log = LogFactory.getLog(UserInfoDAO.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void persist(UserInfo transientInstance) {
		log.debug("persisting UserInfo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UserInfo instance) {
		log.debug("attaching dirty UserInfo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserInfo instance) {
		log.debug("attaching clean UserInfo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UserInfo persistentInstance) {
		log.debug("deleting UserInfo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserInfo merge(UserInfo detachedInstance) {
		log.debug("merging UserInfo instance");
		try {
			UserInfo result = (UserInfo) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserInfo findById(java.lang.Integer id) {
		log.debug("getting UserInfo instance with id: " + id);
		try {
			UserInfo instance = (UserInfo) sessionFactory.getCurrentSession().get("UserInfo", id);
			//System.out.println(instance.getUserInfoname());
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

	public List findByExample(UserInfo instance) {
		log.debug("finding UserInfo instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("UserInfo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<UserInfo> getUserInfoList() {
		// TODO Auto-generated method stub

		log.debug("getting UserInfoList");
		try {
			String queryName = "getMemberList";
			Query getUserInfoList = sessionFactory.getCurrentSession().getNamedQuery(queryName);
			List<UserInfo> UserInfoList = (List<UserInfo>) getUserInfoList.list();
			return UserInfoList;
		} catch (RuntimeException re) {
			log.error("getting UserInfoList", re);
			throw re;
		}

	}

	/*public boolean authenticate(UserInfo user) {
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
	}*/

}
