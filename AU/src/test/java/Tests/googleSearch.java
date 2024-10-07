package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSearch {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		//Set chromedriver path
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		
		//Initialize Driver
		driver = new ChromeDriver();

		//Go to URL
		driver.get("https://www.google.com");
		
		//Maximize browser screen
		driver.manage().window().maximize();
		
		//Finding WebELement with ID
		//WebElement searchBox = driver.findElement(By.id("APjFqb"));
		
		//Finding WebELement with Name
		//WebElement searchBox = driver.findElement(By.name("q"));
		
		//Finding WebELement with Classname
		//WebElement searchBox = driver.findElement(By.className("gLFyf"));
		
		//Finding WebELement with Tagname
		//WebElement searchBox = driver.findElement(By.tagName("textarea"));
		
		//Finding WebELement with CSSSelector
		//WebElement searchBox = driver.findElement(By.cssSelector(".gLFyf"));
		
		//Finding WebELement with Xpath
		WebElement searchBox = driver.findElement(By.xpath("//div[@class='a4bIc']//textarea"));
		
		//Input text in search box
		searchBox.sendKeys("Selenium automation");
		
		//Submit Text in search box
		searchBox.submit();
		
		//Added wait
		Thread.sleep(100);
			
		//print statement
		System.out.println("Page title is: " + driver.getTitle());
		
		//to quit the driver
		driver.quit();
	}
}
