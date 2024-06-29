package com.amazon.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class amazonSearchObject {

    private static WebElement element;

    protected static By searchBoxBy = By.id("twotabsearchtextbox");
    protected static By searchLabel = By.xpath("//*[text()='Results']");
    protected static By relProductHeader = By.xpath(".//div[contains(@class,'list-col-right')]//h2/a");
    public static WebElement searchBox(WebDriver driver){
        element = driver.findElement(searchBoxBy);
        return element;
    }

    public static WebElement searchButton(WebDriver driver){
        element = driver.findElement(By.id("nav-search-submit-button"));
        return element;
    }

    public static List<WebElement> searchResults(WebDriver driver){
        return driver.findElements(By.xpath("//*[text()='Results']/ancestor::div[contains(@data-cel-widget,'search_result')]/following-sibling::div"));
    }
}
