package com.ysj.tinyspring.context;

import org.junit.Test;

import com.ysj.tinyspring.HelloWorldService;
import com.ysj.tinyspring.context.ApplicationContext;
import com.ysj.tinyspring.context.ClassPathXmlApplicationContext;

/**
 * @author yihua.huang@dianping.com
 */
public class ApplicationContextTest {
	
	@Test
	public void test() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
		// OutputService outputService = (OutputService) applicationContext.getBean("outputService");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		
		// Assert.assertNotNull(helloWorldService);
		helloWorldService.helloWorld();
	}

	@Test
	public void testPostBeanProcessor() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc-postbeanprocessor.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
