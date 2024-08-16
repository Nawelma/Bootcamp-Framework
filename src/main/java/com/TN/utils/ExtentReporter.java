package com.TN.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	public static ExtentReports generateExtentReporter() throws Exception {
		ExtentReports extent = new ExtentReports();

		File extentReportFile = new File(
				"/Users/hassanekhouni/eclipse-workspace/FRAMEWORK_BOOTCAMP/test-output/index.html");

		ExtentSparkReporter sparkReport = new ExtentSparkReporter(extentReportFile);

		sparkReport.config().setReportName("Framework Bootcamp");
		sparkReport.config().setDocumentTitle("Report title");
		sparkReport.config().setTimeStampFormat(" MM/dd/YYYY : hh:mm:ss");

		extent.attachReporter(sparkReport);

		Properties prop = new Properties();
		FileInputStream ip1 = new FileInputStream(
				"/Users/hassanekhouni/eclipse-workspace/FRAMEWORK_BOOTCAMP/src/main/java/com/TN/config/Config.properties");
		prop.load(ip1);

		extent.setSystemInfo("Web application", prop.getProperty("url"));
		extent.setSystemInfo("Browser", prop.getProperty("browser"));
		extent.setSystemInfo("email", prop.getProperty("validEmail"));
		extent.setSystemInfo("password", prop.getProperty("validPassword"));

		return extent;

	}

}
