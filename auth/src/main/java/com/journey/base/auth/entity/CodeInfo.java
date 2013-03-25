/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-21</p>
 */
package com.journey.base.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 码表信息
 */
@Entity
@Table(name="j_code_info")
public class CodeInfo extends IdEntity {

	private String code;
	
	private String codeValue;
	
	private String indexNo;
	
	private Long local;
	
	private String remark;
	
	private String codeType;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the codeValue
	 */
	public String getCodeValue() {
		return codeValue;
	}

	/**
	 * @param codeValue the codeValue to set
	 */
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	/**
	 * @return the indexNo
	 */
	public String getIndexNo() {
		return indexNo;
	}

	/**
	 * @param indexNo the indexNo to set
	 */
	public void setIndexNo(String indexNo) {
		this.indexNo = indexNo;
	}

	/**
	 * @return the local
	 */
	public Long getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(Long local) {
		this.local = local;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the codeType
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * @param codeType the codeType to set
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
}
