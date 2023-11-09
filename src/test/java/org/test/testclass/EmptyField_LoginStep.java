package org.test.testclass;

import org.excel.ExcelRead;
import org.report.ReportConfig;
import org.test.utils.UtilityClass;
import org.testng.annotations.Test;

public class EmptyField_LoginStep extends UtilityClass{
	@Test(priority=3)
	public void user_login_to_the_app() throws Throwable {
		try {
			ReportConfig.ReportCreateTestcase("User checks the error message when failed to feed credentials");
			launchURL(ExcelRead.readData(1, 0, "Login"));
			Thread.sleep(10000);
			getElement("Addooccoemail", login).clear();
			clickElement("Addooccoemail", login);
			getElement("Addooccopassword", login).clear();
			clickElement("Addooccopassword", login);
			waitForElement("Addooccocontinue", login);
			clickElement("Addooccocontinue", login);
			Thread.sleep(10000);
			waitForElement("Addooccoinvalidemptyemailmessage", login);
			String expectederror1 = getElement("Addooccoinvalidemptyemailmessage", login).getText();
			String expectederror2 = getElement("Addooccoinvalidemptypasswordmessage", login).getText();
			waitForElement("Addooccoinvalidemptyemailmessage", login);
			if(expectederror1.contains("Value is required")&&expectederror2.contains("Value is required"))
			{
				ReportConfig.Pass("User views error message");
			}
			else
			{
				ReportConfig.Fail("User failed to view error message");
			}

			//ReportConfig.ReportCooldown();
			closewindow();
		}
		catch (Exception e) {
			System.out.println(e);
			ReportConfig.Fail("Failure "+ e);
			ReportConfig.ReportCooldown();
			closewindow();
		}}
}