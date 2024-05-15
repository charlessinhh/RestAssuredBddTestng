package runner;

//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.TestNGCucumberRunner;

import org.junit.runner.RunWith;




import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/resources/features/HttpReqRes.feature",
	    glue = "com.qa.stepDefinition",
	    		dryRun = false,
	    	    monochrome = true,
	    	    tags = "@testNG",
	    	    plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
	)

public class RunCucumberTest {
	
	
}
