package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.basePage;

import org.junit.Assert;
import page.factorialPageFile;

public class factorialStepDef extends basePage {
	
	factorialPageFile factorialPage;
	
	@Given("I navigate to the factorial calculator page")
    public void iNavigateToTheFactorialCalculatorPage() {
        driver.get().navigate().to("http://qainterview.pythonanywhere.com/");
        factorialPage = new factorialPageFile();
    }

    @When("The page is loaded I can see the title {string} of the window")
    public void thePageIsLoadedICanSeeTheTitleOfTheWindow(String windowTitle) {
        String windowTitleFromUI = driver.get().getTitle();
        Assert.assertEquals(windowTitle, windowTitleFromUI);
    }

    @Then("The user gives {string} in the text field and click on calculate button")
    public void theUserGivesInputInTheTextFieldAndClickOnCalculateButton(String input) {
        factorialPage.getInputBoxLocator().sendKeys(input);
        factorialPage.isCalculateButtonPresent();
    }

    @Then("I can see the result {string} on the page")
    public void iCanSeeTheResultOnThePage(String expectedResult) {
        Assert.assertEquals(expectedResult, factorialPage.getCalculatedResult());
    }

    @And("the user clicks on {string} which navigates to {string}")
    public void theUserClicksOnLinkTestWhichNavigatesToURL(String linkName, String linkURL) {
        switch (linkName){
            case "Terms and Conditions":
                Assert.assertEquals(linkURL, factorialPage.getTermsWindowURL());
                break;
            case "Privacy":
                Assert.assertEquals(linkURL, factorialPage.getPrivacyWindowURL());
                break;
            case "Qxf2 Services":
                Assert.assertEquals(linkURL, factorialPage.getQxf2ServicesWindowURL());
                break;
        }
    }

    @Then("I can see the {string} and {string} for {string}")
    public void iCanSeeTheWindowTitleAndExpectedWindowContent(String windowTitle, String expectedWindowContent, String linkName) {

        String winHandleBefore = driver.get().getWindowHandle();

        for(String winHandle : driver.get().getWindowHandles()){
            driver.get().switchTo().window(winHandle);
        }

        switch (linkName){
            case "Terms and Conditions":
                Assert.assertEquals(windowTitle, factorialPage.getTermsAndConditionWindowTitle());
                Assert.assertEquals(expectedWindowContent, factorialPage.getTermsWindowContent());
                break;
            case "Privacy":
                Assert.assertEquals(windowTitle, factorialPage.getPrivacyWindowTitle());
                Assert.assertEquals(expectedWindowContent, factorialPage.getPrivacyWindowContent());
                break;
            case "Qxf2 Services":
                Assert.assertEquals(windowTitle, factorialPage.getQxf2ServicesWindowTitle());
                Assert.assertEquals(expectedWindowContent, factorialPage.getQxf2ServicesWindowContent());
                break;
        }
    }

    @Then("I can see the page title as {string}")
    public void iCanSeeThePageTitleAs(String pageTitle) {
        Assert.assertEquals(pageTitle, factorialPage.getPageTitle());
    }

    @And("I can see the placeholder value as {string} in the input box")
    public void iCanSeeThePlaceholderValueAsInTheInputBox(String placeHolderValue) {
        Assert.assertEquals(placeHolderValue, factorialPage.getPlaceHolderValue());
    }
}
