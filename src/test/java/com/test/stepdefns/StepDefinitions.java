package com.test.stepdefns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.test.selenium.BrowserMethods;
import com.test.utilities.ExcelHandling;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class StepDefinitions {

	public long aa;
	static WebDriver driver;
	public Workbook workbook;
    public Sheet sheet;
	BrowserMethods bm=new BrowserMethods();
	@Given("that I open the {string} browser")
	public void i_open_the_browser(String browser) {
	    // Write code here that turns the phrase above into concrete actions
		bm.openBrowser(browser);
	}
	@When("I enter the {string}")
	public void i_enter_the(String url) {
	    // Write code here that turns the phrase above into concrete actions
		bm.openUrl(url);
	}

	@When("I enter")
	public void i_enter(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.

		List<Map<String,String>> data=dataTable.asMaps(String.class,String.class);
		String url=data.get(0).get("url");
		bm.openUrl(url);
	}
	
	
	
	@Given("that I get the time")
	public void that_i_get_the_time() {
	    // Write code here that turns the phrase above into concrete actions
		long bb=56;
		long cc=33;
		aa=bb+cc;
	}
	@Then("i display the time")
	public void i_display_the_time() {
	    // Write code here that turns the phrase above into concrete actions
	System.out.println("time is" + aa);
		
	}

	@Given("that the user enter the url {string}")
	public void that_the_user_enter_the_url(String url) {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--AcceptRemoteOrigin");
		driver=new ChromeDriver(c);
		driver.get(url);
		
	}

	@When("the user enters the value in {string} row {string} textbox")
	public void the_user_enters_the_value_in_row_textbox(String sheetName, String row)
	{
		ExcelHandling ec=new ExcelHandling();
		
		try
		{
	    // Write code here that turns the phrase above into concrete actions
	    WebElement element=driver.findElement(By.xpath("//textarea[@title='Search']"));
	    
	    String fileName="D:\\Book2.xlsx";
	    int r=Integer.parseInt(row);
	   String searchString=ec.getStringValue(fileName, sheetName, r, 0);
	    
	    //String =sheet.getRow(r).getCell(0).getStringCellValue();
	    System.out.println(searchString);
	    element.sendKeys(searchString);
	    Actions actions=new Actions(driver);
	    actions.sendKeys(element,Keys.ENTER).build().perform();
	    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



	@When("I enter the values")
	public void i_enter_the_values(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	List<Map<String,String>> data=dataTable.asMaps(String.class,String.class);
	String sheetName=data.get(0).get("Sheet");	
	String row=data.get(0).get("row");
	System.out.println(sheetName);
	System.out.println(row);
	ExcelHandling ec=new ExcelHandling();
	int r=Integer.parseInt(row);
	String fileName="D:\\Book2.xlsx";
	String s=ec.getStringValue(fileName, sheetName, r,0);
	System.out.println(s);
	//WebElement element=driver.findElement(By.xpath("//textarea[@title='Search']"));
	}



	



	



	
	

}
