package com.selenium;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavigatingLoginUIWindowHandleHelp {

//    NOTE INSECURE BROWSER COULD NOT BE BYPASSED AT THE CURRENT MOMENT TEST HERE SHOWS THAT LOGIN IS POSSIBLE
    WebDriver driver;

    String GOOGLEEMAIL = "";
    String GOOGLEPASS = "";

    @Test
    public void LOGINUITestingChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/selenium/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/login-page");
        String title = driver.getTitle();
        System.out.println("The title of the web page opened is: " + title);
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("SIGN-IN WITH GOOGLE")).click();

        String parentWindow = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
//            driver.manage().window().maximize();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        driver.findElement(By.id("identifierId")).sendKeys(GOOGLEEMAIL);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierNext\"]/div/button")));
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
        Thread.sleep(2000);

    }
    @Test
    public void LOGINUITestingFirefox() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","src/test/java/com/selenium/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/login-page");
        String title = driver.getTitle();
        System.out.println("The title of the web page opened is: " + title);
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("SIGN-IN WITH GOOGLE")).click();

        String parentWindow = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
//            driver.manage().window().maximize();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        driver.findElement(By.id("identifierId")).sendKeys(GOOGLEEMAIL);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierNext\"]/div/button")));
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
        Thread.sleep(2000);

    }

    @Test
    public void LOGINUITestingME() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "src/test/java/com/selenium/drivers/msedgedriver");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/login-page");
        String title = driver.getTitle();
        System.out.println("The title of the web page opened is: " + title);
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("SIGN-IN WITH GOOGLE")).click();

        String parentWindow = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles())
        {
            driver.switchTo().window(winHandle);
//            driver.manage().window().maximize();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        driver.findElement(By.id("identifierId")).sendKeys(GOOGLEEMAIL);
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifierNext\"]/div/button")));
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button")).click();
        Thread.sleep(2000);


    }
}
