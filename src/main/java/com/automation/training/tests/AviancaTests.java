package com.automation.training.tests;

import com.automation.training.MyDriver;
import com.automation.training.pages.*;
import org.testng.annotations.Test;

public class AviancaTests extends BaseTests {


    //@Test
    public void testBookingAFlight() {
        String origen = "Bogotá";
        String destiny = "Miami";
        AviancaHomePage aviancaHomePage = getAviancaHomePage();
        aviancaHomePage.fromCity(origen);
        aviancaHomePage.toCity(destiny);
        aviancaHomePage.sinceDateAndUntilDate("27 marzo 2021", "29 abril 2021" );
        aviancaHomePage.bookingFlight();
        PricesPage pricesPage = new PricesPage(myDriver.getDriver());
        pricesPage.resumeFlight(origen,destiny);
    }

    @Test
    public void testSortFlights()
    {
        AviancaHomePage aviancaHomePage = getAviancaHomePage();
        aviancaHomePage.clickIconMenu();
        MenuPage menuPage = new MenuPage(myDriver.getDriver());
        menuPage.clickOnFlightSchedules();
        FlightSchedulePage flightSchedulePage = new FlightSchedulePage(myDriver.getDriver());
        flightSchedulePage.selectFromCity("Bogotá").selectToCity("Cartagena");
        flightSchedulePage.selectDates("30 marzo 2021", "23 abril 2021");
        flightSchedulePage.clickOnSearch();
        ConsultingTimePage consultingTimePage = new ConsultingTimePage(myDriver.getDriver());
        consultingTimePage.sortFlights();
    }
}
