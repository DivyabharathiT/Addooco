package org.report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Archivereports {
	    public static void copy() throws IOException, Throwable
	    {
	    	File[] files = new File(System.getProperty("user.dir") + "\\Reports").listFiles();
	    	File directory1 = new File(System.getProperty("user.dir") +"\\Reports");
	    	int fileCount = directory1.list().length;
	    	System.out.println("Count is"+ fileCount);
	    	if (fileCount<=0)
	        {
	    	System.out.println("No Reports Found In Source Folder");
	    	}
	    	else
	    	{
	    	for(File file : files)
	        {
	        if(file.isFile())
	    	{
	    	System.out.println(file.getAbsolutePath());
	    	String PathVal= file.getAbsolutePath();
	    	Thread.sleep(2000);
	    	String fileName = file.getName();
	    	File sourceFile= new File(PathVal);
	    	File destinationFile= new File(System.getProperty("user.dir") + "\\Archieve_Reports"+"\\"+fileName);
	    	try
	        {
	    	Files.move(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
	    	System.out.println("File Moved to Destination Folder");
	    	}
	    	catch(IOException e)
	    	{
	    	e.printStackTrace();
	    	}
	    	}
	        }
	    	}
		}
	}

