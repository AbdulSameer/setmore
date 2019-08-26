package com.setmore.specifications;

import org.openqa.selenium.By;

public class CreateCustomer {
	
	public static String calendar_expec="Calendar";
	public static String customers_expec="Customers";
	public static String addNewCustomer_expec="Add New Customer";
	
	public static String cancel_btn="Cancel";
	
	public static By login_button=By.xpath("//a[@onclick='loginCheckFunction();']");
	
	//loginpage
	public static By username=By.xpath("//input[@id='username']");
	public static By password=By.xpath("//input[@id='password']");
	public static By sigin_click=By.xpath("//input[@type='submit']");
	
	//customer page tab
	public static By customer_tab=By.xpath("//a[@class='setmore-icon-users2']");
	public static By add_customer=By.xpath("//a[@id='newCustomer']");
	public static By customer_name=By.xpath("//input[@id='customerNewName']");
	public static By customer_email=By.xpath("//input[@id='customerNewEmail']");
	public static By customer_ph=By.xpath("//input[@id='customerNewMobile']");
	public static By add_customer_click=By.xpath("//button[@id='addnewCustomer']");
	
	//deleting the customer
	public static By delete_customer=By.xpath("//div[@id='deleteCustomerIcon']/img");
	public static By delete_confirmation=By.xpath("//span[@id='delete-confirmation-btn']");
	
	//clicking the checkbox for the customer
	public static By clickCheckBox=By.xpath("//li[@class='active']//a");
	
	//click cancel button for the customer add
	public static By cancel_button=By.xpath("//button[@id='cancelNewCustomer']");
	
	//for asserts
		public static By calendar_header=By.xpath("//h1[contains(text(),'Calendar')]");
		public static By customer_header=By.xpath("//h1[contains(text(),'Customers')]");
		public static By addNewCustomer_header=By.xpath("//h3[contains(text(),'Add New Customer')]");
	
}
 