package com.automation.training.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.automation.training.MyDriver;
import com.automation.training.pages.AviancaHomePage;

public class BaseTests {
	
	MyDriver myDriver;
	
	private AviancaHomePage aviancaHomePage;
	
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser) {
		myDriver = new MyDriver(browser);
		aviancaHomePage = new AviancaHomePage(myDriver.getDriver());
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		aviancaHomePage.dispose();
	}

	public AviancaHomePage getAviancaHomePage() {
		return aviancaHomePage;
	}
}
