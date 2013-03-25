package com.journey.base.auth.repository.mybatis;

import java.util.List;
import java.util.Map;

import com.journey.base.auth.entity.Resource;


/**
 * @author liulinkun
 */
@MyBatisRepository
public interface ResourceMybatisDao {

	List<Resource> getResourceByLoginId(Map<String, Object> param);
}
