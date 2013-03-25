/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2013-3-19</p>
 */
package com.journey.base.auth.service.h2;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


/**
 * h2数据库的远程服务类
 * 方便h2浏览器控制台连接此内嵌数据库
 */
@Component
@Lazy(value = false)
public class H2RemoteServer implements Serializable {
	/**
	 *  H2RemoteServer.java
	 */
	private static final long serialVersionUID = -6976697053421492262L;
	private static Logger logger = LoggerFactory
			.getLogger(H2RemoteServer.class);
	private int port = 9081;
	private Server server = null;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@PostConstruct
	public void start() {
		if (server == null) {
			try {
				server = Server.createTcpServer(
						new String[] { "-tcpPort", "" + port }).start();
				logger.debug("start the H2 MixedMode server on port:" + port);
			} catch (SQLException e) {
				logger.error(e.getMessage());
				logger.error("fail to start the h2 Assist server..");
			}
		}
	}

	@PreDestroy
	public void stop() {
		if (server != null) {
			server.stop();
			server.shutdown();
			logger.debug("the H2 MixedMode server has been shutdown successfully:");
		}
	}
}
