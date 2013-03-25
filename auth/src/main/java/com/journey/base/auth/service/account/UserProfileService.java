/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-8</p>
 */
package com.journey.base.auth.service.account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journey.base.auth.constant.AuthConstants;
import com.journey.base.auth.entity.Resource;
import com.journey.base.auth.model.MenuGroup;
import com.journey.base.auth.model.UserProfile;
import com.journey.base.auth.repository.ResourceDao;
import com.journey.base.auth.repository.mybatis.ResourceMybatisDao;

@Component
@Transactional(readOnly=true)
public class UserProfileService {

	private ResourceMybatisDao resourceMybatisDao;
	
	private ResourceDao resourceDao;
	
	public UserProfile getUserProfile(String loginId) {
		UserProfile userProfile = new UserProfile();
		/** 设置LoginId   **/
		userProfile.setLoginId(loginId);
		/** 设置菜单组   **/
		setMenuGroup(userProfile,loginId);
		return userProfile;
	}
	
	/**
	 * 取出loginId的相关信息，存入当前session中
	 * @param loginId
	 */
	public void setUserProfileToSession(String loginId) {
		UserProfile userProfile = getUserProfile(loginId);
		SecurityUtils.getSubject().getSession().setAttribute(AuthConstants.USER_PROFILE, userProfile);
	}
	
	
	public void setMenuGroup(UserProfile userProfile,String loginId) {
		if("ADMIN".equals(loginId.toUpperCase())){
			Iterable<Resource> i = resourceDao.findAll();
			userProfile.setMenuGroup(paserMenuGroup(i));
		}else {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("loginId", loginId);
			List<Resource> resLst = resourceMybatisDao.getResourceByLoginId(param);
			userProfile.setMenuGroup(paserMenuGroup(resLst));
		}
	}
	
	private MenuGroup paserMenuGroup(Iterable<Resource> i) {
		MenuGroup mg = new MenuGroup();
		for(Resource res:i) {
				mg.setMenu(res);
		}
		return mg;
	}
	
	
	public ResourceMybatisDao getResourceMybatisDao() {
		return resourceMybatisDao;
	}


	@Autowired
	public void setResourceMybatisDao(ResourceMybatisDao resourceMybatisDao) {
		this.resourceMybatisDao = resourceMybatisDao;
	}


	public ResourceDao getResourceDao() {
		return resourceDao;
	}


	@Autowired
	public void setResourceDao(ResourceDao resourceDao) {
		this.resourceDao = resourceDao;
	}
}
