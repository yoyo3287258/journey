/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-11-26</p>
 */
package com.journey.base.auth.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.journey.base.auth.constant.AuthConstants;
import com.journey.base.auth.model.UserProfile;
import com.journey.base.auth.service.account.UserProfileService;

public class JWebSecurityManager extends DefaultWebSecurityManager {
	
	
	UserProfileService userProfileService;
	
	@Override
	protected void onSuccessfulLogin(AuthenticationToken token,
			AuthenticationInfo info, Subject subject) {
		/**
		 * 获取用户相关的信息详情,存入到session中
		 */
		String loginId = (String)info.getPrincipals().getPrimaryPrincipal();
		UserProfile userProfile = userProfileService.getUserProfile(loginId);
		subject.getSession().setAttribute(AuthConstants.USER_PROFILE, userProfile);
		
		super.onSuccessfulLogin(token, info, subject);
	}
	
	/**
	 * @return the userProfileService
	 */
	public UserProfileService getUserProfileService() {
		return userProfileService;
	}

	/**
	 * @param userProfileService the userProfileService to set
	 */
	@Autowired
	public void setUserProfileService(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}


	
}
