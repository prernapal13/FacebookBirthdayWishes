package auto.utility;

/*
 * Created by: Prerna Pal Email: prerna.chanchal13@gmail.com Date: 12-Aug-18
 */

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Services {

	protected WebDriver driver;

	public Services(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElement(String locator) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void assertAndClick(String locator) {
		assertElementPresentByXpath(locator);
		driver.findElement(By.xpath(locator)).click();
	}

	public void assertAndType(String locator, String text) {
		assertElementPresentByXpath(locator);
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}

	public void assertElementPresentByXpath(String locator) {
		Assert.assertTrue(isElementPresent(locator), "Element " + locator + " not found.");
	}

	public boolean isElementPresent(String locator) {
		try {
			driver.findElement(By.xpath(locator));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void waitForElementVisible(String locator) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
}
