/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-24</p>
 */
package com.journey.base.auth.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import com.journey.base.auth.tag.model.Column;

/**
 * 列标签，属于Grid的子标签
 */
public class ColumnTag extends SimpleTagSupport {

	/**
	 * 表头文字   *require
	 */
	private String header;
	/**
	 * 与数据模型对应的字段				*require
	 */
	private String field;
	/**
	 * 列的宽度，数字，单位px，或者'autoExpand'。注意只能有一个列被设置为'autoExpand'属性。
	 * 默认40
	 */
	private String width;
	/**
	 * 列文字对齐方式，可以为'left'、'center'、'right'之中的一个 ，默认center。
	 */
	private String align;
	/**
	 * 是否自动换行，取值为true或者false， 默认false
	 */
	private String wrap;
	
	
	@Override
	public void doTag() throws JspException, IOException {
		GridTag gridTag = (GridTag)this.getParent();
		if(gridTag != null) {
			checkAttribute();
			Column col = new Column();
			try {
				PropertyUtils.copyProperties(col, this);
				/**
				 * Column 中 name字段比较特殊，需要单独给它赋值。
				 * (这是由于标签的属性与对应的OM-Grid组件中colModel的属性不匹配造成的)
				 */
				col.setName(this.getField());
			} catch (Exception e) {
				throw new JspException(e);
			}
			gridTag.getColumnLst().add(col);
		}
	}

	/**
	 * 检验标签属性
	 */
	private void checkAttribute() {

		if(StringUtils.isEmpty(width)) {
			width = "40";
		}
		if("autoExpand".equals(width)) {
			width = "'" + width + "'";
		}
		if(StringUtils.isEmpty(align)) {
			align = "center";
		}
		align = "'" + align + "'";
		if(StringUtils.isEmpty(wrap)) {
			wrap = "false";
		}
	}
	

	/**
	 * @return the header
	 */
	public String getHeader() {
		return header;
	}


	/**
	 * @param header the header to set
	 */
	public void setHeader(String header) {
		this.header = header;
	}


	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}


	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}


	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}


	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}


	/**
	 * @return the align
	 */
	public String getAlign() {
		return align;
	}


	/**
	 * @param align the align to set
	 */
	public void setAlign(String align) {
		this.align = align;
	}


	/**
	 * @return the wrap
	 */
	public String getWrap() {
		return wrap;
	}


	/**
	 * @param wrap the wrap to set
	 */
	public void setWrap(String wrap) {
		this.wrap = wrap;
	}
}
