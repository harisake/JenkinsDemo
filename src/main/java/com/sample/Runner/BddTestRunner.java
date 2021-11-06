package com.sample.Runner;


import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;



import cucumber.api.CucumberOptions;

import cucumber.api.testng.TestNGCucumberRunner;



@CucumberOptions(tags={"@hari1"},glue = {"com.sample.stepdefinations"}, features = {"src/test/features"},
plugin = {"pretty",
		 "html:target/site/cucumber-pretty",
         "json:target/cucumber.json",
         "usage:target/cucumber-usage.json",
         "junit:target/cucumber-results.xml",
         "junit:target/cucumber-json-report.json"})


public class BddTestRunner {
	

	@Test()
    public void runCukes()
	{
		new TestNGCucumberRunner(getClass()).runCukes();
		
	}
	
	

}