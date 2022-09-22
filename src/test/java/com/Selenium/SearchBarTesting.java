package com.Selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.Assert.assertEquals;

public class SearchBarTesting {

    @Test
    public void checkChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Ahmed\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:4200/"); //opens local host / port number
        driver.findElement(By.name("Search")).sendKeys("1452");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("1452")); //tests to see if the page contains the searched word
        driver.close();
    }

    @Test
    public void checkEdge() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","C:\\Users\\Ahmed\\Downloads\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("http://127.0.0.1:4200/"); //opens local host / port number
        driver.findElement(By.name("Search")).sendKeys("egg");
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("egg")); //tests to see if the page contains the searched word
        driver.close();
    }
}
