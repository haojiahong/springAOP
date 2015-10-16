package com.haojiahong.springStudy.Bean;

/**
 * 舞台：没有公开的构造方法，使用factory—method调用getInstance静态方法，返回单例类实例
 * 
 * @author haojiahong
 * 
 * @createtime：2015-10-16 上午9:05:25
 * 
 * 
 */
public class Stage {
	private Stage() {

	}

	public static Stage getInstance() {
		return StageSingletonHolder.instance;
	}

	private static class StageSingletonHolder {
		static Stage instance = new Stage();
	}

}
