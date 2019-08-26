package com.setmore.implementations;

import java.awt.Robot;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.setmore.constants.OpeningBrowser;
import com.setmore.specifications.BusinessHours;
import com.setmore.specifications.CreateCustomer;
import com.setmore.specifications.SigninPage;
import com.setmore.testcases.BusinesshoursTestCase;

public class BusinessHoursImplementation extends OpeningBrowser {
	
	public void createCustomer()
	{
		String url="https://my.setmore.com";

		driver.get(url);
		String current_url=driver.getCurrentUrl();
		Assert.assertEquals(current_url, url+"/");
		BusinesshoursTestCase.logger.log(Status.PASS,"Browser is invoked and url is passed");
		
		driver.findElement(SigninPage.username).sendKeys("abdulsameersetmore@gmail.com");
		driver.findElement(SigninPage.password).sendKeys("sameer999");
		
		boolean signin_button=driver.findElement(SigninPage.signin_button).isEnabled();
		System.out.println("Click signin button is enabled?: "+signin_button);
		driver.findElement(SigninPage.signin_button).click();
		BusinesshoursTestCase.logger.log(Status.PASS,"All the details are passed and signin successfully");
		
		String calendar_act=driver.findElement(CreateCustomer.calendar_header).getText();
		Assert.assertEquals(calendar_act, CreateCustomer.calendar_expec);
			}

	public void businessHours() throws Exception
	{
		/*Logger logger=Logger.getLogger("BookingPageImplements");
		PropertyConfigurator.configure("log.properties");
	*/
	boolean click_appsintegration=driver.findElement(BusinessHours.click_appsintegration).isEnabled();	
	System.out.println(click_appsintegration);
	driver.findElement(BusinessHours.click_appsintegration).click();
	BusinesshoursTestCase.logger.log(Status.PASS,"clicked on apps and integrations");
	
	boolean click_configure=driver.findElement(BusinessHours.click_configure).isEnabled();
	System.out.println(click_configure);
	driver.findElement(BusinessHours.click_configure).click();
	BusinesshoursTestCase.logger.log(Status.PASS,"clicked on configure button");
	
	String bookingpageheader_act=driver.findElement(BusinessHours.bookingpageheader).getText();
	Assert.assertEquals(bookingpageheader_act, BusinessHours.bookingpage_expec);
	
	boolean click_businesshours=driver.findElement(BusinessHours.click_busineeshours).isEnabled();
	System.out.println(click_businesshours);
	driver.findElement(BusinessHours.click_busineeshours).click();
	BusinesshoursTestCase.logger.log(Status.PASS,"clicked on business hours");
	
	boolean click_dropdown=driver.findElement(BusinessHours.click_dropdown).isEnabled();
	driver.findElement(BusinessHours.click_dropdown).click();
	BusinesshoursTestCase.logger.log(Status.PASS,"clicked on dropdown to choose the timezone");
	
	WebDriverWait wait1=new WebDriverWait(driver,5);
	int i=1;
	do
	{
		Robot r=new Robot();
		r.mouseWheel(i);
	  WebElement click_timezone =wait1.until(ExpectedConditions.visibilityOf(driver.findElement(BusinessHours.click_timezone1)));
	  if(click_timezone.isEnabled())
	  {
		  String timezone_act=driver.findElement(BusinessHours.click_timezone1).getText();
		  Assert.assertEquals(timezone_act, BusinessHours.timezone_expec);
	  click_timezone.click();
	  driver.findElement(BusinessHours.click_ok).click();
	  BusinesshoursTestCase.logger.log(Status.PASS,"time zone for Phoenix is choosen");
	  break;
	  }
	}while(i<=900);
	
	}
}
