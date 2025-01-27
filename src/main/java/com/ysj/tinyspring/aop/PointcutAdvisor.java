package com.ysj.tinyspring.aop;

/**
 * 切点通知器
 */
public interface PointcutAdvisor extends Advisor {

    /**
     * 获得切点
     *
     * @return
     */
    Pointcut getPointcut();
}