package com.test.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class General32 extends General31 {

	private String prop;
	
	public void set(String prop)
	{
		this.prop=prop;
	}
	public String get()
	{
		return prop;
	}
	public String getProperty() throws IOException
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream("fileName");
		p.load(fis);
		
		return p.getProperty(get());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		General32 g=new General32();
		
	}

}
