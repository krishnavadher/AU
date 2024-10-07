package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementWait {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		
		//Set chromedriver path
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		
		//Initialize Driver
		driver = new ChromeDriver();

		//Initialize wait- Explicit wait
		wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Fluent wait
//		FluentWait<WebDriver> wait =
//			    new FluentWait<WebDriver>(driver)
//			        .withTimeout(Duration.ofSeconds(10))
//			        .pollingEvery(Duration.ofSeconds(5));
		
		//Maximize browser screen
		driver.manage().window().maximize();
		
		//Go to URL
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		
		//Finding WebELement with id
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='start']/button"))).click();
		
		//wait for element
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		
		//Print Text
		System.out.println(driver.findElement(By.id("finish")).getText());
	
		//Quit session
		driver.quit();
	}
	
		
}
