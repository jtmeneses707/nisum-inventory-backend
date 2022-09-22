package com.api;

import com.ascend.components.entities.Products;
import com.ascend.components.services.ProductsService;
import com.ascend.nisuminventoryapi.NisumInventoryApiApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static groovy.json.JsonOutput.toJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes= NisumInventoryApiApplication.class)
@SpringBootTest
@AutoConfigureMockMvc

public class UpdateTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void UpdateTest() throws Exception{
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

    }
}
