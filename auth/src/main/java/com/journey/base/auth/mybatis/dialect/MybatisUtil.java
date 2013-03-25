/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-28</p>
 */
package com.journey.base.auth.mybatis.dialect;

import org.apache.ibatis.session.RowBounds;

public class MybatisUtil {

	public static RowBounds getPageable(int offset,int pagesize) {
		return new RowBounds(offset,pagesize);
	}
}
