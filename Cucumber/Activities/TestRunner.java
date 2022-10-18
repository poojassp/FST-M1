package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinition"},
        tags = "@BasicScenario1",
        plugin = {
                "pretty",
                "html:reports/HTML_report.html",
                "junit:reports/JSON_report.json",
                "junit:reports/XML_report.xml"
        }
)
public class TestRunner {

}
