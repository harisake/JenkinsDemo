package com.test.auto.framework.browser;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.auto.framework.util.TestContext;
import com.test.framework.OnlineShoping.pages.LoginPage;
import com.test.pom.factory.DefaultPageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserfactoryWithSupplier {
	
	LoginPage loginpage;
	WebDriver driver;
	public DefaultPageFactory factory = new DefaultPageFactory();
	TestContext context = TestContext.getContext();
	
	public BrowserfactoryWithSupplier()
	{
		
	}
	
	private final static Supplier<WebDriver> CHROME = ()-> {
		
		WebDriverManager.chromedriver().setup();
		
		return new ChromeDriver();
	};
	
	
	private final static Supplier<WebDriver> FIREFOX = ()-> {
		
		WebDriverManager.firefoxdriver().setup();
		
		return new FirefoxDriver();
	};

	private static final Map<BrowsersType,Supplier<WebDriver>>  browserMap = new EnumMap<>(BrowsersType.class);
	
	static 
	{
		browserMap.put(BrowsersType.CHROME,CHROME);
		browserMap.put(BrowsersType.FIREFOX,FIREFOX);
	}
	
	public static WebDriver getDriver(BrowsersType browserType)
	{
		return browserMap.get(browserType).get();
	}
	
	public LoginPage navigateToLibLoginPage()
	{
		
		
		driver = BrowserfactoryWithSupplier.getDriver(BrowsersType.CHROME);
		context.setWebDriver(driver);
		driver.get("https://www.demoqa.com/books");
		driver.findElement(By.id("login")).click(); 
		return factory.create(LoginPage.class, true);
	}
	
	
}
