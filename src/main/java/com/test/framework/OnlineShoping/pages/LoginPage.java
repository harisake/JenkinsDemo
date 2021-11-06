package com.test.framework.OnlineShoping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.auto.framework.browser.BrowserfactoryWithSupplier;
import com.test.auto.framework.browser.BrowsersType;
import com.test.auto.framework.customException.ExecutionTimeException;
import com.test.auto.framework.locators.EcommersLocators;
import com.test.auto.framework.util.TestContext;
import com.test.pom.Page;
import com.test.pom.factory.DefaultPageFactory;

public class LoginPage extends Page {
	
	TestContext context = TestContext.getContext();
	public DefaultPageFactory factory = new DefaultPageFactory();
	LoginPage loginpage;

	BrowserfactoryWithSupplier browserfactoryWithSupplier = new BrowserfactoryWithSupplier();
	@Override
	public void assertIsOpen(Object... arguments) throws AssertionError {
		
	}

	
	
	public BookHomePage doSuccessfulBooksLogin()
	{
		
		//loginpage = browserfactoryWithSupplier.navigateToLibLoginPage();
		getUserIdField().sendKeys("brajusr");;
		getPasswordField().sendKeys("Welcome*123");
		getLoginButtonField().click();
		return factory.create(BookHomePage.class, true);
	}
	
	public WebElement getUserIdField() {
		try {
			
			return context.getWebDriver().findElement(By.id(EcommersLocators.LoginPage.USER_ID));
		} catch (Throwable ex) {
			throw new ExecutionTimeException(
					"Books Login Page : User ID Field is absent / got changed on the webpage.");
		}
	}

	public WebElement getPasswordField() {
		try {
		
			return context.getWebDriver().findElement(By.id(EcommersLocators.LoginPage.PASSWORD));
		} catch (Throwable ex) {
			throw new ExecutionTimeException(
					"Books Login Page : User ID Field is absent / got changed on the webpage.");
		}
	}
	
	
	public WebElement getLoginButtonField() {
		try {
		
			return context.getWebDriver().findElement(By.id(EcommersLocators.LoginPage.LOGIN_BUTTON));
		} catch (Throwable ex) {
			throw new ExecutionTimeException(
					"Books Login Page : User ID Field is absent / got changed on the webpage.");
		}
	}
	
	
	
	
}
