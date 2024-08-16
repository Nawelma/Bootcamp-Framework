package com.TN.Listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.TN.utils.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
	public ExtentReports extentR;
	public ExtentTest extentTest;
	public WebDriver driver;
	public String testN;

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Start executing the project");

		try {
			extentR =ExtentReporter.generateExtentReporter();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		testN = result.getName();

		extentTest = extentR.createTest(testN);
		extentTest.log(Status.INFO, testN + "----> started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(testN + "--->Executed Successfully");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = ("\\test-output\\Screenshots\\" + testN + ".png");

		try {
			FileHandler.copy(source, new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}

		extentTest.addScreenCaptureFromPath(destinationFile);
		extentTest.log(Status.FAIL, testN + "got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(testN + "--->skip execution");
		System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("finish execution");
		extentR.flush();
	}

}
