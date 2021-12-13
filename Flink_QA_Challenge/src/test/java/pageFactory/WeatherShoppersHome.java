package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class WeatherShoppersHome {

    WebDriver driver;
    WebDriverWait wait;

    public WeatherShoppersHome(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        //specifying 20 seconds wait timeout
        wait = new WebDriverWait(driver,20);
    }

    @FindBy(how = How.ID, using = "temperature")
    WebElement tempDiv;

    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    List<WebElement> btnList;


    public int getCurrentTemperature() {
       wait.until(ExpectedConditions.visibilityOf(tempDiv));
       return Integer.parseInt(tempDiv.getText().replaceAll("[\\D]", ""));
    }


    public void clickOnBuyMoisturizersBtn() {
      wait.until(ExpectedConditions.elementToBeClickable(btnList.get(0)));
      btnList.get(0).click();
    }

    public void clickOnBuySunscreens() {
        wait.until(ExpectedConditions.elementToBeClickable(btnList.get(1)));
        btnList.get(1).click();
    }

}
