package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Topic_08_Default_Dropdown_List {

	WebDriver driver;

	By countryDropdownBy = By.name("where_country");
	By countrySearchButtonBy = By.id("search_loc_submit");
	By countResultNoValueBy = By.xpath("//div[@class='result_count']//span");
	By countResultValueBy = By.xpath("//div[@class='result_count']//span[text()='29']");
	By storeNameListBy = By.xpath("//div[@id='search_results']//div[@class='store_name']");
	By registerLinkBy = By.xpath("//a[text()='Register']");
	By femaleRadioBy = By.id("gender-female");
	By firstNameInputBy = By.id("FirstName");
	By lastNameInputBy = By.id("LastName");
	By dayDropdownBy = By.name("DateOfBirthDay");
	By monthDropdownBy = By.name("DateOfBirthMonth");
	By yearDropdownBy = By.name("DateOfBirthYear");
	By emailInputBy = By.id("Email");
	By passwordInputBy = By.id("Password");
	By passwordConfirmInputBy = By.id("ConfirmPassword");
	By registerButtonBy = By.id("register-button");
	By resultNoMessageBy = By.xpath("//div[@class='result']");
	By resultMessageBy = By.xpath("//div[@class='result' and text()='Your registration completed']");
	By myAccountLinkBy = By.xpath("//div[@class='header']//a[text()='My account']");

	String rodeUrl = "https://www.rode.com/wheretobuy";
	String nopCommerceUrl = "https://demo.nopcommerce.com/";
	String firstNameValue, lastNameValue, emailValue, passwordValue;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "..\\WEDDRIVER_TMHOANG\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		firstNameValue = "firstName";
		lastNameValue = "lastName";
		emailValue = "autotester" + randomNumber(9999) + "@gmail.com";
		passwordValue = "password";
	}

	@Test
	public void TC_02_Rode() {
		// Open rode url : https://www.rode.com/wheretobuy
		driver.get(rodeUrl);
		// Veriry this dropdown is not support to be multiple selected
		Select countryDropdownSelect = new Select(driver.findElement(countryDropdownBy));
		assertFalse(countryDropdownSelect.isMultiple());
		// Selecting Vietnam in dropdown list
		countryDropdownSelect.selectByVisibleText("Vietnam");
		// Verify selected value is Vietnam
		assertEquals(countryDropdownSelect.getFirstSelectedOption().getText(), "Vietnam");
		// Click button search
		driver.findElement(countrySearchButtonBy).click();
		// Verify count of result is 29
		// Solution 1. Using get text of element
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(driver.findElement(countResultNoValueBy).getText(), "29");
		// Solution 2. Using is displayed method
		assertTrue(driver.findElement(countResultValueBy).isDisplayed());
		// Printing all value into console
		List<WebElement> storeNameList = driver.findElements(storeNameListBy);
		for (WebElement storeName : storeNameList) {
			System.out.println(storeName.getText());
		}
	}

	@Test
	public void TC_03_NopCommerce() {
		// Open url : https://demo.nopcommerce.com/
		driver.get(nopCommerceUrl);
		// Click register link in Header
		driver.findElement(registerLinkBy).click();
		// Input valid value into form
		driver.findElement(femaleRadioBy).click();
		driver.findElement(firstNameInputBy).sendKeys(firstNameValue);
		driver.findElement(lastNameInputBy).sendKeys(lastNameValue);

		// Selecting Day = 1
		Select daySelect = new Select(driver.findElement(dayDropdownBy));
		daySelect.selectByVisibleText("1");
		// Verify count of items : 32
		assertEquals(daySelect.getOptions().size(), 32);
		// Selecting Month = May
		Select monthSelect = new Select(driver.findElement(monthDropdownBy));
		monthSelect.selectByVisibleText("May");
		// Verify count of items : 13
		assertEquals(monthSelect.getOptions().size(), 13);
		// Selecting Year = 1980
		Select yearSelect = new Select(driver.findElement(yearDropdownBy));
		yearSelect.selectByVisibleText("1980");
		// Verify count of items : 112
		assertEquals(yearSelect.getOptions().size(), 112);

		driver.findElement(emailInputBy).sendKeys(emailValue);
		driver.findElement(passwordInputBy).sendKeys(passwordValue);
		driver.findElement(passwordConfirmInputBy).sendKeys(passwordValue);

		// Click Register Button
		driver.findElement(registerButtonBy).click();
		// Verify navigating to home page successfully.
		assertEquals(driver.findElement(resultNoMessageBy).getText(), "Your registration completed");
		assertTrue(driver.findElement(resultMessageBy).isDisplayed());
		// Click My Account link
		driver.findElement(myAccountLinkBy).click();
		// Verify right information
		assertEquals(driver.findElement(firstNameInputBy).getAttribute("value"), firstNameValue);
		assertEquals(driver.findElement(lastNameInputBy).getAttribute("value"), lastNameValue);
		assertEquals(driver.findElement(emailInputBy).getAttribute("value"), emailValue);
		// Verify value of date/month/year is match with input value
		Select dayValueSelect = new Select(driver.findElement(dayDropdownBy));
		Select monthValueSelect = new Select(driver.findElement(monthDropdownBy));
		Select yearValueSelect = new Select(driver.findElement(yearDropdownBy));
		assertEquals(dayValueSelect.getFirstSelectedOption().getText(), "1");
		assertEquals(monthValueSelect.getFirstSelectedOption().getText(), "May");
		assertEquals(yearValueSelect.getFirstSelectedOption().getText(), "1980");

	}

	private int randomNumber(int bound) {
		Random rand = new Random();
		return rand.nextInt(bound);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
