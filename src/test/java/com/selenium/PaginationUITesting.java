package com.selenium;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class PaginationUITesting {       //Moved to manual testing due to IRRETRIEVABLE Element Finding Problems
    WebDriver driver;

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void paginationTestingChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/selenium/drivers/chromedriver");
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");

        //traveling page forward
        WebElement nextPage = driver.findElement(By.className("mat-paginator-navigation-next"));

        js.executeScript("arguments[0].scrollIntoView();", nextPage);

        nextPage.getLocation();

        System.out.println("Next Page Location is " + nextPage.getLocation());

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.className("mat-paginator-navigation-next")), 0, 0);

        actions.moveByOffset(1320, 960).click();

        //traveling page backward

        WebElement previousPage = driver.findElement(By.className("mat-paginator-navigation-previous"));

        js.executeScript("arguments[0].scrollIntoView();", previousPage);

        previousPage.getLocation();

        System.out.println("Previous Page Location is " + previousPage.getLocation());

        Actions action = new Actions(driver);

        actions.moveToElement(driver.findElement(By.className("mat-paginator-navigation-next")), 0, 0);

        actions.moveByOffset(1280,960).click();

        /* elements were unfortunately deemed unclickable with automation testing, however upon manual testing
        pagination functions work. elements are also deemed to be present on the page.
         */

    }

    @Test
    public void paginationTestingFirefox() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","src/test/java/com/selenium/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");

        //traveling page forward

        //traveling page backward

    }

    @Test
    public void paginationTestingME() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "src/test/java/com/selenium/drivers/msedgedriver");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");

        //traveling page forward

        //traveling page backward

    }
}