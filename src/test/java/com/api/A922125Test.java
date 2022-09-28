package com.api;

import com.ascend.nisuminventoryapi.NisumInventoryApiApplication;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = NisumInventoryApiApplication.class)
@SpringBootTest
@AutoConfigureMockMvc
public class A922125Test {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void SearchByEndpointTestOneSearch() throws Exception {

        //test one inventory value first
        JSONObject body = new JSONObject();

        body.put(apiConstants.CATEGORY, "snacks");

        this.mockMvc
                .perform(get("/api/products/search")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body.toJSONString()))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void SearchByEndpointTestTwoSearch() throws Exception {

        //test one inventory value first
        JSONObject body = new JSONObject();

        body.put(apiConstants.CATEGORY, "snacks");
        body.put(apiConstants.BRAND,"peperidge farms");


        this.mockMvc
                .perform(get("/api/products/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body.toJSONString()))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void SearchByEndpointTestMaxSearch() throws Exception {

        //test one inventory value first
        JSONObject body = new JSONObject();

        body.put(apiConstants.CATEGORY, "snacks");
        body.put(apiConstants.BRAND,"peperidge farms");
        body.put(apiConstants.UPC,"134561728334");


        this.mockMvc
                .perform(get("/api/products/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body.toJSONString()))
                .andDo(print()).andExpect(status().isOk());
    }
}