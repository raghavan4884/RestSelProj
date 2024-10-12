package com.test.utilities;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class General18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		WebDriver driver=new ChromeDriver(c);
		driver.get("D:\\4.html");
		WebElement element=driver.findElement(By.tagName("table"));
		List<WebElement> rowElements=driver.findElements(By.tagName("tr"));
		boolean b=false;
		/*for(int i=0;i<rowElements.size();i++)
		{
			List<WebElement> colElements=rowElements.get(i).findElements(By.tagName("td"));
			for(int j=0;j<colElements.size();j++)
			{
				//System.out.println(colElements.get(j).getText());
				if(colElements.get(j).getText().equals("2"))
				{
					System.out.println(colElements.get(j).getText());
					System.out.println("hi");
					WebElement element2=colElements.get(j).findElement(By.xpath("//td[contains(text(),'"+colElements.get(j).getText()+"')]/following::td"));
					System.out.println(element2.getText());
				}
			}
		}*/
		
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		

		for(WebElement row:rowElements)
		{
			List<WebElement> colElements=row.findElements(By.tagName("td"));
				for(WebElement col:colElements)
				{
					//System.out.println(col.getText());
					
					if(col.getText().equals("2")){
						WebElement ele=col.findElement(By.xpath("//td[contains(text(),'"+col.getText()+"')]/following::td"));
						System.out.println(ele.getText());
						
					}
					
				}
		}
	}

}
