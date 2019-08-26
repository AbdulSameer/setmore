package com.setmore.constants;

import org.testng.Assert;

public class Validating {
	public static String verify(String actRes, String expRes) {
		try {
			Assert.assertEquals(actRes, expRes);
			return "pass";
		} catch (Error r) {

			return "fail";
		}
	}
}
