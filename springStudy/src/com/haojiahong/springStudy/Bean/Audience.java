package com.haojiahong.springStudy.Bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * ���ڣ����棩
 * 
 * @author haojiahong
 * 
 * @createtime��2015-10-16 ����9:25:24
 * 
 * 
 */
@Component
//���audience���Ϊ�����桱������ķ�����Ϊ��֪ͨ�����������õķ�����ڵ��Ϊ���е㡱
@Aspect
public class Audience {

	// �е�
	@Pointcut("execution(* com.haojiahong.springStudy.Bean.Juggler.perform(..))")
	public void performance() {

	}

	/**
	 * ��Ա����֮ǰ(���������Ĺ�����Ϊ֪ͨ)
	 */
	@Before("performance()")
	public void takeSeats() {
		System.out.println("the audiences is taking their seats...");
	}

	/**
	 * ��Ա����֮ǰ
	 */
	@Before("performance()")
	public void turnOffCellPhone() {
		System.out.println("the audiences is taking their cell phone...");

	}

	/**
	 * ��Ա���ݳɹ�֮��
	 */
	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("the audience clap clap clap clap...");
	}

	/**
	 * ��Ա����ʧ��֮��
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
			System.out.println("�ݳ�ʱ��" + (end - start));
		} catch (Throwable e) {
			System.out.println("Boo!we want our money back!!!");
		}

	}
}
