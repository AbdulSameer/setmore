package com.setmore.specifications;

import org.openqa.selenium.By;

public class UploadingPic {
	
	//click on the customer tab
	public static By click_customerTab=By.xpath("//a[@class='setmore-icon-users2']");
	
	
	//searching the customer
	public static By search_customer=By.xpath("//input[@id='searchCustomer']");
	
	//click on the camera icon
	public static By click_camera=By.xpath("//img[@id='stafflistimage']");
	
	//cropandsave
	public static By crop_save=By.xpath("//button[@id='cropandsave']");
	
	//drag and drop the image
	public static By dragndrop=By.xpath("//div[@class='jcrop-tracker']");
	

}
