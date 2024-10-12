package com.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="@target/rerun.txt",glue={"com.test.stepdefns","com.test.hooks"},monochrome=true,plugin={"pretty","json:target/report.json","html:target/report.html","junit:target/report.xml","rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class FailedRunner {

}
