package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Activity1 runnerfile
/*@CucumberOptions(
features = "Features",
glue = {"stepDefinitions"},
tags = "@activity1_1"
)
-----Activity2 runner file
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tag = "@activity1_2"
	)

-----Activity3 Runner file:
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SmokeTest",
    strict = true
)
---Activity4 Runner file
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tag = "@activity2_4"
)
----Activity5 Runner File

@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity2_5"
)
---Activity6 Runner file to generate html report
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@SmokeTest",
    plugin = {"html: test-reports"},
    monochrome = true
)
*/
//Activity6 Runner file to generate json report
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@SmokeTest",
        plugin = {"pretty","json: test-reports/json-report.json"},
        monochrome = true
)

//public class ActivitiesRunner {}
public class ActivitiesRunner {
}
