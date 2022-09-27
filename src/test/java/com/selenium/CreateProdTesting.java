package com.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProdTesting {
    @Test
    public void checkChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/com/selenium/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:4200/"); //opens local host / port number
        driver.findElement(By.xpath("/html/body/app-root/div/app-create-product-btn/button")).click();
        driver.findElement(By.id("upc")).sendKeys("111111111114");
        driver.findElement(By.id("prodname")).sendKeys("Waffles");
        driver.findElement(By.id("brand")).sendKeys("ego");
        driver.findElement(By.id("proddesc")).sendKeys("WAFFLLLLLLLLLLES");
        driver.findElement(By.id("category")).sendKeys("Food");
        driver.findElement(By.id("priceperunit")).sendKeys("3.75");
        driver.findElement(By.id("imageurl")).sendKeys("LALALALA");
        driver.findElement(By.id("availablestock")).sendKeys("153345");
        driver.findElement(By.id("reservedstock")).sendKeys("12354");
        driver.findElement(By.id("shippedstock")).sendKeys("22000");
        driver.findElement(By.xpath("/html/body/app-root/div/app-create-product-btn/div/div/div/div[2]/form/button")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void checkEdge() throws InterruptedException {
        System.setProperty("webdriver.edge.driver","src/test/java/com/selenium/drivers/msedgedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:4200/"); //opens local host / port number
        driver.findElement(By.xpath("/html/body/app-root/div/app-create-product-btn/button")).click();
        driver.findElement(By.id("upc")).sendKeys("111111111414");
        driver.findElement(By.id("prodname")).sendKeys("Waffles");
        driver.findElement(By.id("brand")).sendKeys("ego");
        driver.findElement(By.id("proddesc")).sendKeys("WAFFLLLLLLLLLLES");
        driver.findElement(By.id("category")).sendKeys("Food");
        driver.findElement(By.id("priceperunit")).sendKeys("3.75");
        driver.findElement(By.id("imageurl")).sendKeys("LALALALA");
        driver.findElement(By.id("availablestock")).sendKeys("153345");
        driver.findElement(By.id("reservedstock")).sendKeys("12354");
        driver.findElement(By.id("shippedstock")).sendKeys("22000");
        driver.findElement(By.xpath("/html/body/app-root/div/app-create-product-btn/div/div/div/div[2]/form/button")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.close();
    }
}
