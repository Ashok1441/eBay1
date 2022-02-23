package com.eBay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eBay.genricLib.BaseTest;
import com.eBay.genricLib.WebdriverCommonLib;

public class RegisterPage {
	
	@FindBy(xpath="//a[text()='register']") WebElement register;
	@FindBy(id="ifhItem0") WebElement FAQs;
	@FindBy(id="ifhItem1") WebElement survey;

	public RegisterPage() {
		PageFactory.initElements(BaseTest.driver, this);
		
	}
	
	public void clickRegister() {
		register.click();
	}
	
	public void clickFAQs() {
		By ele = By.id("ifhItem0");
		WebdriverCommonLib wlib = new WebdriverCommonLib();
		wlib.waitForElement(ele);
		FAQs.click();
		
	
	}
	
	public void clickSurvey() {
		By ele = By.id("ifhItem1");
		WebdriverCommonLib wlib = new WebdriverCommonLib();
		wlib.waitForElement(ele);
		survey.click();
	
	}
	
	public void Register() {
		clickRegister();
		clickFAQs();
		clickSurvey();
	}
	
	
}
