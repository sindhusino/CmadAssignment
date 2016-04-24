package com.service.dao;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mydomain.service.HibernateUtil;
import com.mydomain.service.Users;


public class UserDao {

	public Users getUser(Integer id) {
		Session ses = HibernateUtil.currentSession();
		try {
			Criteria crit =  ses.createCriteria(Users.class);
			crit.add(Restrictions.idEq(id));
			Users u = (Users)crit.uniqueResult();
			return u;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public boolean validateUser(Users user) {
		Session ses = HibernateUtil.currentSession();
		Transaction tx = null;
		try {
			//String hql = "select u from Users u where (u.emailId = :emailID AND u.password=BINARY:password)";
			//Query query  = ses.createQuery(hql).setString("emailID", user.getEmailId()).setString("password", user.getPassword());
			//List<Users> listProducts = query.list();
			//System.out.println("\nSINDHU email= "+listProducts.toString());
			//if(listProducts.isEmpty()) {
				//System.out.println("\n Invalid user info");
				//return (false);		
		//	}
			Criteria criteria = ses.createCriteria(Users.class);   
			criteria.add(Restrictions.ilike("emailId", user.getEmailId()));
			criteria.add(Restrictions.ilike("password", user.getPassword()));
			Users u = null;
			u = (Users)criteria.uniqueResult();
			if (u == null) {
				return (false);
			} else if (!u.getPassword().toString().equals(user.getPassword().toString())) {
				System.out.println("password case mismatch");
				return (false);
			}
			System.out.println("SINDHU users in criteria = "+u.toString());
		} finally {
			HibernateUtil.closeSession();
		}
		System.out.println("\n SINDHU return True");
		return (true);
	}
	
	public List<Users> getUsers() {
		Session ses = HibernateUtil.currentSession();
		try {
			return ses.createCriteria(Users.class).list();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	public boolean createUser(Users user){
		Session ses = HibernateUtil.currentSession();
		Transaction tx = null;
		/*
		String hql = "select u from Users u where u.emailId = :emailID";
		Query query  = ses.createQuery(hql).setString("emailID", user.getEmailId());
		List<Users> listProducts = query.list();
		System.out.println("\nSINDHU email= "+listProducts.toString());
		if(listProducts != null  && !listProducts.isEmpty()) {
			System.out.println("\n SINDHU Not null");
			return (false);		
		}
		*/
		Criteria criteria = ses.createCriteria(Users.class);   
		criteria.add(Restrictions.like("emailId", user.getEmailId()));
		Users u = null;
		u = (Users)criteria.uniqueResult();
		if (u != null) {
			return (false);
		}
		try {
			tx = ses.beginTransaction();
			ses.save(user);
			tx.commit();
		}catch (Exception e) { 
			if (tx != null) {
				tx.rollback();
				System.out.println("Return null exception");
				return (false);
			}
		} finally{
			HibernateUtil.closeSession();
		}
		System.out.println("\n SINDHU return True");
		return (true);
	}
	
	public void updateUser(Users u){
		System.out.println("Updating user: ");
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			ses.update(u);
			tx.commit();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	public boolean deleteUser(@PathParam("param") Integer id) {
		System.out.println("Deleting user: "+id);
		Session ses = HibernateUtil.currentSession();
		try {
			Transaction tx = ses.beginTransaction();
			Users u = (Users) ses.load(Users.class, id);
			ses.delete(u);
			tx.commit();
			return true;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
}


