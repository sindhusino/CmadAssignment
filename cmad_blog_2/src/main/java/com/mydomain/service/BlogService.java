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

import com.service.dao.Blogdao;

@Path("/page")
public class BlogService {
	
Blogdao dao = new Blogdao();
	
	public void setBlogDao(Blogdao dao){
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
	public List<Posts> getTitlesPage() {
		return dao.getTitles();
	}
	@GET
	@Path("/blogpagetitle/{param}")
	@Produces({MediaType.APPLICATION_JSON})
	public Posts getBlogPage(@PathParam("param") String param) {
		System.out.println("check if : "+param+ " exists\n" );
		return dao.getPage(param);
	}
	
	@POST
	@Path("/comment/{param}")
	@Consumes({MediaType.APPLICATION_JSON})
	public void updateComment(Comments comment,@PathParam("param") String param) {
		System.out.println("Insert to Comments db : "+param+ " \n" );
		System.out.println("content :" + comment);
		dao.updateComment(comment,param);
	}
}
