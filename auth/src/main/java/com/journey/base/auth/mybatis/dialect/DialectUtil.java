/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-28</p>
 */
package com.journey.base.auth.mybatis.dialect;

public class DialectUtil {

	
	/**
	 * 去掉sql字符串的空格和';'号
	 * @param sql
	 * @return
	 */
	public static String trim(String sql)
	  {
	    sql = sql.trim();
	    if (sql.endsWith(";"))
	      sql = sql.substring(0, sql.length() - 1 - ";".length());

	    return sql;
	  }
	
	/**
	 * 根据数据库类型，得到相应的方言
	 * @return
	 */
	public static IDialect getDialect(String databaseId) {
		if("H2".equals(databaseId)) {
			return new H2Dialect();
		}
		return new MySQLDialect();
	}
}
