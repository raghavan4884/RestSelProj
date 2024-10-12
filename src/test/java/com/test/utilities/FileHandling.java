package com.test.utilities;

import java.io.*;

public class FileHandling {
	
	public void writeToFile(String fileName,String message)
	{
		File file=new File(fileName);
		try {
			if(!file.exists())
			{
				file.createNewFile();
			}
			else
			{
				FileWriter fw=new FileWriter(file,true);
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write(message);
				bw.write("/n");
				bw.close();
				fw.close();
			}	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public String readFromFile(String fileName)
	{
		File file=new File(fileName);
		String fileValue=null;
		String value=null;
		try {
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			while((value=br.readLine())!=null)
			{
				fileValue=value;
			}
			br.close();
			fr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return fileValue;
	}

	
	public void verifyFileisPresent(String folderName,String fileName)
	{
		
		File folder= new File(folderName);
		File Files[]=folder.listFiles();
		String fiName=null;
		for(File file:Files)
		{
			if(file.isFile())
			{
				fiName=file.getName();
				if(fileName.equals(fiName))
				{
					System.out.println("file Exists");
					double d=fileName.length();
					System.out.println(d/(1024*1024));
				}
				
			}
		}
		
			//String s=file.getName();
			
	}
}
