package com.cozilyworks.test;

import junit.framework.TestCase;

/**
 * @author ordinarybackstreetmoldywilliam@gmail.com
 * @datetime Mar 6, 2008 9:54:22 PM
 * 
 * Setup a default config file
 */
public class BaseSpringTestCase extends TestCase implements BaseTest {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected String[] getConfigLocations() {
		return new String[] { webbase + "/www/WEB-INF/applicationContext.xml" };
	}
}
