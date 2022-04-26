package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {


	public WebDriver driver;
	public LandingPage(WebDriver driver) {

		this.driver=driver;

	}

	//driver.findElement(By.xpath("//button[normalize-space()='NO THANKS']")).click();
	private By nothanks = By.xpath("//button[normalize-space()='NO THANKS']");
	private	By featured = By.xpath("//h2[normalize-space()='Featured Courses']");
	private	By navigation = By.cssSelector("div[role='navigation']");
	
	private	By signIn = By.xpath("//span[normalize-space()='Login']");

	public WebElement getcloseTab() {
		return driver.findElement(nothanks);
	}

	public WebElement getTitle() {

		return driver.findElement(featured);
	}

	public WebElement getNavigation() {
		return driver.findElement(navigation);
	}

	public LoginPage getLogin() {

		driver.findElement(signIn).click();
		LoginPage loginPage = new LoginPage(driver);
		return loginPage;

	}
}
