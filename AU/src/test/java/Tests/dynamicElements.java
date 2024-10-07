package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dynamicElements {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		
		//Set chromedriver path
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
		
		//Initialize Driver
		driver = new ChromeDriver();

		//Initialize wait
		wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		
		//Maximize browser screen
		driver.manage().window().maximize();
		
		//Go to URL
		driver.get("https://the-internet.herokuapp.com/disappearing_elements");
		
		WebElement ListOptions= driver.findElement(By.xpath("//div[@class='example']//ul"));
		
		List<WebElement> menuOptions = ListOptions.findElements(By.tagName("li"));
		
		//Condition that if element is visible on screen then click
		for (WebElement option : menuOptions) {
            if (option.isDisplayed()) {
                // Print the text of the displayed option
                System.out.println("Displayed option: " + option.getText());
                // Perform action, like clicking the option
                if(option.getText().equals("Gallery")) {
                	option.click();
                	System.out.println("Gallery Page Content: " +driver.findElement(By.tagName("h1")).getText());
                }
            }
        }
		
		//Quit Session
		driver.quit();
	}
}
