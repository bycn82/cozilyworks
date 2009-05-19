package com.xa;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import com.xa.service.UserService;

public class TestXa extends AbstractDependencyInjectionSpringContextTests{
	protected String[] getConfigLocations(){
		return new String[]{"classpath:applicationContext.xml"};
	}
	public void testInsertBothDatabase(){
        Resource resource = new ClassPathResource("applicationContext.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
		UserService ut=(UserService)factory.getBean("userTest");
		try{
			ut.insertBothDatabase(1,"william");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}