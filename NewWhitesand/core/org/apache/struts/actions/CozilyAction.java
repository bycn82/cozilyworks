/*
 * Copyright 2007 Cozilyworks.com
 *
 * Licensed on "U DO KNOW HAKKA"
 * you may not use this file except in compliance with my License
 * You can download my License at
 *      
 *      http://cozilyworks.com/LICENSE.TXT
 *
 * HOW TO HAVE MY LICENSE
 *
 * You can have my License via the following two ways
 *
 * 1. Get the LICENSE.TXT and read it
 * 2. Search some documentations on the network
 *
 * If you still don't know what Hakka is ,the only way is "REDO IT"!
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.struts.actions;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.support.AbstractBeanFactory;

public abstract class CozilyAction extends MappingDispatchAction implements BeanFactoryAware,BeanNameAware{
	private final static Logger log=Logger.getLogger(CozilyAction.class);
	protected static final String EXT="coz";
	static final String PACKAGE_DELIMITER=".action";
	static final String DEFAULT_SCOPE="request";
	static final String DEFAULT_FORM_SUFFIX="Form";
	static final String DEFAULT_ACTION_SUFFIX="Action";
	static final String DEFAULT_HOME_CONTROLLER_NAME="home";
	static final String DEFAULT_VIEW_EXTENSION=".jsp";
	public static final String DEFAULT_ACTION_FORM_NAME="form";
	public static final String OKAY="SUCCESS";
	public static final String RIDRECT="REDIRECT";
	private String beanName;
	private ThreadLocal<DynaBean> formPool=new ThreadLocal<DynaBean>();
	private ThreadLocal<HttpServletRequest> requestPool=new ThreadLocal<HttpServletRequest>();
	private ServletContext servletContext;
	public ServletContext getServletContext(){
		return servletContext;
	}
	public void setServletContext(ServletContext servletContext){
		this.servletContext=servletContext;
	}
	public final void setBeanFactory(final BeanFactory factory) throws BeansException{
		if(!factory.isSingleton(beanName)){
			log.warn(getClass().getName()+" must be defined with singleton=\"true\" in order to self-register.");
			return;
		}
		final String pkgName=getClass().getPackage().getName();
		final String path=
			pkgName.substring(pkgName.indexOf(PACKAGE_DELIMITER)+PACKAGE_DELIMITER.length()).replace('.','/')+"/";
		final String controllerName=
			this.getClass().getSimpleName().substring(0,this.getClass().getSimpleName().indexOf(DEFAULT_ACTION_SUFFIX))
				.replaceAll("([A-Z])","_$1").toLowerCase().substring(1);
		if(factory instanceof AbstractBeanFactory){
			final AbstractBeanFactory dlbf=(AbstractBeanFactory)factory;
			final Collection<Method> methods=getDeclaredMethods(getClass(),CozilyAction.class);
			// register beans for each url
			if(log.isDebugEnabled()){
				log.debug("Registering paths...");
			}
			for(final Iterator<Method> i=methods.iterator();i.hasNext();){
				final Method method=i.next();
				String name=method.getName();
				if(Modifier.isPublic(method.getModifiers())&&method.getReturnType().equals(ActionForward.class)){
					final String url=
						path+(controllerName.equals(DEFAULT_HOME_CONTROLLER_NAME)?"":controllerName+"/")
							+name.replaceAll("([A-Z])","_$1").toLowerCase();
					if(log.isDebugEnabled()){
						log.debug(url);
					}
					if(!ArrayUtils.contains(dlbf.getAliases(beanName),url))
						dlbf.registerAlias(beanName,url);
				}
			}
		}else{
			log.warn("Unable to self-register; factory bean was of an unsupported type.");
			throw new BeanNotOfRequiredTypeException(beanName,AbstractBeanFactory.class,factory.getClass());
		}
	}
	public final void setBeanName(final String name){
		this.beanName=name;
	}
	public final void init(final ActionMapping mapping,final ActionForm form,final HttpServletRequest request,
		final HttpServletResponse response){
		if(form instanceof DynaBean)
			formPool.set((DynaBean)form);
		else
			formPool.remove();
		requestPool.set(request);
		request.getSession().setAttribute("ext",EXT);
		onInit(mapping,form,request,response);
	}
	protected void onInit(final ActionMapping mapping,final ActionForm form,final HttpServletRequest request,
		final HttpServletResponse response){}
	protected String $(final String key){
		if(null==formPool.get())
			throw new UnsupportedOperationException("Active form is not a DynaBean.");
		return formPool.get().get(key).toString();
	}
	protected String $s(final String key){
		return $(key);
	}
	protected Object $$(final String key){
		if(null==formPool.get())
			throw new UnsupportedOperationException("Active form is not a DynaBean.");
		return formPool.get().get(key);
	}
	protected Object $o(final String key){
		return $$(key);
	}
	protected Integer $i(final String key){
		return (Integer)$$(key);
	}
	protected void _set(final String key,final Object value){
		if(null==formPool.get())
			throw new UnsupportedOperationException("Active form is not a DynaBean.");
		formPool.get().set(key,value);
	}
	protected void _(final String key,final Object value){
		requestPool.get().setAttribute(key,value);
	}
	protected void _r(final String key,final Object value){
		requestPool.get().setAttribute(key,value);
	}
	protected void _s(final String key,final Object value){
		requestPool.get().getSession().setAttribute(key,value);
	}
	private static Collection<Method> getDeclaredMethods(Class clazz,final Class upto){
		// collect methods to register (include methods for all classes up to
		// and including this one)
		final Collection<Method> methods=new ArrayList<Method>();
		while(!clazz.equals(upto.getSuperclass())){
			methods.addAll(Arrays.asList(clazz.getDeclaredMethods()));
			clazz=clazz.getSuperclass();
		}
		return methods;
	}
	protected ActionForward redirectAfterPost(ActionMapping mapping,String actionMsg,String backUrl){
		_("actionMsg",actionMsg);
		_("backUrl",backUrl);
		return mapping.findForward(RIDRECT);
	}
	protected ActionForward index(final ActionMapping mapping,final ActionForm form,final HttpServletRequest request,
		final HttpServletResponse response) throws IOException,ServletException{
		return mapping.findForward(OKAY);
	}
}
