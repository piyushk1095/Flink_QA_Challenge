package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"resources/feature/"},
        glue= {"com.glue"},
        plugin = { "html:target/cucumber-html-reports/report.html"},
        strict = true

)
public class TestRunner {
}
