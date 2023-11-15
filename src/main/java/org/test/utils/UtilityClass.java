package org.test.utils;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilityClass {

	public static  WebDriver driver ;
	public static String login = System.getProperty("user.dir")
			+ "\\src\\test\\java\\org\\test\\pagelocators\\Login.properties";
	public static String home = System.getProperty("user.dir")
			+ "\\src\\test\\java\\org\\test\\pagelocators\\Homepage.properties";
	public static Actions a;

	public static WebElement getElement(String ID, String locatorfile) throws Throwable {
		String EleType, Value;
		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		EleType = Prop.getProperty(ID).split(" ")[0];
		Value = Prop.getProperty(ID).split(" ", 2)[1];
		switch (EleType) {
		case "id":
			return driver.findElement(By.id(Value));
		case "xpath":
			return driver.findElement(By.xpath(Value));
		default:
			return driver.findElement(By.xpath(Value));

		}
	}

	public static void launchURL(String url) {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void waitForElement(String ID, String locatorfile) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(ID, locatorfile)));
	}
	public static void sendKeystoElement(String ID, String locatorfile, String Value) throws Throwable {
		getElement(ID, locatorfile).clear();
		getElement(ID, locatorfile).sendKeys(Value);
	}
	public static String getElementText(String ID, String locatorfile) throws Throwable {
		String textvalue = getElement(ID, locatorfile).getText();
		return textvalue;
	}
	public static void clickElement(String ID, String locatorfile) throws Throwable {
		getElement(ID, locatorfile).click();

	}
	public static void jsclick(String ID, String locatorfile) throws Throwable {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", getElement(ID, locatorfile));
	}

	public static void  actionRightclick(String ID, String locatorfile) throws Throwable {
		a=new Actions(driver);
		a.contextClick(getElement(ID, locatorfile)).perform();
	}
	public static void  actionDoubleclick(String ID, String locatorfile) throws Throwable {
		a=new Actions(driver);
		a.doubleClick(getElement(ID, locatorfile)).perform();
	}
	public static void  actionMoveToElement(String ID, String locatorfile) throws Throwable {
		a=new Actions(driver);
		a.moveToElement(getElement(ID, locatorfile)).click().perform();
	}

	public static void selectByValue(String ID, String locatorfile,String value) throws Throwable {
		Select s=new Select(getElement(ID, locatorfile));
		s.selectByValue(value);
	}
	public static void selectByIndex(String ID, String locatorfile,int value) throws Throwable {
		Select s=new Select(getElement(ID, locatorfile));
		s.selectByIndex(value);
	}

	public static void selectByText(String ID, String locatorfile,String value) throws Throwable {
		Select s=new Select(getElement(ID, locatorfile));
		s.selectByVisibleText(value);
	}

	public static void deselectByValue(String ID, String locatorfile,String value) throws Throwable {
		Select s=new Select(getElement(ID, locatorfile));
		s.selectByValue(value);
	}
	public static void deselectByIndex(String ID, String locatorfile,int value) throws Throwable {
		Select s=new Select(getElement(ID, locatorfile));
		s.selectByIndex(value);
	}

	public static void deselectByText(String ID, String locatorfile,String value) throws Throwable {
		Select s=new Select(getElement(ID, locatorfile));
		s.selectByVisibleText(value);
	}
	public static String captureScreenshot() throws IOException {
		File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] encoded;
		try {
			encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcFiler));
			String s = new String(encoded, StandardCharsets.US_ASCII);
			return s;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return login;
	}

	public static void closewindow() {
		driver.close();

	}
	public static void closeAllwindow() {
		driver.quit();

	}
	public static void Enabled(String ID, String locatorfile) throws Throwable {
		getElement(ID, locatorfile).isEnabled();

	}
	public static void selected(String ID, String locatorfile) throws Throwable {
		getElement(ID, locatorfile).isSelected();

	}
	public static void Displayed(String ID, String locatorfile) throws Throwable {
		getElement(ID, locatorfile).isDisplayed();

	}
	public static void frameID(String name)throws Throwable {
		driver.switchTo().frame(name);

	}
	public static void frameIndex(int i)throws Throwable {
		driver.switchTo().frame(i);

	}
	public static void frameWebelement(String ID, String locatorfile)throws Throwable {
		driver.switchTo().frame(getElement(ID, locatorfile));

	}

	public static void parentFrame()throws Throwable {
		driver.switchTo().parentFrame();

	}
	public static void navigateTo(String url)throws Throwable {
		driver.navigate().to(url);

	}
	public static void navigateForward()throws Throwable {
		driver.navigate().forward();

	}
	public static void navigateBackward()throws Throwable {
		driver.navigate().back();

	}
	public static void maximize()throws Throwable {
		driver.manage().window().maximize();

	}
	public static void refresh()throws Throwable {
		driver.navigate().refresh();

	}
	public static void getDimension()throws Throwable {
		driver.manage().window().getSize();

	}
}

