package Tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts {
	static WebDriver driver;
	static WebDriverWait wait;
	static Alert alert;

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
		driver.get("https://demoqa.com/alerts");
		//Click Button to see alert
		driver.findElement(By.id("alertButton")).click();
		alert= driver.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
		
		//On button click, alert will appear after 5 seconds
		driver.findElement(By.id("timerAlertButton")).click();
		alert= wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert Text: " + alert.getText());
		alert.accept();
		
		//On button click, confirm box will appear
		driver.findElement(By.id("confirmButton")).click();
		alert= driver.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.dismiss();
		
		//On button click, prompt box will appear
		driver.findElement(By.id("promtButton")).click();
		alert= driver.switchTo().alert();
		System.out.println("Alert Text: " + alert.getText());
		alert.sendKeys("Hello Selenium");
		alert.accept();
		
		driver.quit();
	}
}
