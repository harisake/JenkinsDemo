package com.test.framework.OnlineShoping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.auto.framework.locators.EcommersLocators;
import com.test.auto.framework.util.TestContext;
import com.test.pom.Page;
import com.test.pom.factory.DefaultPageFactory;

public class BookHomePage extends Page {


	TestContext context = TestContext.getContext();

	@Override
	public void open(Object... arguments) {

	}

	@Override
	public void assertIsOpen(Object... arguments) throws AssertionError {

	}

	public WebElement getSearchText() {
		try {
			return context.getWebDriver().findElement(By.id(EcommersLocators.BookHomePageLoc.SEARCHBOX));
		} catch (Exception e) {
			return null;

		}

	}
	
	
	public void getBook(String bookName) {
		try {
			getSearchText().sendKeys(bookName);
			
		} catch (Exception e) {
			
		}

	}
	
	public WebElement getSearchicon() {
		try {
			return context.getWebDriver().findElement(By.id(EcommersLocators.BookHomePageLoc.SEARCHBOX));
			
		} catch (Exception e) {
			
			return null;
		}

	}
	
	
	

}
