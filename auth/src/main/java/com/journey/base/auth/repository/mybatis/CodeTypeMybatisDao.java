package com.journey.base.auth.repository.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.journey.base.auth.entity.CodeType;


/**
 * @author liulinkun
 */
@MyBatisRepository
public interface CodeTypeMybatisDao {

	List<CodeType> getCodeTypeByCondition(Map<String, Object> param,RowBounds rb);
	
	Integer getCountOfCodeTypeByCondition(Map<String, Object> param);
}
