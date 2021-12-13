package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MoisturizersHome {

    WebDriver driver;
    WebDriverWait wait;
    int leastExpensiveAloeMoisturizer= 0;
    int leastExpensiveAlmondMoisturizer = 0;

    public MoisturizersHome(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,20);
    }

    @FindBy(how = How.CLASS_NAME, using = "text-center")
    List<WebElement> listOfMoisturizers;

    @FindBy(how = How.CLASS_NAME, using = "btn-primary")
    List<WebElement> addToCartBtnList;

    public void addMoisturizersToCart() {

      WebElement leastExpensiveAloBtn = addToCartBtnList.get(0);
      WebElement leastExpensiveAlmondeBtn = addToCartBtnList.get(0);

      for ( int i = 0 ; i < listOfMoisturizers.size(); i++)
        {

            wait.until(ExpectedConditions.visibilityOf(listOfMoisturizers.get(i).findElement(By.xpath("./p[1]"))));
            String name = listOfMoisturizers.get(i).findElement(By.xpath("./p[1]")).getText();

            if ( name.toLowerCase().contains("aloe")) {
                int price =   Integer.parseInt(listOfMoisturizers.get(i).findElement(By.xpath("./p[2]")).getText().replaceAll("[\\D]", ""));

                if   ( leastExpensiveAloeMoisturizer == 0)
                {
                    leastExpensiveAloeMoisturizer= price;
                    leastExpensiveAloBtn = listOfMoisturizers.get(i).findElement(By.xpath("./button"));

                } else if (  leastExpensiveAloeMoisturizer != 0 && leastExpensiveAloeMoisturizer > price)
                {
                    leastExpensiveAloeMoisturizer= price;
                    leastExpensiveAloBtn = listOfMoisturizers.get(i).findElement(By.xpath("./button"));
                }
                else {//do nothing
                }
            }
            else if ( name.toLowerCase().contains("almond"))
            {
                int price =   Integer.parseInt(listOfMoisturizers.get(i).findElement(By.xpath("./p[2]")).getText().replaceAll("[\\D]", ""));

                if   ( leastExpensiveAlmondMoisturizer == 0)
                {
                    leastExpensiveAlmondMoisturizer= price;
                    leastExpensiveAlmondeBtn = listOfMoisturizers.get(i).findElement(By.xpath("./button"));

                } else if (  leastExpensiveAlmondMoisturizer != 0 && leastExpensiveAlmondMoisturizer > price)
                {
                    leastExpensiveAlmondMoisturizer= price;
                    leastExpensiveAlmondeBtn = listOfMoisturizers.get(i).findElement(By.xpath("./button"));
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
