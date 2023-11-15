package org.test.testclass;

import org.excel.ExcelRead;
import org.report.ReportConfig;
import org.test.utils.UtilityClass;
import org.testng.annotations.Test;

public class LogoutStep extends UtilityClass{
	@Test(priority=4)
	public void user_login_to_the_app() throws Throwable {
		try {
			ReportConfig.ReportCreateTestcase("Logout");
			ReportConfig.ReportCreateNode("User checks logout functionality is working");
			launchURL(ExcelRead.readData(1, 0, "Login"));
			Thread.sleep(10000);
			waitForElement("Addooccoemail", login);
			sendKeystoElement("Addooccoemail", login, ExcelRead.readData(1, 1, "Login"));
			waitForElement("Addooccopassword", login);
			sendKeystoElement("Addooccopassword", login, ExcelRead.readData(1, 2, "Login"));
			waitForElement("Addooccocontinue", login);
			clickElement("Addooccocontinue", login);
			Thread.sleep(10000);
			waitForElement("Addooccomainmenu", home);
			clickElement("Addooccomainmenu", home);
			Thread.sleep(10000);
			waitForElement("Addooccologout", home);
			clickElement("Addooccologout", home);
			waitForElement("Addooccoyes", home);
			clickElement("Addooccoyes", home);
			Thread.sleep(10000);
			waitForElement("Addooccocontinue", login);
			if(getElement("Addooccocontinue", login).isDisplayed())
			{
				ReportConfig.Pass("User logged out successfully");
			}
			else
			{
				ReportConfig.Fail("User failed to logout");
			}
			ReportConfig.ReportCooldown();
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
