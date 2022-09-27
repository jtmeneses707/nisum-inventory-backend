package com.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageViewTest {

    @Test
    public void checkChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/com/selenium/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:4200/"); //opens local host / port number
        String bodyText = driver.findElement(By.className("container")).getText();
        Thread.sleep(2000);
        Assert.assertTrue(bodyText.contains("036000291452\n" +
                "Chicken\n" +
                "food\n" +
                "4.2\n" +
                "10\n" +
                "20\n" +
                "5"));

        Assert.assertTrue(bodyText.contains("111111111114\n" +
                "Waffles\n" +
                "Food\n" +
                "3.75\n" +
                "153345\n" +
                "12354\n" +
                "22000"));
        driver.close();

    }
}

