package com.ysj.tinyspring.context;

import com.ysj.tinyspring.HelloWorldService;
import org.junit.Test;

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