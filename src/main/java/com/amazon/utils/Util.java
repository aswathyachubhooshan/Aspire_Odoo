package com.amazon.utils;

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

import com.amazon.pages.CartPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Util {
	public static WebDriver driver;
	public String browserType;
	public String excelVal;
	public String filePath="D:/TestData.xls";
	public String chromeVersion="96.0.4664.45";
	public FileReader reader;
	public  Properties p;
	protected CartPage cartP;

	@BeforeClass
	public void setDriver() {
		try {
			reader=new FileReader(System.getProperty("user.dir")+"/src/main/java/com/amazon/resources/resources.properties");
			p=new Properties();
			p.load(reader);
		
		System.out.println(p.getProperty("url"));
		WebDriverManager.chromedriver().driverVersion(chromeVersion).setup();
		ChromeOptions chrop = new ChromeOptions();
		String opt[] = new String[] { "-test-type", "test-type=browser", "-disable-default-apps",
				"-enable-precise-memory-info", "-js-flags=-expose-gc", "-disable-infobars", "-start-maximized",
				"-ignore-certificate-errors", "-disable-popup-blocking", "-allow-running-insecure-content",
				"-disable-notifications", "-disable-save-password", "-disable-translate", "-always-authorize-plugins" };
		chrop.addArguments(opt);
			//System.setProperty("webdriver.chrome.driver", "G:\\drivers\\chrome\\chromedriver_win32\\chromedriver.exe");
			this.driver = new ChromeDriver(chrop);
			driver.get(p.getProperty("url"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@AfterClass
	public void tearDown() {
		cartP=new CartPage(driver);
		cartP.gotoCart();
		cartP.deleteItems();
		driver.quit();
	}
	
	public void normalWait(int time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
}