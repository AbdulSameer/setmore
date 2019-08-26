package com.setmore.implementations;

import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.setmore.constants.OpeningBrowser;
import com.setmore.specifications.CreateCustomer;
import com.setmore.specifications.SigninPage;
import com.setmore.testcases.CreateCustomerTestCase;

public class CreateCustomerImplements extends OpeningBrowser {
	public void createCustomer()
	{
		String url="https://my.setmore.com";

		driver.get(url);
		String current_url=driver.getCurrentUrl();
		Assert.assertEquals(current_url, url+"/");
		CreateCustomerTestCase.logger.log(Status.PASS,"Browser is invoked and url is passed");

		
		driver.findElement(SigninPage.username).sendKeys("abdulsameersetmore@gmail.com");
		driver.findElement(SigninPage.password).sendKeys("sameer999");
		
		boolean signin_button=driver.findElement(SigninPage.signin_button).isEnabled();
		System.out.println("Click signin button is enabled?: "+signin_button);
		driver.findElement(SigninPage.signin_button).click();
		CreateCustomerTestCase.logger.log(Status.PASS,"All the details are passed and signin successfully");
		
		String calendar_act=driver.findElement(CreateCustomer.calendar_header).getText();
		Assert.assertEquals(calendar_act, CreateCustomer.calendar_expec);
			}
	
	public void addNewCustomer() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(CreateCustomer.customer_tab));
		ele.click();
		
		String customer_act=driver.findElement(CreateCustomer.customer_header).getText();
		Assert.assertEquals(customer_act, CreateCustomer.customers_expec);

	String customer_name = UUID.randomUUID().toString();
    customer_name = customer_name.substring(0, Math.min(customer_name.length(), 10));
	String email = UUID.randomUUID().toString();
	email = email.substring(0, Math.min(email.length(), 10));
	String ph = UUID.randomUUID().toString();
	ph = ph.substring(0, Math.min(ph.length(), 10));
	
	
		
	    Thread.sleep(4000);
		driver.findElement(CreateCustomer.add_customer).click();
		
		String addNewCustomer_act=driver.findElement(CreateCustomer.addNewCustomer_header).getText();
		Assert.assertEquals(addNewCustomer_act, CreateCustomer.addNewCustomer_expec);
		
		driver.findElement(CreateCustomer.customer_name).sendKeys(customer_name);
		driver.findElement(CreateCustomer.customer_email).sendKeys(email+"@gmail.com");
		driver.findElement(CreateCustomer.customer_ph).sendKeys(ph);
		
		boolean add_customer_click=driver.findElement(CreateCustomer.add_customer_click).isEnabled();
		System.out.println("add customer button is enabled?: "+add_customer_click);
		driver.findElement(CreateCustomer.add_customer_click).click();
		CreateCustomerTestCase.logger.log(Status.PASS,"Customer is added and all the customer details are filled");
		
		
	
		//driver.findElement(CreateCustomer.cancel_button).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement check = wait1.until(ExpectedConditions.visibilityOfElementLocated(CreateCustomer.delete_customer));
		check.click();


	}

	public void delete_customer()
	{
		boolean delete_confirmation=driver.findElement(CreateCustomer.delete_confirmation).isEnabled();
		System.out.println("delete confirmation button is enabled?: "+delete_confirmation);
		driver.findElement(CreateCustomer.delete_confirmation).click();
		CreateCustomerTestCase.logger.log(Status.PASS,"Customer is deleted successfully");
	}
}
