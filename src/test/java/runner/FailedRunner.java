package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	    features = "@target/rerun.txt", 
	    glue = "com.qa.stepDefinition",
	    	    monochrome = true,
	    	    plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	)
public class FailedRunner extends AbstractTestNGCucumberTests {

}
