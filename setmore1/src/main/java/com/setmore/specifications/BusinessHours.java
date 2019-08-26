package com.setmore.specifications;

import org.openqa.selenium.By;

public class BusinessHours {
	
	public static String bookingpage_expec="Booking Page";
	public static String timezone_expec="(GMT -07:00) Mountain Time - Phoenix";
	
	public static By click_appsintegration=By.xpath("//a[@class='setmore-icon-laptop-phone']");
	public static By click_configure=By.xpath("//button[@id='CompanyBookingPopUp']");
	public static By click_busineeshours=By.xpath("//span[contains(text(),'Business Hours')]");
	public static By click_dropdown=By.xpath("//a[@class='btn dropdown-toggle timezoneContainValue']");
	public static By click_timezone=By.xpath("//a[@index='Asia/Baku']");
	public static By click_ok=By.xpath("//input[@id='alertOk']");
	
	public static By click_timezone1=By.xpath("//ul[@class='dropdown-menu timezoneHolderList']/li/a[contains(text(),'(GMT -07:00) Mountain Time - Phoenix')]");
	
	//for asserts
	public static By bookingpageheader=By.xpath("//a[@class='close-btn left']//following::h3[1]");

}
