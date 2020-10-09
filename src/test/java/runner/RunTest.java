package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="classpath:features",
		glue = "stepdefs",
		tags = "@Wip5",
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











