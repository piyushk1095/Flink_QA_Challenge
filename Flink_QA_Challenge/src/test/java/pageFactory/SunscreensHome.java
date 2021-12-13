package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SunscreensHome {

    WebDriver driver;
    WebDriverWait wait;
    int leastExpensiveSPF30 = 0;
    int leastExpensiveSPF50 = 0;

    public SunscreensHome(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,20);
    }

    @FindBy(how = How.CLASS_NAME, using = "text-center")
    List<WebElement> listOfSunscreens;

    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    List<WebElement> addToCartBtnList;

    public void addSunScreensToCart() {

        WebElement leastExpensiveAloBtn = addToCartBtnList.get(0);
        WebElement leastExpensiveAlmondeBtn = addToCartBtnList.get(0);

        for ( int i = 0 ; i < listOfSunscreens.size(); i++)
        {
            wait.until(ExpectedConditions.visibilityOf(listOfSunscreens.get(i).findElement(By.xpath("./p[1]"))));
            String name = listOfSunscreens.get(i).findElement(By.xpath("./p[1]")).getText();

            if ( name.toUpperCase().contains("SPF-30")) {
                int price =   Integer.parseInt(listOfSunscreens.get(i).findElement(By.xpath("./p[2]")).getText().replaceAll("[\\D]", ""));

                if  ( leastExpensiveSPF30 == 0)
                {
                    leastExpensiveSPF30= price;
                    leastExpensiveAloBtn = listOfSunscreens.get(i).findElement(By.xpath("./button"));

                } else if (  leastExpensiveSPF30 != 0 && leastExpensiveSPF30 > price)
                {
                    leastExpensiveSPF30= price;
                    leastExpensiveAloBtn = listOfSunscreens.get(i).findElement(By.xpath("./button"));
                }
                else { //do nothing
                }
            }
            else if ( name.toUpperCase().contains("SPF-50"))
            {
                int price =   Integer.parseInt(listOfSunscreens.get(i).findElement(By.xpath("./p[2]")).getText().replaceAll("[\\D]", ""));

                if ( leastExpensiveSPF50 == 0)
                {
                    leastExpensiveSPF50= price;
                    leastExpensiveAlmondeBtn = listOfSunscreens.get(i).findElement(By.xpath("./button"));

                } else if ( leastExpensiveSPF50 != 0 && leastExpensiveSPF50 > price)
                {
                    leastExpensiveSPF50= price;
                    leastExpensiveAlmondeBtn = listOfSunscreens.get(i).findElement(By.xpath("./button"));
                }
                else {//do nothing
                }
            }
        }
        leastExpensiveAloBtn.click();
        leastExpensiveAlmondeBtn.click();
    }


    @FindBy (how = How.CLASS_NAME , using = "nav-link")
    WebElement cartBtn;

    public void clickOnCart() {

        wait.until(ExpectedConditions.visibilityOf(cartBtn));
        cartBtn.click();
    }
}
