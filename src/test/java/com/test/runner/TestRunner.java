package com.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//@CucumberOptions(features="src/test/resources/Features1/5.feature",glue={"com.test.stepdefns","com.test.hooks"},monochrome=true,dryRun=false,plugin={"pretty","json:target/report.json","html:target/report.html","junit:target/report.xml","rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
@CucumberOptions(features="src/test/resources/Features2/1.feature",glue={"com.test.step"},monochrome=true,plugin={"pretty"})
public class TestRunner {

	

}
