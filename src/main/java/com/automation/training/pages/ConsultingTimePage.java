package com.automation.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ConsultingTimePage extends BasePage{

    @FindBy(xpath = "//h1[contains(text(),'Consulta de itinerarios')]")
    private WebElement title;

    @FindBy(id = "mainContent_GrillaItinerariosIda_GridVuelos_LinkSortHoraSale_0")
    private WebElement sortByTime;

    public ConsultingTimePage(WebDriver pDriver) {
        super(pDriver);
    }

    public void sortFlights(){
        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
        //getDriver().close();
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(title));
        sortByTime.click();
    }
}
