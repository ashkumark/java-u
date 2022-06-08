package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"bdd/steps", "bdd/hooks"},
        tags = "@processing",
        plugin = { "html:target/cucumber/cucumber-reports.html" }
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
