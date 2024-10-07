package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class searchPage {
    WebDriver driver;

    By searchBar = By.name("q");
    By searchButton = By.name("btnK");

    public searchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchQuery(String query) {
        driver.findElement(searchBar).sendKeys(query);
    }
    
    public void clickEnter() {
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
    }
    
    public void quitDriver() {
    	driver.quit();
    }
}
