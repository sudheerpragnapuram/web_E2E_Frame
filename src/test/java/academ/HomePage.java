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

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	public WebDriver driver; // To run parallel execution

	private static Logger log =LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void initializeDrive() throws IOException {
		driver = initializeDriver();
		log.info("Driver is instilaized");
		driver.get(prop.getProperty("url"));	
		log.info("Navigated to Home page");
	}

	@Test(dataProvider = "InputData" , dataProviderClass = DataProvider.class)
	public void validateHomePage(String username, String password) throws IOException, InterruptedException {

		//Landing Page starts
		LandingPage lp = new LandingPage(driver);
		Thread.sleep(3000);
		lp.getcloseTab().click();
		String title = lp.getTitle().getText();
		System.out.println(title);
		AssertJUnit.assertEquals(title, "FEATURED COURSES");

		// LoginPage starts
		LoginPage loginpage = lp.getLogin();
		loginpage.getUser().sendKeys(username);
		loginpage.getpass().sendKeys(password);
		loginpage.getLoginBtn().click();

		//FprgotPassword starts
		ForgotPassword fp=loginpage.getForgotPass();
		fp.getUser().sendKeys("Checking");
		fp.clickBtn().click();
		//System.out.println(text);

	}


	@AfterTest
	public void teardown() {
		System.out.println("Successfully closed");
		driver.quit();
	}
}



