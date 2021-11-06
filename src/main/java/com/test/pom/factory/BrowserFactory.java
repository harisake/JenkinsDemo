package com.test.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	
	private BrowserFactory()
	{
		
	}
	
	public static WebDriver getDriver(String browserType) {
		WebDriver driver = null ;
		
		if(browserType.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

}
