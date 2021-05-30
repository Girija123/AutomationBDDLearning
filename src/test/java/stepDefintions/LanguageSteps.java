package stepDefintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pageObjects.HomePage;
import utils.CommonFunctions;

public class LanguageSteps extends CommonFunctions {

    HomePage homePage = new HomePage(driver);

    @Given("^I'm on Home Page \"([^\"]*)\"$")
    public void i_m_on_Home_Page(String url) throws Throwable {
        driver.get(readProperty("urlDev"));
    }

    @When("^I click on language Icon$")
    public void i_click_on_language_Icon() throws Throwable {
        homePage.clickLanguageIcon();
    }

    @Then("^I should see \"([^\"]*)\" dropdown and language button$")
    public void i_should_see_dropdown_and_language_button(String location) throws Throwable {
        String actualLanguageDropDownLabel = driver.findElement(By.xpath("//label[@class='country']")).getText();
        Assert.assertEquals(location, actualLanguageDropDownLabel);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='languageButtons']")).isDisplayed());
    }

    @When("^I choose location as \"([^\"]*)\"$")
    public void i_choose_location_as(String locationOption) throws Throwable {
        new Select(driver.findElement(By.name("countrySelectorDropdown"))).selectByValue(locationOption);
    }

   /*  public void chooseProduct(String productName)
    {
        driver.findElement(By.xpath("//span[normalize-space(text())='"+productName+"']"));
    }*/

    @When("^I choose language as \"([^\"]*)\"$")
    public void i_choose_language_as(String languageOption) throws Throwable {
        driver.findElement(By.xpath("//input[@data-language='"+languageOption+"']")).click();
    }

    @When("^I click shop now button$")
    public void i_click_shop_now_button() throws Throwable {
        driver.findElement(By.id("btnFlagSelectorShopNow")).click();
        waitForTime(2);
    }

    @Then("^I should be re-directed to appropriate domain as \"([^\"]*)\"$")
    public void i_should_be_re_directed_to_appropriate_domain_as(String expectedDomain) throws Throwable {
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedDomain, actualUrl);
    }

}
