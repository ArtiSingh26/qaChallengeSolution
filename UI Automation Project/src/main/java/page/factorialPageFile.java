package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class factorialPageFile extends basePage {

    public factorialPageFile(WebDriver driver){
        super(driver);
    }
    private final By inputFieldLocator = By.cssSelector("input#number");
    private final By calculateButtonLocator = By.cssSelector("button#getFactorial");
    private final By pageTitleLocator = By.cssSelector("h1.margin-base-vertical");
    private final By resultLocator = By.cssSelector("p#resultDiv");
    private final By termsAndConditionLocator = By.xpath("//a[contains (text(), 'Terms and Conditions')]");
    private final By privacyLocator = By.xpath("//a[contains (text(), 'Privacy')]");
    private final By qxf2ServicesLocator = By.xpath("//a[contains (text(), 'Qxf2 Services')]");
    private final By qxf2ServicesContentLocator = By.cssSelector("h1.banner-brown");
    private final By privacyContentLocator = By.tagName("body");
    private final By termsContentLocator = By.tagName("body");

    public boolean isCalculateButtonPresent(){
        WebElement calculateButton = driver.findElement(calculateButtonLocator);
        boolean display = calculateButton.isDisplayed();
        if (calculateButton.isDisplayed()){
            calculateButton.click();
        }
        return display;
    }

    public WebElement getInputBoxLocator(){
        WebElement inputBox = driver.findElement(inputFieldLocator);
        return inputBox;
    }

    public String getCalculatedResult(){
        String result = driver.findElement(resultLocator).getText();
        return result;
    }

    public String getTermsAndConditionWindowTitle(){
       String title = driver.getTitle();
       return title;
    }

    public String getPrivacyWindowTitle(){
        String title = driver.getTitle();
        return title;
    }

    public String getQxf2ServicesWindowTitle(){
        String title = driver.getTitle();
        return title;
    }

    public String getTermsWindowURL(){
        WebElement windowTitle = driver.findElement(termsAndConditionLocator);
        windowTitle.click();
        String URL = driver.getCurrentUrl();
        return URL;
    }

    public String getPrivacyWindowURL(){
        WebElement windowTitle = driver.findElement(privacyLocator);
        windowTitle.click();
        String URL = driver.getCurrentUrl();
        return URL;
    }

    public String getQxf2ServicesWindowURL(){
        WebElement windowTitle = driver.findElement(qxf2ServicesLocator);
        windowTitle.click();
        String URL = driver.getCurrentUrl();
        return URL;
    }

    public String getPageTitle(){
        String pageTitle = driver.findElement(pageTitleLocator).getText();
        return pageTitle;
    }

    public String getPlaceHolderValue(){
        WebElement inputBox = driver.findElement(inputFieldLocator);
        String placeholderValue = inputBox.getAttribute("placeholder");
        return placeholderValue;
    }

    public String getTermsWindowContent(){
        String windowContent = driver.findElement(termsContentLocator).getText();
        return windowContent;
    }

    public String getPrivacyWindowContent(){
        String windowContent = driver.findElement(privacyContentLocator).getText();
        return windowContent;
    }

    public String getQxf2ServicesWindowContent(){
        String windowContent = driver.findElement(qxf2ServicesContentLocator).getText();
        return windowContent;
    }
}
