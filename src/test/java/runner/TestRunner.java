package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:Features", // Features tel ls cucumber where feature files are stored  
		glue = {"stepDefinitions"}, //glue tells cucumber options where all step definitions class are stored or availible
		tags= {"@sqlquery"},// we can run all scenarios or one scenario with help of tags
		dryRun = false, // dryRun stes falls will check if all steps in senario has d//help to cehck all steps are writen or not 
		monochrome = true,//if set to ture, make consle output readable 
		strict= false,// if set to false will fail the execution if there are any pending or or undefined steps
		//format is used  to generate different types of reporting 
		format = {"pretty","html:target/cucumber-reports/cucumber-pretty",
		        "json:target/cucumber-reports/CucumberTestReport.json",
		        "rerun:target/cucumber-reports/rerun.txt"},
		plugin = "json:target/cucumber-reports/CucumberTestReport.json"
		
		
		)



public class TestRunner {
	
	
	

}
