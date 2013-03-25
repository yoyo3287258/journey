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

import com.journey.base.auth.entity.CodeInfo;
import com.journey.base.auth.entity.CodeType;
import com.journey.base.auth.mybatis.dialect.MybatisUtil;
import com.journey.base.auth.repository.CodeInfoDao;
import com.journey.base.auth.repository.CodeTypeDao;
import com.journey.base.auth.repository.mybatis.CodeTypeMybatisDao;

@Component
@Transactional
public class CodeInfoService {

	@PersistenceContext
	private EntityManager em;
	
	
	private CodeInfoDao codeInfoDao;
	
	
	/**
	 * 根据码表代码查询编码信息List
	 * @param codeType
	 * @param offset
	 * @param pagesize
	 * @return
	 */
	public List<CodeInfo> getCodeInfoByCodeType(String codeType,int offset,int pagesize) {
		Pageable pageable = new PageRequest(offset/pagesize, pagesize);
		List<CodeInfo> lst = codeInfoDao.findByCodeType(codeType, pageable);
		return lst;
	}

	/**
	 * 根据码表代码查询编码信息的数量
	 * @param codeType
	 * @return
	 */
	public int getCountOfCodeInfoByCodeType(String codeType) {
		return codeInfoDao.countByCodeType(codeType).intValue();
	}
	/**
	 * @return the codeInfoDao
	 */
	public CodeInfoDao getCodeInfoDao() {
		return codeInfoDao;
	}

	/**
	 * @param codeInfoDao the codeInfoDao to set
	 */
	@Autowired
	public void setCodeInfoDao(CodeInfoDao codeInfoDao) {
		this.codeInfoDao = codeInfoDao;
	}
	
	
}
