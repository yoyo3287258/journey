/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-8</p>
 */
package com.journey.base.auth.service.Code;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.journey.base.auth.entity.CodeType;
import com.journey.base.auth.mybatis.dialect.MybatisUtil;
import com.journey.base.auth.repository.CodeTypeDao;
import com.journey.base.auth.repository.mybatis.CodeTypeMybatisDao;

@Component
@Transactional
public class CodeTypeService {

	@PersistenceContext
	private EntityManager em;
	
	private CodeTypeMybatisDao codeTypeMybatisDao;
	
	private CodeTypeDao codeTypeDao;
	
	/**
	 * 根据查询条件查询码表类型
	 * @return
	 */
	public List<CodeType> getCodeTypeByCondition(Map<String,Object> param,int offset,int pagesize) {
		List<CodeType> lst = codeTypeMybatisDao.getCodeTypeByCondition(param,MybatisUtil.getPageable(offset, pagesize));
		return lst;
	}
	
	/**
	 * 根据查询条件查询码表类型的数目
	 * @return
	 */
	public Integer getCountOfCodeTypeByCondition(Map<String,Object> param) {
		Integer i = codeTypeMybatisDao.getCountOfCodeTypeByCondition(param);
		return i;
	}
	
	/**
	 * 查询所有码表类型的分类（一级码表）
	 * @return
	 */
	public List<CodeType> getCodeTypeByGroup(int offset,int pagesize) {
		int pageNum = offset / pagesize;
		Pageable pageable = new PageRequest(pageNum, pagesize);
		return codeTypeDao.findByGroupNameIsNull(pageable);
	}
	/**
	 * 查询所有码表类型的分类（一级码表）的数目
	 * @return
	 */
	public Integer getCountOfCodeTypeByGroup() {
		Long i = codeTypeDao.countByGroupNameIsNull();
		return i.intValue();
	}
	/**
	 * 保存码表类型
	 * @param codeType
	 */
	public void save(CodeType codeType) {
		codeTypeDao.save(codeType);
	}
	
	/**
	 * 修改码表类型
	 * @param codeType
	 */
	public void update(CodeType codeType) {
		em.merge(codeType);
	}
	
	public void delete(CodeType codeType) {
		em.remove(em.merge(codeType));
	}
	
	/**
	 * @return the codeTypeMybatisDao
	 */
	public CodeTypeMybatisDao getCodeTypeMybatisDao() {
		return codeTypeMybatisDao;
	}

	/**
	 * @param codeTypeMybatisDao the codeTypeMybatisDao to set
	 */
	@Autowired
	public void setCodeTypeMybatisDao(CodeTypeMybatisDao codeTypeMybatisDao) {
		this.codeTypeMybatisDao = codeTypeMybatisDao;
	}

	/**
	 * @return the codeTypeDao
	 */
	public CodeTypeDao getCodeTypeDao() {
		return codeTypeDao;
	}

	/**
	 * @param codeTypeDao the codeTypeDao to set
	 */
	@Autowired
	public void setCodeTypeDao(CodeTypeDao codeTypeDao) {
		this.codeTypeDao = codeTypeDao;
	}
	
	
}
