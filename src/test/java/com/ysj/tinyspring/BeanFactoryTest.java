package com.ysj.tinyspring;

import java.util.Map;

import org.junit.Test;

import com.ysj.tinyspring.beans.BeanDefinition;
import com.ysj.tinyspring.beans.factory.AbstractBeanFactory;
import com.ysj.tinyspring.beans.factory.AutowireCapableBeanFactory;
import com.ysj.tinyspring.beans.io.ResourceLoader;
import com.ysj.tinyspring.beans.xml.XmlBeanDefinitionReader;

/**
 * @author yihua.huang@dianping.com
 */
public class BeanFactoryTest {

	@Test
	public void testLazy() throws Exception {
		// 1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

		// 2.初始化BeanFactory并注册bean
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}

		// 3.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}

	@Test
	public void testPreInstantiate() throws Exception {
		// 1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");

		// 2.初始化BeanFactory并注册bean
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}

		// 3.初始化bean
		beanFactory.preInstantiateSingletons();

		// 4.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
