package com.myproject.myproject;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@CucumberOptions(
    features = "src/test/resources/features",   // Path to feature files
    glue = "stepDefinitions",                   // Path to step definition classes
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reports
    monochrome = true                            // For better console output
)
public class TestRunnerJava {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

 
}

	

