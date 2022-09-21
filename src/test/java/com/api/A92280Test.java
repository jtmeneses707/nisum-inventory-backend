//package com.api;
//
//import com.ascend.components.entities.Products;
//import com.ascend.nisuminventoryapi.NisumInventoryApiApplication;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static groovy.json.JsonOutput.toJson;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ContextConfiguration(classes= NisumInventoryApiApplication.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//
//public class A92280Test {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void A92266CreateProductItem() throws Exception{
//        Products productA92266 = new Products();
//
//        productA92266.setUPC("036234291452v");
//        productA92266.setBrand("ChipsAhoy");
//        productA92266.setProdName("Cookies");
//        productA92266.setProdDesc("soft cookies");
//        productA92266.setCategory("snacks");
//        productA92266.setPricePerUnit((float) 2.22);
//        productA92266.setImageURL("cookieschips.url");
//        productA92266.setAvailableStock(10);
//        productA92266.setShippedStock(5);
//        productA92266.setReservedStock(20);
//
//        this.mockMvc.perform(post("/api/products/create")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(toJson(productA92266)))
//                .andDo(print()).andExpect(status().isCreated());
//
//    }
//}
