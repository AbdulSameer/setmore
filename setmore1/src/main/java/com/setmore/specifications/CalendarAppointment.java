package com.setmore.specifications;

import org.openqa.selenium.By;

public class CalendarAppointment {
	
	public static String calendar_expec="Calendar";
	public static String appointment_expec="Appointment";
	public static String customers_expec="Customers";
	public static String activate_doubleBooking="Activate off-hours booking";
	
	//capturing the table
	public static By calendar_table=By.xpath("//table[@class='fc-agenda-slots']/tbody/tr");
	
	//click on the calendar tab
	//public static By calendar_tab=By.xpath("//a[@class='setmore-icon-calendar-31']");
	//click on the calendar to book the appointment
	public static By calendar_appointment=By.xpath("//div[@style='position:relative']");
	
	//calendar date
	public static By calendar_date=By.xpath("//*[@id=\"calendarHolder\"]/div/div/div/div/div/table/tbody/tr[49]/td/div");
	
	
	//clicking the provider
	public static By provider=By.xpath("//div[@class='appt-details-provider']");
	public static By choose_provider=By.xpath("//ul[@class='appt-dropdown-menu']//span[contains(text(),'Amazon')]");
	
	//click the service
	public static By service=By.xpath("//b[@class='appt-service-name']");
	public static By select_service=By.xpath("//span[contains(text(),'Hair Cut')]");
	
	//click the service time
	public static By click_service=By.xpath("//b[@class='appt-time-title']");
	public static By clickService_time=By.xpath("//ul[@class='appt-dropdown-menu appt-time-dropdown-list']/li[1]");
	public static By textarea=By.xpath("//textarea[@class='appt-notes-area']");
	
	//click the continue button
	public static By continue_button=By.xpath("//a[contains(text(),'Continue')]");
	
	//add new customer
	public static By addcustomer=By.xpath("//a[contains(text(),' + New Customer')]");
	
	//add customer details
	public static By customer_name=By.xpath("//input[@id='apptCust-name']");
	public static By customer_email=By.xpath("//input[@id='apptCust-LoginId']");
	public static By customer_ph=By.xpath("//input[@id='apptCust-MobileNo']");
	public static By customer_office=By.xpath("//input[@id='apptCust-OfficeNumber']");
	public static By save_appointment=By.xpath("//a[@id='dup-appt-save-btn']");
	
	//click on the customer tab
	public static By customer_tab=By.xpath("//li[@id='side-customers']/a");
	public static By search_customer=By.xpath("//input[@id='searchCustomer']");
	public static By customer_name_page=By.xpath("//input[@class='custProfileInput fl customer_name yellow_hover blue_focus']");
	
	//delete the customer
	public static By delete_customer_page=By.xpath("//div[@id='customerListHolder']/ul/li[1]/span/a");
	public static By delete_button_customer=By.xpath("//code[@class='delete_btn']");
	public static By confirm_delete=By.xpath("//span[@id='delete-confirmation-btn']");
	
	//double booking
	public static By click_settings=By.xpath("//div[@id='menu-button-svg']/div");
	public static By click_activate=By.xpath("//li[@class='options staff-openapp-opt selectable open-stats active']");
	public static By day_time_appointment=By.xpath("//b[@class='appt-day-label']");
	public static By click_date_appointment=By.xpath("//div[@class='datepicker calDatePicker']//following::div[@class='datepicker datepicker-day-time'][5]//div[@class='datepickerContainer']//tbody[@class='datepickerDays']/tr[5]/td[4]/a/span");

	//for asserts
	public static By calendar_header=By.xpath("//h1[contains(text(),'Calendar')]");
	public static By appointment_details=By.xpath("//div[@id='editApptPopup']/div[1]/h3");
	public static By customer_header=By.xpath("//h1[contains(text(),'Customers')]");	
}
