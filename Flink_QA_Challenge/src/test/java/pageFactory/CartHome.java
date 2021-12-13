package pageFactory;

import Utility.Constant;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartHome {

    WebDriver driver;
    WebDriverWait wait;

    public CartHome(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,20);
    }

    @FindBy ( how = How.CSS, using = "body > div.container.top-space-50 > div.row.justify-content-center.top-space-50 > table > tbody > tr:nth-child(1) > td:nth-child(1)")
    WebElement cartTableDiv1;
    @FindBy ( how = How.CSS, using =  "body > div.container.top-space-50 > div.row.justify-content-center.top-space-50 > table > tbody > tr:nth-child(2) > td:nth-child(1)")
    WebElement cartTableDiv2;
    @FindBy ( how = How.CLASS_NAME , using = "stripe-button-el")
    WebElement payWithCardBtn;
    @FindBy( how = How.ID , using = "email")
    WebElement emailDiv;
    @FindBy (how = How.ID , using = "card_number")
    WebElement cardNumberDiv;
    @FindBy ( how = How.ID, using = "cc-exp")
    WebElement ccExpiryDiv;
    @FindBy ( how = How.ID, using = "cc-csc")
    WebElement cvvDiv;
    @FindBy ( how = How.ID , using = "billing-zip")
    WebElement zipDiv;

    @FindBy ( how = How.CLASS_NAME , using = "iconTick")
    WebElement submitBtn;

    @FindBy ( how = How.CLASS_NAME, using = "text-justify")
    WebElement successMessage;

    public boolean verifyCartNotEmpty() {
        return ( cartTableDiv1.getText().length() > 0 && cartTableDiv2.getText().length() > 0);
    }

    public void clickOnPayWithCardBtn() {
        wait.until(ExpectedConditions.visibilityOf(payWithCardBtn));
        payWithCardBtn.click();
    }

    public String fillCardDetails() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(emailDiv));
        emailDiv.sendKeys(Constant.email);


        // sending card number and expiry number one by one as the input is not accepting complete string
        for ( int i = 0 ; i < Constant.cardNumber.length() ; i++)
        {
            cardNumberDiv.sendKeys( String.valueOf(Constant.cardNumber.charAt(i)));
        }

        for ( int i = 0 ; i < Constant.cardvalidity.length() ; i++)
        {
            ccExpiryDiv.sendKeys(String.valueOf(Constant.cardvalidity.charAt(i)));
        }

        cvvDiv.sendKeys(Constant.cvv);

        wait.until(ExpectedConditions.visibilityOf(zipDiv));
        zipDiv.sendKeys(Constant.zipcode);
        submitBtn.click();

        switchBackToDefaultContent();
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();

    }

    @FindBy(how = How.TAG_NAME, using = "iframe")
    WebElement iFrame;

    public void switchToIFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
    }

    public void switchBackToDefaultContent()  throws InterruptedException
    {
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
    }
}
