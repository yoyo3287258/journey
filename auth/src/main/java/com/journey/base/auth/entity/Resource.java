/**
 * 
 */
package com.journey.base.auth.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author liulinkun
 *
 */
@Entity
@Table(name="j_resource")
public class Resource extends IdEntity {
	private String createdDatetime;
	private String creatorId;
	private String delFlag = "0";
	private String lastModifiedDatetime;
	private String lastModifierId;
	private String ext1;
	private String ext2;
	private String ext3;
	private String ext4;
	private String ext5;
	private String ext6;
	private String ext7;
	private String ext8;
	private String ext9;
	private String otherExts;
	private String parentResCode;
	private String parentResTypeCode;
	private String remark;
	private String resCode;
	private String resName;
	private Long resSequence;
	private String resTypeCode;
	private String status;
	private Long level;
	
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
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	public String getExt3() {
		return ext3;
	}
	public void setExt3(String ext3) {
		this.ext3 = ext3;
	}
	public String getExt4() {
		return ext4;
	}
	public void setExt4(String ext4) {
		this.ext4 = ext4;
	}
	public String getExt5() {
		return ext5;
	}
	public void setExt5(String ext5) {
		this.ext5 = ext5;
	}
	public String getExt6() {
		return ext6;
	}
	public void setExt6(String ext6) {
		this.ext6 = ext6;
	}
	public String getExt7() {
		return ext7;
	}
	public void setExt7(String ext7) {
		this.ext7 = ext7;
	}
	public String getExt8() {
		return ext8;
	}
	public void setExt8(String ext8) {
		this.ext8 = ext8;
	}
	public String getExt9() {
		return ext9;
	}
	public void setExt9(String ext9) {
		this.ext9 = ext9;
	}
	public String getOtherExts() {
		return otherExts;
	}
	public void setOtherExts(String otherExts) {
		this.otherExts = otherExts;
	}
	public String getParentResCode() {
		return parentResCode;
	}
	public void setParentResCode(String parentResCode) {
		this.parentResCode = parentResCode;
	}
	public String getParentResTypeCode() {
		return parentResTypeCode;
	}
	public void setParentResTypeCode(String parentResTypeCode) {
		this.parentResTypeCode = parentResTypeCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public Long getResSequence() {
		return resSequence;
	}
	public void setResSequence(Long resSequence) {
		this.resSequence = resSequence;
	}
	public String getResTypeCode() {
		return resTypeCode;
	}
	public void setResTypeCode(String resTypeCode) {
		this.resTypeCode = resTypeCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getLevel() {
		return level;
	}
	public void setLevel(Long level) {
		this.level = level;
	}
}
