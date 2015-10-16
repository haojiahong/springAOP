package com.haojiahong.springStudy.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.haojiahong.springStudy.Bean.Stage;
import com.haojiahong.springStudy.service.Performer;

public class SpringStudyTest {
	ApplicationContext ctx = null;

	@Before
	public void setUp() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testJuggler() {
		Performer performer = (Performer) ctx.getBean("juggler");
		Performer performer2 = (Performer) ctx.getBean("juggler");
		System.out.println(performer);
		System.out.println(performer2);// springÈÝÆ÷Ä¬ÈÏµ¥Àý

		performer.perform();
	}

	@Test
	public void testStage() {
		Stage stage = (Stage) ctx.getBean("theStage");
		System.out.println(stage);
		Stage stage2 = (Stage) ctx.getBean("theStage");
		System.out.println(stage2);
	}
}
