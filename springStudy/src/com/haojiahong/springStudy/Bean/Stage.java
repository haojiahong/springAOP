package com.haojiahong.springStudy.Bean;

/**
 * ��̨��û�й����Ĺ��췽����ʹ��factory��method����getInstance��̬���������ص�����ʵ��
 * 
 * @author haojiahong
 * 
 * @createtime��2015-10-16 ����9:05:25
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
