package stepDefintions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ListProductsPage;
import utils.CommonFunctions;

public class SearchSteps extends CommonFunctions {

    HomePage homePage = new HomePage(driver);
    ListProductsPage listProductsPage =  new ListProductsPage(driver);

    @When("I enter searchTerm {string}")
    public void i_enter_search_term(String searchTerm) {
          homePage.enterSearchTerm(searchTerm);
    }
    @When("I click search Icon")
    public void i_click_search_icon() {
        homePage.clickSearchIcon();
    }
    @Then("I should get relevant results with name contains {string}")
    public void i_should_get_relevant_results(String expectedText) {
        listProductsPage.validateSearchResults(expectedText);
    }
}
