package com.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateProdTesting {


    @Test
    public void checkChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/com/selenium/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://127.0.0.1:4200/products"); //opens local host / port number
        driver.manage().window().maximize();
        String bodyText = driver.findElement(By.className("container")).getText();
        driver.findElement(By.xpath("/html/body/app-root/div/app-product-view-page/app-product-list/mat-table/mat-row[1]/mat-cell[8]/button")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("prodName")).clear();
        driver.findElement(By.id("prodName")).sendKeys("Chicken");
        driver.findElement(By.id("brand")).clear();
        driver.findElement(By.id("brand")).sendKeys("ego!!");
        driver.findElement(By.id("prodDescription")).clear();
        driver.findElement(By.id("prodDescription")).sendKeys("WAFFLLLLLLLLLLES");
        driver.findElement(By.id("category")).clear();
        driver.findElement(By.id("category")).sendKeys("Food");
        driver.findElement(By.id("pricePerUnit")).clear();
        driver.findElement(By.id("pricePerUnit")).sendKeys("3.75");
        driver.findElement(By.id("imageURL")).clear();
        driver.findElement(By.id("imageURL")).sendKeys("LALALALA");
        driver.findElement(By.id("availableStock")).clear();
        driver.findElement(By.id("availableStock")).sendKeys("153345");
        driver.findElement(By.id("reservedStock")).clear();
        driver.findElement(By.id("reservedStock")).sendKeys("12354");
        driver.findElement(By.id("shippedStock")).clear();
        driver.findElement(By.id("shippedStock")).sendKeys("726");
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-edit-product-btn/div/div/div/div[2]/form/div[11]/button[1]")).click();

        driver.navigate().refresh();
        Thread.sleep(2000);
        Assert.assertTrue(bodyText.contains("036000291452\n" +
                "Chicken\n" +
                "Food\n" +
                "3.75\n" +
                "153345\n" +
                "12354\n" +
                "726"));
        driver.close();
    }
}
