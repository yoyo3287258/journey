package com.journey.base.auth.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journey.base.auth.entity.UserAuth;
import com.journey.base.auth.repository.UserAuthDao;


@Component
@Transactional(readOnly=true)
public class AuthService {

	private UserAuthDao userAuthDao;


	public UserAuth findByLoginId(String loginName) {
		return this.userAuthDao.findByLoginId(loginName);
	}
	

	@Autowired
	public void setUserAuthDao(UserAuthDao userAuthDao) {
		this.userAuthDao = userAuthDao;
	}
}
