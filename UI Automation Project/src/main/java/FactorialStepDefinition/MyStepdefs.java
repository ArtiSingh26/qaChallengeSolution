package FactorialStepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.factorialPageFile;
import cucumber.api.java.After;

public class MyStepdefs {
    WebDriver driver =null;
    factorialPageFile factorialPage = null;

//    @Before
//    public void beforeScenario(){
//        System.out.println("*********** This is a cucumber before scenario method **********");
//        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
//        driver = new ChromeDriver();
//    }

    @Given("I navigate to the factorial calculator page")
    public void iNavigateToTheFactorialCalculatorPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://qainterview.pythonanywhere.com/");
        factorialPage = new factorialPageFile(driver);
    }

    @When("The page is loaded I can see the title {string} of the window")
    public void thePageIsLoadedICanSeeTheTitleOfTheWindow(String windowTitle) {
        String windowTitleFromUI = driver.getTitle();
        Assert.assertEquals(windowTitle, windowTitleFromUI);
    }

    @And("The user gives {string} in the text field and click on calculate button")
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

        String winHandleBefore = driver.getWindowHandle();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
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

//    @After
//    public void afterScenario(){
//        System.out.println("********* This is a cucumber after scenario method *********");
//        driver.quit();
//    }
}
