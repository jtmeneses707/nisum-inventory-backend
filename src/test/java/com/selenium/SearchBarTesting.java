package com.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class SearchBarTesting {

    @Test
    public void checkChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/com/selenium/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:4200/products"); //opens local host / port number
        driver.findElement(By.name("Search")).sendKeys("1452");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("1452")); //tests to see if the page contains the searched word
        driver.close();
    }

    @Test
    public void checkEdge() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","src/test/java/com/selenium/drivers/msedgedriver");
        WebDriver driver = new EdgeDriver();
        driver.get("http://127.0.0.1:4200/"); //opens local host / port number
        driver.findElement(By.name("Search")).sendKeys("egg");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("egg")); //tests to see if the page contains the searched word
        driver.close();
    }

    @Test
    public void checkFireFox() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","src/test/java/com/selenium/drivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://127.0.0.1:4200/"); //opens local host / port number
        driver.findElement(By.name("Search")).sendKeys("5.6");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("5.6")); //tests to see if the page contains the searched number
        driver.close();
        //NOTE: Firefox Search Bar testing passes and will sendkeys search, but fails to load database products and searched products.
    }
}
