package com.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderSortTesting {

    @Test
    public void checkChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/com/selenium/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:4200/"); //opens local host / port number
        driver.findElement(By.name("Search")).sendKeys("food");
        Thread.sleep(2000);
        driver.close();
    }
}
