package com.eBay.genricLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebdriverCommonLib {
	
	public String getPageTitle() {
		String pageTitle=BaseTest.driver.getTitle();
		return pageTitle;
		
	}
	public void verfiy(String actual, String excepted, String page) {
		Assert.assertEquals(actual, excepted, page);
		//Reporter.log(page+" is Displayed, PASS", true);
		
	}
	public void selectOption(WebElement eleAdd, String value) {
		Select sel= new Select(eleAdd);
		sel.selectByValue(value);
	}
	
	public void selectOption(WebElement eleAdd, int index) {
		Select sel= new Select(eleAdd);
		sel.selectByIndex(index);;
	}
	
	public void selectOption(String text, WebElement eleAdd) {
		Select sel= new Select(eleAdd);
		sel.selectByValue(text);
	}
	
	public void mouseHover(WebElement eleAdd) {
		Actions ac = new Actions(BaseTest.driver);
		ac.moveToElement(eleAdd).perform();
		
	}
	public void rightClick(WebElement eleAdd) {
		Actions ac = new Actions(BaseTest.driver);
		ac.contextClick(eleAdd).perform();
	}
	
	public void actionsClass() {
		Actions ac = new Actions(BaseTest.driver);
	}
	
	public void getFullPageScreenshot(String ScreenshotPath) {
		TakesScreenshot ts = (TakesScreenshot) BaseTest.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(ScreenshotPath);
		try {
			Files.copy(src, dest);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElement(By element) {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}





























