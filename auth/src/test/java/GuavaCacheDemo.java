

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springside.modules.test.spring.SpringTransactionalTestCase;

import com.google.common.collect.Maps;
import com.journey.base.auth.model.UserProfile;
import com.journey.base.auth.service.account.UserProfileService;
import com.journey.base.cache.Cache;
import com.journey.base.cache.CacheManager;

/**
 * 本地缓存演示，使用GuavaCache.
 * 
 * @author hzl7652
 */
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class GuavaCacheDemo extends SpringTransactionalTestCase {

	private static Logger logger = LoggerFactory.getLogger(GuavaCacheDemo.class);

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private UserProfileService userprofileService;
	
	@Test
	public void demo() throws Exception {
		UserProfile up = userprofileService.getUserProfile("admin");
		Cache<String, UserProfile> cache =  cacheManager.create(String.class,UserProfile.class);
		cache.put("admin", up);
		assertEquals(up, cache.get("admin"));
		cache =  cacheManager.create(String.class,UserProfile.class);
		assertEquals(up, cache.get("admin"));
	}
}
