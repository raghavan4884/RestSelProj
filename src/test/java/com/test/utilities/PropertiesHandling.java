package com.test.utilities;

import java.io.*;
import java.util.Properties;

public class PropertiesHandling {

	public String getPropValue(String fileName,String key)
	{
		Properties prop=new Properties();
		String propValue=null;
		File file=new File(fileName); 
		try {
			FileInputStream fis=new FileInputStream(file);
			prop.load(fis);
			propValue=prop.getProperty(key);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return propValue;
	}
	 
}
