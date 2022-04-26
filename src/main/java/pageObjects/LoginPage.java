package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver) {

		this.driver=driver;

	}

	By user = By.cssSelector("#user_email");
	By pass = By.cssSelector("#user_password");
	By loginBtn = By.xpath("//input[@name='commit']");

	By forgotPass = By.cssSelector(".link-below-button");

	public WebElement getUser() {

		return driver.findElement(user);

	}
	public WebElement getpass() {

		return driver.findElement(pass);

	}
	public WebElement getLoginBtn() {

		return driver.findElement(loginBtn);

	}

	public ForgotPassword getForgotPass() {
		driver.findElement(forgotPass).click();
		return new ForgotPassword(driver); // Another method creating return object, object will created in class

	}



}
