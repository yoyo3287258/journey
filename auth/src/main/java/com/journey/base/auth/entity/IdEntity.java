package com.journey.base.auth.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 统一定义id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * Oracle需要每个Entity独立定义id的SEQUCENCE时，不继承于本类而改为实现一个Idable的接口。
 * 
 * @author calvin
 */
//JPA 基类的标识
@MappedSuperclass
public abstract class IdEntity {

	@Id
	@GenericGenerator(name="uuid2" ,strategy="org.hibernate.id.UUIDHexGenerator")
	@GeneratedValue(strategy=GenerationType.AUTO ,generator="uuid2")
	protected String id;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
