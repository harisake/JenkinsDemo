package com.test.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import com.test.pom.Page;

public interface PageFactory {
	/**
	 * Initializes a {@link Page} and optionally waits for the page to load.
	 * @param pageClass
	 * @param waitForPageLoad
	 * @param decorator
	 * @param arguments
	 * @return the created page
	 * @throws AssertionError
	 */
	<T extends Page> T create(Class<T> pageClass, boolean waitForPageLoad, FieldDecorator decorator, Object...arguments) throws AssertionError;
	/**
	 * Initializes a {@link Page} and optionally waits for the page to load.
	 * @param pageClass
	 * @param waitForPageLoad
	 * @param driver
	 * @param arguments
	 * @return the created page
	 * @throws AssertionError
	 */
	<T extends Page> T create(Class<T> pageClass, boolean waitForPageLoad, WebDriver driver, Object...arguments) throws AssertionError;
	
	/**
	 * Initializes a {@link Page} and optionally waits for the page to load.
	 * @param pageClass
	 * @param waitForPageLoad
	 * @param arguments
	 * @return the created page
	 * @throws AssertionError
	 */
	<T extends Page> T create(Class<T> pageClass, boolean waitForPageLoad, Object...arguments) throws AssertionError; 

}
