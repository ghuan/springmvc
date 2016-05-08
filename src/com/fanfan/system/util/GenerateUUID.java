package com.fanfan.system.util;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * 
* Copy right huan.gao 2015-7-9下午10:07:25
* All right reserved
* QQ:2223486623 
* description：自定义主键生成策略UUID
* 由于hibernate4 不建议使用老版本自带的uuid、uuid.hex，而uuid2又是36位的
* 所以这里采用实现IdentifierGenerator来自定义主键生成策略
 */
public class GenerateUUID implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString().replace("-", "");
	}

}
