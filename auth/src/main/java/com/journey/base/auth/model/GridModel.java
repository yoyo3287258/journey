/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-23</p>
 */
package com.journey.base.auth.model;

import java.util.List;

/**
 * 封装页面Grid标签的数据模型
 */
public class GridModel <T> extends Model {
	private static final long serialVersionUID = -3358533808047824067L;
	
	/**
	 * grid 列表的总行数
	 */
	private Integer total;
	
	/**
	 * grid当前页的所有数据
	 */
	private List<T> rows;

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * 设置列表的总行数
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the rows
	 */
	public List<T> getRows() {
		return rows;
	}

	/**
	 * 设置当前页的数据
	 * @param rows the rows to set
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
}
