package com.ysj.tinyspring.aop;

import com.ysj.tinyspring.HelloWorldServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import com.ysj.tinyspring.HelloWorldService;
import com.ysj.tinyspring.aop.AspectJExpressionPointcut;

/**
 * @author yihua.huang@dianping.com
 */
public class AspectJExpressionPointcutTest {

	@Test
	public void testClassFilter() throws Exception {
		String expression = "execution(* us.codecraft.tinyioc.*.*(..))";
		AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
		aspectJExpressionPointcut.setExpression(expression);
		boolean matches = aspectJExpressionPointcut.getClassFilter().matches(HelloWorldService.class);
		Assert.assertTrue(matches);
	}

	@Test
	public void testMethodInterceptor() throws Exception {
		String expression = "execution(* com.ysj.*.*(..))";
		AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
		aspectJExpressionPointcut.setExpression(expression);
		boolean matches = aspectJExpressionPointcut.getMethodMatcher()
				.matches(HelloWorldServiceImpl.class.getDeclaredMethod("helloWorld"), HelloWorldServiceImpl.class);
		Assert.assertTrue(matches);
	}
}
