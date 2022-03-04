package runner;

import org.testng.annotations.DataProvider;

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
//	@DataProvider(parallel = true)
//	public Object[][] scenarios(){
//		return super.scenarios();
		
	//}
}
