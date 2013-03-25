/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-22</p>
 */
package com.journey.base.cache;

import java.util.Map;


public interface Cache <K,V> {

	  void put(K key, V value);

	  V get(K key);

	  void putAll(Map<? extends K,? extends V> m);

	  long size();

	  void cleanUp();
}
