package com.webtest.demo.ziqingyu;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class QingtingshaiTest extends BaseTest{
	@Test(priority = 0)
	public void shaixuan1() throws IOException {
		Action action = new Action(webtest);
		action.Qshai("Ů", "default");
		assertTrue(webtest.ifContains("˵������"));
	}
	@Test(priority = 1)
	public void shaixuan2() throws IOException {
		Action action = new Action(webtest);
		action.Qshai("default", "30-40");
		assertTrue(webtest.ifContains("˵������"));
	}
	@Test(priority = 2)
	public void shaixuan3() throws IOException {
		Action action = new Action(webtest);
		action.Qshai("��", "30-40");
		assertTrue(webtest.ifContains("˵������"));
	}



}
