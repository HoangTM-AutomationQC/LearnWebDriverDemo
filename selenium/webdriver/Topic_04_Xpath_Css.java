package webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Xpath_Css {

	WebDriver driver;

	By registerButton = By.xpath("//div[contains(@class,'frmRegister')]//button[text()='ĐĂNG KÝ']");
	By firstNameError = By.id("txtFirstname-error");
	By emailError = By.id("txtEmail-error");
	By emailCError = By.id("txtCEmail-error");
	By passwordError = By.id("txtPassword-error");
	By passwordCError = By.id("txtCPassword-error");
	By phoneError = By.id("txtPhone-error");
	By firstNameInput = By.id("txtFirstname");
	By emailInput = By.id("txtEmail");
	By emailCInput = By.id("txtCEmail");
	By passwordInput = By.id("txtPassword");
	By passwordCInput = By.id("txtCPassword");
	By phoneInput = By.id("txtPhone");

	By myAccountLink = By.xpath("//div[@class='footer']//a[@title='My Account']");
	By emailGuruInput = By.id("email");
	By emailGuruRequiredError = By.id("advice-required-entry-email");
	By emailGuruInValidError = By.id("advice-validate-email-email");
	By passwordGuruInput = By.id("pass");
	By passworduruRequiredError = By.id("advice-required-entry-pass");
	By passwordGuruInValidError = By.id("advice-validate-password-pass");
	By loginButton = By.xpath("//button[@title='Login']");
	By messageValue = By.xpath("//ul[@class='messages']//span");
	By createAAcountButton = By.xpath("//a[@title='Create an Account']");
	By addFirstNameInput = By.id("firstname");
	By addMiddleNameInput = By.id("middlename");
	By addLastNameInput = By.id("lastname");
	By addEmailInput = By.id("email_address");
	By addPasswordInput = By.name("password");
	By addConfirmPasswordInput = By.name("confirmation");
	By addRegisterButton = By.xpath("//button[@title='Register']");
	By addContactInforValue = By.xpath("//div[@class='col-1']//p");
	By accountMenu = By.xpath("//a//span[text()='Account']");
	By logOutLink = By.xpath("//a[@title='Log Out']");
	By welComeMsg = By.xpath("//div[@class='welcome-msg']//strong");

	String firstNameValue = "tester";
	String emailValue = "tester26@gmail.com";
	String emailCValue = "tester26@gmail.com";
	String passwordValue = "tester26@";
	String passwordCValue = "tester26@";
	String phoneValue = "0351234567";

	String addFirstNameValue = "firstname";
	String addMiddleNameValue = "middlename";
	String addLastNameValue = "lastname";
	String addEmailValue = "autotester";
	String addPasswordValue = "password";
	String addConfirmPasswordValue = "password";
	String fullName;

	String demoguru99Url = "http://live.demoguru99.com/";
	String aladaUrl = "https://alada.vn/tai-khoan/dang-ky.html";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "..\\WEDDRIVER_TMHOANG\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {
		// Truy cập vào trang
		driver.get(aladaUrl);
		// Click vào button Đăng kí
		driver.findElement(registerButton).click();
		// Kiểm tra các error message hiển thị tại form đăng kí
		assertEquals(driver.findElement(firstNameError).getText(), "Vui lòng nhập họ tên");
		assertEquals(driver.findElement(emailError).getText(), "Vui lòng nhập email");
		assertEquals(driver.findElement(emailCError).getText(), "Vui lòng nhập lại địa chỉ email");
		assertEquals(driver.findElement(passwordError).getText(), "Vui lòng nhập mật khẩu");
		assertEquals(driver.findElement(passwordCError).getText(), "Vui lòng nhập lại mật khẩu");
		assertEquals(driver.findElement(phoneError).getText(), "Vui lòng nhập số điện thoại.");
	}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		// Truy cập vào trang
		driver.get(aladaUrl);
		// Nhập các field hợp lệ ngoại trừ Email và confirm Email
		driver.findElement(firstNameInput).sendKeys(firstNameValue);
		driver.findElement(passwordInput).sendKeys(passwordValue);
		driver.findElement(passwordCInput).sendKeys(passwordCValue);
		driver.findElement(phoneInput).sendKeys(phoneValue);
		// Nhập giá trị invalid email
		emailValue = "123@123.234@";
		emailCValue = "123@123.234@";
		driver.findElement(emailInput).sendKeys(emailValue);
		driver.findElement(emailCInput).sendKeys(emailCValue);
		// Click button Đăng kí
		driver.findElement(registerButton).click();
		// Kiểm tra các error message hiển thị tại form đăng kí
		assertEquals(driver.findElement(emailError).getText(), "Vui lòng nhập email hợp lệ");
		assertEquals(driver.findElement(emailCError).getText(), "Email nhập lại không đúng");
	}

	@Test
	public void TC_03_Register_With_Incorrect_ConfirmEmail() {
		// Truy cập vào trang
		driver.get(aladaUrl);
		// Nhập các field hợp lệ ngoại trừ confirm Email
		driver.findElement(firstNameInput).sendKeys(firstNameValue);
		driver.findElement(emailInput).sendKeys(emailValue);
		driver.findElement(passwordInput).sendKeys(passwordValue);
		driver.findElement(passwordCInput).sendKeys(passwordCValue);
		driver.findElement(phoneInput).sendKeys(phoneValue);
		// Nhập giá trị invalid cho confirm email
		emailCValue = "tmh@gmail.com";
		driver.findElement(emailCInput).sendKeys(emailCValue);
		// Click button Đăng kí
		driver.findElement(registerButton).click();
		// Kiểm tra các error message hiển thị tại form đăng kí
		assertEquals(driver.findElement(emailCError).getText(), "Email nhập lại không đúng");
	}

	@Test
	public void TC_04_Register_With_Less6Charater_Password() {
		// Truy cập vào trang
		driver.get(aladaUrl);
		// Nhập các field hợp lệ ngoại trừ confirm Email
		driver.findElement(firstNameInput).sendKeys(firstNameValue);
		driver.findElement(emailInput).sendKeys(emailValue);
		driver.findElement(emailCInput).sendKeys(emailCValue);
		driver.findElement(phoneInput).sendKeys(phoneValue);
		// Nhập giá trị password nhỏ hơn 6 kí tự
		passwordValue = "12345";
		passwordCValue = "12345";
		driver.findElement(passwordInput).sendKeys(passwordValue);
		driver.findElement(passwordCInput).sendKeys(passwordCValue);
		// Click button Đăng kí
		driver.findElement(registerButton).click();
		// Kiểm tra các error message hiển thị tại form đăng kí
		assertEquals(driver.findElement(passwordError).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		assertEquals(driver.findElement(passwordCError).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}

	@Test
	public void TC_05_Register_With_Incorrect_ConfirmPassword() {
		// Truy cập vào trang
		driver.get(aladaUrl);
		// Nhập các field hợp lệ ngoại trừ confirm Email
		driver.findElement(firstNameInput).sendKeys(firstNameValue);
		driver.findElement(emailInput).sendKeys(emailValue);
		driver.findElement(emailCInput).sendKeys(emailCValue);
		driver.findElement(phoneInput).sendKeys(phoneValue);
		// Nhập giá trị password nhỏ hơn 6 kí tự
		passwordCValue = "1234567";
		driver.findElement(passwordInput).sendKeys(passwordValue);
		driver.findElement(passwordCInput).sendKeys(passwordCValue);
		// Click button Đăng kí
		driver.findElement(registerButton).click();
		// Kiểm tra các error message hiển thị tại form đăng kí
		assertEquals(driver.findElement(passwordCError).getText(), "Mật khẩu bạn nhập không khớp");
	}

	@Test
	public void TC_06_Register_With_Invalid_PhoneNumber() {
		// Truy cập vào trang
		driver.get(aladaUrl);
		// Nhập các field hợp lệ ngoại trừ confirm Email
		driver.findElement(firstNameInput).sendKeys(firstNameValue);
		driver.findElement(emailInput).sendKeys(emailValue);
		driver.findElement(emailCInput).sendKeys(emailCValue);
		driver.findElement(passwordInput).sendKeys(passwordValue);
		driver.findElement(passwordCInput).sendKeys(passwordCValue);
		// Nhập giá trị password nhỏ hơn 6 kí tự
		phoneValue = "testertmh@gmail.com";
		driver.findElement(phoneInput).sendKeys(phoneValue);
		// Click button Đăng kí
		driver.findElement(registerButton).click();
		// Kiểm tra các error message hiển thị tại form đăng kí
		assertEquals(driver.findElement(phoneError).getText(), "Vui lòng nhập con số");

		// Nhập giá trị password lớn hơn 11 kí tự
		driver.findElement(phoneInput).clear();
		phoneValue = "035123456789";
		driver.findElement(phoneInput).sendKeys(phoneValue);
		// Click button Đăng kí
		driver.findElement(registerButton).click();
		// Kiểm tra các error message hiển thị tại form đăng kí
		assertEquals(driver.findElement(phoneError).getText(), "Số điện thoại phải từ 10-11 số.");

		// Nhập giá trị password lớn hơn 11 kí tự
		driver.findElement(phoneInput).clear();
		phoneValue = "0001234567";
		driver.findElement(phoneInput).sendKeys(phoneValue);
		// Click button Đăng kí
		driver.findElement(registerButton).click();
		// Kiểm tra các error message hiển thị tại form đăng kí
		assertEquals(driver.findElement(phoneError).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
	}

	@Test
	public void Logic_TC_01_Login_With_Empty_Email_Password() {
		// Truy cập vào trang http://live.demoguru99.com/
		driver.get(demoguru99Url);
		// Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(myAccountLink).click();
		// Để trống username và password
		driver.findElement(emailGuruInput).sendKeys("");
		driver.findElement(passwordGuruInput).sendKeys("");
		// Click vào login button
		driver.findElement(loginButton).click();
		// Check error message
		assertEquals(driver.findElement(emailGuruRequiredError).getText(), "This is a required field.");
		assertEquals(driver.findElement(passworduruRequiredError).getText(), "This is a required field.");
	}

	@Test
	public void Logic_TC_02_Login_With_Invalid_Email() {
		// Truy cập vào trang http://live.demoguru99.com/
		driver.get(demoguru99Url);
		// Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(myAccountLink).click();
		// Để trống username và password
		emailValue = "123@123.456";
		passwordValue = "123456";
		driver.findElement(emailGuruInput).sendKeys(emailValue);
		driver.findElement(passwordGuruInput).sendKeys(passwordValue);
		// Click vào login button
		driver.findElement(loginButton).click();
		// Check error message
		assertEquals(driver.findElement(emailGuruInValidError).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Logic_TC_03_Login_With_Less6Chatacter_Password() {
		// Truy cập vào trang http://live.demoguru99.com/
		driver.get(demoguru99Url);
		// Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(myAccountLink).click();
		// Để trống username và password
		passwordValue = "123";
		driver.findElement(emailGuruInput).sendKeys(emailValue);
		driver.findElement(passwordGuruInput).sendKeys(passwordValue);
		// Click vào login button
		driver.findElement(loginButton).click();
		// Check error message
		assertEquals(driver.findElement(passwordGuruInValidError).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Logic_TC_04_Login_With_Incorrect_Email_Password() {
		// Truy cập vào trang http://live.demoguru99.com/
		driver.get(demoguru99Url);
		// Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(myAccountLink).click();
		// Để trống username và password
		emailValue = "automation@gmail.com";
		passwordValue = "123123123";
		driver.findElement(emailGuruInput).sendKeys(emailValue);
		driver.findElement(passwordGuruInput).sendKeys(passwordValue);
		// Click vào login button
		driver.findElement(loginButton).click();
		// Check error message
		assertEquals(driver.findElement(messageValue).getText(), "Invalid login or password.");
	}

	@Test
	public void Logic_TC_05_Create_New_A_Account() {
		// Truy cập vào trang http://live.demoguru99.com/
		driver.get(demoguru99Url);
		// Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(myAccountLink).click();
		// Click vào button "Create An Account"
		driver.findElement(createAAcountButton).click();
		// Nhập vào tất cả các fields
		driver.findElement(addFirstNameInput).sendKeys(addFirstNameValue);
		driver.findElement(addMiddleNameInput).sendKeys(addMiddleNameValue);
		driver.findElement(addLastNameInput).sendKeys(addLastNameValue);
		Random rand = new Random();
		addEmailValue += rand.nextInt(999) + "@gmail.com";
		driver.findElement(addEmailInput).sendKeys(addEmailValue);
		driver.findElement(addPasswordInput).sendKeys(addPasswordValue);
		driver.findElement(addConfirmPasswordInput).sendKeys(addConfirmPasswordValue);
		// Click button Register
		driver.findElement(addRegisterButton).click();
		// Verify message xuất hiện khi đăng kí thành công
		assertEquals(driver.findElement(messageValue).getText(), "Thank you for registering with Main Website Store.");
		assertTrue(driver.findElement(messageValue).isDisplayed());
		// Verify thông tin được tạo ở dashboard
		fullName = addFirstNameValue + " " + addMiddleNameValue + " " + addLastNameValue;
		assertTrue(driver.findElement(welComeMsg).getText().contains(fullName));
		assertTrue(driver.findElement(addContactInforValue).getText().contains(fullName));
		assertTrue(driver.findElement(addContactInforValue).getText().contains(addEmailValue));
		driver.findElement(accountMenu).click();
		driver.findElement(logOutLink).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(driver.getTitle(), "Home page");
	}

	@Test
	public void Logic_TC_06_Login_With_Valid_Email_And_Password() {
		// Click vào link "My Account" để tới trang đăng nhập
		driver.findElement(myAccountLink).click();
		// Login với thông tin đăng nhập đã tạo ở trên
		driver.findElement(emailGuruInput).sendKeys(addEmailValue);
		driver.findElement(passwordGuruInput).sendKeys(addPasswordValue);
		// Click vào button Login
		driver.findElement(loginButton).click();
		// Verify các thông tin đươc hiển thị
		assertTrue(driver.findElement(welComeMsg).getText().contains(fullName));
		assertTrue(driver.findElement(addContactInforValue).getText().contains(fullName));
		assertTrue(driver.findElement(addContactInforValue).getText().contains(addEmailValue));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
