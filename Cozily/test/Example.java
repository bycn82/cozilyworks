
 package org.apache.struts.action;
 import  java.io.Serializable;
 import  javax.servlet.ServletRequest;
 import  javax.servlet.http.HttpServletRequest;
 import  org.apache.struts.upload.MultipartRequestHandler;
 public abstract  class ActionForm implements Serializable{
	 protected transient  ActionServlet servlet= null  
	 protected transient  MultipartRequestHandler multipartRequestHandler
	 }
