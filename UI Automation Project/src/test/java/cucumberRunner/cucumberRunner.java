package cucumberRunner;

import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		tags = "@LinkTest",
		dryRun = false,
		plugin = { "pretty", "html:target/cucumber/report.html"},
		features = "src/test/java/features",
		glue = {"stepsDefinition", "cucumberHooks"},  
		monochrome = true
		)

public class cucumberRunner {

}
