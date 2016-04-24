package com.mydomain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Hashtable;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.service.dao.Bloginfo;

@Path("/page")
public class BlogService {
	
Bloginfo dao = new Bloginfo();
	
	public void setBlogDao(Bloginfo dao){
		this.dao = dao;
	}
	
	@POST
	@Path("/blogpage")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updatePost(Posts info) {	
		System.out.println("Insert to Posts db : "+info.toString()+ " \n" );
		dao.updatePost(info);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public HashMap getTitles() {
		/*
	      java.util.Hashtable modelData = new Hashtable();
          modelData.put("topic", topicById);
          modelData.put("commentList", commentList);
          */
		return dao.getTitles();
	}
	
	@POST
	@Path("/blogpage/comment")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateComment(Comments comment) {
		System.out.println("Insert to Comments db : "+comment.toString()+ " \n" );
		dao.updateComment(comment);
	}
}
