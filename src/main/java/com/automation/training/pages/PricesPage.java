package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PricesPage extends BasePage{
	
	public PricesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[contains(text(),'Salida de')]")
	private WebElement resumeLabel;
	
   public void resumeFlight(String origenCity, String destinyCity){
	   WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
	   wait.until(ExpectedConditions.visibilityOf(resumeLabel));
	   Assert.assertTrue(resumeLabel.getText().contains(origenCity) );
	   Assert.assertTrue(resumeLabel.getText().contains(destinyCity) );
   }
}
