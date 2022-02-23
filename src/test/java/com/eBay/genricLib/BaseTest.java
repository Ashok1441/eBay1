package com.eBay.genricLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutoConsts {
	
	public static WebDriver driver;
	
	@Test(priority = 1)
	public void browser() throws Throwable {
		
		FileLib flib = new FileLib();
		String browserName=flib.readProprertyData(Prop_Path, "browserName");
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
		    driver= new EdgeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
		else {
			Reporter.log("Given Browser name is Mismatched", true);
		}
		
		String URL=flib.readProprertyData(Prop_Path, "url");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebdriverCommonLib wlib = new WebdriverCommonLib();
		String acHomeTitle=wlib.getPageTitle();
		String exHomeTitle="Electronics, Cars, Fashion, Collectibles & More | eBay";
		wlib.verfiy(acHomeTitle, exHomeTitle, "Title is mistached");
		
	}

}
