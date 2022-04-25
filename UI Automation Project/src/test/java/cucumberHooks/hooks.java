package cucumberHooks;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import page.basePage;

public class hooks extends basePage{
	
	@Before
	public void beforeScenrio(Scenario scenario) {
		System.out.println("*********** This is a cucumber before scenario method **********");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver.set(new ChromeDriver());
		driver.get().manage().window().maximize();;
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		System.out.println("********* This is a cucumber after scenario method *********");
		driver.get().quit();;
	}
	
}
