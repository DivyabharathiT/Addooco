package org.test.testclass;

import java.util.concurrent.TimeUnit
;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.excel.ExcelRead;
import org.report.Archivereports;
import org.report.ReportConfig;
import org.test.utils.UtilityClass;
import org.testng.annotations.Test;

public class Valid_LoginStep extends UtilityClass{
	@Test(priority=1)
	public void user_login_to_the_app() throws Throwable {
		try {
			ReportConfig.ReportCreateTestcase("User login to the app with valid credentials and checks assignment option is present");
			launchURL(ExcelRead.readData(1, 0, "Login"));
			Thread.sleep(10000);
			waitForElement("Addooccoemail", login);
			sendKeystoElement("Addooccoemail", login, ExcelRead.readData(1, 1, "Login"));
			waitForElement("Addooccopassword", login);
			sendKeystoElement("Addooccopassword", login, ExcelRead.readData(1, 2, "Login"));
			waitForElement("Addooccocontinue", login);
			waitForElement("Addooccoemail", login);
			if(getElement("Addooccoemail", login).isEnabled()&&getElement("Addooccopassword", login).isEnabled())
			{
				ReportConfig.Pass("User enters valid credentials");
			}
			else
			{
				ReportConfig.Fail("User failed to enter valid credentials");
			}
			waitForElement("Addooccocontinue", login);
			clickElement("Addooccocontinue", login);
			Thread.sleep(10000);
			waitForElement("Addooccomainmenu", home);
			clickElement("Addooccomainmenu", home);
			Thread.sleep(10000);
			waitForElement("Addooccoassignment", home);
			clickElement("Addooccoassignment", home);
			waitForElement("Addooccoassignment", home);
			if(getElement("Addooccoassignment", home).isDisplayed())
			{
				ReportConfig.Pass("User logged in  & verifies assignment option");
			}
			else
			{
				ReportConfig.Fail("User failed to view assignment option");
			}

		//	ReportConfig.ReportCooldown();
			closewindow();
		}
		catch (Exception e) {
			System.out.println(e);
			ReportConfig.Fail("Failure "+ e);
			ReportConfig.ReportCooldown();
			closewindow();
		}
	}}