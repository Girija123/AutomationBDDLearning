package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListProductsPage {

    public ListProductsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

      @FindBy(xpath="//div[@class='Info']/h2/a/span")
      public List<WebElement> allProductsNameReturned;

    public void validateSearchResults(String expectedTextInProductName)
    {
        for(WebElement eachProductName: allProductsNameReturned)
        {
            String actualProductName = eachProductName.getText();
            Assert.assertTrue(actualProductName.contains(expectedTextInProductName));
        }
    }

}
