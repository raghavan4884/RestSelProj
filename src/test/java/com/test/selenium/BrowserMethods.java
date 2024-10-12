package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserMethods {

	public static WebDriver driver;
	
	
public WebDriver openBrowser(String browser)
	{
		switch (browser) {
		case "chrome":
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
			ChromeOptions c=new ChromeOptions();
			c.addArguments("--RemoteAcceptOrigin");
			driver=new ChromeDriver(c);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			
			
			break;
		}
		case "edge":
		{
			System.setProperty("webdriver.edge.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
			//firefoxOptions f=new FirefoxOptions();
			EdgeOptions c=new EdgeOptions();
			c.addArguments("--RemoteAcceptOrigin");
			driver=new EdgeDriver(c);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			
			break;
		}	
			

		default:
		{
			System.out.println("please enter correct values");
			break;
		}
			
		}
		
		return driver;
	}
	
	public void openIncognitioWindow()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		c.addArguments("--Incognito");
		c.setAcceptInsecureCerts(true);
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY,c );
		c.merge(cap);
		driver=new ChromeDriver(c);
	}
	public void openUrl(String url)
	{
	
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
	}
	public String getPgTitle()
	{
		return driver.getTitle();
	}
	public String getPgSource()
	{
		return driver.getPageSource();
	}
	public void navigateUrl(String url)
	{
		driver.navigate().to(url);
	}
	public void navigateBack()
	{
		driver.navigate().back();
	}
	public void navigateForward()
	{
		driver.navigate().forward();
	}
	public void navigateRefresh()
	{
		driver.navigate().refresh();
	}
	public void quitBrowser()
	{
		driver.quit();
		
	}
	public void closeBrowser()
	{
		driver.close();
	}
	
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	public void minimizeBrowser()
	{
		driver.manage().window().minimize();
	}
		
}
