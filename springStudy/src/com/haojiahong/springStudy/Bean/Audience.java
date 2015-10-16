package com.haojiahong.springStudy.Bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 观众（切面）
 * 
 * @author haojiahong
 * 
 * @createtime：2015-10-16 上午9:25:24
 * 
 * 
 */
@Component
//这个audience类称为“切面”，切面的方法称为“通知”，切面作用的方法入口点称为“切点”
@Aspect
public class Audience {

	// 切点
	@Pointcut("execution(* com.haojiahong.springStudy.Bean.Juggler.perform(..))")
	public void performance() {

	}

	/**
	 * 演员表演之前(切面所做的工作称为通知)
	 */
	@Before("performance()")
	public void takeSeats() {
		System.out.println("the audiences is taking their seats...");
	}

	/**
	 * 演员表演之前
	 */
	@Before("performance()")
	public void turnOffCellPhone() {
		System.out.println("the audiences is taking their cell phone...");

	}

	/**
	 * 演员表演成功之后
	 */
	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("the audience clap clap clap clap...");
	}

	/**
	 * 演员表演失败之后
	 */
	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Boo!we want our money back!!!");
	}

	public void watchPerformance(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("the audiences is taking their seats...");
			System.out.println("the audiences is taking their cell phone...");
			long start = System.currentTimeMillis();
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println("the audience clap clap clap clap...");
			System.out.println("演出时间" + (end - start));
		} catch (Throwable e) {
			System.out.println("Boo!we want our money back!!!");
		}

	}
}
