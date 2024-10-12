package com.test.stepdefns;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.test.selenium.BrowserMethods;
import com.test.utilities.ExcelUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class General2  {

	
	
	ExcelUtils eu=new ExcelUtils();
	
	public static WebDriver driver;
/*	BrowserMethods bm=new BrowserMethods();
	WebEleme
*/	


	@Given("that the user enters the url and searchString and verify the title from {string} in {string}")
	public void that_the_user_enters_the_url_and_search_string_and_verify_the_title_from_in(String string, String string2) throws IOException {
	    // Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		int row=Integer.parseInt(string2);		
		
			driver=new ChromeDriver(c);
			driver.manage().window().maximize();
			driver.get(eu.getValue("D:\\Book5.xlsx", string, row, 0));
			WebElement element=driver.findElement(By.name("q"));
			element.sendKeys(eu.getValue("D:\\Book5.xlsx", string, row, 1));			
			element.sendKeys(Keys.ENTER);
			String title=eu.getValue("D:\\Book5.xlsx", string, row, 2);
			String s=title.equals(driver.getTitle())?"equals":"NotEquals";
			System.out.println(s);
				

	}





	



	
	@Given("that the user enters the url from {string} in {string} in {string}")
	public void that_the_user_enters_the_url_from_in_in(String string, String string2, String string3) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		int row=eu.getTotalRows(string, string2);
		//int col=eu
			
		for(int i=1;i<row;i++)
		{
			driver=new ChromeDriver(c);
			driver.manage().window().maximize();
			driver.get(eu.getValue(string, string2, i, 0));
			WebElement element=driver.findElement(By.name("q"));
			element.sendKeys(eu.getValue(string,string2,i,1));
			element.sendKeys(Keys.ENTER);
			
		}
		
			
	}
	@When("the user enters the searchString from {string} in {string} in {string}")
	public void the_user_enters_the_search_string_from_in_in(String string, String string2, String string3) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement element;
		int row=eu.getTotalRows(string, string2);
		int col=Integer.parseInt(string3);
		for(int i=1;i<row;i++)
		{
			
			element=driver.findElement(By.name("q"));
			element.sendKeys(eu.getValue(string,string2,row,col));
			
		}
		

	}
	@Then("verify that the title {string} in {string} in {string}")
	public void verify_that_the_title_in_in(String string, String string2, String string3) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		int row=eu.getTotalRows(string, string2);
		int col=Integer.parseInt(string3);
		String title="";
		for(int i=1;i<row;i++)
		{
			System.out.println(driver.getTitle());
			
		}
		
	}
	
	@Then("I close the browser")
	public void i_close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		//bm.quitBrowser();
		driver.quit();
	}



	@Given("that the user enters the url {string}")
	public void that_the_user_enters_the_url(String string) {
	    // Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		driver=new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.get(string);

		/*bm.openBrowser("chrome");
		bm.maximizeBrowser();
		bm.openUrl(string);
*/
			
		
	}
@When("the user enters the searchString {string}")
	public void the_user_enters_the_search_string(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	
		WebElement element=driver.findElement(By.name("q"));
		System.out.println(string);				
		element.sendKeys(string);
		element.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	@Then("verify that the title {string}")
	public void verify_that_the_title(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(driver.getTitle());
		String ss=driver.getTitle().equals(string)?"Equal":"NotEqual";
		System.out.println(ss);
		
	}



	




}
