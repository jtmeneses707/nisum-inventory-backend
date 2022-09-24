package com.selenium.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class inventoryUISortSteps {
    WebDriver driver;

//USERCASE1-CHROME
    @Given("I navigate to the Nisum inventory page with ChromeDriver")
    public void i_navigate_to_the_nisum_inventory_page_with_chrome_driver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/com/selenium/drivers/chromedriver");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:4200/");
        String title = driver.getTitle();
        System.out.println("The title of the web page opened is: "+title);
        Thread.sleep(2000);

    }
    @When("I click on each respective product information categories once")
    public void i_click_on_each_respective_product_information_categories_once() throws InterruptedException {

       var m = driver.findElements(By.tagName("mat-header-cell"));
       m.forEach(WebElement::click);

    }
    @Then("I should be able to see all items in its respective category in ascending order")
    public void i_should_be_able_to_see_all_items_in_its_respective_category_in_ascending_order() {
        var m = driver.findElements(By.tagName("mat-header-cell"));

        var rowElements = driver.findElements(By.tagName("mat-row"));
        String[] split = rowElements.get(0).getText().split("\n");

        String[][] arr = new String[rowElements.size()][m.size()];
//        for(int i = 0; i < m.size(); i++) {
//            m.get(i).click();
//            rowElements = driver.findElements((By.tagName("mat-row")));
//            for(int j = 0; j < rowElements.size(); j++) {
//                String[] currAscendingRow = rowElements.get(j).getText().split("\n");
//                arr[j][i] = currAscendingRow[i];
//            }
//        }

        for(int i = 0; i < m.size(); i++) {
            m.get(i).click();
            rowElements = driver.findElements((By.tagName("mat-row")));
            for(int j = 0; j < rowElements.size(); j++) {
                String[] currAscendingRow = rowElements.get(j).getText().split("\n");
                arr[i][j] = currAscendingRow[i];
            }
        }


        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }

    }


    @Given("I navigate to the inventory page again with ChromeDriver")
    public void i_navigate_to_the_inventory_page_again_with_chrome_driver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/test/java/com/selenium/drivers/chromedriver");
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://127.0.0.1:4200/");
        String title = driver.getTitle();
        System.out.println("The title of the web page opened is: "+title);
        Thread.sleep(2000);
    }
    @When("I click on each respective product information categories twice")
    public void i_click_on_each_respective_product_information_categories_twice() throws InterruptedException {


    }
    @Then("I should be able to see all items in its respective category in descending order")
    public void i_should_be_able_to_see_all_items_in_its_respective_category_in_descending_order() {

    }

}