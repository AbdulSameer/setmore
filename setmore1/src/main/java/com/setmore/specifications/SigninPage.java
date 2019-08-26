package com.setmore.specifications;

import org.openqa.selenium.By;

public class SigninPage {

	// signin details
	public static By username = By.xpath("//ul[@class='sign_in']//child::li[1]/input");
	public static By password = By.xpath("//ul[@class='sign_in']//child::li[2]/input");
	public static By signin_button = By.xpath("//input[@class='global_btn2_rt signin_btn']");

	// setmore apps and integration
	public static By appsandintegration = By.xpath("//a[@class='setmore-icon-laptop-phone']");
	public static By companyurl = By.xpath("//a[@class='wixBookingPageURL']");
	// signout
	public static By signout = By.xpath("//a[@class='right_nav_holder-loginid']");
	public static By clicksignout = By
			.xpath("//ul[@class='nav-topsub-navigation active-dropdown']/li[4]/a/div[2]//child::p");

	// click on the calendar page
	public static By calendarpage = By.xpath("//a[@class='setmore-icon-calendar-31']");
}
