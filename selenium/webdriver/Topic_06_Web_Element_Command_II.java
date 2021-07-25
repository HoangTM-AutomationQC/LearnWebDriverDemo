package webdriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Topic_06_Web_Element_Command_II {

	WebDriver driver;
	By emailBy = By.id("mail");
	By under18By = By.id("under_18");
	By educationBy = By.id("edu");
	By h5By = By.xpath("//h5[text()='Name: User5']");
	By job1By = By.id("job1");
	By job2By = By.id("job2");
	By job3By = By.id("job3");
	By developmentBy = By.id("development");
	By checkboxDisabledBy = By.id("check-disbaled");
	By slider1By = By.id("slider-1");
	By slider2By = By.id("slider-2");
	By passwordBy = By.id("password");
	By radioDisabledBy = By.id("radio-disabled");
	By biographyBy = By.id("bio");
	By javaLanguageBy = By.id("java");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "..\\WEDDRIVER_TMHOANG\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Element_IsDisplayed() {
		// Truy cập vào trang : https://automationfc.github.io/basic-form/index.html
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Kiểm tra các phần từ sau hiển thị trên trang
		// Email
		if (isElementDisplayed(emailBy)) {
			sendKeyToElement(emailBy, "Automation testing");
			System.out.println("Email is displayed");
		} else {
			System.out.println("Email is not displayed");
		}
		// Age(Under 18)
		if (isElementDisplayed(under18By)) {
			System.out.println("under18 is displayed");
		} else {
			System.out.println("under18 is not displayed");
		}
		// Education
		if (isElementDisplayed(educationBy)) {
			sendKeyToElement(educationBy, "Automation testing");
			System.out.println("education is displayed");
		} else {
			System.out.println("education is not displayed");
		}
		// Kiểm tra các phần từ sau không hiển thị trên trang
		// Name: User5
		if (isElementDisplayed(h5By)) {
			System.out.println("h5 is displayed");
		} else {
			System.out.println("h5 is not displayed");
		}
	}

	@Test
	public void TC_02_Element_IsEnabled() {
		// Truy cập vào trang : https://automationfc.github.io/basic-form/index.html
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Kiểm tra các phần tử sau enabled trên trang
		// Email
		if (isElementEnabled(emailBy)) {
			System.out.println("Email is enabled");
		} else {
			System.out.println("Email is not enabled");
		}
		// Age (Under 18)
		if (isElementEnabled(under18By)) {
			System.out.println("Age (Under 18) is enabled");
		} else {
			System.out.println("Age (Under 18) is not enabled");
		}
		// Education
		if (isElementEnabled(educationBy)) {
			System.out.println("Education is enabled");
		} else {
			System.out.println("Education is not enabled");
		}
		// Job Role 01 and Job Role 02
		if (isElementEnabled(job1By)) {
			System.out.println("Job Role 01 is enabled");
		} else {
			System.out.println("Job Role 01 is not enabled");
		}
		if (isElementEnabled(job2By)) {
			System.out.println("Job Role 02 is enabled");
		} else {
			System.out.println("Job Role 02 is not enabled");
		}
		// Interests (development) Checkbox
		if (isElementEnabled(developmentBy)) {
			System.out.println("Interests (development) is enabled");
		} else {
			System.out.println("Interests (development) is not enabled");
		}
		// Slider 01
		if (isElementEnabled(slider1By)) {
			System.out.println("Slider 01 is enabled");
		} else {
			System.out.println("Slider 01 is not enabled");
		}
		// Kiểm tra các phần tử sau disabled trên trang
		// Password
		if (isElementEnabled(passwordBy)) {
			System.out.println("Password is enabled");
		} else {
			System.out.println("Password is not enabled");
		}
		// Age
		if (isElementEnabled(radioDisabledBy)) {
			System.out.println("Age is enabled");
		} else {
			System.out.println("Age is not enabled");
		}
		// Biography
		if (isElementEnabled(biographyBy)) {
			System.out.println("Biography is enabled");
		} else {
			System.out.println("Biography is not enabled");
		}
		// Job role 3
		if (isElementEnabled(job3By)) {
			System.out.println("Job role 3 is enabled");
		} else {
			System.out.println("Job role 3 is not enabled");
		}
		// Interests
		if (isElementEnabled(checkboxDisabledBy)) {
			System.out.println("Interests is enabled");
		} else {
			System.out.println("Interests is not enabled");
		}
		// Slider 02
		if (isElementEnabled(slider2By)) {
			System.out.println("Slider 02 is enabled");
		} else {
			System.out.println("Slider 02 is not enabled");
		}
	}

	@Test
	public void TC_03_Element_IsSelected() {
		// Truy cập vào trang : https://automationfc.github.io/basic-form/index.html
		driver.get("https://automationfc.github.io/basic-form/index.html");
		// Click chọn
		// Age (Under 18) radio button
		WebElement under18 = driver.findElement(under18By);
		under18.click();
		// "Language: Java" checkbox
		WebElement javaCheckbox = driver.findElement(javaLanguageBy);
		javaCheckbox.click();
		// Kiểm tra các phần tử ở step 02 được chọn
		// Age (under 18) radio button
		if (isElementSelected(under18By)) {
			System.out.println("Under 18 is selected");
		} else {
			System.out.println("Under 18 is not selected");
		}
		// "Language: Java" checkbox
		if (isElementSelected(javaLanguageBy)) {
			System.out.println("Language: Java is selected");
		} else {
			System.out.println("Language: Java is not selected");
		}
		// Click bỏ chọn "Language: Java" checkbox
		javaCheckbox.click();
		// Kiểm tra phần từ đã bỏ chọn
		if (isElementSelected(javaLanguageBy)) {
			System.out.println("Language: Java is selected");
		} else {
			System.out.println("Language: Java is not selected");
		}
	}

	public boolean isElementDisplayed(By elementBy) {
		WebElement element = driver.findElement(elementBy);
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementEnabled(By elementBy) {
		WebElement element = driver.findElement(elementBy);
		if (element.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementSelected(By elementBy) {
		WebElement element = driver.findElement(elementBy);
		if (element.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public void sendKeyToElement(By elementBy, String value) {
		WebElement element = driver.findElement(educationBy);
		element.sendKeys(value);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
