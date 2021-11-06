package com.test.auto.framework.util;

import org.openqa.selenium.WebDriver;

import com.github.webdriverextensions.WebDriverExtensionsContext;
import com.test.pom.POM;

public class TestContext {
	
	private static WebDriver driver;
	
	
	private TestContext()
	{
		
	}
	
	// Singleton
		// private static TestContext me = null;

		private static final ThreadLocal<TestContext> me = new ThreadLocal<TestContext>() {
			@Override
			protected TestContext initialValue() {
				return new TestContext();
			}
		};
	
	/**
	 * Sets the WebDriver for the current test run.
	 * 
	 * @param wd
	 */
	public void setWebDriver(WebDriver wd) {
		
		driver = wd;
		WebDriverExtensionsContext.setDriver(driver);
		//POM.setDriver(driver);
	}
	
	/**
	 * Returns the singleton TestContext object.
	 * 
	 * @return
	 */
	public static TestContext getContext() {

		return me.get();
	}
	/**
	 * Returns the current WebDriver.
	 * 
	 * @return
	 */
	public WebDriver getWebDriver() {
		return driver;
	}
}
