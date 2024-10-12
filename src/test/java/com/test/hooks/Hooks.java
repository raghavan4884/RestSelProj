package com.test.hooks;

import java.io.IOException;

import com.test.selenium.BrowserMethods;
import com.test.selenium.ScreenshotMethods;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	BrowserMethods bm=new BrowserMethods();
	@Before
	public void beforeMethod()
	{
		System.out.println("before method");
	}
	@After
	public void afterMethod()
	{
		System.out.println("after method");
	}
	@Before(order=0)
	public void beforeMethod1()
	{
		System.out.println("before method1");	
	}
	@After(order=0)
	public void afterMethod1()
	{
		//bm.quitBrowser();
		System.out.println("after method1");
	}
	
	@Before("@smoke" )
	public void beforesmoke2()
	{
		System.out.println("before smoake");
	}
	
	@After("@smoke")
	public void afterSmoke2()
	{
		System.out.println("after smoke");
	}
	@Before("@regression" )
	public void beforesmok31()
	{
		System.out.println("before regression");
	}
	
	@After("@regression")
	public void afterSmoke3()
	{
		System.out.println("after regression");
	}
	@BeforeStep
	public void beforeStep()
	{
		System.out.println("before step");
		
	}
	@AfterStep
	public void afterStep(Scenario scenario) throws IOException
	{
		
		//ScreenshotMethods sm=new ScreenshotMethods();		
		//scenario.attach(sm.getScreenShots(), "image/png", null);
		System.out.println("After Step");
		
	}
	

}
