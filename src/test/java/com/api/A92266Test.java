package com.api;

import com.ascend.nisuminventoryapi.NisumInventoryApiApplication;
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

    @Test
    public void A92266FetchALLUPC() throws Exception {

        this.mockMvc
                .perform(get("/api/products/fetchAllItems"))
                .andDo(print()).andExpect(status().isOk());
    }
}