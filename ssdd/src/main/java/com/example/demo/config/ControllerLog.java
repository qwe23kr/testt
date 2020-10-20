package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Aspect
@Component
@Slf4j
public class ControllerLog {
	@Before("execution(* com.example.demo.controller.*Controller.*(..))")
	public void before(JoinPoint jp) {
		log.info("before");
	}
	@After("execution(* com.example.demo.controller.*Controller.*(..))")
	public void after(JoinPoint jp) {
		log.info("after");
	}

	@Around("execution(* com.example.demo.controller.*Controller.*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		log.info("controller=>{}", pjp.getSignature().getDeclaringTypeName() + "," + pjp.getSignature().getName());
		Object[] args = pjp.getArgs();
		String params = "";
		for (Object arg : args) {
			params += arg + ",";
		}
		log.info("params=>{}", params);
		long sTime = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long lTime = System.currentTimeMillis();
		long executeTime = lTime - sTime;
		log.info("executeTime=>{}", executeTime);
		return obj;
	}
}
