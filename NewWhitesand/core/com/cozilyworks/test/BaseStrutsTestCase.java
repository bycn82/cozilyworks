package com.cozilyworks.test;

import java.io.File;
import servletunit.struts.MockStrutsTestCase;

/**
 * @author ordinarybackstreetmoldywilliam@gmail.com
 * @datetime Mar 6, 2008 9:55:13 PM
 * 
 * Setup a default config file,when app has other configs,user can add them 
 * via overriding the setUp method.
 */
public class BaseStrutsTestCase extends MockStrutsTestCase implements BaseTest {

	protected void setUp() throws Exception {
		super.setUp();
		File web = new File(webbase + "/www");
		this.setContextDirectory(web);
		setConfigFile(webbase + "/www/WEB-INF/web.xml");
		setConfigFile(webbase + "/www/WEB-INF/struts-config.xml");
	}

}
