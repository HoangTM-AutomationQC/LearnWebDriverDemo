package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Selenium_Locator {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "..\\WEDDRIVER_TMHOANG\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_FindElement() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement(By.xpath("//a[@title='Site Map']")).click();
	}

	@Test
	public void TC_02_ID() {
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.findElement(By.id("email")).sendKeys("testid@gmail.com");
	}

	@Test
	public void TC_03_Class() {
		driver.navigate().refresh();
		driver.findElement(By.className("validate-password")).sendKeys("testclass");
	}

	@Test
	public void TC_04_Name() {
		driver.navigate().refresh();
		driver.findElement(By.name("login[username]")).sendKeys("testname@gmail.com");
		
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
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
