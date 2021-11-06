package com.test.pom;



import org.openqa.selenium.WebDriver;

import com.github.webdriverextensions.WebDriverExtensionsContext;

public final class POM {
	private POM() {
	}
	
	/**
	 * Sets the singleton driver instance to enable page object functionality
	 * @param driver
	 */
	public static void setDriver(WebDriver driver) {
		WebDriverExtensionsContext.setDriver(driver);
	}
	
	/**
	 * Gets the singleton driver instance for page objects
	 * @return driver
	 */
	public static WebDriver getWebDriver() {
		return WebDriverExtensionsContext.getDriver();
	}
}
