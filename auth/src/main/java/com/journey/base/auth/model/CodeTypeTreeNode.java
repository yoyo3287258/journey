/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2013-3-20</p>
 */
package com.journey.base.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value={"id"})
public class CodeTypeTreeNode extends Model {
	/**
	 *  CodeTypeTreeNode.java
	 */
	private static final long serialVersionUID = 6514154755649280750L;

	private String name;
	
	@JsonProperty(value="isParent")
	private boolean isParent;
	
	private String typeCode;
	
	private String parentTId ;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isParent
	 */
	public boolean isParent() {
		return isParent;
	}

	/**
	 * @param isParent the isParent to set
	 */
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	/**
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * @param typeCode the typeCode to set
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	/**
	 * @return the parentTId
	 */
	public String getParentTId() {
		return parentTId;
	}

	/**
	 * @param parentTId the parentTId to set
	 */
	public void setParentTId(String parentTId) {
		this.parentTId = parentTId;
	}


}
