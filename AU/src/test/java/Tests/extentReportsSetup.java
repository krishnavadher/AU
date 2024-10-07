package Tests;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class extentReportsSetup {
	public static void main(String[] args) throws IOException {
        // Step 1: Initialize ExtentHtmlReporter
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
		sparkReporter.config().setDocumentTitle("Automation Report"); // Title of the report
		sparkReporter.config().setReportName("Functional Testing"); // Name of the report
		sparkReporter.config().setTheme(Theme.STANDARD); // Theme of the report

        // Step 2: Initialize ExtentReports and attach the HtmlReporter
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Krishna");

        // Step 3: Create a test case (starts the logging)
        ExtentTest test = extent.createTest("Sample Test Case", "Testing Extent Report Integration");

        // Step 4: Log test details (simulating test actions with Selenium)
        WebDriver driver = new ChromeDriver();
        test.log(Status.INFO, "Starting the browser");
        driver.get("https://www.google.com");
        test.log(Status.PASS, "Navigated to google.com");
        
        // Capture a screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/test.png";
        Files.copy(srcFile, new File(screenshotPath));

        // Log with a screenshot
        test.addScreenCaptureFromPath(screenshotPath);
        test.log(Status.PASS, "Screenshot captured");

        // Close the browser
        driver.quit();
        test.log(Status.INFO, "Closed the browser");

        // Step 5: Flush the report (this writes everything to the report)
        extent.flush();
    }
}
