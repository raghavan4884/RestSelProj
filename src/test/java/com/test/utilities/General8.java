package com.test.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class General8 {

	public static void main(String args[])
	{
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
	WebDriver driver=new ChromeDriver(c);
	driver.get("D:\\2.html");
	WebElement element=driver.findElement(By.name("cars"));
	Select select=new Select(element);
	List<WebElement> options=select.getOptions();	
	String a[]={"Volvo","Saab","Ambasador"};
	int flag=0;
	//for(int i=0;i<3;i++)
	//{
			
				//select.selectByVisibleText(options.get(i).getText());
				//System.out.println("equals"+a[j]);
				//break;
			
			
		
	//}
	
	for(WebElement opt:options)
	{
		//String b=null;
		System.out.println(opt.getText());
		for(String b:a)
		{
			if(opt.getText().equals(b))
			{
				//System.out.println("equals" +b);
				flag=1;
				
			}
			else 
			{
				//System.out.println("not equals" +b);
				flag=0;
			}
			if(flag==1)
			{
				System.out.println("equals" +b);
				
			}
			
		}
		//System.out.println("not equals"+opt.getText());	
	}
	
	}
	
}
