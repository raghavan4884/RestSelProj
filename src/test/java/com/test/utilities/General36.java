package com.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class General36  extends General37{
	General35 g35=new General35();
	
	public Object[][] d()
	{
		Object[][] obj=g35.m();
		for(int i=0;i<obj.length;i++)
		{
			for(int j=0;j<obj.length;j++)
			{
				System.out.println(obj[i][j]);		
			}
		}
		
		return obj;
		
	}
	public static void main(String args[])
	{
	
		General36 g36=new General36();
		g36.d();
		
		String s=g36.getValue("browser", "D:\\1.properties");
		System.out.println(s);
	
	}
	
	

}
