package org.report;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.test.utils.UtilityClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportConfig {				
	public static ExtentHtmlReporter reports;			
	public static ExtentReports extent;			
	public static ExtentTest test;	
	public static  ExtentTest node;


	public static void Report() {		
		LocalDateTime timestamp = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String timestampString = formatter.format(timestamp);
		String path=System.getProperty("user.dir")+"\\Reports"+"\\Comprobo_"+timestampString+".html";		
		File f=new File(path);		
		reports=new ExtentHtmlReporter(f);		
		extent=new ExtentReports();		
		extent.attachReporter(reports);		
	}			
	public static void ReportCooldown() {
		extent.flush();
	}
	public static void ReportCreateTestcase(String Title) throws ClassNotFoundException {
		 test = extent.createTest(Title);
	}
	public static void ReportCreateNode(String Title) throws ClassNotFoundException {
		node =test.createNode(Title);
	}
	public static void Pass(String passdetails) throws Throwable {
		String ScreenShot = UtilityClass.captureScreenshot();
		node.pass(passdetails, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());
	}
	public static void Fail(String e) throws Throwable {
		String ScreenShot = UtilityClass.captureScreenshot();
		node.fail(e, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());

	}

}
