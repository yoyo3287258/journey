/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-21</p>
 */
package com.journey.base.cache;


public interface CacheManager {

	public void destroy() throws Exception;
	
	/**
	 * 创建缓存对象
	 * kCazz参数是key的clazz类对象
	 * vClazz参数是value的clazz类对象
	 * @param kClazz
	 * @param vClazz
	 * @return
	 * @throws Exception
	 */
	public <K,V> Cache<K, V> create(Class<K> kClazz,Class<V> vClazz) throws Exception ;
}
