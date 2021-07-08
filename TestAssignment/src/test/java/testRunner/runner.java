package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/Features/NewRegistration.feature",

glue = {
		"StepDefinations", }, dryRun = false, monochrome = true)

public class runner {

}
