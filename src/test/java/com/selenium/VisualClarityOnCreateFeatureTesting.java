package com.selenium;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VisualClarityOnCreateFeatureTesting {

    WebDriver driver;

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void visualClarityTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/selenium/drivers/chromedriver");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");

        driver.findElement(By.xpath("/html/body/app-root/div/app-product-view-page/button")).click();

        String createPOP = driver.findElement(By.className("mat-dialog-container")).getText();

        System.out.println("Message: " + createPOP);

        if (createPOP.toString().contains("Add Product")) {
            System.out.println("Successfully launched create product pop up after prompting specific item create button ");

        } else {
            System.out.println("Failed to launch create product pop up after prompting specific item create button");
        }

        //actual background color
        String backgroundColor = driver.findElement(By.xpath("/html/body/div[3]/div[1]"))
                .getCssValue("background-color");
        System.out.println("THE CREATE BACKGROUND COLOR IS: " + backgroundColor);

        //assert expected, actual
        Assert.assertTrue(backgroundColor.contains("rgba(0, 0, 0, 0.32)"), String.valueOf(true));
    }
}