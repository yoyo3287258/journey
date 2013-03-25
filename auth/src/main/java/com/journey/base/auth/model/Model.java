/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-8</p>
 */
package com.journey.base.auth.model;

import java.io.Serializable;

/**
 * 模型的基类
 */
public abstract class Model implements Serializable {
	/**
	 *  Model.java
	 */
	private static final long serialVersionUID = -201518958553909803L;
	
	private String Id;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}
}
