/**
 * 
 */
package com.journey.base.auth.manager;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

/**
 * @author liulinkun
 * 此类是用于统一管理系统中获取spring的applicationcontext和获取相关bean
 * 注意：如果使用此类的程序是在应用启动时调用，可能会抛出nullpoint异常，
 * 因为有可能web容器还未初始化spring容器，在使用时要明确要在spring容器初始化之后进行调用
 */
public class ApplicationContextManager {
	
	private static ApplicationContext ac = null;
	

	
	public static ApplicationContext getApplicationContext() {
		synchronized (ApplicationContextManager.class) {
			if(ac == null) {
				ac = ContextLoaderListener.getCurrentWebApplicationContext();
			}
		}
		if(ac == null) {
			throw new NullPointerException("没有能够从容器获得Spring的ApplicationContext!");
		}
		return ac;
	}
	
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
	
	public static <T> T getBean(String name, Class<T> requiredType) {
		return getApplicationContext().getBean(name,requiredType);
	}
	
	public static  <T> T getBean(Class<T> requiredType)  {
		return getApplicationContext().getBean(requiredType);
	}
	
	public static Object getBean(String name, Object... args)  {
		return getApplicationContext().getBean(name,args);
	}
	
	public static boolean containsBean(String name) {
		return getApplicationContext().containsBean(name);
	}
	
	public static boolean isSingleton(String name){
		return getApplicationContext().isSingleton(name);
	}
	
	public static boolean isPrototype(String name){
		return getApplicationContext().isPrototype(name);
	}
	
	public static boolean isTypeMatch(String name, Class<?> targetType) {
		return getApplicationContext().isTypeMatch(name,targetType);
	}
	
	public static Class<?> getType(String name) {
		return getApplicationContext().getType(name);
	}
	
	public static  String[] getAliases(String name) {
		return getApplicationContext().getAliases(name);
	}
}
