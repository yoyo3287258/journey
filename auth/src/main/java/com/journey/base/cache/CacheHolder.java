/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-22</p>
 */
package com.journey.base.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 存放所有的缓存对象
 * 把需缓存的key的clazz和vlaue的calzz的hashcode作为key
 */
public class CacheHolder {

	ConcurrentHashMap<Object, Object> cacheMap = new ConcurrentHashMap<Object, Object>();
	
	public  <K,V> Cache<K,V> getCache(Class<K> kClazz,Class<V> vClazz) {
		String key = String.valueOf(kClazz.hashCode()) + String.valueOf(vClazz.hashCode());
		
		Object oValue = cacheMap.get(key);
		Cache<K,V> cache = (Cache<K,V>)oValue;
		return cache;
	}
	
	
	/**
	 * 把需缓存的key的clazz和vlaue的calzz的hashcode作为key
	 * @param kClazz
	 * @param vClazz
	 * @param cache
	 */
	public void putCache(Object kClazz,Object vClazz, Object cache) {
		String key = String.valueOf(kClazz.hashCode()) + String.valueOf(vClazz.hashCode());
		cacheMap.put(key, cache);
	}
}
