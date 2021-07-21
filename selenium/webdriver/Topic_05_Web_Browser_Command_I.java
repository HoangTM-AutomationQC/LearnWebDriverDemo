package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_Command_I {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "..\\WEDDRIVER_TMHOANG\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01() {
		// Open url 
		driver.get("http://live.demoguru99.com/");
		
		// return one element
		driver.findElement(By.xpath(""));
		
		// return list of element
		driver.findElements(By.xpath(""));
		
		// return current url in active tab
		driver.getCurrentUrl();
		
		// return source of current page
		driver.getPageSource();
		
		// return title of current page
		driver.getTitle();
		
		// return window id of current tab or window
		driver.getWindowHandle();
		
		// return list of tab or window
		driver.getWindowHandles();
		
		// open fullscreen of browser
		driver.manage().window().fullscreen();
		
		// seting maximize for browser
		driver.manage().window().maximize();
		
		// back to previous page
		driver.navigate().back();
		
		// forward to page
		driver.navigate().forward();
		
		// refresh page
		driver.navigate().refresh();
		
		// seting implicitlywait for find element
		driver.manage().timeouts().implicitlyWait(0, null);
		
		// closing active tab
		driver.close();
		
		// closing browser
		driver.quit();
	}

	@AfterClass
	public void afterClass() {

	}

}
