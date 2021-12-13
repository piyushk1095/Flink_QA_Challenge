package com.glue;

import Utility.Constant;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageFactory.CartHome;
import pageFactory.MoisturizersHome;
import pageFactory.SunscreensHome;
import pageFactory.WeatherShoppersHome;

public class WeatherShopper {

    WebDriver driver;
    WeatherShoppersHome objWeatherShoppers;
    MoisturizersHome objMoisturizersHome;
    SunscreensHome objSunscreensHome;
    CartHome objCartHome;
    int currentTemperature;

    @Given("^User navigates to Home page$")
    public void userNavigatesToHomePage() {
        driver = Hooks.driver;
        driver.get(Constant.baseURL);
    }

    @When("^User checks current temperature$")
    public void userChecksCurrentTemperature() {

        objWeatherShoppers = new WeatherShoppersHome(driver);
        currentTemperature = objWeatherShoppers.getCurrentTemperature();
    }

    @And("^User clicks for correct cream based on the temperature$")
    public void userClicksForCorrectCreamBasedOnTheTemperature() {

        objMoisturizersHome = new MoisturizersHome(driver);
        objSunscreensHome = new SunscreensHome(driver);

        if (currentTemperature < Constant.temperatureForMoisturizers)
        {
            objWeatherShoppers.clickOnBuyMoisturizersBtn();
            objMoisturizersHome.addMoisturizersToCart();
        }
        else if (currentTemperature > Constant.temperatureForSunscreens )
        {
            objWeatherShoppers.clickOnBuySunscreens();
            objSunscreensHome.addSunScreensToCart();
        }
        else
        {
            System.out.println("Temperature is above 19 and below 34, no shopping necessary!");
        }
    }

    @Then("^User updates the cart with correct products and makes payment$")
    public void userUpdatesTheCartWithCorrectProducts() throws Throwable{

        objCartHome = new CartHome(driver);

        if (currentTemperature < Constant.temperatureForMoisturizers)
        { objMoisturizersHome.clickOnCart(); }
        else if (currentTemperature > Constant.temperatureForSunscreens )
        { objSunscreensHome.clickOnCart(); }

        boolean cartNotEmptyFlag = objCartHome.verifyCartNotEmpty();
        Assert.assertTrue(cartNotEmptyFlag);

        objCartHome.clickOnPayWithCardBtn();
        //switching to iFrame for the card payment
        objCartHome.switchToIFrame();
        String expectedSuccessMessage = objCartHome.fillCardDetails();
        Assert.assertEquals(Constant.successMessage, expectedSuccessMessage.trim());

    }
}
