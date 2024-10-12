package com.test.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class General30 {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Workbook workbook;
		Sheet sheet;
		FileInputStream fis=new FileInputStream("D:\\Book5.xlsx");
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet("search");
		String action="";
		String locator="";
		String data="";
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win32\\chromedriver.exe");
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--RemoteAcceptOrigin");
		driver=new ChromeDriver();
		String title="";
		for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
		{
			action=sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(action);
			locator=sheet.getRow(i).getCell(1).getStringCellValue();
			data=sheet.getRow(i).getCell(2).getStringCellValue();
			
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
					
				WebElement element=driver.findElement(By.name(locator));
				element.sendKeys(data);
				element.sendKeys(Keys.ENTER);
				title=driver.getTitle();
				}
				break;
			}
			case "verifyTitle":
			{
				
				System.out.println("title"+title);
				if(title.equals(data))
				{
					System.out.println("page opened");
				}
				else
				{
					System.out.println("page not opened");
				}
				break;
			}
			}
			}
		driver.close();
	}

}
