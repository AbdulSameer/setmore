package com.setmore.specifications;

import org.openqa.selenium.By;

public class BookingPage {
	public static String appdate = "09/Aug/2019";
	public static String[] temporary = appdate.split("/");
	public static String bookingtime = "17:30";
	public static String[] temp1 = bookingtime.split(":");
	public static String hour = temp1[0];
	public static String min = temp1[1];
	public static String dt = temporary[0];
	public static String month = temporary[1];
	public static String year = temporary[2];
	public static String calyear, calmonth, caldt;
	public static int i;
	public static int j;
	public static String morning="Morning";
	public static String evening="Evening";
	public static String afternoon="Afternoon";
	public static String noSlots="No Slots Available";
	
	public static String bookingpolicy_expec="Our Booking Policy";
	public static String skip_step_expec="Skip login process >>";
	public static String book_appointment_expec="Book My Appointment";
	

	public static By okay_button = By.linkText("Okay");
	public static By service_massage = By.xpath("//div[@id='chs_service_act']/h3[1]");
	public static By head_massage = By.xpath("//div[@id='chs_service_act']//ul[1]//li[1]");
	public static By staff_engineer = By
			.xpath("//div[@id='sp_act']/ul/li[1]");
	public static By click_date = By
			.xpath("//tbody[@class='datepickerDays skiptranslate']//span[contains(text(),'todays_date')]");
	//public static By click_time = By
			//.xpath("//a[@data-company_time='"+ dt+ " /" + month+ " / "+ year +" "+ hour +":"+ min + "IST']");

	 public static By click_time = By.xpath("//a[contains(text(),'"+hour+":"+min+"')]");
			//public static By click_date=By.xpath("//tbody[@class='datepickerDays skiptranslate']//child::span[contains(text(),'09')]");
	//public static By click_time = By.xpath("");

	// skip login
	public static By skip_login = By.xpath("//div[@id='skip_step']");

	// enter the fields
	public static By name = By.xpath("//input[@id='cust-IName']");
	public static By email = By.xpath("//input[@id='cust-IEmailId']");
	public static By phone = By.xpath("//input[@id='cust-PhoneNo']");
	public static By address = By.xpath("//input[@id='cust-Address']");
	public static By city = By.xpath("//input[@id='cust-City']");
	public static By state = By.xpath("//input[@id='cust-State']");
	public static By postal_code = By.xpath("//input[@id='cust-Zip']");
	public static By comments = By.xpath("//textarea[@id='cust-Comments']");
	public static By checkbox = By.xpath("//input[@id='TnCcheckbox']");
	public static By continue_button = By.xpath("//form[@style='display: block;']/div[5]");
	public static By book_appointment = By.xpath("//span[@id='cnfAppt']");

	// to click random date
	public static By booking_date = By.xpath("//tr[@class='month_header']");
	public static By next_month = By.xpath("//th[@class='datepickerGoNext']");

	// pick the date
	public static By click_date1 = By.xpath("//td[@class='datepickerSelected']/a/span");
	
	//no slots available
	public static By no_slots=By.xpath("//div[@class='time_sheet noSlots']");
	
	//capture the calendar table
	public static By calendar_table=By.xpath("//tbody[@class='datepickerDays skiptranslate']/tr["+i+"]/td["+j+"]");
	public static By calendar_table1=By.xpath("//tbody[@class='datepickerDays skiptranslate']//td");
	public static By calendar_table2=By.xpath("//table[@class='datepickerViewDays']");
	
	//capture the time in morning table
	public static By morning_text=By.xpath("//li[contains(text(),'Morning')]");
	public static By time_table=By.xpath("//ul[@class='morning']/li[2]/a");
	
	//capture the time in afternoon table
	public static By afternoon_text=By.xpath("//li[contains(text(),'Afternoon')]");
	public static By time_afternoon=By.xpath("//ul[@class='afternoon']/li[2]/a");
	
	//capture the time in evening table
	public static By evening_text=By.xpath("//li[contains(text(),'Evening')]");
	public static By time_evening=By.xpath("//ul[@class='evening']/li[2]/a");
	
	//morning name
	public static By morning_name=By.xpath("//ul[@class='morning']");
	
	//timesheet
	public static By timing_schedule=By.xpath("//div[@id='timesheet']/ul[k]");
	
	//for asserts using testng
	public static By bookingpolicy_actual=By.xpath("//div[@id='notes_wrapper']/h3[contains(text(),'Policy')]");
	public static By skiplogin_actual=By.xpath("//div[@id='skip_step']");
	public static By bookmyappointment_actual=By.xpath("//span[contains(text(),'Book My Appointment')]");
	
	//for validating the booking page with customer details
	public static By sevice_validate=By.xpath("//ul[@id='confirm_ul']/li[1]/span");
	public static By provider_validate=By.xpath("//ul[@id='confirm_ul']/li[2]/span");
	//public static By date_time_validate=By.xpath("//span[@id='date_time_selected']");
	public static By customername_validate=By.xpath("//ul[@id='confirm_ul']/li[4]/span/ul/li[1]");
	public static By phone_validate=By.xpath("//ul[@id='confirm_ul']/li[4]/span/ul/li[2]");
	public static By email_validate=By.xpath("//ul[@id='confirm_ul']/li[4]/span/ul/li[3]");
	public static By address_validate=By.xpath("//ul[@id='confirm_ul']/li[4]/span/ul/li[4]");
	

}
