package com.api;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ascend.nisuminventoryapi.NisumInventoryApiApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;


@ContextConfiguration(classes= NisumInventoryApiApplication.class)
@SpringBootTest
@AutoConfigureMockMvc

public class A92281Test {
    @Autowired
    private MockMvc mockMvc;

    private static final Logger LOGGER = LogManager.getLogger(A92281Test.class);

    @BeforeAll
    public static void setUp() {
        LOGGER.info("API TEST LOG COMMENCED: DELETE SPECIFIC PRODUCTS");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        LOGGER.info("LOG COMPLETED: DELETE SPECIFIC PRODUCTS");
    }

    @Test
    public void A92281DeleteProduct() throws Exception{
        LOGGER.info("Test DELETE METHOD WITH ENDPOINT: /api/products/delete/{upc}");


        this.mockMvc.perform(delete("/api/products/delete/{upc}","036000291452"))
                        .andDo(print()).andExpect(status().isOk());

        LOGGER.info("Printed Response");
        LOGGER.info("Expected status code 200 OK");
        LOGGER.info("Successfully DELETED specific product");

    }
}
