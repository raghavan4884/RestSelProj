package com.test.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class General26 {

	
	public static void main(String[] args) throws IOException {

		// TODO Auto-generated method stub
		
		String fileName="D:\\Book5.xlsx";
		String sheetName="search";
		FileInputStream fis=new FileInputStream(fileName);
		Workbook workbook=new XSSFWorkbook(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		String action="";
		String locator="";
		String data="";
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
	
		WebDriver driver=new ChromeDriver(c);
		
		for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
		{
			action=sheet.getRow(i).getCell(0).getStringCellValue();
			locator=sheet.getRow(i).getCell(1).getStringCellValue();
			data=sheet.getRow(i).getCell(2).getStringCellValue();
			WebElement element=null;
			switch(action)
			{
			case "openUrl":
			{
				driver.get(data);
				break;
			}
			case "enterSearchText":
			{
				if(!locator.equals("NA"))
				{
				String loc[]=locator.split("=");
				String locatorType=loc[0];
				String locatorValue=loc[1];
				
				switch(locatorType)
				{
				case "name":
				{
					 element=driver.findElement(By.name(locatorValue));
					break;
				}
				}
				
				element.sendKeys(data);
				element.sendKeys(Keys.ENTER);
				break;
				}
			}
			case "verifyTitle":
			{
				String ss=driver.getTitle();
				if(ss.equals(data))
				{
					System.out.println("Correct");
					
				}
				else
				{
					System.out.println("Not Correct");
				}
			}
			}
			}
		}

	

}
