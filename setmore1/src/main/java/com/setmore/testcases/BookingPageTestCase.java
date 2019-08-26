package com.setmore.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.setmore.constants.OpeningBrowser;
import com.setmore.implementations.BookinPageImplements;

import XLutils.Utilities;
@Listeners(com.setmore.constants.TestNgListeners.class)
public class BookingPageTestCase extends OpeningBrowser {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	@Test
	public void bookingTest() throws Exception {
		reporter = new ExtentHtmlReporter("./Reports/bookingpagereport.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);

		logger = extent.createTest("BookingPageTestCase");
	
		BookinPageImplements bk = new BookinPageImplements();
		bk.bookingPage();
		bk.validateBooking();
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
