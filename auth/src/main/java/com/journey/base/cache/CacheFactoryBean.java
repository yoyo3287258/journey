/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-21</p>
 */
package com.journey.base.cache;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public  class CacheFactoryBean implements FactoryBean<CacheManager>,InitializingBean, DisposableBean {
	

	
	private String cacheType = "GuavaCache";
	
	private CacheManager cacheManager;

	@Override
	public void destroy() throws Exception {
		cacheManager.destroy();
	}
	
	public void afterPropertiesSet() throws Exception {
		if("GuavaCache".equals(cacheType)) {
			cacheManager = new GuavaCacheManager();
		}else {
			Exception e = new Exception("can not handle this type of cache!");
			throw e;
		}
	}
	
	@Override
	public CacheManager getObject() throws Exception {
		return this.cacheManager;
	}

	@Override
	public Class<?> getObjectType() {
		return (this.cacheManager != null ? this.cacheManager.getClass() : CacheManager.class);
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	/**
	 * @param cacheManager the cacheManager to set
	 */
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	/**
	 * @param cacheType the cacheType to set
	 */
	public void setCacheType(String cacheType) {
		this.cacheType = cacheType;
	}

	/**
	 * @return the cacheType
	 */
	public String getCacheType() {
		return cacheType;
	}

}
