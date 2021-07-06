package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Selenium_Locator {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_FindElement() {
		driver.get("http://live.demoguru99.com/");
	}

	@Test
	public void TC_02_ID() {
		driver.navigate().refresh();
	}

	@Test
	public void TC_03_Class() {
		driver.navigate().refresh();
	}

	@Test
	public void TC_04_Name() {
		driver.navigate().refresh();
	}

	@Test
	public void TC_05_TagName() {
		driver.navigate().refresh();
	}

	@Test
	public void TC_06_LinkText() {
		driver.navigate().refresh();
	}

	@Test
	public void TC_07_PartialLinkText() {
		driver.navigate().refresh();
	}

	@Test
	public void TC_08_Css() {
		driver.navigate().refresh();
	}

	@Test
	public void TC_09_Xpath() {
		driver.navigate().refresh();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
