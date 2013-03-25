/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-21</p>
 */
package com.journey.base.cache;

import java.util.concurrent.locks.ReentrantLock;


public class GuavaCacheManager  implements CacheManager {

	private  CacheHolder cacheHolder = new CacheHolder();
	private final ReentrantLock lock = new ReentrantLock();

	/* (non-Javadoc)
	 * @see com.journey.base.cache.CacheManager#destroy()
	 */
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 *  K，V表示缓存的Key，value的类型
	 */
	@Override
	public <K,V> Cache<K, V> create(Class<K> kClazz,Class<V> vClazz) throws Exception {
		try {
			lock.lock();
			Cache<K, V> cache = cacheHolder.getCache(kClazz,vClazz);
			if(cache == null) {
				cache = new GuavaCache<K,V> ();
				cacheHolder.putCache(kClazz,vClazz, cache);
			}
			return cache;
		}finally {
			lock.unlock();
		}
	}

}
