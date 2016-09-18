package com.fanfan.system.xsd;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
/**
 * Created by Administrator on 2016/9/18.
 */
public class PersonBeanDefinitionParser implements BeanDefinitionParser {
    public BeanDefinition parse(Element element, ParserContext context)
    {
        RootBeanDefinition def = new RootBeanDefinition();

        // 设置Bean Class
        def.setBeanClass(Person.class);

        // 注册ID属性
        String id = element.getAttribute("id");
        BeanDefinitionHolder idHolder = new BeanDefinitionHolder(def, id);
        BeanDefinitionReaderUtils.registerBeanDefinition(idHolder,
                context.getRegistry());

        // 注册属性
        String name = element.getAttribute("name");
        String age = element.getAttribute("age");

        BeanDefinitionHolder nameHolder = new BeanDefinitionHolder(def, name);
        BeanDefinitionHolder ageHolder = new BeanDefinitionHolder(def,
                age);

        BeanDefinitionReaderUtils.registerBeanDefinition(nameHolder,
                context.getRegistry());
        BeanDefinitionReaderUtils.registerBeanDefinition(ageHolder,
                context.getRegistry());

        def.getPropertyValues().addPropertyValue("name", name);
        def.getPropertyValues().addPropertyValue("age", Integer.parseInt(age));

        return def;
    }
}
