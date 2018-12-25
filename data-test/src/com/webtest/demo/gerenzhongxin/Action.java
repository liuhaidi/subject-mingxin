package com.webtest.demo.gerenzhongxin;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.webtest.core.WebDriverEngine;
import com.webtest.utils.ReadProperties;

public class Action {
	WebDriverEngine webtest = null;
	public Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	//������ҳ
	public void openURL() throws IOException {
		webtest.open(ReadProperties.getPropertyValue("gerenzhongxin_url"));
	}
	//ȡ��ԤԼ
	public void cancel1() throws IOException {
		openURL();
		webtest.click("xpath=/html/body/div[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/td[3]/span/button");
	}
	public void cancel2() throws IOException {
		openURL();
		webtest.click("xpath=/html/body/div[2]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/td[3]/span/button");
		webtest.click("link=��Ҫȡ��ԤԼ");
		webtest.click("link=��ȡ��");
	}
	//��������-������Ϣ
	public void jiben1(String name, String qianming) throws IOException {
		openURL();
		webtest.click("link=��������");
		webtest.click("xpath=//button[@id='essentialInfo']");
		webtest.typeAndClear("xpath=//input[@id='userNickName']", name);
		webtest.typeAndClear("xpath=//input[@id='userAutograph']", qianming);
		webtest.click("xpath=//button[@id='essentialInfo']");
		webtest.pause(500);
		
	}
	public void jiben2(String name, String qianming) throws IOException {
		openURL();
		webtest.click("link=��������");
		webtest.click("xpath=//button[@id='essentialInfo']");
		webtest.typeAndClear("xpath=//input[@id='userNickName']", name);
		webtest.click("xpath=//input[@id='male']");
		webtest.typeAndClear("xpath=//input[@id='userAutograph']", qianming);
		webtest.click("xpath=//button[@id='essentialInfo']");
		
	}
	//��������-ʵ����Ϣ
	public void shiming(String name,String number) throws IOException {
		openURL();
		webtest.click("link=��������");
		webtest.click("xpath=//button[@id='realName']");
		webtest.typeAndClear("xpath=//input[@name='idName']", name);
		webtest.typeAndClear("xpath=//input[@name='idNum']", number);
	}
	//��������-�޸�����
	public void mima(String oldPwd,String newPwd,String confirmPwd) throws IOException {
		openURL();
		webtest.click("link=��������");
		webtest.click("link=�޸�����");
		webtest.type("xpath=//input[@name='oldPwd']", oldPwd);
		webtest.type("xpath=//input[@name='newPwd']", newPwd);
		webtest.type("xpath=//input[@name='confirmPwd']", confirmPwd);
	
	}
	//��������-���ֻ�
	public void phone(String phonenumber) throws IOException {
		openURL();
		webtest.click("link=��������");
		webtest.click("link=���ֻ�");
		webtest.type("xpath=//input[@name='phoneNum']",phonenumber );
	}
	//��¼��ʱ��
	public void jilu() throws IOException {
		openURL();
		webtest.click("link=��¼��ʱ�� ");
	}
	//�˳���¼
	public void tuichu() throws IOException {
		openURL();
		webtest.click("xpath=//img[@id='avatar']");
		webtest.click("link=�˳���¼");
	}
	//��¼ע��
	public void login() throws IOException {
		openURL();
		webtest.click("xpath=//img[@id='avatar']");
		webtest.click("link=�˳���¼");
		webtest.click("link=��¼/ע��");
	}
	
	


}
