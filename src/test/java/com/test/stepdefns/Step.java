package com.test.stepdefns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Step {
	
	static WebDriver driver;
	@Given("that the user enters the {string}")
	public void that_the_user_enters_the(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		driver=new ChromeDriver(c);
		driver.get(string);
	}
	@Then("verify that the follwing values")
	public void verify_that_the_follwing_values(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		WebElement element=driver.findElement(By.tagName("select"));
		Select select=new Select(element);
		List<WebElement> optElements=select.getOptions();
		
		System.out.println("hi");
		List<String> ss=new ArrayList<>();
		int flag=0;
		//List<Integer> ss1=new ArrayList<>();
		for(Map<String,String> hm:dataTable.asMaps(String.class,String.class))
		{
			
			//ss.add(hm.get("cars"));
			//ss1.add(hm.get("price"));
			ss.add(hm.get("cars"));
		}
		for(WebElement e:optElements)
		{
			for(String s:ss)
			{
			if(e.getText().equals(s))
			{
				//System.out.println("equals");
				flag=1;
			}
			else
			{
				//System.out.println("not equals");
				flag=0;
			}
			}
		}
		if(flag==0)
		{
			System.out.println("Not Equals");
		}
		else
		{
			System.out.println("equals");
		}
		System.out.println(ss);
		//System.out.println(ss1);
		
	}






	@Then("verify that the following valu")
	public void verify_that_the_following_valu(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		/*List<Map<String,String>> mm=dataTable.asMaps(String .class,String.class);
		String cars=mm.get(0).get("cars");
		String proce=mm.get(0).get("price");
		System.out.println(cars);
		System.out.println(proce);*/
				
		List<String> al=new ArrayList<>();
		List<String> all=new ArrayList<>();
		Map<String,String> ww=new HashMap<>();
		
		//String a[][]={{"volvo","2000"},{"abcd","2000"}};
		for(Map<String, String> hm:dataTable.asMaps(String.class,String.class))
		{
			/*al.add(hm.get("cars"));
			all.add(hm.get("price"));*/
			ww.put(hm.get("cars"), hm.get("price"));
		}
		
		if(ww.containsKey("volvo")&&ww.get("volvo").equals("2000"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		System.out.println(ww);
		System.out.println(all);
				
	}





	@When("the user enters the {string} string in the {string}")
	public void the_user_enters_the_string_in_the(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement element=driver.findElement(By.name(string2));
		element.sendKeys(string);
		element.sendKeys(Keys.ENTER);
	}
	@Then("close the application")
	public void close_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.quit();
	}


	@Then("verify the following")
	public void verify_the_following(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		HashMap<String ,String> hm=new HashMap<>();
		for(Map<String,String> mm:dataTable.asMaps(String.class,String.class))
		{
			
		hm.put(mm.get("Lab"),mm.get("controlType") );
		
		}
		
		System.out.println(hm);
		
		for(String s:hm.keySet())
		{
			if(hm.get(s).equals("textbox"))
			{
				
			}
		}
		/*for(Map.Entry<String,String> ee:hm.entrySet())
		{
					
			
			
			if(hm.get("Lab").equals("textbox"))
{
	System.out.println("Pass");
}
			else
			{
				System.out.println("Fail");
			}
		}
*/
	}







}
