package com.hrms.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features"  // /Login.feature
		, glue = "com/hrms/steps"
		, dryRun = true
		, plugin="pretty"
		,monochrome = true
		//,tags= {"@smoke"}
		)


public class RunnerClass {

}
