package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage extends BasePage{

    @FindBy(xpath = "//div/a[contains(text(),'Antes de tu viaje')]/..//a[contains(text(),'Horarios de vuelo')]")
    private WebElement flightScheduleButton;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public MenuPage clickOnFlightSchedules(){
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(flightScheduleButton));
        flightScheduleButton.click();
        return this;
    }
}
