package org.test.testclass;

import org.excel.ExcelRead;
import org.report.ReportConfig;
import org.test.utils.UtilityClass;
import org.testng.annotations.Test;

public class Invalid_LoginStep extends UtilityClass {
	@Test(priority=2)
	public void user_login_to_the_app() throws Throwable {
		try {
			ReportConfig.ReportCreateTestcase("User tries to login with invalid credentials");
			launchURL(ExcelRead.readData(1, 0, "Login"));
			Thread.sleep(10000);
			waitForElement("Addooccoemail", login);
			sendKeystoElement("Addooccoemail", login, ExcelRead.readData(1, 3, "Login"));
			waitForElement("Addooccopassword", login);
			sendKeystoElement("Addooccopassword", login, ExcelRead.readData(1, 4, "Login"));
			waitForElement("Addooccocontinue", login);
			clickElement("Addooccocontinue", login);
			Thread.sleep(10000);
			waitForElement("Addooccoinvaliderrormessage", login);
			String expectederror = getElement("Addooccoinvaliderrormessage", login).getText();
			if(expectederror.contains("Username or Password were incorrect"))
			{
				ReportConfig.Pass("User views error message");
			}
			else
			{
				ReportConfig.Fail("User failed to view error message");
			}

		//	ReportConfig.ReportCooldown();
			closewindow();
		}
		catch (Exception e) {
			System.out.println(e);
			ReportConfig.Fail("Failure "+ e);
			ReportConfig.ReportCooldown();
			closewindow();
		}}
}
