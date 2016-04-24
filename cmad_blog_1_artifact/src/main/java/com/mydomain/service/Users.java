package com.mydomain.service;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Users {

	private String emailId="";
	private String password="";
	private int id;
	private String name="";
//	private Set<Posts> userId;

	public Users(){}
	   public Users(String emailId, String name, String password) {
		   this.emailId = emailId;
		   this.password = password;
		   this.name = name;
	   }
	   
	   public void setId( int id ) {
		      this.id = id;
		   }
	   public int getId() {
		      return id;
		   }

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getname() {
		return name;
	}
	
	public void setname(String name) {
		this.name = name;
	}
/*	public Set getUserId() {
		return userId;
	}
	public void setUserId(Set userId){
		this.userId = userId;
	}
	*/
	@Override
	public String toString() {
		return "Users [emailId=" + emailId +", password=" + password +"Name = "+name+"id = "+id+"]";
	}
	

}
