/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-28</p>
 */
package com.journey.base.auth.mybatis.dialect;

public interface IDialect {

	public abstract boolean supportsPaged();

	public abstract String getPagedString(String sql, int offset, int limit);
}
