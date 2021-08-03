package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic_07_TextBox_TextArea {

	WebDriver driver;
	JavascriptExecutor js;

	By hereLink = By.xpath("//a[text()='here']");
	By emailIDInput = By.name("emailid");
	By loginButton = By.name("btnLogin");
	By submitButton = By.name("sub");
	By submitEditButton = By.name("AccSubmit");
	By userIDValue = By.xpath("//td[text()='User ID :']/following-sibling::td");
	By passwordValue = By.xpath("//td[text()='Password :']/following-sibling::td");
	By userIDInput = By.name("uid");
	By passwordInput = By.name("password");
	By welcomeTitle = By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]");
	By newCustomerMenu = By.xpath("//a[text()='New Customer']");
	By editCustomerMenu = By.xpath("//a[text()='Edit Customer']");
	By customerIDInput = By.name("cusid");
	By customerNameInput = By.name("name");
	By femaleRadio = By.xpath("//input[@value='f']");
	By dateofbirthInput = By.name("dob");
	By addressInput = By.name("addr");
	By cityInput = By.name("city");
	By stateInput = By.name("state");
	By pinInput = By.name("pinno");
	By numberphoneInput = By.name("telephoneno");
	By emailInput = By.name("emailid");

	By customerIDOutput = By.xpath("//td[text()='Customer ID']/following-sibling::td");
	By customerNameOutput = By.xpath("//td[text()='Customer Name']/following-sibling::td");
	By femaleRadioOutput = By.xpath("//td[text()='Gender']/following-sibling::td");
	By genderRadioOutput = By.xpath("//td[text()='Gender']/following-sibling::td/input");
	By dateofbirthOutput = By.xpath("//td[text()='Birthdate']/following-sibling::td");
	By addressOutput = By.xpath("//td[text()='Address']/following-sibling::td");
	By cityOutput = By.xpath("//td[text()='City']/following-sibling::td");
	By stateOutput = By.xpath("//td[text()='State']/following-sibling::td");
	By pinOutput = By.xpath("//td[text()='Pin']/following-sibling::td");
	By numberphoneOutput = By.xpath("//td[text()='Mobile No.']/following-sibling::td");
	By emailOutput = By.xpath("//td[text()='Email']/following-sibling::td");

	String loginUrl;
	String userID, password, customernameValue, dateofbirthValueInput, dateofbirthValueOutput, addressValue, cityValue, stateValue, pinValue, numberphoneValue, emailValue, passUserValue;
	String addressEditValue, cityEditValue, stateEditValue, pinEditValue, numberphoneEditValue, emailEditValue;
	String genderValueInput, genderValueOutput;
	String customerID;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "..\\WEDDRIVER_TMHOANG\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		// Open url : http://demo.guru99.com/v4/
		driver.get("http://demo.guru99.com/v4/");

		customernameValue = "tester";
		dateofbirthValueInput = "01/01/1990";
		dateofbirthValueOutput = "1990-01-01";
		genderValueInput = "f";
		genderValueOutput = "female";
		addressValue = "address";
		cityValue = "city";
		stateValue = "state";
		pinValue = "123456";
		numberphoneValue = "0351234567";
		emailValue = "testerdemo" + randomNumber(9999) + "@gmail.com";
		passUserValue = "password";

		addressEditValue = "address Edit";
		cityEditValue = "city Edit";
		stateEditValue = "state Edit";
		pinEditValue = "654321";
		numberphoneEditValue = "0357654321";
		emailEditValue = "testerdemoEdit" + randomNumber(9999) + "@gmail.com";
	}

	@Test
	public void TC_01_Register() {
		// Get login url
		loginUrl = driver.getCurrentUrl();
		// Click Here link in footer to register
		driver.findElement(hereLink).click();
		// Input email id to textbox
		String emailValue = "demoauto" + randomNumber(9999) + "@gmail.com";
		driver.findElement(emailIDInput).sendKeys(emailValue);
		// Click Submit button
		driver.findElement(loginButton).click();
		// Get value of user id and password
		userID = driver.findElement(userIDValue).getText();
		password = driver.findElement(passwordValue).getText();
	}

	@Test
	public void TC_02_Login() {
		// Open login url
		driver.get(loginUrl);
		// Input user id and password that were register in register step
		driver.findElement(userIDInput).sendKeys(userID);
		driver.findElement(passwordInput).sendKeys(password);
		// Click login button
		driver.findElement(loginButton).click();
		// Verify welcome message is displayed
		assertTrue(driver.findElement(welcomeTitle).isDisplayed());
	}

	@Test
	public void TC_03_New_Customer() {
		// Click New Customer menu
		driver.findElement(newCustomerMenu).click();
		// Input value for all items
		driver.findElement(customerNameInput).sendKeys(customernameValue);
		driver.findElement(femaleRadio).click();
		js.executeScript("arguments[0].removeAttribute('type')", driver.findElement(dateofbirthInput));
		driver.findElement(dateofbirthInput).sendKeys(dateofbirthValueInput);
		driver.findElement(addressInput).sendKeys(addressValue);
		driver.findElement(cityInput).sendKeys(cityValue);
		driver.findElement(stateInput).sendKeys(stateValue);
		driver.findElement(pinInput).sendKeys(pinValue);
		driver.findElement(numberphoneInput).sendKeys(numberphoneValue);
		driver.findElement(emailInput).sendKeys(emailValue);
		driver.findElement(passwordInput).sendKeys(passUserValue);
		// Click to submit button
		driver.findElement(submitButton).click();
		// Verify input value
		customerID = driver.findElement(customerIDOutput).getText();
		assertEquals(driver.findElement(customerNameOutput).getText(), customernameValue);
		assertEquals(driver.findElement(femaleRadioOutput).getText(), genderValueOutput);
		assertEquals(driver.findElement(dateofbirthOutput).getText(), dateofbirthValueOutput);
		assertEquals(driver.findElement(addressOutput).getText(), addressValue);
		assertEquals(driver.findElement(cityOutput).getText(), cityValue);
		assertEquals(driver.findElement(stateOutput).getText(), stateValue);
		assertEquals(driver.findElement(pinOutput).getText(), pinValue);
		assertEquals(driver.findElement(numberphoneOutput).getText(), numberphoneValue);
		assertEquals(driver.findElement(emailOutput).getText(), emailValue);
	}

	@Test
	public void TC_04_Edit_Customer() {
		// Click New Customer menu
		driver.findElement(editCustomerMenu).click();
		// Input value to customer id
		driver.findElement(customerIDInput).sendKeys(customerID);
		// Click submit button
		driver.findElement(submitEditButton).click();
		// Verify displayed value
		assertEquals(driver.findElement(customerNameInput).getAttribute("value"), customernameValue);
		assertEquals(driver.findElement(genderRadioOutput).getAttribute("value"), genderValueOutput);
		assertEquals(driver.findElement(dateofbirthInput).getAttribute("value"), dateofbirthValueOutput);
		assertEquals(driver.findElement(addressInput).getText(), addressValue);
		assertEquals(driver.findElement(cityInput).getAttribute("value"), cityValue);
		assertEquals(driver.findElement(stateInput).getAttribute("value"), stateValue);
		assertEquals(driver.findElement(pinInput).getAttribute("value"), pinValue);
		assertEquals(driver.findElement(numberphoneInput).getAttribute("value"), numberphoneValue);
		assertEquals(driver.findElement(emailInput).getAttribute("value"), emailValue);
		// Edit value to all items
		driver.findElement(addressInput).clear();
		driver.findElement(addressInput).sendKeys(addressEditValue);
		driver.findElement(cityInput).clear();
		driver.findElement(cityInput).sendKeys(cityEditValue);
		driver.findElement(stateInput).clear();
		driver.findElement(stateInput).sendKeys(stateEditValue);
		driver.findElement(pinInput).clear();
		driver.findElement(pinInput).sendKeys(pinEditValue);
		driver.findElement(numberphoneInput).clear();
		driver.findElement(numberphoneInput).sendKeys(numberphoneEditValue);
		driver.findElement(emailInput).clear();
		driver.findElement(emailInput).sendKeys(emailEditValue);
		// Click button submit
		driver.findElement(submitButton).click();
		// Verify input value
		assertEquals(driver.findElement(addressOutput).getText(), addressEditValue);
		assertEquals(driver.findElement(cityOutput).getText(), cityEditValue);
		assertEquals(driver.findElement(stateOutput).getText(), stateEditValue);
		assertEquals(driver.findElement(pinOutput).getText(), pinEditValue);
		assertEquals(driver.findElement(numberphoneOutput).getText(), numberphoneEditValue);
		assertEquals(driver.findElement(emailOutput).getText(), emailEditValue);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber(int bound) {
		Random rand = new Random();
		return rand.nextInt(bound);
	}

}
