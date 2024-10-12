package com.test.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private Workbook workbook;
	private Sheet sheet;
	
	public Sheet openSheet(String fileName,String sheetName) throws IOException
	{
		String extension=fileName.substring(fileName.indexOf("."));
		FileInputStream fis=new FileInputStream(fileName);
		if(extension.contains(".xlsx"))
		{
			workbook=new XSSFWorkbook(fis);
			
		}
		else
		{
			workbook=new HSSFWorkbook(fis);
		}
		sheet=workbook.getSheet(sheetName);
		return sheet;
	}
	
	public int getTotalRows(String fileName,String sheetName) throws IOException
	{
	return openSheet(fileName,sheetName).getPhysicalNumberOfRows();
	
	}
	public int getTotalCols(String fileName,String sheetName) throws IOException
	{
		return openSheet(fileName,sheetName).getRow(0).getLastCellNum();
	}
	public String getValue(String fileName,String sheetName,int row,int cols) throws IOException
	{
		String s="";
		int i=0;
		if(openSheet(fileName,sheetName).getRow(row).getCell(cols).getCellType()==CellType.NUMERIC)
		{
			i=(int) openSheet(fileName,sheetName).getRow(row).getCell(cols).getNumericCellValue();
			s=String.valueOf(i);
		}
		else
		{
			s=openSheet(fileName,sheetName).getRow(row).getCell(cols).getStringCellValue();
			System.out.println(s);
					
		}
		return s;
	}

	

}
