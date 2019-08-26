package com.setmore.implementations;

import java.util.Set;

import org.openqa.selenium.NoSuchFrameException;

import com.setmore.constants.OpeningBrowser;
import com.setmore.constants.Validating;
import com.setmore.specifications.SigninPage;

public class SigninPageImplements extends OpeningBrowser {
	public static String expTitle = "Free Online Software for Small Business - Login";
	public String email;
	public String pass;
	public static String childwindowtitle_expected = "Book an Appointment with DC COMICS Saloon - Hair Salon/Barbershop - ?????? - Arizona";
	public static String childwindow_actual;
	public String parentwindow_expc = "Setmore Profile";

	public void signin(String email, String password) throws Exception {
		driver.get("https://my.setmore.com");
		driver.findElement(SigninPage.username).sendKeys(email);
		driver.findElement(SigninPage.password).sendKeys(password);
		driver.findElement(SigninPage.signin_button).click();
		Thread.sleep(10000);
	}

	public void appsAndIntegration() throws Exception {

		driver.findElement(SigninPage.appsandintegration).click();
		driver.findElement(SigninPage.companyurl).click();

		// handling multiple windows
		Set<String> windows = driver.getWindowHandles();
		Object[] windowsconvert = windows.toArray();
		String parentwindow = windowsconvert[0].toString();
		String childwindow = windowsconvert[1].toString();
		driver.switchTo().window(childwindow);
		Thread.sleep(8000);
		childwindow_actual = driver.getTitle();
		System.out.println(childwindow_actual);
		Validating.verify(childwindowtitle_expected, childwindow_actual);
		driver.close();
		driver.switchTo().window(parentwindow);
		driver.findElement(SigninPage.appsandintegration).click();
		/*
		 * driver.navigate().back();
		 * 
		 * Thread.sleep(10000);
		 */
		/*
		 * Robot r = new Robot(); r.keyPress(KeyEvent.VK_TAB);
		 * r.keyRelease(KeyEvent.VK_TAB); r.keyPress(KeyEvent.VK_TAB);
		 * r.keyRelease(KeyEvent.VK_TAB); r.keyPress(KeyEvent.VK_ENTER);
		 * r.keyRelease(KeyEvent.VK_ENTER); r.keyPress(KeyEvent.VK_TAB);
		 * r.keyRelease(KeyEvent.VK_TAB); r.keyPress(KeyEvent.VK_TAB);
		 * r.keyRelease(KeyEvent.VK_TAB); r.keyPress(KeyEvent.VK_TAB);
		 * r.keyRelease(KeyEvent.VK_TAB); r.keyPress(KeyEvent.VK_ENTER);
		 * r.keyRelease(KeyEvent.VK_ENTER);
		 * 
		 */
		try {
			Thread.sleep(3000);
			String parentwindow_act = driver.getTitle();
			Validating.verify(parentwindow_expc, parentwindow_act);
			driver.findElement(SigninPage.signout).click();
			driver.findElement(SigninPage.clicksignout).click();
		} catch (NoSuchFrameException e) {
			System.out.println(e.getMessage());
		}
	}
}
