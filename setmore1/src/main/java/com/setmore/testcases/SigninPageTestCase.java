package com.setmore.testcases;

import org.testng.annotations.Test;

import com.setmore.constants.OpeningBrowser;
import com.setmore.constants.Validating;
import com.setmore.implementations.SigninPageImplements;

import XLutils.XlUtils;

public class SigninPageTestCase extends OpeningBrowser {

	String Xlfile = "C:\\Users\\User.FULL308-WIN.003\\Desktop\\setmore.xlsx";
	String Xlsheet = "credentials";

	@Test
	public void signPage() throws Exception {
		String act_title = driver.getTitle();
		Validating.verify(act_title, SigninPageImplements.expTitle);

		SigninPageImplements log = new SigninPageImplements();

		log.email = XlUtils.getdata(Xlfile, Xlsheet, 1, 0);
		log.pass = XlUtils.getdata(Xlfile, Xlsheet, 1, 1);
		log.signin(log.email, log.pass);
		log.appsAndIntegration();

	}

}
