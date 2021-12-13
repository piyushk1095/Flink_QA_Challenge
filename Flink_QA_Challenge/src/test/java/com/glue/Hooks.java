package com.glue;

import Utility.Common;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static WebDriver driver;

    @Before()
    public void beforeScenario(Scenario scenario) {

        System.out.println("\n .....Before Starting the scenario...... \n");
        driver =  Common.assignWebDriver(scenario);
    }

    @After()
    public void afterScenario() {

        System.out.println("\n....After Scenario is completed successfully.....\n");
        driver.quit();
    }

}
