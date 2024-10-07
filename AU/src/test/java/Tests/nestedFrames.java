package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class nestedFrames {
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
		driver.get("https://demoqa.com/nestedframes");
	
		System.out.println("Main Page: "+driver.findElement(By.xpath("//div[@id='framesWrapper']//div")).getText());
		
		//Switch to a Frame
		driver.switchTo().frame("frame1");
		
		System.out.println("Parent Frame: "+ driver.findElement(By.xpath("//html//body")).getText());
		
		//Inside parent frame switch to child frame
		driver.switchTo().frame(0);
		
		System.out.println("Child Frame: "+driver.findElement(By.xpath("//html//body")).getText());
		
		driver.quit();	
	}
}
