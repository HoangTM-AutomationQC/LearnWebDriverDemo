package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic_06_Web_Element_Command_III {

	WebDriver driver;

	By emailBy = By.id("email");
	By usernameBy = By.id("new_username");
	By passwordBy = By.id("new_password");
	By signupBy = By.id("create-account");
	By oneNumberBy = By.xpath("//li[text()='One number' and @class='number-char completed']");
	By lowerCaseBy = By.xpath("//li[text()='One lowercase character' and @class='lowercase-char completed']");
	By upperCaseBy = By.xpath("//li[text()='One uppercase character' and @class='uppercase-char completed']");
	By oneSpecialBy = By.xpath("//li[text()='One special character' and @class='special-char completed']");
	By minCharactersBy = By.xpath("//li[text()='8 characters minimum' and @class='8-char completed']");
	By passwordRequiredContainsBy = By.xpath("//div[contains(@class,'password-requirements')]");
	By passwordRequiredDisplayedBy = By.xpath("//div[@class='line password-requirements !margin-bottom--lv2 always-open hide']");
	By newsLetterBy = By.id("marketing_newsletter");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "..\\WEDDRIVER_TMHOANG\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC_04_Register_Function_At_MailChimp() {
		// Truy cập vào trang : https://login.mailchimp.com/signup/
		driver.get("https://login.mailchimp.com/signup/");

		// Nhập dữ liệu hợp lệ vào 2 trường : Email/Username
		driver.findElement(emailBy).sendKeys("tester999@gmail.com");
		driver.findElement(usernameBy).sendKeys("tester999");

		// Nhập dữ liệu với các tiêu chí khác nhau để kiểm tra cách validate của trường Password
		// Nhập số
		driver.findElement(passwordBy).clear();
		driver.findElement(passwordBy).sendKeys("1");
		// Kiểm tra tiêu chí bị disabled khi password hợp lệ
		assertTrue(driver.findElement(oneNumberBy).isDisplayed());
		// Kiểm tra sign up button bị disable khi có password không hợp lệ
		assertFalse(driver.findElement(signupBy).isEnabled());

		// Nhập chữ thường
		driver.findElement(passwordBy).clear();
		driver.findElement(passwordBy).sendKeys("u");
		// Kiểm tra tiêu chí bị disabled khi password hợp lệ
		assertTrue(driver.findElement(lowerCaseBy).isDisplayed());
		// Kiểm tra sign up button bị disable khi có password không hợp lệ
		assertFalse(driver.findElement(signupBy).isEnabled());

		// Nhập chữ hoa
		driver.findElement(passwordBy).clear();
		driver.findElement(passwordBy).sendKeys("A");
		// Kiểm tra tiêu chí bị disabled khi password hợp lệ
		assertTrue(driver.findElement(upperCaseBy).isDisplayed());
		// Kiểm tra sign up button bị disable khi có password không hợp lệ
		assertFalse(driver.findElement(signupBy).isEnabled());

		// Nhập kí tự đặc biệt
		driver.findElement(passwordBy).clear();
		driver.findElement(passwordBy).sendKeys("@");
		// Kiểm tra tiêu chí bị disabled khi password hợp lệ
		assertTrue(driver.findElement(oneSpecialBy).isDisplayed());
		// Kiểm tra sign up button bị disable khi có password không hợp lệ
		assertFalse(driver.findElement(signupBy).isEnabled());

		// Lớn hơn 8 kí tự
		driver.findElement(passwordBy).clear();
		driver.findElement(passwordBy).sendKeys("11111111");
		// Kiểm tra tiêu chí bị disabled khi password hợp lệ
		assertTrue(driver.findElement(minCharactersBy).isDisplayed());
		// Kiểm tra sign up button bị disable khi có password không hợp lệ
		assertFalse(driver.findElement(signupBy).isEnabled());

		// Nhập tất cả thông tin hợp lệ
		driver.findElement(passwordBy).clear();
		driver.findElement(passwordBy).sendKeys("1@Aution");
		assertFalse(driver.findElement(passwordRequiredDisplayedBy).isDisplayed());
		assertTrue(driver.findElement(passwordRequiredContainsBy).getAttribute("class").contains("hide"));
		// Kiểm tra sign up button không còn disable khi không bất kì có password không hợp lệ
		assertTrue(driver.findElement(signupBy).isEnabled());

		// Kiểm tra checkbox được chọn sau khi click chọn thành công
		driver.findElement(newsLetterBy).click();
		assertTrue(driver.findElement(newsLetterBy).isSelected());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
