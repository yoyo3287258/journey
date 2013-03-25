/**
 * 
 */
package com.journey.base.auth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.journey.base.auth.entity.UserAuth;

/**
 * @author liulinkun
 *
 */
public interface UserAuthDao extends PagingAndSortingRepository<UserAuth, String> {

	
	UserAuth findByLoginId(String loginName);
}
