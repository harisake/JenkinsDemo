package com.sample.stepdefinations;

import org.junit.Assert;

import com.test.auto.framework.browser.BrowserfactoryWithSupplier;
import com.test.auto.framework.helper.RESTheaders;
import com.test.auto.framework.helper.serviceFactory;
import com.test.framework.OnlineShoping.pages.BookHomePage;
import com.test.framework.OnlineShoping.pages.LoginPage;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

public class ShopingStepdefination {

	LoginPage loginPage;
	BookHomePage homePage;
	Response response;
	
	@Given("^I launched broeser with this URL$")
	public void i_call_the_space_data_service() throws Throwable {
		BrowserfactoryWithSupplier browserfactoryWithSupplier = new BrowserfactoryWithSupplier();
		loginPage = browserfactoryWithSupplier.navigateToLibLoginPage();
	}

	@When("^I entered valid us pwd and click on login button$")
	public void i_entered_valid_us_pwd_and_click_on_login_button() throws Throwable {
	   
		homePage=loginPage.doSuccessfulBooksLogin();
		Thread.sleep(1000);
	}

	@Then("^I should navigate to home page$")
	public void i_should_navigate_to_home_page() throws Throwable {
		homePage.getBook("git");
		homePage.getSearchicon().click();
	  
	}
	
	
	@Given("^I Give the End point URL$")
	public void i_Give_the_End_point_URL() throws Throwable {
serviceFactory.invokeRestService("REST_RELAXED_VAL_NO_FORM_PARAMS", "get", RESTheaders.getHeaderConnectJsonAcceptJson1(), "", "https://reqres.in/api/users?page=2", null, null);

		
		response = serviceFactory.invokeRestService("REST_RELAXED_VAL_NO_FORM_PARAMS", "post",
				RESTheaders.getHeaderConnectJsonAcceptJson1(), "", "", null, null);
		System.out.println("res***" + response.asString());
	}
	
	@When("I call the API Service")
	public void i_call_the_api_service() {
		serviceFactory.invokeRestService("REST_RELAXED_VAL_NO_FORM_PARAMS", "get", RESTheaders.getHeaderConnectJsonAcceptJson1(), "", "https://reqres.in/api/users?page=2", null, null);

		
		response = serviceFactory.invokeRestService("REST_RELAXED_VAL_NO_FORM_PARAMS", "post",
				RESTheaders.getHeaderConnectJsonAcceptJson1(), "", "", null, null);
		System.out.println("res***" + response.asString());
		
		//CommonStepDefination.assertResponseStatus(200, response);
	    
	}

	@Then("I will verify the response of the service")
	public void i_will_verify_the_response_of_the_service() {
		Assert.assertTrue("mis match of id !!! "+"Excepted :"+"605b4b95aa5433645e37d041" + "Actual :"+response.jsonPath().getString("body"),response.jsonPath().getString("body").equals("Sent from your Twilio trial account - 1234567"));
	 
	}

}
