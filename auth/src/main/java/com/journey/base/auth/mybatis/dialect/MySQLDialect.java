/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-28</p>
 */
package com.journey.base.auth.mybatis.dialect;

public class MySQLDialect implements IDialect {

	@Override
	public boolean supportsPaged() {
		return true;
	}

	@Override
	public String getPagedString(String sql, int offset, int limit) {
		sql = DialectUtil.trim(sql);
	    StringBuffer sb = new StringBuffer(sql.length() + 20);
	    sb.append(sql);
	    if (offset > 0)
	      sb.append(" limit ").append(offset).append(',').append(limit).append(";");
	    else
	      sb.append(" limit ").append(limit).append(";");

	    return sb.toString();
	}

}
