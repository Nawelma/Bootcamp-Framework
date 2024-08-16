package com.TN.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.TN.utils.TestUtil;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	public FileInputStream ip1;
	public Properties dataProp;
	public ChromeOptions options;

	public TestBase() throws Exception {

		prop = new Properties();
		ip = new FileInputStream("/Users/hassanekhouni/eclipse-workspace/FRAMEWORK_BOOTCAMP/src/main/java/com/TN/config/Config.properties");
		prop.load(ip);

		dataProp = new Properties();
		ip1 = new FileInputStream("/Users/hassanekhouni/eclipse-workspace/FRAMEWORK_BOOTCAMP/src/test/java/com/TN/testData/testData.properties");
		dataProp.load(ip1);

	}

	public WebDriver Initialization(String browserName) {
		if (browserName.equals("chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		} else {
			System.out.println("browser doesn't work");
			}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGELOAD_TIME_WAIT));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(TestUtil.SCRIPT_TIME_WAIT));
		driver.get(prop.getProperty("url"));

		return driver;

	}

}
