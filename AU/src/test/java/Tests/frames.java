package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class frames {
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
		driver.get("https://demoqa.com/frames");
		
		System.out.println("Main Page: "+driver.findElement(By.xpath("//div[@id='framesWrapper']//div")).getText());
		
		//Switching to frame 1
		driver.switchTo().frame("frame1");
		
		System.out.println("Frame 1: "+driver.findElement(By.id("sampleHeading")).getText());
		
		//Switching to main page
		driver.switchTo().defaultContent();
		
		//Switching to frame 2
		driver.switchTo().frame("frame2");
		
		System.out.println("Frame 2: "+driver.findElement(By.id("sampleHeading")).getText());
		
		driver.quit();
	}

}
