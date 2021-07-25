package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic_06_Web_Element_Command_I {

	WebDriver driver;
	By myAccountBy = By.xpath("//div[@class='footer']//a[text()='My Account']");
	By emailBy = By.id("email");
	By loginBy = By.xpath("//button[@title='Login']");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "..\\WEDDRIVER_TMHOANG\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		driver.get("http://live.demoguru99.com/");
		// 1. Không dùng biến
		driver.findElement(myAccountBy).click();
		driver.findElement(emailBy).sendKeys("automation");

		// 2. Dùng biến
		WebElement myAccountLink = driver.findElement(myAccountBy);
		WebElement emailInput = driver.findElement(emailBy);

		// Click to defined element
		myAccountLink.click();

		// Input value to element
		emailInput.sendKeys("automation");

		// Clear all value of element
		emailInput.clear();

		// Get value of defined attribute
		emailInput.getAttribute("class");

		// Get value of css
		emailInput.getCssValue("");

		// get tagname of defined element
		emailInput.getTagName();

		// get text value of element
		emailInput.getText();

		// return status of element
		emailInput.isDisplayed();
		emailInput.isEnabled();
		emailInput.isSelected();

		// only use of form
		emailInput.submit();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
