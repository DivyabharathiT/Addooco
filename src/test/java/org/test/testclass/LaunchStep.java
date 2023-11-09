package org.test.testclass;

import java.util.concurrent.TimeUnit;

import org.excel.ExcelRead;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.report.Archivereports;
import org.report.ReportConfig;
import org.test.utils.UtilityClass;
import org.testng.annotations.Test;

public class LaunchStep extends UtilityClass{
	@Test(priority=0)
	public void user_login_to_the_app() throws Throwable {
		try {
			Archivereports.copy();
			ReportConfig.Report();
			ReportConfig.ReportCreateTestcase("User launch to the valid Url and checks login button is present");
			launchURL(ExcelRead.readData(1, 0, "Login"));
			String currenturl=driver.getCurrentUrl();
			if(currenturl.contains("https://www.comprobo.net"))
			{
				ReportConfig.Pass("The URL - "+currenturl);
			}
			else
			{
				ReportConfig.Fail("Failure");
			}
			Thread.sleep(10000);
			waitForElement("Addooccoemail", login);
			if(getElement("Addooccologin", login).isDisplayed())
			{
				ReportConfig.Pass("User launched the application successfully and verifies Login box");
			}
			else
			{
				ReportConfig.Fail("User failed to launch");
			}
			waitForElement("Addooccoemail", login);
			if(getElement("Addooccoemail", login).isDisplayed()&&getElement("Addooccopassword", login).isDisplayed())
			{
				ReportConfig.Pass("User views email and password fields successfully");
			}
			else
			{
				ReportConfig.Fail("User failed to view email and password fields");
			}
			//ReportConfig.ReportCooldown();
			closewindow();
		}
		catch (Exception e) {
			System.out.println(e);
			ReportConfig.Fail("Failure "+ e);
			ReportConfig.ReportCooldown();
			closewindow();
		}
	}

}