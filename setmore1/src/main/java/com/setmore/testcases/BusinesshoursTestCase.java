package com.setmore.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.setmore.constants.OpeningBrowser;
import com.setmore.implementations.BusinessHoursImplementation;

import XLutils.Utilities;
 
public class BusinesshoursTestCase extends OpeningBrowser 
{
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	
	@Test
	
	public void businesshoursTimezone() throws Exception {
		reporter = new ExtentHtmlReporter("./Reports/businesshourstimezone.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);

		logger = extent.createTest("create_customer_delete");

		BusinessHoursImplementation bh=new BusinessHoursImplementation();
		bh.createCustomer();
		bh.businessHours();
	}
	
	@AfterMethod
	public void testscreenshots(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			String temp = Utilities.getScreenshot(driver);
			logger.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

		}
		extent.flush();
		driver.quit();
	}
}
