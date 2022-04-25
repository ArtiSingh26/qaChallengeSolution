package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@PageContentTest",
        monochrome = true,
        dryRun = false,
        plugin = { "pretty", "html:target/cucumber-reports" },
        features = {"classpath:Features/factorial.feature"},
        glue = {"FactorialStepDefinition"})

public class cucumberRunner {
}
