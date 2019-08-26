package com.setmore.implementations;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.setmore.constants.OpeningBrowser;
import com.setmore.specifications.CreateCustomer;
import com.setmore.specifications.SigninPage;
import com.setmore.specifications.UploadingPic;
import com.setmore.testcases.UploadinPicTestCase;

public class UploadingPicImplements extends OpeningBrowser {
	
	public void createCustomer()
	{
		String url="https://my.setmore.com";

		driver.get(url);
		String current_url=driver.getCurrentUrl();
		Assert.assertEquals(current_url, url+"/");
		UploadinPicTestCase.logger.log(Status.PASS,"Browser is invoked and url is passed");

		driver.findElement(SigninPage.username).sendKeys("abdulsameersetmore@gmail.com");
		driver.findElement(SigninPage.password).sendKeys("sameer999");
		
		boolean signin_button=driver.findElement(SigninPage.signin_button).isEnabled();
		System.out.println("Click signin button is enabled?: "+signin_button);
		driver.findElement(SigninPage.signin_button).click();
		UploadinPicTestCase.logger.log(Status.PASS,"All the details are passed and signin successfully");
		
		String calendar_act=driver.findElement(CreateCustomer.calendar_header).getText();
		Assert.assertEquals(calendar_act, CreateCustomer.calendar_expec);
	}
	/*public static String event(char imageName,String hardCode) {
		return hardCode+imageName+";";
	}*/
	public void customerPic() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(UploadingPic.click_customerTab));
		ele.click();
	    Thread.sleep(3000); 
		driver.findElement(UploadingPic.search_customer).sendKeys("abdul sameer");
	
		Thread.sleep(3000);
	  /*  File classpathRoot = new File(System.getProperty("user.dir"));
        File picturesDir = new File(classpathRoot, "./images");
        File picture = new File(picturesDir, "Captain_America.jpg");
        String picturePath = picture.getAbsolutePath();
	  */ 
		driver.findElement(UploadingPic.click_camera).click();
	    Thread.sleep(2000);
	    Robot r =new Robot();
	    for(int i=1;i<=6;i++)
	    {
	    r.keyPress(KeyEvent.VK_TAB);
	    r.keyRelease(KeyEvent.VK_TAB);
	    }
	    
	        r.keyPress(KeyEvent.VK_ENTER);
    	    r.keyRelease(KeyEvent.VK_ENTER);
	    					   
		    for(int j=0;j<=4;j++)
		    {
		    	r.keyPress(KeyEvent.VK_A);
		    	r.keyRelease(KeyEvent.VK_A);
	
		    }
		    Thread.sleep(2000);
				    r.keyPress(KeyEvent.VK_ENTER);
			    	r.keyRelease(KeyEvent.VK_ENTER);

			    	
			    	 for(int i=1;i<=3;i++)
			 	    {
			 	    r.keyPress(KeyEvent.VK_TAB);
			 	    r.keyRelease(KeyEvent.VK_TAB);
			 	    Thread.sleep(1000);
			 	    }
			    	 
			    	 r.keyPress(KeyEvent.VK_ENTER);
				     r.keyRelease(KeyEvent.VK_ENTER);
				     
				     r.keyPress(KeyEvent.VK_TAB);
				 	    r.keyRelease(KeyEvent.VK_TAB);
				 	  
				    	
				     for(int j=0;j<=4;j++)
					    {
					    	r.keyPress(KeyEvent.VK_A);
					    	r.keyRelease(KeyEvent.VK_A);
				
					    }
							    	

				    	 for(int i=1;i<=2;i++)
				 	    {
				 	    r.keyPress(KeyEvent.VK_TAB);
				 	    r.keyRelease(KeyEvent.VK_TAB);
				 	    Thread.sleep(1000);
				 	    }
				    	 
				    	 r.keyPress(KeyEvent.VK_ENTER);
					     r.keyRelease(KeyEvent.VK_ENTER);
					     
					     Thread.sleep(2000);	
					     
					     driver.findElement(UploadingPic.dragndrop).click();
					     
					     for(int k=1;k<=10;k++)
					     {
					     r.keyPress(KeyEvent.VK_LEFT);
					     r.keyRelease(KeyEvent.VK_LEFT);
					     Thread.sleep(1000);
					     }
					     Assert.assertEquals(driver.findElement(UploadingPic.crop_save).isEnabled(),true);
					     UploadinPicTestCase.logger.log(Status.PASS,"Crop and Save button is enabled");
					     driver.findElement(UploadingPic.crop_save).click();
					     
				    	Thread.sleep(10000);
				    
	     }
	

}
