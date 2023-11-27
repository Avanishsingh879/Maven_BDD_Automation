package Testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = {"src/test/resources/features/"},
		tags={"@Analytics_2"},
		glue = {"stepdefinition","Testrunner"}, 	
		plugin = {
	                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
	                "pretty",
	                "json:target/cucumber-reports/cucumber.json",
	                "html:target/cucumber-reports"
	        }
	
		 
	//	 plugin = {"json:target/cucumber-report/cucumber.json"}
		)

public class TestSuiterunner extends AbstractTestNGCucumberTests {

}
