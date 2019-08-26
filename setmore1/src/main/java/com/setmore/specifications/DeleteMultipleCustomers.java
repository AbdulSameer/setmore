package com.setmore.specifications;

import org.openqa.selenium.By;

public class DeleteMultipleCustomers {
	
	public static String customers_expec="Customers";
	public static String delete_customer_expec="Delete 2 customers";
	
	//click customer tab
	public static By click_customertab=By.xpath("//a[@class='setmore-icon-users2']");
	
	//selecting the multiple customers
	public static By check_customer=By.xpath("//div[@id='customerListHolder']/ul/li[1]/span/a");
	public static By check_customer1=By.xpath("//div[@id='customerListHolder']/ul/li[2]/span/a");
	
	//click delete the multiple customer
	public static By delete_customer=By.xpath("//li[@id='deleteAllCustomer']");
	public static By delete_multiple_customers=By.xpath("//span[@id='deleteSelectedCustomer']");
	
	//for asserts
	public static By customer_header=By.xpath("//h1[contains(text(),'Customers')]");
	public static By deleteCustomer_header=By.xpath("//span[contains(text(),'Delete')]");

	

}
