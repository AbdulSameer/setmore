package com.setmore.implementations;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.setmore.constants.OpeningBrowser;
import com.setmore.specifications.CreateCustomer;
import com.setmore.specifications.DeleteMultipleCustomers;
import com.setmore.specifications.SigninPage;
import com.setmore.testcases.DeleteMultipleCustomersTestCase;

public class DeleteMultipleCustomersImplementations extends OpeningBrowser {
	
	public void createCustomer()
	{
		String url="https://my.setmore.com";

		driver.get(url);
		String current_url=driver.getCurrentUrl();
		Assert.assertEquals(current_url, url+"/");
		DeleteMultipleCustomersTestCase.logger.log(Status.PASS,"Browser is invoked and url is passed");

		driver.findElement(SigninPage.username).sendKeys("abdulsameersetmore@gmail.com");
		driver.findElement(SigninPage.password).sendKeys("sameer999");
		
		boolean signin_button=driver.findElement(SigninPage.signin_button).isEnabled();
		System.out.println("Click signin button is enabled?: "+signin_button);
		driver.findElement(SigninPage.signin_button).click();
		DeleteMultipleCustomersTestCase.logger.log(Status.PASS,"All the details are passed and signin successfully");
		
		String calendar_act=driver.findElement(CreateCustomer.calendar_header).getText();
		Assert.assertEquals(calendar_act, CreateCustomer.calendar_expec);
			}

	
	public void delete() {
		
		
		String parentwindow = driver.getWindowHandle();
		driver.switchTo().window(parentwindow);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(CreateCustomer.customer_tab));
		ele.click();

		
		String customer_act=driver.findElement(DeleteMultipleCustomers.customer_header).getText();
        Assert.assertEquals(customer_act, DeleteMultipleCustomers.customers_expec);		
		
		boolean check_customer=driver.findElement(DeleteMultipleCustomers.check_customer).isSelected();
		System.out.println("check the customer one is enabled?:"+check_customer);
		driver.findElement(DeleteMultipleCustomers.check_customer).click();
		
		boolean check_customer1=driver.findElement(DeleteMultipleCustomers.check_customer1).isSelected();
		System.out.println("check the customer 2 is enabled?: "+check_customer1);
		driver.findElement(DeleteMultipleCustomers.check_customer1).click();
		DeleteMultipleCustomersTestCase.logger.log(Status.PASS,"multiple customers are clicked");
		
		driver.findElement(DeleteMultipleCustomers.delete_customer).click();
		
		boolean delete_multiplecustomers=driver.findElement(DeleteMultipleCustomers.delete_multiple_customers).isEnabled();
		System.out.println("Check whehter the multiple customers are deleted?: "+delete_multiplecustomers);
		
		String deleteCustomer_act=driver.findElement(DeleteMultipleCustomers.deleteCustomer_header).getText();
		Assert.assertEquals(deleteCustomer_act, DeleteMultipleCustomers.delete_customer_expec);
		
		driver.findElement(DeleteMultipleCustomers.delete_multiple_customers).click();
		DeleteMultipleCustomersTestCase.logger.log(Status.PASS,"multiple customers are deleted");
		
	}
}
