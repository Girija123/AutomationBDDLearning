package stepDefintions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.CommonFunctions;

public class MenuSteps extends CommonFunctions {

    public static String thisMenu;

    @When("I mouseover menu {string}")
    public void i_mouseover_menu(String menuOption) {


        WebElement menu = driver.findElement(By.xpath("//span[text()='" + menuOption + "']"));
        mouseOver(menu);
        thisMenu = menuOption;
     /*   JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");*/
        //js.executeScript("arguments[0].click();", menu);
    }

    @When("I click submenu {string}")
    public void i_click_submenu(String subMenuOption) {
        driver.findElement(By.xpath("//div[@data-parentname='" + thisMenu + "']/div/ul/li/div/a[text()='" + subMenuOption + "']"));
    }

    @Then("I should be on appropriate product page with Header as {string}")
    public void i_should_be_on_appropriate_product_page_with_header_as(String expectedPageHeader) {
        driver.findElement(By.xpath("//h1[contains(text(), '"+expectedPageHeader+"')]"));
    }


}
