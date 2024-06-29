package com.amazon.test;

import com.amazon.pages.amazonSearch;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;


public class amazonSearchTest {
    static ExtentHtmlReporter htmlreport;
    static Logger logger;
    static ExtentReports report;
    static WebDriver driver = null;

    @BeforeSuite
    public static void setupReport(){
        htmlreport = new ExtentHtmlReporter("extentReports.html");
        report = new ExtentReports();
        report.attachReporter(htmlreport);
    }
    @BeforeTest
    public static void initializeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @Test
    public static void searchTest() throws IOException {
        ExtentTest test =  report.createTest("searchTest","search product in amazon");
        String input = "iPhone";
        amazonSearch as = new amazonSearch(driver);
        as.searchOnAmazon(driver,input);
        test.log(Status.INFO,"search functionality check on amazon application");
        as.verifySearchedResultOnAmazon(driver,input);
        test.log(Status.INFO,"validate search functionality check on amazon application");
        test.pass("search functionality", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
    }

    @AfterTest
    public static void teardown(){
        driver.close();
        driver.quit();
    }

    @AfterSuite
    public static void closeReport(){
        report.flush();
    }
}
