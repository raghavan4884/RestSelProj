package com.test.utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class General35  {
	
private Workbook workbook;
private Sheet sheet;

public General35()
{

	try
	{
		FileInputStream fis=new FileInputStream("D:\\Book4.xlsx");
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet("search");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
}

public int getTotalRows()
{
	return sheet.getPhysicalNumberOfRows();
}
public int getTotalCols()
{
	return sheet.getRow(0).getLastCellNum();
}

public String getStringValue(int row,int col)
{
	return sheet.getRow(row).getCell(col).getStringCellValue();
}
public Object[][] m()
{
	String data="";
	int row=getTotalRows();
	int col=getTotalCols();
	
	Object[][] obj=new Object[row][col];
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<col;j++)
		{
			data=getStringValue(i,j);
			obj[i][j]=data;
		}
		
		
	}
	return obj;
}
}
