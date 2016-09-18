package com.fanfan.system.xsd;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
/**
 * Created by Administrator on 2016/9/18.
 */

public class MyNamespaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("aty", new PersonBeanDefinitionParser());
    }
}
