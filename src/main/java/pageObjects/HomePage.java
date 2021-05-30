package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

public class HomePage {

      CommonFunctions commonFunctions = new CommonFunctions();

      public HomePage(WebDriver driver)
      {
            PageFactory.initElements(driver, this);
      }

      @FindBy(id="")
      public WebElement menuOption;

      @FindBy(id="")
      public WebElement brandLogoIcon;

      @FindBy(id="sli_search_1")
      public WebElement searchTextFld;

      @FindBy(className="SearchButton")
      public WebElement searchIcon;

      @FindBy(id="")
      public WebElement basketIcon;

      @FindBy(id="")
      public WebElement languageIcon;

      @FindBy(id="")
      public WebElement myAccountLink;

      public void clickLogo()
      {
          brandLogoIcon.click();
      }

      public void validateLogo()
      {
          Assert.assertTrue(brandLogoIcon.isDisplayed());
      }

      public void enterSearchTerm(String searchTerm)
      {
          searchTextFld.sendKeys(searchTerm);
      }

      public void clickSearchIcon()
      {
          searchIcon.click();
      }

      public void clickBasketIcon()
      {
          basketIcon.click();
      }

      public void clickLanguageIcon()
      {
          languageIcon.click();
      }

      public void clickMyaccountLink()
      {
          myAccountLink.click();
      }

      public void mouseoverMenu()
      {
            commonFunctions.mouseOver(menuOption);
      }
}
