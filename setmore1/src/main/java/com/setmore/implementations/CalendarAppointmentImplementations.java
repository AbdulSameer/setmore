package com.setmore.implementations;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.setmore.constants.OpeningBrowser;
import com.setmore.specifications.CalendarAppointment;
import com.setmore.specifications.CreateCustomer;
import com.setmore.specifications.SigninPage;
import com.setmore.testcases.CalendarAppointmentTestCase;

public class CalendarAppointmentImplementations extends OpeningBrowser {
	
	public void createCustomer()
	{
		String url="https://my.setmore.com";

		driver.get(url);
		String current_url=driver.getCurrentUrl();
		Assert.assertEquals(current_url, url+"/");
		CalendarAppointmentTestCase.logger.log(Status.PASS,"Browser is invoked and url is passed");

		
		driver.findElement(SigninPage.username).sendKeys("abdulsameersetmore@gmail.com");
		driver.findElement(SigninPage.password).sendKeys("sameer999");
		
		boolean signin_button=driver.findElement(SigninPage.signin_button).isEnabled();
		System.out.println("Click signin button is enabled?: "+signin_button);
		driver.findElement(SigninPage.signin_button).click();
		CalendarAppointmentTestCase.logger.log(Status.PASS,"All the details are passed and signin successfully");
		
		String calendar_act=driver.findElement(CreateCustomer.calendar_header).getText();
		Assert.assertEquals(calendar_act, CreateCustomer.calendar_expec);
			}
	
	
	public void calendarCustomer()
	{
		driver.findElement(CalendarAppointment.click_settings).click();
		String doublebooking_act=driver.findElement(CalendarAppointment.click_activate).getText();
		System.out.println(doublebooking_act);
		if(doublebooking_act==CalendarAppointment.activate_doubleBooking)
		{
			
		driver.findElement(CalendarAppointment.click_activate).click();
		String calendar_act=driver.findElement(CalendarAppointment.calendar_header).getText();
		Assert.assertEquals(calendar_act,CalendarAppointment.calendar_expec);
		
		int xcord=driver.findElement(CalendarAppointment.calendar_date).getLocation().getX();
		int ycord=driver.findElement(CalendarAppointment.calendar_date).getLocation().getY();
		System.out.println(xcord+","+ycord);
		
		List<WebElement> cal=driver.findElements(CalendarAppointment.calendar_table);
		int total_rows=cal.size();
		System.out.println(total_rows);
		
				for(int i=1;i<total_rows;i++)
		{
			cal.get(i).click();
			break;
		}	
	}
		else
		{
			String calendar_act=driver.findElement(CalendarAppointment.calendar_header).getText();
			Assert.assertEquals(calendar_act,CalendarAppointment.calendar_expec);
			
			int xcord=driver.findElement(CalendarAppointment.calendar_date).getLocation().getX();
			int ycord=driver.findElement(CalendarAppointment.calendar_date).getLocation().getY();
			System.out.println(xcord+","+ycord);
			
			List<WebElement> cal=driver.findElements(CalendarAppointment.calendar_table);
			int total_rows=cal.size();
			System.out.println(total_rows);
			
					for(int i=1;i<total_rows;i++)
			{
				cal.get(i).click();
				break;
			}	
		}
}
	public void bookingdetails() throws Exception
	{
		
		CalendarAppointmentTestCase.logger.log(Status.PASS,"clicked on the date of the calendar page");
	
		String appointment_act=driver.findElement(CalendarAppointment.appointment_details).getText();
		Assert.assertEquals(appointment_act, CalendarAppointment.appointment_expec);
		
	 driver.findElement(CalendarAppointment.provider).click();
	 driver.findElement(CalendarAppointment.choose_provider).click();
	 driver.findElement(CalendarAppointment.service).click();
	 driver.findElement(CalendarAppointment.select_service).click();
	 Thread.sleep(3000);
	 driver.findElement(CalendarAppointment.day_time_appointment).click();
	 driver.findElement(CalendarAppointment.click_date_appointment).click();
	 Thread.sleep(3000);
	 driver.findElement(CalendarAppointment.click_service).click();
	 driver.findElement(CalendarAppointment.clickService_time).click();
	 
	 boolean textarea=driver.findElement(CalendarAppointment.textarea).isEnabled();
	 System.out.println("comments are entered in the text area: "+textarea);
	 driver.findElement(CalendarAppointment.textarea).sendKeys("abc");
	 
	 boolean continue_button=driver.findElement(CalendarAppointment.continue_button).isEnabled();
	 System.out.println("clicked the continue button: "+continue_button);
	 driver.findElement(CalendarAppointment.continue_button).click();
	 CalendarAppointmentTestCase.logger.log(Status.PASS,"Entered all the details of the appointment");
	}
	public void addNewCustomer() throws Exception
	{
		/*Logger logger=Logger.getLogger("BookingPageImplements");
		PropertyConfigurator.configure("log.properties");
*/		driver.findElement(CalendarAppointment.addcustomer).click();

		boolean customer_name=driver.findElement(CalendarAppointment.customer_name).isEnabled();
		System.out.println("adding a new customer: "+customer_name);
		driver.findElement(CalendarAppointment.customer_name).sendKeys("abcdefgh");
		
		boolean customer_email=driver.findElement(CalendarAppointment.customer_email).isEnabled();
		System.out.println("adding a customer email: "+customer_email);
		driver.findElement(CalendarAppointment.customer_email).sendKeys("abcdefgh@gmail.com");
		
		boolean customer_ph=driver.findElement(CalendarAppointment.customer_ph).isEnabled();
		System.out.println("adding a customer phone: "+customer_ph);
		driver.findElement(CalendarAppointment.customer_ph).sendKeys("9988776655");
		
		boolean save_appointment=driver.findElement(CalendarAppointment.save_appointment).isEnabled();
		System.out.println("finally clicking the save appointment: "+save_appointment);
		driver.findElement(CalendarAppointment.save_appointment).click();
		CalendarAppointmentTestCase.logger.log(Status.PASS,"A new customer is added and the details have been entered");
		Thread.sleep(2000);
	
	}
	public void customer_tab() throws Exception
	{
		/*Logger logger=Logger.getLogger("BookingPageImplements");
		PropertyConfigurator.configure("log.properties");
		*/
		WebElement ele_click=driver.findElement(CalendarAppointment.customer_tab);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele_click);
		
		String customers_act=driver.findElement(CalendarAppointment.customer_header).getText();
		Assert.assertEquals(customers_act, CalendarAppointment.customers_expec);
		
		boolean search_customer=driver.findElement(CalendarAppointment.search_customer).isEnabled();
		System.out.println("Is search field for the customer is enabled?: "+search_customer);
		driver.findElement(CalendarAppointment.search_customer).sendKeys("abcdefgh");
		Thread.sleep(3000);
		CalendarAppointmentTestCase.logger.log(Status.PASS,"customer name is entered in search field");
		
		boolean customer_name_page=driver.findElement(CalendarAppointment.customer_name_page).isEnabled();
		System.out.println("customer name is editable: "+customer_name_page);
		driver.findElement(CalendarAppointment.customer_name_page).click();
		Thread.sleep(3000);
		driver.findElement(CalendarAppointment.customer_name_page).sendKeys("123");
		Thread.sleep(2000);
		CalendarAppointmentTestCase.logger.log(Status.PASS,"customer name is edited and saved");
		
		driver.findElement(CalendarAppointment.delete_customer_page).click();
		driver.findElement(CalendarAppointment.delete_customer_page).click();
		Thread.sleep(2000);
		driver.findElement(CalendarAppointment.delete_button_customer).click();
        Thread.sleep(2000);
		driver.findElement(CalendarAppointment.confirm_delete).click();
		CalendarAppointmentTestCase.logger.log(Status.PASS,"Customer is deleted");
	}
}
