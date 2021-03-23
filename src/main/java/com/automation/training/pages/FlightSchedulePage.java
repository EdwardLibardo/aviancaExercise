package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightSchedulePage extends BasePage {

    @FindBy(css = "[data-msg-required='Origen, ingresa una ciudad, Aeropuerto']")
    private WebElement fromCityTextBox;

    @FindBy(css = "[data-msg-required='Destino, ingresa una ciudad, Aeropuerto']")
    private WebElement toCityTextBox;

    @FindBy(css = ".main-title")
    private WebElement title;

    @FindBy(css = "[data-msg-required='Fecha de salida, este campo es requerido']")
    private WebElement sinceDateTextBox;

    @FindBy(id = "fechaRegresoIter")
    private WebElement untilDateTextBox;

    @FindBy(css = "[title='Consultar']")
    private WebElement searchButton;

    public FlightSchedulePage(WebDriver pDriver) {
        super(pDriver);
    }

    public FlightSchedulePage selectFromCity(String originCity) {
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(title));
        getDriver().manage().window().maximize();
        fromCityTextBox.sendKeys(originCity);
        fromCityTextBox.sendKeys(Keys.DOWN);
        fromCityTextBox.sendKeys(Keys.ENTER);
        return this;
    }

    public FlightSchedulePage selectToCity(String toCity) {
        toCityTextBox.sendKeys(toCity);
        toCityTextBox.sendKeys(Keys.DOWN);
        toCityTextBox.sendKeys(Keys.ENTER);
        return this;
    }

    public FlightSchedulePage selectDates(String since, String until){
        sinceDateTextBox.click();
        String date ="//td[@class='cal1']/div[@class='number-days']/table/tbody/tr/td[@aria-label='%1']";
        String untDateStr= "//div[@class='bookingflow calendar2 c_fechaRegresoIter']/table/tbody/tr/td[@class='cal2']/div[@class='number-days']/table/tbody/tr/td[@aria-label='%1']";
        String sinceDate = date.replace("%1",since);
        getDriver().findElement(By.xpath(sinceDate)).click();
        String untilDate = untDateStr.replace("%1",until);
        untilDateTextBox.click();
        getDriver().findElement(By.xpath(untilDate)).click();
        return this;
    }

    public void clickOnSearch(){
        searchButton.click();
    }
}
