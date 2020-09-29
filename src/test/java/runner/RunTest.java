package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="D:/Project/cucumber_with_selenium_01/Cucumber_with_Selenium_02/src/test/resources/features/HealthCheck.feature",
		glue = "stepdefs",
		tags = "@Wip",
		plugin = { "pretty", 
				"html:target/html/",
				"json:target/json/file.json",
		},
		publish = true,
		monochrome = true,
		dryRun = false
		)
public class RunTest {

}
