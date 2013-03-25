/**
 * 
 */
package com.journey.base.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author liulinkun
 *
 */
@Entity
@Table(name = "j_user_auth")
public class UserAuth extends IdEntity {

	private String accountExpireDatetime;
	private String createdDatetime;
	private String creatorId;
	private String delFlag;
	private Long failedLoginCount;
	private String lastLoginDatetime;
	private String lastLoginIp;
	private String lastModifiedDatetime;
	private String lastModifierId;
	private String loginDatetime;
	private String loginId;
	private String loginIp;
	private Long maxFailedLoginCount;
	private String passwd;
	private String passwdExpireDatetime;
	private Long passwdExpireDays;
	private String staffId;

	public String getAccountExpireDatetime() {
		return accountExpireDatetime;
	}
	public void setAccountExpireDatetime(String accountExpireDatetime) {
		this.accountExpireDatetime = accountExpireDatetime;
	}
	public String getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(String createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public Long getFailedLoginCount() {
		return failedLoginCount;
	}
	public void setFailedLoginCount(Long failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}
	public String getLastLoginDatetime() {
		return lastLoginDatetime;
	}
	public void setLastLoginDatetime(String lastLoginDatetime) {
		this.lastLoginDatetime = lastLoginDatetime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getLastModifiedDatetime() {
		return lastModifiedDatetime;
	}
	public void setLastModifiedDatetime(String lastModifiedDatetime) {
		this.lastModifiedDatetime = lastModifiedDatetime;
	}
	public String getLastModifierId() {
		return lastModifierId;
	}
	public void setLastModifierId(String lastModifierId) {
		this.lastModifierId = lastModifierId;
	}
	public String getLoginDatetime() {
		return loginDatetime;
	}
	public void setLoginDatetime(String loginDatetime) {
		this.loginDatetime = loginDatetime;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Long getMaxFailedLoginCount() {
		return maxFailedLoginCount;
	}
	public void setMaxFailedLoginCount(Long maxFailedLoginCount) {
		this.maxFailedLoginCount = maxFailedLoginCount;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPasswdExpireDatetime() {
		return passwdExpireDatetime;
	}
	public void setPasswdExpireDatetime(String passwdExpireDatetime) {
		this.passwdExpireDatetime = passwdExpireDatetime;
	}
	public Long getPasswdExpireDays() {
		return passwdExpireDays;
	}
	public void setPasswdExpireDays(Long passwdExpireDays) {
		this.passwdExpireDays = passwdExpireDays;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
