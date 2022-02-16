package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src//test//resources//Features",
		glue = {"stepdefinitions" }, 
		dryRun = false, 
		monochrome = true, 
		plugin = { "pretty",
				"html:targer/reports/htmlreports.html",

})

public class Feature1Runner extends AbstractTestNGCucumberTests {

}
