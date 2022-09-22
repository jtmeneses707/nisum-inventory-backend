package com.api;


import com.ascend.components.entities.Products;
import com.ascend.nisuminventoryapi.NisumInventoryApiApplication;
import io.cucumber.messages.types.Product;
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

    @Test
    public void createProductTest() throws Exception {
         Products product = new Products();
         product.setProdName("Hot Cheetos");
         product.setProdDesc("Spicy chips");
         product.setCategory("Chips");
         product.setPricePerUnit((float) 2.29);
         product.setImageURL("chips url");
         product.setAvailableStock(99);
         product.setReservedStock(1000);
         product.setShippedStock(20);
         product.setUPC("213414732684");
         product.setBrand("Cheeto");
    System.out.println(toJson(product));
    this.mockMvc.perform(post("/api/products/create").contentType(MediaType.APPLICATION_JSON)
            .content(toJson(product))).andDo(print()).andExpect(status().isCreated());
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
