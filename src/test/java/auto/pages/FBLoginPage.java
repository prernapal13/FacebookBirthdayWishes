package auto.pages;

/*
 * Created by: Prerna Pal Email: prerna.chanchal13@gmail.com Date: 12-Aug-18
 */

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.List;
import org.jboss.netty.handler.codec.frame.LengthFieldBasedFrameDecoder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import auto.utility.Services;

public class FBLoginPage extends Services {

	public FBLoginPage(WebDriver driver) {
		super(driver);
	}

	// locators
	private final static String HEADING = "Facebook";
	public String xpathHeading = "//i[contains(@class, 'fb_logo')]/u";
	public String xpathUsername = "//input[@class='inputtext' and @id='email']";
	public String xpathPassword = "//input[@class='inputtext' and @id='pass']";
	public String xpathLoginBtn = "//input[@value='Log In']";
	public String xpathUserNavigationLabel = "//div[@id='userNavigationLabel']";
	public String xpathLogoutBtn = "//a[contains(@data-gt, 'menu_logout')]";
	public String xpathNotification = "//span[@class='jewelCount']//i[text()='Notifications']";
	public String xpathBirthdayToday = "//span[contains(text(),'s birthday today.')]";
	public String xpathBirthdaysToday = "//span[contains(text(),' have birthdays today.')]";
	public String xpathGetBirthdayTextBoxes = "//div[@id='birthdays_today_card']//following-sibling::div//textarea";

	// methods
	public void verifyFBLoginPageHeader() {
		waitForElement(xpathHeading);
		WebElement headerEle = driver.findElement(By.xpath(xpathHeading));
		String actualHeading = headerEle.getText();
		assertEquals(actualHeading, HEADING,
				"Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
	}

	public void loginToYourAccount(String username, String password) {
		assertAndType(xpathUsername, username);
		assertAndType(xpathPassword, password);
		assertAndClick(xpathLoginBtn);

		waitForElementVisible(xpathUserNavigationLabel);
		assertAndClick(xpathUserNavigationLabel);
		waitForElementVisible(xpathLogoutBtn);
		String actualMsg = driver.findElement(By.xpath(xpathLogoutBtn)).getText().trim();

		assertTrue(actualMsg.contains("Log Out"), "Actual '" + actualMsg + "' should be same as expected 'Log Out'");

	}

	public void navigateToFriendsBirthdaysToday() {
		assertAndClick(xpathNotification);
		List<WebElement> birthdayToday = driver.findElements(By.xpath(xpathBirthdayToday));
		if (birthdayToday.size() != 0) {
			birthdayToday.get(0).click();
		} else {
			List<WebElement> birthdaysToday = driver.findElements(By.xpath(xpathBirthdaysToday));
			if (birthdaysToday.size() == 0) {
				System.out.println("None of the friends have their birthday today");
			} else {
				System.out.println("Some of your friends have birthday today. Let's make some wishes... ");
				birthdaysToday.get(0).click();

			}
		}
	}

	public void writeBirthdayWishes(String birthdayWish) {
		List<WebElement> lstBirthdayList = driver.findElements(By.xpath(xpathGetBirthdayTextBoxes));
		if (lstBirthdayList.size() > 0) {
			for (int i = 0; i < lstBirthdayList.size(); i++) {
				lstBirthdayList.get(i).sendKeys(birthdayWish);
				lstBirthdayList.get(i).sendKeys(Keys.ENTER);
			}
		}
	}
}
