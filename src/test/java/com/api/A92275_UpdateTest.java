package com.api;

import com.ascend.components.entities.Products;
import com.ascend.nisuminventoryapi.NisumInventoryApiApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes= NisumInventoryApiApplication.class)
@SpringBootTest
@AutoConfigureMockMvc

public class A92275_UpdateTest {
    @Autowired
    private MockMvc mockMvc;

    private static final Logger LOGGER = LogManager.getLogger(A92266Test.class);

    @BeforeAll
    public static void setUp() {
        LOGGER.info("API TEST LOG COMMENCED: UPDATE PRODUCTS");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        LOGGER.info("LOG COMPLETED: UPDATE PRODUCTS");
    }

    @Test
    public void UpdateTest() throws Exception{
        LOGGER.info("Test PUT METHOD WITH ENDPOINT: /api/products/update");

        Products product = new Products();

        product.setUPC("123456789012");
        product.setBrand("Google");
        product.setProdName("F22");
        product.setProdDesc("Top secret");
        product.setCategory("Aircraft");
        product.setPricePerUnit((float) 1000.00);
        product.setImageURL("This is a URL");
        product.setAvailableStock(100);
        product.setShippedStock(50);
        product.setReservedStock(20);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(product);

        this.mockMvc.perform(put("/api/products/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print()).andExpect(status().isOk());

        LOGGER.info("Printed Response");
        LOGGER.info("Expected status code 200 OK");
        LOGGER.info("Successfully Updated specific product");
    }
}