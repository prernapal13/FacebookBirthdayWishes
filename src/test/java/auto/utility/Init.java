package auto.utility;
/*
 * Created by: Prerna Pal Email: prerna.chanchal13@gmail.com Date: 12-Aug-18
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class Init {
	protected WebDriver driver = null;

	/**
	 * This function is used for web driver setup.
	 */
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		System.out.println("*** Setup ***");
		//FirefoxProfile ffprofile = createFirefoxProfile();
		//driver = new FirefoxDriver(ffprofile);
		driver = new ChromeDriver();
		driver.get("http://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	/**
	 * This function quits the driver instance.
	 */
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		System.out.println("*** Teardown ***");
		if (driver != null)
			driver.quit();

	}

	public FirefoxProfile createFirefoxProfile() {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
		return firefoxProfile;
	}
}
