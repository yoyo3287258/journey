/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-24</p>
 */
package com.journey.base.auth.tag.model;

public class Column {

	/**
	 * 表头文字   
	 */
	private String header;
	/**
	 * 与数据模型对应的字段	与标签的field属性匹配
	 */
	private String name ;
	/**
	 * 列的宽度，数字，单位px，或者'autoExpand'。注意只能有一个列被设置为'autoExpand'属性。
	 * 默认 25
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
	
}
