package com.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class LoginUIReroutingTest {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void LoginUIReroutingCHROME () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/selenium/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");           //direct products page
        Thread.sleep(1000);

        //Test1                                                 //checks if on login page
        if(driver.getCurrentUrl().endsWith("/login-page") ){
            System.out.println("Successfully rerouted to login page due to improper authentification");
        } else {
            System.out.println("Failure webpage was not rerouted to login page despite improper authentification");
        }

        //Test2
        List<WebElement> list = driver.findElements(By.partialLinkText("SIGN-IN WITH GOOGLE"));
        System.out.println(list);
        Assert.assertTrue("SIGN-IN WITH GOOGLE", list.size() > 0);

        //Test3
        String bodyText = driver.findElement(By.partialLinkText("SIGN-IN WITH GOOGLE")).getText();
        Assert.assertTrue("SIGN-IN WITH GOOGLE", bodyText.contains("SIGN-IN"));

    }

    @Test
    public void LoginUIReroutingFIREFOX () throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","src/test/java/com/selenium/drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");           //direct products page
        Thread.sleep(1000);
        if(driver.getCurrentUrl().endsWith("/login-page") ){
            System.out.println("Successfully rerouted to login page due to improper authentification");
        } else {
            System.out.println("Failure webpage was not rerouted to login page despite improper authentification");
        }

        List<WebElement> list = driver.findElements(By.partialLinkText("SIGN-IN WITH GOOGLE"));
        System.out.println(list);

        Assert.assertTrue("SIGN-IN WITH GOOGLE", list.size() > 0);

        String bodyText = driver.findElement(By.partialLinkText("SIGN-IN WITH GOOGLE")).getText();
        Assert.assertTrue("SIGN-IN WITH GOOGLE", bodyText.contains("SIGN-IN"));
    }

    @Test
    public void LoginUIReroutingME () throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "src/test/java/com/selenium/drivers/msedgedriver");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");           //direct products page
        Thread.sleep(1000);

        if(driver.getCurrentUrl().endsWith("/login-page") ){
            System.out.println("Successfully rerouted to login page due to improper authentification");
        } else {
            System.out.println("Failure webpage was not rerouted to login page despite improper authentification");
        }

        List<WebElement> list = driver.findElements(By.partialLinkText("SIGN-IN WITH GOOGLE"));
        System.out.println(list);

        Assert.assertTrue("SIGN-IN WITH GOOGLE", list.size() > 0);

        String bodyText = driver.findElement(By.partialLinkText("SIGN-IN WITH GOOGLE")).getText();
        Assert.assertTrue("SIGN-IN WITH GOOGLE", bodyText.contains("SIGN-IN"));


    }
}
