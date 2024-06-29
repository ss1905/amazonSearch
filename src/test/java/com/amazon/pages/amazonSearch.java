package com.amazon.pages;

import com.amazon.objectRepository.amazonSearchObject;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class amazonSearch extends amazonSearchObject {

    private static WebDriver driver;

    public amazonSearch(WebDriver driver){
        this.driver = driver;
    }
    public static void searchOnAmazon(String input){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBoxBy));
        searchBox(driver).sendKeys(input);
        searchButton(driver).click();
    }

    public static void verifySearchedResultOnAmazon(String input){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchLabel));
        System.out.println("Total result : "+searchResults(driver).size());
        WebElement firstLink = searchResults(driver).get(0).findElement(relProductHeader);
        Assert.isTrue(firstLink.getText().trim().contains(input),"search result title verification");
    }
}
