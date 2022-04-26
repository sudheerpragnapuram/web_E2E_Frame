package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	public ForgotPassword(WebDriver driver) {

		this.driver=driver;

	}

	By email = By.cssSelector("#user_email");
	By sendmeBtn = By.xpath("//input[@name='commit']");

	public WebElement getUser() {

		return driver.findElement(email);

	}
	public WebElement clickBtn() {

		return driver.findElement(sendmeBtn);

	}	


}
