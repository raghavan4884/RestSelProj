package com.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class General {
	
	protected General()
	{
		System.out.println("Hi");
	}
	private General(int a)
	{
		a=2;
		System.out.println(a);
	}
	public static void main(String args[])
	{
	
		General g=new General();
		
	}
}
