package com.setmore.constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class OpeningBrowser {

	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User.FULL308-WIN.003\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		ChromeOptions obj = new ChromeOptions();
		obj.addArguments("disable-infobars");
		obj.addArguments("disable-notifications");

		driver = new ChromeDriver(obj);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Users\\User.FULL308-WIN.003\\Downloads\\geckodriver-v0.24.0-win64\\geckodriver.exe"
		 * ); driver = new FirefoxDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * driver.manage().deleteAllCookies();
		 */
		// opening the page

	}

}
