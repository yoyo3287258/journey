/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-27</p>
 */
package com.journey.base.auth.mybatis;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.journey.base.auth.mybatis.dialect.DialectUtil;
import com.journey.base.auth.mybatis.dialect.IDialect;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PaginationInterceptor implements Interceptor {

	private static Logger logger = LoggerFactory.getLogger(PaginationInterceptor.class);
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);
		String sql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");
		Configuration configuration  = (Configuration)metaStatementHandler.getValue("delegate.configuration");
		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
		if ((rowBounds.getLimit() > 0) && (rowBounds.getLimit() < 2147483647)) {

			IDialect dialect = DialectUtil.getDialect(configuration.getDatabaseId());
			sql = dialect.getPagedString(sql, rowBounds.getOffset(),
					rowBounds.getLimit());
			logger.debug("生成分页SQL : " + sql);
			metaStatementHandler.setValue("delegate.boundSql.sql", sql);
			metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			metaStatementHandler.setValue("delegate.rowBounds.limit",RowBounds.NO_ROW_LIMIT);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		
	}

}
