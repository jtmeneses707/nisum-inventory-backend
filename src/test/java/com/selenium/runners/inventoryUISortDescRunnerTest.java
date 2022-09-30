package com.selenium.runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/com/selenium/feature/inventoryUISortDescFeature.feature", glue = {"com/selenium/stepdefinitions"})

public class inventoryUISortDescRunnerTest {
}
