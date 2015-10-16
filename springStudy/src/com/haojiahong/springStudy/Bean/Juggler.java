package com.haojiahong.springStudy.Bean;

import org.springframework.stereotype.Component;

import com.haojiahong.springStudy.service.Performer;

/**
 * 杂技表演者
 * 
 * @author haojiahong
 * 
 * @createtime：2015-10-16 上午8:39:44
 * 
 * 
 */
@Component("juggler")
public class Juggler implements Performer {
	private int beanBags;

	public Juggler() {
	}

	public Juggler(int beanBags) {
		this.beanBags = beanBags;
	}

	@Override
	public void perform() {
		System.out.println("juggler" + beanBags + "beanBags");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
