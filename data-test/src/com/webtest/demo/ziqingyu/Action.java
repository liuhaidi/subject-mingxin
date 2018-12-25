package com.webtest.demo.ziqingyu;

import java.io.IOException;

import com.webtest.core.WebDriverEngine;
import com.webtest.utils.ReadProperties;

public class Action {
	WebDriverEngine webtest = null;
	public Action(WebDriverEngine webtest) {
		this.webtest = webtest;
	}
	//��¼
	public void openurl(String name) throws IOException {
		webtest.open(ReadProperties.getPropertyValue("ziqingyu_url"));
		webtest.click("link=��¼");
		webtest.type("xpath=//input[@name='userNickName']", name);
		webtest.click("xpath=//input[@value='submit']");
	}
	//ɸѡ��ʱ��
	public void shaixuan1(String fenlei) throws IOException {
		openurl("�Ŵ���");
		webtest.selectByValue("xpath=//select[@name='fenlei']", fenlei);
		webtest.click("xpath=/html/body/div[1]/div[1]/div/form/div/div/span[2]");
		webtest.click("xpath=/html/body/div[2]/div[3]/table/thead/tr[1]/th[1]/i");
		webtest.click("xpath=/html/body/div[2]/div[3]/table/tbody/tr[5]/td[2]");
		webtest.click("xpath=/html/body/div[1]/div[1]/div/form/button");
	}
	//ɸѡ��ʱ��
	public void shaixuan2(String fenlei) throws IOException {
		openurl("�Ŵ���");
		webtest.selectByValue("xpath=//select[@name='fenlei']", fenlei);
		webtest.click("xpath=/html/body/div[1]/div[1]/div/form/button");
	}
	//ԤԼ
	public void yuyue1() throws IOException {
		openurl("���ž�");
		webtest.click("link=15:00");
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.click("xpath=//button[@id='confirmed-btn']");
		webtest.click("xpath=//input[@value='BOCO-NET']");
		webtest.click("xpath=//button[@class='btn btn-block ']");
		webtest.pause(5000);
	}
	public void yuyue2() throws IOException {
		openurl("���ž�");
		webtest.click("link=11:00");
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.click("xpath=//button[@id='confirmed-btn']");
		webtest.click("xpath=//input[@value='BOCO-NET']");
		webtest.click("xpath=//button[@class='btn btn-block ']");
		webtest.pause(5000);
		//����enter��
		webtest.enterClick();
		webtest.pause(5000);
	}
	//С��ʿ
	public void xiaotieshi1() throws IOException {
		openurl("���ž�");
		webtest.click("link=11:00");
		webtest.click("xpath=//input[@id='pro1']");
	}
	public void xiaotieshi2() throws IOException {
		openurl("���ž�");
		webtest.click("link=11:00");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
	}
	public void xiaotieshi3() throws IOException {
		openurl("���ž�");
		webtest.click("link=11:00");
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
	}
	//֧������
	public void pay() throws IOException {
		openurl("���ž�");
		webtest.click("link=17:00");
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.click("xpath=//button[@id='confirmed-btn']");
		webtest.getText("class=tag");
		webtest.goBack();
		webtest.click("xpath=//input[@value='audio']");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.pause(5000);
		
		
	}
	//֧������
	public void dingdanhao() throws IOException {
			openurl("���ž�");
			webtest.click("link=17:00");
			webtest.click("xpath=//input[@value='audio']");
			webtest.click("xpath=//input[@id='pro1']");
			webtest.click("xpath=//input[@id='pro2']");
			webtest.click("xpath=//button[@id='confirmed-btn']");
			String a =webtest.getText("class=tag");
			System.out.println(a);
			webtest.goBack();
			webtest.click("xpath=//input[@value='audio']");
			webtest.click("xpath=//input[@id='pro1']");
			webtest.click("xpath=//input[@id='pro2']");
			webtest.click("xpath=//button[@id='confirmed-btn']");
			String b =webtest.getText("class=tag");
			System.out.println(b);
			
			
	}
	//����-ɸѡ
	public void Qshai(String sex,String age) throws IOException {
		openurl("�Ŵ���");
		webtest.click("link=����");
		webtest.selectByValue("xpath=//select[@name='gender']", sex);
		webtest.selectByValue("xpath=//select[@name='age']", age);
		webtest.click("xpath=//input[@value='ɸѡ']");
	}
	//����-��һ��
	public void huanyibo() throws IOException {
		openurl("�Ŵ���");
		webtest.click("link=����");
		webtest.click("xpath=//input[@value='��һ������']");
		
	}
	//����-֧��
	public void Qpay() throws IOException {
		openurl("�Ŵ���");
		webtest.click("link=����");
		webtest.click("link=˵������");
		webtest.click("xpath=//input[@id='pro1']");
		webtest.click("xpath=//input[@id='pro2']");
		webtest.click("xpath=//button[@id='confirmed-btn']");
		webtest.click("xpath=//input[@value='BCCB-NET']");
		webtest.click("xpath=//button[@class='btn btn-block ']");
		webtest.pause(3000);
		
	}
	//invite
	public void invite() throws IOException {
		openurl("�Ŵ���");
		webtest.pause(5000);
		webtest.click("link=ConsultationRecord [consultationrecordId=38, randomNum=5744346747, consultationrecordOrderTime=2018-12-25, consultationrecordStartTime=08:00, consultationrecordEndTime=20:00]");
		webtest.pause(5000);
		webtest.click("xpath=//button[@class='setup']");
		webtest.pause(10000);
	}
	
	


}
