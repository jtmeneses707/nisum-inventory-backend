package com.selenium;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductDetailsOnItemUIDisplayTest {
    WebDriver driver;

    @Test
    public void ProductDetailsDisplay() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/selenium/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");

        //due to unidentifiable web elements -> had to utilize xpath

        //click on an item anywhere, specifically chose item UPC to click on but any aspect on table within range of products is clickable

        driver.findElement(By.xpath("/html/body/app-root/div/app-product-view-page/app-product-list/mat-table/mat-row[1]/mat-cell[1]")).click();
        Thread.sleep(1000);

        //switch to window handle

        String details = driver.switchTo().activeElement().getText();

        String detailsPOP = driver.findElement(By.className("mat-dialog-container")).getText();

        System.out.println("POP UP DISPLAY TEXT: " + detailsPOP);

        if (detailsPOP.toString().contains("Name:")) {
            System.out.println("Successfully launched product details pop up after prompting the clicking of specific item");

        } else {
            System.out.println("Failed to launch product details pop up after prompting the clicking of specific item");
        }


        Assert.assertTrue(isUPCPresent("Name:"));       //ASSERTED KEY/UNIQUE FEATURE OF THE DISPLAY ELEMENT

        System.out.println("PRODUCT INFO WAS PRESENT ON PAGE AFTER CLICKING ON ITEM");

        Thread.sleep(2000);

        driver.close();
    }

    private boolean isUPCPresent(String text) {
        try{
            boolean check = driver.getPageSource().contains("Name:");

            return check;
        }
        catch(Exception e){

            return false;
        }
    }
}
