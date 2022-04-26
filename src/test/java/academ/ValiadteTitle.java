package academ;

import org.testng.annotations.Test;
import pageObjects.LandingPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.Set;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.Base;

public class ValiadteTitle extends Base {

	public WebDriver driver; // To run parallel execution
	
	private static Logger log =LogManager.getLogger(ValiadteTitle.class.getName());
	@BeforeTest
	public void initializeDrive() throws IOException {
		driver = initializeDriver();
		log.info("Driver is instilaized");
		driver.get(prop.getProperty("url"));	
		log.info("Navigated to Home page");
	}
	
	@Test
	public void validateTitlePage() throws IOException, InterruptedException {

		LandingPage lp = new LandingPage(driver);
		Thread.sleep(3000);
		
		//Alert alert = driver.switchTo().alert();
		//alert.dismiss();
		lp.getcloseTab().click();
		log.error("Pop Up windowis not closed");
		String title = lp.getTitle().getText();
		System.out.println(title);
		AssertJUnit.assertEquals(title, "FEATURED COURSES123");
		log.info("Successfully validated Text message");

	}
	@AfterTest
	public void teardown() {
		System.out.println("Successfully closed");
		driver.quit();
		log.info("Window is closed successfully");
	}
	
}
