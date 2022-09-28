package com.selenium;

import com.ascend.nisuminventoryapi.NisumInventoryApiApplication;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes= NisumInventoryApiApplication.class)
@SpringBootTest
@AutoConfigureMockMvc

//NOTE UPON RUNNING FOR SMOOTHER OPERATION HASH OUT CHECKPRODUCTEXIST TEST TO RUN DELETEPRODUCTUI TEST
public class DeleteProductUITesting {
    @Autowired
    private MockMvc mockMvc;

    static WebDriver driver;

    @Test
    public void checkProductExists() throws Exception{            //making sure that the item exists

        this.mockMvc.perform(get("/api/products/get/{upc}","123456789012")).  //enter a UPC that matches your database
                andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void DeleteProductUI() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/selenium/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:4200/products");

        //due to unidentifiable web elements -> had to utilize xpath

        driver.findElement(By.xpath("/html/body/app-root/div/app-product-view-page/app-product-list/mat-table/mat-row[3]/mat-cell[9]/button")).click();
        Thread.sleep(1000);

        //switch to window handle + accept delete

       String delete = driver.switchTo().activeElement().getText();

       String deletePOP = driver.findElement(By.className("mat-dialog-container")).getText();

        System.out.println("Message: " + deletePOP);

            if (deletePOP.toString().contains("Are you sure Delete?")) {
            System.out.println("Successfully launched delete product pop up after prompting specific item delete button ");

            } else {
            System.out.println("Failed to launch delete product pop up after prompting specific item to delete");
        }

        //deleting third row
        WebElement elem = driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-delete-dialog/mat-dialog-actions/button[2]")); // obtain an element

        System.out.println("Text: " + elem.getText().toString());       //making sure yes is the option

        elem.click();       //clicking delete

        Thread.sleep(2000);

        driver.navigate().refresh();          //refresh to see if product was deleted

        Assert.assertFalse(isUPCPresent("123456789012"));

        System.out.println("UPC WAS DELETED AND IS NOT PRESENT ON PAGE");

        Thread.sleep(2000);

        driver.close();
    }

    private boolean isUPCPresent(String text) {
        try{
            boolean check = driver.getPageSource().contains("123456789012");

            return check;
        }
        catch(Exception e){

            return false;
        }
    }


}

