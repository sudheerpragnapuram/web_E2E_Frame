package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser"); // Use this step when running with Maven cmd--> mvn test -Dbrowser=chrome
		//String browserName = prop.getProperty("browser");

		if(browserName.contains("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver_100\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();// To run in Headless Mode, need to add this step
			if(browserName.contains("headless")) 
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);

		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\lib\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("IE")) {
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Invalid Browser Name");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}


	public String getScreenShotPath(String testMethoName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testMethoName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;


	}
}

//<test thread-count="5" name="Validating Title">
//<classes>
//  <class name="academ.ValiadteTitle"/>
// </classes>
//</test>
//
//<test thread-count="5" name="Validating Navigation">
//<classes>
//  <class name="academ.ValidateNavigation"/>
// </classes>
//</test>
