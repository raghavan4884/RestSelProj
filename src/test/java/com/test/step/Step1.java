package com.test.step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.test.utilities.General33;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step1 {
	
public static WebDriver driver;
General33 g33=new General33();

	@Given("that I open the {string} browser")
	public void that_i_open_the_browser(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
	    ChromeOptions c=new ChromeOptions();
	    c.addArguments("RemoteAcceptOrigin");
	    driver=new ChromeDriver();
	}
	@When("I enter the {string}")
	public void i_enter_the(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(string);
	}

	@Then("I enter the value in {string} as {string} in {string} page")
	public void i_enter_the_value_in_as_in_page(String string, String string2, String string3) {
	    // Write code here that turns the phrase above into concrete actions
		//string =g33.getSearchTextBoxVal();
	    WebElement txt_Element=driver.findElement(By.xpath(string));
	    txt_Element.sendKeys(string2);
	    txt_Element.sendKeys(string3);
	}



	
	

}
