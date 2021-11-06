package com.test.auto.OnlineShopping;

import org.testng.annotations.Test;

import com.test.auto.framework.browser.BrowserfactoryWithSupplier;
import com.test.framework.OnlineShoping.pages.BookHomePage;
import com.test.framework.OnlineShoping.pages.LoginPage;


public class SearchProduct_Select {
	
	LoginPage loginPage;
	BookHomePage homePage;
	
	@Test
	void searchBook() throws InterruptedException
	{
		
		BrowserfactoryWithSupplier browserfactoryWithSupplier = new BrowserfactoryWithSupplier();
		loginPage = browserfactoryWithSupplier.navigateToLibLoginPage();
		homePage=loginPage.doSuccessfulBooksLogin();
		Thread.sleep(1000);
		homePage.getBook("git");
		homePage.getSearchicon().click();
	}
	

	
	
	
}
