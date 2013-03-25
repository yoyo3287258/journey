/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-22</p>
 */
package com.journey.base.cache;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;

public class GuavaCache <K,V>  implements Cache<K, V> {
	
	private com.google.common.cache.Cache<K, V> cache;

	public GuavaCache() {
		
		cache = CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(1000, TimeUnit.SECONDS).build();
	}

	@Override
	public void put(K key, V value) {
		cache.put(key, value);
		
	}

	@Override
	public V get(K key) {
		return cache.getIfPresent(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		cache.putAll(m);
		
	}

	@Override
	public long size() {
		return cache.size();
	}

	@Override
	public void cleanUp() {
		cache.cleanUp();
	}
}
