package com.mydomain.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Posts {
	
	private int id;
	private String postTitle="";
	private Date  postDate;
	private String postAbout="";
	private String postTags="";
	private Set<Comments> postId;
	private String postEmail="";
//	private int userId;

	public Posts(){}
	   public Posts(String postTitle, String postAbout, String tags) {
		   this.postTitle = postTitle;
		   this.postAbout = postAbout;
		   this.postTags = tags;
		   this.postDate = new Date();
		   this.postId = new HashSet<Comments>();
	   }
	   
	public void setId( int id ) {
		   this.id = id;
	}
	   public int getId() {
		      return id;
		   }

	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostAbout() {
		return postAbout;
	}
	public void setPostAbout(String postAbout) {
		this.postAbout = postAbout;
	}
	public String getpostTags() {
		return postTags;
	}
	
	public void setPostTags(String postTags) {
		this.postTags = postTags;
	}
	
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		 this.postDate = postDate;
	}
	
	public Set getPostId() {
		return postId;
	}
	public void setPostId( Set postId ) {
		this.postId = postId;
	}
	
	public String getPostEmail() {
		return postEmail;
	}
	public void setPostEmail( String postEmail ) {
		this.postEmail = postEmail;
	}
	/*
	public int getuserId() {
		return userId;
	}
	public void setuserId(int userId) {
		this.userId = userId;
	}*/
	/*
	 * 
	 public boolean equals(Object obj) {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      Posts obj2 = (Posts)obj;
	      if((this.id == obj2.getId()) && (this.name.equals(obj2.getName())))
	      {
	         return true;
	      }
	      return false;
	   }
	   public int hashCode() {
	      int tmp = 0;
	      tmp = ( id + name ).hashCode();
	      return tmp;
	   }*/
	@Override
	public String toString() {
		return "posts [Title=" +  postTitle+", about=" + postAbout +"tag = "+postTags+"date = "+postDate+"]";
	}

}
