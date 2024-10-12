package com.test.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class General37 {

private String prop;

public String getValue(String propValue,String fileName)
{
	try
	{
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(fileName);
		p.load(fis);
		prop=p.getProperty(propValue);
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	return prop;
	
}





}
