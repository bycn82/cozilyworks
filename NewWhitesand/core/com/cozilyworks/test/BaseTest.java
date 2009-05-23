package com.cozilyworks.test;

/**
 * @author ordinarybackstreetmoldywilliam@gmail.com
 * @datetime Mar 6, 2008 9:53:59 PM
 * 
 * BaseTest for all kinds of TestCases,get the property of user's dir
 * 
 */
public interface BaseTest {
	public String webbase = System.getProperty("user.dir");
}
