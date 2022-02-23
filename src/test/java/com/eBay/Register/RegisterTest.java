package com.eBay.Register;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.eBay.genricLib.BaseTest;
import com.eBay.genricLib.WebdriverCommonLib;
import com.eBay.pages.RegisterPage;

public class RegisterTest {
	@Test
	public void test1() throws Throwable {
		
		BaseTest bt = new BaseTest();
		bt.browser();
		RegisterPage rp = new RegisterPage();
		rp.clickRegister();
		rp.clickFAQs();
		WebdriverCommonLib wlib = new WebdriverCommonLib();
		wlib.getFullPageScreenshot("D:\\Selenium\\eBay1\\Screenshot\\FAQs.png");
		rp.clickSurvey();
		wlib.getFullPageScreenshot("D:\\Selenium\\eBay1\\Screenshot\\Survey.png");
	}

}
