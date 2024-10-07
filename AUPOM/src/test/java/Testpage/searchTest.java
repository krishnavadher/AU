package Testpage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.searchPage;

public class searchTest {
	static WebDriver driver = new ChromeDriver();

    public static void searchonGoogle() {
        searchPage searchPage = new searchPage(driver);
        driver.get("https://www.google.com");
        searchPage.enterSearchQuery("Selenium WebDriver");
        searchPage.clickEnter();
        searchPage.quitDriver();
    }
    
    public static void main(String[] args) {
    	searchonGoogle();
	}
}
