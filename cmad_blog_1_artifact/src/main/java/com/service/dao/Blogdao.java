package com.service.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mydomain.service.Comments;
import com.mydomain.service.HibernateUtil;
import com.mydomain.service.Posts;
import com.mydomain.service.Users;


public class Blogdao {

	public HashMap getTitles() {
		Session ses = HibernateUtil.currentSession();
		try {
			Criteria criteria =  ses.createCriteria(Posts.class);
			criteria.setProjection(Projections.projectionList().add(
				     Projections.property("postTitle")).add(Projections.property("postAbout"))); 
			List<Posts> students = criteria.list();		 
			HashMap<String, String> hashmap = new HashMap<String, String>();
			Iterator it = students.iterator();
			while(it.hasNext())
			{
				Object o[] = (Object[])it.next();
				hashmap.put(o[0].toString(), o[1].toString());
			}		
			return hashmap;   	     
		}catch (HibernateException e) {
			   e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return null;	 
	}
	/*
	public List<Posts> getTitles() {
		Session ses = HibernateUtil.currentSession();
		try {
			return ses.createCriteria(Posts.class).list();
		} finally {
			HibernateUtil.closeSession();
		}
	}*/
	
	public boolean updatePost(Posts info) {
		Session ses = HibernateUtil.currentSession();
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			info.setPostDate(new Date());
			System.out.println("Inserting to Posts db : "+info.toString()+ " \n" );
			ses.save(info);
			tx.commit();
		}catch (Exception e) { 
			if (tx != null) {
				tx.rollback();
				System.out.println(e.toString());
				System.out.println("Return null exception");
				return (false);
			}
		} finally{
			HibernateUtil.closeSession();
		}
		System.out.println("\n SINDHU Updated Post return True");
		return (true);
	}
	public boolean updateComment(Comments info) {
		Session ses = HibernateUtil.currentSession();
		Transaction tx = null;
		try {
			tx = ses.beginTransaction();
			ses.save(info);
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
		System.out.println("\n SINDHU Updated comment return True");
		return (true);
	}
	public Posts getPage(String title) {
		Session ses = HibernateUtil.currentSession();
		Transaction tx = null;

		try {
			Criteria criteria = ses.createCriteria(Posts.class);   
			criteria.add(Restrictions.like("postTitle", title));
			Posts p = null;
			p = (Posts)criteria.uniqueResult();
			System.out.println("\n SINDHU return True");
			return p;
		} finally{
			HibernateUtil.closeSession();
		}
	}
	/*
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
*/	
}
