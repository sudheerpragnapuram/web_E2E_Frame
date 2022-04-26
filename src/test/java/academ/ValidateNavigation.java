package academ;

import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class ValidateNavigation extends Base {

	public WebDriver driver; // To run parallel execution
	
	private static Logger log =LogManager.getLogger(ValidateNavigation.class.getName());
	@BeforeTest
	public void initializeDrive() throws IOException {
		driver = initializeDriver();
		log.info("Driver is instilaized");
		driver.get(prop.getProperty("url"));	
		log.info("Navigated to Home page");	
	}
	@Test
	public void validateNavigationPage() throws IOException, InterruptedException {

		LandingPage lp = new LandingPage(driver);
		Thread.sleep(3000);
		lp.getcloseTab().click();
		
		AssertJUnit.assertTrue(lp.getNavigation().isDisplayed()); 

	}
	@AfterTest
	public void teardown() {
		System.out.println("Successfully closed");
		driver.quit();
	}
	
}
