package webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_Command_II {

	WebDriver driver;

	String loginPageUrl, registerPageUrl, loginPageTitle, registerPageTitle;

	By myAccountLink = By.xpath("//div[@class='footer']//a[text()='My Account']");
	By createAnAccountButton = By.xpath("//a[@title='Create an Account']");

	public static final String LOGIN_PAGE_URL = "http://live.demoguru99.com/index.php/customer/account/login/";
	public static final String REGISTER_PAGE_URL = "http://live.demoguru99.com/index.php/customer/account/create/";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "..\\WEDDRIVER_TMHOANG\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Browser() {
		// Truy câp vào trang : http://live.demoguru99.com/
		driver.get("http://live.demoguru99.com/");

		// Click My Account link tại footer
		driver.findElement(myAccountLink).click();

		// Verify url của login page
		loginPageUrl = driver.getCurrentUrl();
		assertEquals(loginPageUrl, LOGIN_PAGE_URL);

		// Click Create An Account button
		driver.findElement(createAnAccountButton).click();

		// Verify url của register page
		registerPageUrl = driver.getCurrentUrl();
		assertEquals(registerPageUrl, REGISTER_PAGE_URL);
	}

	@Test
	public void TC_02_Browser() {
		// Truy câp vào trang : http://live.demoguru99.com/
		driver.get("http://live.demoguru99.com/");

		// Click My Account link tại footer
		driver.findElement(myAccountLink).click();

		// Veriry title của login Page
		loginPageTitle = driver.getTitle();
		assertEquals(loginPageTitle, "Customer Login");

		// Click Create An Account button
		driver.findElement(createAnAccountButton).click();

		// Verify title của register page
		registerPageTitle = driver.getTitle();
		assertEquals(registerPageTitle, "Create New Customer Account");
	}

	@Test
	public void TC_03_Browser() {
		// Truy câp vào trang : http://live.demoguru99.com/
		driver.get("http://live.demoguru99.com/");

		// Click My Account link tại footer
		driver.findElement(myAccountLink).click();

		// Click Create An Account button
		driver.findElement(createAnAccountButton).click();

		// Verify url của register page
		registerPageUrl = driver.getCurrentUrl();
		assertEquals(registerPageUrl, REGISTER_PAGE_URL);

		// Back to login page
		driver.navigate().back();

		// Verify url của login page
		loginPageUrl = driver.getCurrentUrl();
		assertEquals(loginPageUrl, LOGIN_PAGE_URL);

		// Forward to register page
		driver.navigate().forward();

		// Verify title của register page
		registerPageTitle = driver.getTitle();
		assertEquals(registerPageTitle, "Create New Customer Account");
	}

	@Test
	public void TC_04_Browser() {
		// Truy câp vào trang : http://live.demoguru99.com/
		driver.get("http://live.demoguru99.com/");

		// Click My Account link tại footer
		driver.findElement(myAccountLink).click();

		// Verify login page chứa text : Login or Create an Account
		assertTrue(driver.getPageSource().contains("Login or Create an Account"));

		// Click Create An Account button
		driver.findElement(createAnAccountButton).click();

		// Verify register page chứa text : Create an Account
		assertTrue(driver.getPageSource().contains("Create an Account"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
