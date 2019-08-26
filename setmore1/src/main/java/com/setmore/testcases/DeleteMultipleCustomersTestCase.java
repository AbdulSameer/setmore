package com.setmore.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.setmore.constants.OpeningBrowser;
import com.setmore.implementations.DeleteMultipleCustomersImplementations;

import XLutils.Utilities;

public class DeleteMultipleCustomersTestCase extends OpeningBrowser {
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	
	@Test
	
	public void deletemulCustomers() throws Exception {
		reporter = new ExtentHtmlReporter("./Reports/delete_customer_pagereport.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);

		logger = extent.createTest("DeleteMultipleCustomersTestCase");


		DeleteMultipleCustomersImplementations dmc=new DeleteMultipleCustomersImplementations();
		dmc.createCustomer();
		dmc.delete();

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
