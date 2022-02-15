package com.aspire.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Util {
	public static WebDriver driver;
	public String browserType;
	public String excelVal;
	public String filePath = "D:/TestData.xls";
	public FileReader reader;
	public Properties p;

	@BeforeClass
	public void setDriver() {
		try {
			reader = new FileReader(
					System.getProperty("user.dir") + "/src/main/java/com/aspire/resources/resources.properties");
			p = new Properties();
			p.load(reader);
			WebDriverManager.chromedriver().driverVersion(p.getProperty("chromeVersion")).setup();
			ChromeOptions chrop = new ChromeOptions();
			String opt[] = new String[] { "-test-type", "test-type=browser", "-disable-default-apps",
					"-enable-precise-memory-info", "-js-flags=-expose-gc", "-disable-infobars", "-start-maximized",
					"-ignore-certificate-errors", "-disable-popup-blocking", "-allow-running-insecure-content",
					"-disable-notifications", "-disable-save-password", "-disable-translate",
					"-always-authorize-plugins" };
			chrop.addArguments(opt);
			// System.setProperty("webdriver.chrome.driver",
			// "G:\\drivers\\chrome\\chromedriver_win32\\chromedriver.exe");
			this.driver = new ChromeDriver(chrop);
			driver.get(p.getProperty("url"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void normalWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}