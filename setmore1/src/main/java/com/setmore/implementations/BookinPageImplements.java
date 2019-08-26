package com.setmore.implementations;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.setmore.constants.OpeningBrowser;
import com.setmore.specifications.BookingPage;
import com.setmore.testcases.BookingPageTestCase;

public class BookinPageImplements extends OpeningBrowser {


	public void bookingPage() throws Exception {
		
		String url="https://dccomics.setmore.com";

		driver.get(url);
		String current_url=driver.getCurrentUrl();
		Assert.assertEquals(current_url,url+"/");
		System.out.println(current_url);
		BookingPageTestCase.logger.log(Status.PASS,"Browser invoked successfully and url is passed into the browser");
		
		WebDriverWait wait=new WebDriverWait(driver,5);
		WebElement click_ok =wait.until(ExpectedConditions.visibilityOf(driver.findElement(BookingPage.okay_button))); 
		String booking_policy_act=driver.findElement(BookingPage.bookingpolicy_actual).getText();
		Assert.assertEquals(booking_policy_act,BookingPage.bookingpolicy_expec);
		boolean okay_button=driver.findElement(BookingPage.okay_button).isEnabled();
		System.out.println("Is okay button is enabled?: "+okay_button);
		
		click_ok.click();
		BookingPageTestCase.logger.log(Status.PASS,"okay button clicked");

		
		boolean service_massage=driver.findElement(BookingPage.service_massage).isEnabled();
		System.out.println("clicked on the service button: "+service_massage);
		driver.findElement(BookingPage.service_massage).click();
		BookingPageTestCase.logger.log(Status.PASS,"massage button clicked");
		
		boolean head_massage=driver.findElement(BookingPage.head_massage).isEnabled();
		System.out.println("Is head massage is enabled: "+head_massage);
		driver.findElement(BookingPage.head_massage).click();
		BookingPageTestCase.logger.log(Status.PASS,"head massaged service is choosen");
		
		boolean staff_engineer=driver.findElement(BookingPage.staff_engineer).isEnabled();
		System.out.println("Is staff Engineer is enabled?: "+staff_engineer);
		driver.findElement(BookingPage.staff_engineer).click();
		BookingPageTestCase.logger.log(Status.PASS,"staff is choosen for head massage-Engineer");
		for (int i = 1; i <= 6;) {
			for (int j = 1; j <= 7;) {

				WebDriverWait wait12 = new WebDriverWait(driver, 10);
				Boolean check = wait12.until(ExpectedConditions.invisibilityOf(driver.findElement(
						By.xpath("//tbody[@class='datepickerDays skiptranslate']/tr[\"+i+\"]/td[\"+j+\"]"))));
				if (check == false) {
					driver.findElement(BookingPage.calendar_table).click();
				} else {
					j++;
				}

			}
			i++;
		}
 
		String ele = driver.findElement(BookingPage.morning_text).getText();
		String ele1 = driver.findElement(BookingPage.afternoon_text).getText();
		String ele2 = driver.findElement(BookingPage.evening_text).getText();
		
		
		if (ele == BookingPage.morning) 
		{
			  WebDriverWait wait1=new WebDriverWait(driver,5);
			  WebElement click_time1 =wait1.until(ExpectedConditions.visibilityOf(driver.findElement(BookingPage.
			  click_time))); 
			  click_time1.click();
		} 
		else
		{
			if (ele1 == BookingPage.afternoon) 
			{
				WebDriverWait wait1=new WebDriverWait(driver,5);
				  WebElement click_time1 =wait1.until(ExpectedConditions.visibilityOf(driver.findElement(BookingPage.
						  time_afternoon)));
				  click_time1.click();
				//driver.findElement(BookingPage.time_afternoon).click();
			} 
			else 
			{
				WebDriverWait wait1=new WebDriverWait(driver,5);
				  WebElement click_time1 =wait1.until(ExpectedConditions.visibilityOf(driver.findElement(BookingPage.
						  time_evening))); 
				  click_time1.click();
				//driver.findElement(BookingPage.time_evening).click();
			}
		}

		BookingPageTestCase.logger.log(Status.PASS,"timing has booked");
		
		String skipstep_act=driver.findElement(BookingPage.skiplogin_actual).getText();
		Assert.assertEquals(skipstep_act, BookingPage.skip_step_expec);
		boolean skip_login=driver.findElement(BookingPage.skip_login).isEnabled();
		System.out.println("Skip login button is enabled?: "+skip_login);
		driver.findElement(BookingPage.skip_login).click();
		BookingPageTestCase.logger.log(Status.PASS,"login is skipped in booking page");
	}
		
		public void validateBooking() throws Exception	
		{

			String username = UUID.randomUUID().toString();
			username = username.substring(0, Math.min(username.length(), 10));
			String email = UUID.randomUUID().toString();
			email = email.substring(0, Math.min(email.length(), 10));
			String mobile = UUID.randomUUID().toString();
			mobile = mobile.substring(0, Math.min(mobile.length(), 10));
			String address = UUID.randomUUID().toString();
			address = address.substring(0, Math.min(address.length(), 10));
			String cityname = UUID.randomUUID().toString();
			cityname = cityname.substring(0, Math.min(cityname.length(), 10));
			String statename = UUID.randomUUID().toString();
			statename = statename.substring(0, Math.min(statename.length(), 10));
			String postalcode = UUID.randomUUID().toString();
			postalcode = postalcode.substring(0, Math.min(postalcode.length(), 10));
			String comments = UUID.randomUUID().toString();
			comments = comments.substring(0, Math.min(comments.length(), 10));
			
		driver.findElement(BookingPage.name).sendKeys(username);
		driver.findElement(BookingPage.email).sendKeys(email + "@gmail.com");
		driver.findElement(BookingPage.phone).sendKeys(mobile);
		driver.findElement(BookingPage.address).sendKeys(address);
		driver.findElement(BookingPage.city).sendKeys(cityname);
		driver.findElement(BookingPage.state).sendKeys(statename);
		driver.findElement(BookingPage.postal_code).sendKeys(postalcode);
		driver.findElement(BookingPage.comments).sendKeys(comments);
		driver.findElement(BookingPage.checkbox).click();
		driver.findElement(BookingPage.continue_button).click();
		
		String book_appointment_act=driver.findElement(BookingPage.book_appointment).getText();
		Assert.assertEquals(book_appointment_act, BookingPage.book_appointment_expec);
		boolean book_appointment=driver.findElement(BookingPage.book_appointment).isEnabled();
		System.out.println("book appointment button is enabled?: "+book_appointment);
		driver.findElement(BookingPage.book_appointment).click();
		BookingPageTestCase.logger.log(Status.INFO,"All the details are entered successfully and booked");
	
	    Thread.sleep(2000);
		
	    
		String customer_name=driver.findElement(BookingPage.customername_validate).getText();
		if(customer_name.hashCode()==username.hashCode())
		{
		Assert.assertEquals(customer_name,username);
		BookingPageTestCase.logger.log(Status.PASS,"customer name is validated");
		}
		//String customer_phone=driver.findElement(BookingPage.phone_validate).getText();
		//Assert.assertEquals(customer_phone,"+91"+mobile);
		//BookingPageTestCase.logger.log(Status.PASS,"phone number is validated");
		
		String customer_email=driver.findElement(BookingPage.email_validate).getText();
		if(customer_email.hashCode()==(email+"gmail").hashCode())
		{
		Assert.assertEquals(customer_email, email+"@gmail.com");
		BookingPageTestCase.logger.log(Status.PASS,"email is validated");
		}
		
		String customer_address=driver.findElement(BookingPage.address_validate).getText();
		if(customer_address.hashCode()==(address+", "+cityname+", "+statename+", "+postalcode).hashCode())
		{
		Assert.assertEquals(customer_address,address+", "+cityname+", "+statename+", "+postalcode);
		BookingPageTestCase.logger.log(Status.PASS,"address is validated");
		}
	}
}
