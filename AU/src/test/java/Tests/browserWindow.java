package Tests;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browserWindow {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {

		// Set chromedriver path
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");

		// Initialize Driver
		driver = new ChromeDriver();

		// Initialize wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Maximize browser screen
		driver.manage().window().maximize();

		// Go to URL
		driver.get("https://demoqa.com/browser-windows");

		// Get main window Handle
		String mainWindow = driver.getWindowHandle();

		driver.findElement(By.id("tabButton")).click();

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("New tab Window Text: " + driver.findElement(By.id("sampleHeading")).getText());
			}
		}
		driver.switchTo().window(mainWindow);

		driver.findElement(By.id("windowButton")).click();
		
		Set<String> allWindows1 = driver.getWindowHandles();
		System.out.println(allWindows1);
		
		for (String windowHandle : allWindows1) {
			if (!windowHandle.equals(mainWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("New tab Window Text: " + driver.findElement(By.id("sampleHeading")).getText());
			}
		}
		driver.switchTo().window(mainWindow);

		driver.quit();
	}
}
