package com.setmore.implementations;

import java.util.List;
import java.util.UUID;

import org.openqa.selenium.WebElement;

import com.setmore.constants.OpeningBrowser;
import com.setmore.specifications.BookingPage;

public class BookingPageImplements2 extends OpeningBrowser {
	public void bookingPage() throws Exception {
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
		
		driver.get("https://dccomics.setmore.com");
		driver.findElement(BookingPage.okay_button).click();
		driver.findElement(BookingPage.service_massage).click();
		driver.findElement(BookingPage.head_massage).click();
		driver.findElement(BookingPage.staff_engineer).click();
		
		List<WebElement> book_calendar=driver.findElements(BookingPage.calendar_table1);
		int date_size=book_calendar.size();
		System.out.println(date_size);
		boolean isChecked=false;
		for(int i=1;i<date_size;i++)
		{
			isChecked=book_calendar.get(i).isEnabled();
			if(!isChecked)
			{
				book_calendar.get(i).click();
				Thread.sleep(3000);
			}
		}
		driver.findElement(BookingPage.skip_login).click();
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
		driver.findElement(BookingPage.book_appointment).click();
	}
}
