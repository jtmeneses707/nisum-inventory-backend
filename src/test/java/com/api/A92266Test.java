package com.api;

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes= NisumInventoryApiApplication.class)
@SpringBootTest
@AutoConfigureMockMvc

public class A92266Test {
    @Autowired
    private MockMvc mockMvc;

    private static final Logger LOGGER = LogManager.getLogger(A92266Test.class);
    @BeforeAll
    public static void setUp() {
        LOGGER.info("API TEST LOG COMMENCED: FETCH ALL PRODUCTS");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        LOGGER.info("LOG COMPLETED: FETCH ALL PRODUCTS");
    }


    @Test
    public void A92266FetchALLUPC() throws Exception {

        LOGGER.info("Test GET METHOD WITH ENDPOINT: /api/products/fetchAllItems");

        this.mockMvc
                .perform(get("/api/products/fetchAllItems"))
                .andDo(print()).andExpect(status().isOk());


        LOGGER.info("Printed Response");
        LOGGER.info("Expected status code 200 OK");
        LOGGER.info("Successfully fetched ALL products");

    }

}