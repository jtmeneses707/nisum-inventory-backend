package com.api;


import com.ascend.components.entities.Products;
import com.ascend.nisuminventoryapi.NisumInventoryApiApplication;
import io.cucumber.messages.types.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = NisumInventoryApiApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class A92280Test {

    @Autowired
    private MockMvc mockMvc;

    private static final Logger LOGGER = LogManager.getLogger(A92280Test.class);

    @BeforeAll
    public static void setUp() {
        LOGGER.info("API TEST LOG COMMENCED: CREATE PRODUCTS");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        LOGGER.info("LOG COMPLETED: CREATE PRODUCTS");
    }

    @Test
    public void createProductTest() throws Exception {
        LOGGER.info("Test POST METHOD WITH ENDPOINT: /api/products/create");

        Products product = new Products();
         product.setProdName("Hot Cheetos");
         product.setProdDesc("Spicy flaming chips");
         product.setCategory("Chips");
         product.setPricePerUnit((float) 5.29);
         product.setImageURL("chips url");
         product.setAvailableStock(919);
         product.setReservedStock(1000);
         product.setShippedStock(230);
         product.setUPC("213476732684");
         product.setBrand("Cheetos");

        this.mockMvc.perform(post("/api/products/create").contentType(MediaType.APPLICATION_JSON)
            .content(toJson(product))).andDo(print()).andExpect(status().isCreated());

        LOGGER.info("Printed Response");
        LOGGER.info("Expected status code 201 CREATED");
        LOGGER.info("Successfully created a product");
    }

    public String toJson(Products product){

        return
                "{\"prodName\":\"" + product.getProdName()+
                "\",\"prodDesc\":\""+product.getProdDesc()+
                "\",\"category\":\""+product.getCategory()+
                "\",\"pricePerUnit\":"+product.getPricePerUnit()+
                ",\"imageURL\":\""+product.getImageURL()+
                "\",\"availableStock\":"+product.getAvailableStock()+
                ",\"reservedStock\":"+product.getReservedStock()+
                ",\"shippedStock\":"+product.getShippedStock()+
                ",\"upc\":\""+product.getUPC()+
                "\",\"brand\":\""+product.getBrand()+
                "\"}";

    }
}
