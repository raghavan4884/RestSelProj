package com.test.utilities;

import java.net.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




public class GeneralUtils {
	
	public void getLocalTime()
	{
		DateTimeFormatter df=DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		df.format(now);
	}
	public void addMinutes()
	{
		try
		{
		String s="09:30";
		SimpleDateFormat st=new SimpleDateFormat("HH:mm");
		Date d=st.parse(s);
		Calendar cal=Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.MINUTE, 30);
		st.format(cal.getTime());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public void getBrokenLink(String linkName)
	{
	try {
		URL url=new URL(linkName);
		HttpURLConnection hc=(HttpURLConnection) url.openConnection();
		hc.setConnectTimeout(5000);
		hc.connect();
		hc.getResponseCode();
		hc.getResponseMessage();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}	
	}

	public void getBrokenImage(String imgName)
	{
		try {
			
			HttpClient client=(HttpClient) HttpClientBuilder.create().build();
			HttpGet request=new HttpGet(imgName);
			HttpResponse response=client.execute(request);
			response.getStatusLine().getStatusCode();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public boolean verifyCorrectBrowser(String title)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver();
		Set<String> windowNames=driver.getWindowHandles();
		ArrayList<String> l=new ArrayList<String>(windowNames);
		for (String window : windowNames) {
			String pgTitle=driver.switchTo().window(window).getTitle();
			if(pgTitle.equals(title))
			{
				return true;
			}
			
		}
		return false;
	}
	public boolean handleWebTable(String value)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver();
		WebElement tabElement=driver.findElement(By.tagName("table"));
		List<WebElement> rowElement=tabElement.findElements(By.tagName("tr"));
		for (WebElement row : rowElement) {
			List<WebElement> colElement=row.findElements(By.tagName("td"));
			for (WebElement cols : colElement) {
				{
					if(cols.getText().equals(value))
					{
						return true;
					}
				}
			}
			
		}
		return false;
	}
}
