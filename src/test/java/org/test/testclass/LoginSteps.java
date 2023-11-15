package org.test.testclass;

import org.excel.ExcelRead;
import org.report.ReportConfig;
import org.test.utils.UtilityClass;
import org.testng.annotations.Test;

public class LoginSteps extends UtilityClass{
	@Test(priority=1)
	public void user_login_to_the_app() throws Throwable {
		try {
			ReportConfig.ReportCreateTestcase("Login");
			ReportConfig.ReportCreateNode("User login to the app with valid credentials and checks assignment option is present");
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
	}
		@Test(priority=2)
		public void user_login_to_the_app_with_invalid_credentials() throws Throwable {
			try {
				ReportConfig.ReportCreateNode("User tries to login with invalid credentials");
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

		@Test(priority=3)
		public void user_login_to_the_app_without_credentials() throws Throwable {
			try {
				ReportConfig.ReportCreateNode("User checks the error message when failed to feed credentials");
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
