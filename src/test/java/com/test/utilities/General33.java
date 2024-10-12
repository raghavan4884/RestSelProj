package com.test.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class General33 {
	
	/*String s="fileName";
	private String searchTextBox="//textarea[@name='q']";
	String d="D:\\"+s+".xml";
	public String getSearchTextBoxVal()
	{
		return searchTextBox;
	}*/

	private String property;
	
	public String getPropValue(String property,String fileName)
	{
		this.property=property;
		
		String propVal="";
		try
		{
			Properties prop=new Properties();
			FileInputStream fis=new FileInputStream(fileName);
			prop.load(fis);
			propVal=prop.getProperty(property);
		
		}
		catch(Exception e)
		{
			
		}
		return propVal;
	}

}
