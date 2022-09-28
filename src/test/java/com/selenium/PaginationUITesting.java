package com.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PaginationUITesting {       //Moved to manual testing due to IRRETRIEVABLE Element Finding Problems
    WebDriver driver;

    @After
    public void tearDown() throws Exception {
//      driver.quit();
    }

    @Test
    public void paginationTestingChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/selenium/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");

        //traveling page forward
        driver.findElement(By.className("mat-paginator-navigation-next")).click();

        //traveling page backward
        driver.findElement(By.className("mat-paginator-navigation-previous")).click();

        //traveling forward & backward


    }

    @Test
    public void paginationTestingFirefox() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","src/test/java/com/selenium/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");


        //traveling page forward

        //traveling page backward

        //traveling forward & backward

    }

    @Test
    public void paginationTestingME() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "src/test/java/com/selenium/drivers/msedgedriver");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");

        //traveling page forward

        //traveling page backward


        //traveling forward & backward

    }
}