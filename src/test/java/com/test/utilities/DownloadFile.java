package com.test.utilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadFile {
	
	public static void main(String args[])
	{
		System.setProperty("webdriver..chrome.driver", "D:\\Softwares\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		HashMap<String,Object> hm=new HashMap<String,Object>();
		hm.put("profile.default_content_settings.popup","0");
		hm.put("download.deafult_diectory","fiePath");
		c.setExperimentalOption("prefs", hm);
		WebDriver driver= new ChromeDriver(c);		
	}		
}
