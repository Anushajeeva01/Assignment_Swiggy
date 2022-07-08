package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/Features/Homepage.feature",
        glue="StepDefinitions",
        tags = "@regression" ,
        plugin= {"pretty", "html:target/cucumber-reports.html"},
        monochrome=true
        )
public class StepRunnerr {
 
}
