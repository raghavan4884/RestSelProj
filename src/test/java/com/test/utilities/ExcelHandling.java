package com.test.utilities;

import java.io.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {
	
	public Workbook workbook;
	public Sheet sheet;
	public Cell cell;
	
	
	public Sheet openSheet(String fileName,String sheetName)
	{
		File file=new File(fileName);
		String extension=fileName.substring(fileName.indexOf("."));
		try {
			FileInputStream fis=new FileInputStream(file);
			if(extension.contains(".xlsx"))
			{
				workbook=new XSSFWorkbook(fis);
			}
			else
			{
				workbook=new HSSFWorkbook(fis);
			}
			
			sheet=workbook.getSheet(sheetName);
			System.out.println(sheet);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sheet;
	}

	public Sheet openSheet(String fileName,int index)
	{
		File file=new File(fileName);
		String extension=fileName.substring(fileName.indexOf("."));
		try {
			
			FileInputStream fis=new FileInputStream(file);
			if (extension.contains(".xlsx"))
			{
				workbook=new XSSFWorkbook(fis);
				
			} else {
				workbook=new HSSFWorkbook(fis);
			}
			sheet=workbook.getSheetAt(index);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sheet;
	}
	public int getTotalRows(String fileName,String sheetName)
	{
		System.out.println(openSheet(fileName,sheetName).getPhysicalNumberOfRows());
		return openSheet(fileName,sheetName).getPhysicalNumberOfRows();
		
	}
	public String getStringValue(String fileName,String sheetName,int row,int cols)
	{
		System.out.println(openSheet(fileName,sheetName).getRow(row).getCell(cols).getStringCellValue());
		if(openSheet(fileName,sheetName).getRow(row).getCell(cols).getCellType()==CellType.NUMERIC)
		{
			int s=(int) openSheet(fileName,sheetName).getRow(row).getCell(cols).getNumericCellValue();
			String ss=String.valueOf(s);
					
		}
			
		return openSheet(fileName,sheetName).getRow(row).getCell(cols).getStringCellValue();
	}
	public void writeToSheet(String fileName,String sheetName,int row,int cols,String message)
	{
		cell=openSheet(fileName,sheetName).getRow(row).getCell(cols);
		cell.setCellValue(message);
		File file=new File(fileName);
		try {
			FileOutputStream fos=new FileOutputStream(file);
			workbook.write(fos);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void main(String args[])
	{
		ExcelHandling ex=new ExcelHandling();
		ex.getTotalRows("D:\\Book2.xlsx", "search");
		ex.getStringValue("D:\\Book2.xlsx", "search", 1, 0);
	}
}
