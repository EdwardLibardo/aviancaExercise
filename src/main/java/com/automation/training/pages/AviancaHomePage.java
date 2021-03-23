package com.automation.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AviancaHomePage extends BasePage {

    @FindBy(css = ".airport_ida[data-msg='Selecciona un origen']")
    private WebElement fromCity;

    @FindBy(css = ".airport_regreso[data-msg='Selecciona un destino']")
    private WebElement toCity;

    @FindBy(css = ".new-container-flexible .errorIntegradas .material-icons")
    private WebElement calendarButton;

    @FindBy(css = ".boton-container .pull-btn")
    private WebElement searchFlightsButton;

    @FindBy(css=".icon-menu")
    private WebElement iconMenu;

    public AviancaHomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.avianca.com/co/es/?gclid=EAIaIQobChMI5fukj7PC7wIVBjKGCh3ezgUKEAAYASAAEgJmn_D_BwE&gclsrc=aw.ds");
    }

    public AviancaHomePage fromCity(String originCity) {
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(fromCity)).clear();
        getDriver().manage().window().maximize();
        fromCity.sendKeys(originCity);
        fromCity.sendKeys(Keys.DOWN);
        fromCity.sendKeys(Keys.ENTER);
        return this;
    }

    public AviancaHomePage toCity(String destinationCity) {
        toCity.sendKeys(destinationCity);
        toCity.sendKeys(Keys.DOWN);
        toCity.sendKeys(Keys.ENTER);
        return this;
    }

    public AviancaHomePage sinceDateAndUntilDate(String sinceDateAttribute, String untilDateAttribute){
        String dateStr = "//div[@class='number-days']/table/tbody/tr/td[@aria-label='%1']";
        String sinceDate =  dateStr.replace("%1", sinceDateAttribute);
        calendarButton.click();
        getDriver().findElement(By.xpath(sinceDate)).click();
        String untilDate = dateStr.replace("%1", untilDateAttribute);
        getDriver().findElement(By.xpath(untilDate)).click();
        return this;
    }

    public AviancaHomePage bookingFlight(){
        searchFlightsButton.click();
        return this;
    }

    public AviancaHomePage clickIconMenu(){
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(fromCity)).clear();
        iconMenu.click();
        return this;
    }
}
