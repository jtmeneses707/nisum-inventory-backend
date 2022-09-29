package com.ascend.components.controller;

import com.ascend.components.entities.Products;
import com.ascend.components.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/products") // <--- this good?
public class ProductsController {

    @Autowired
    ProductsService service;

////    Here for kafka producer testing purposes
//    @Autowired
//    private KafkaTemplate<String, Order> kafkaTemplate;
//
//    private static final String TOPIC = "oms-order-canceled";
//
//    @GetMapping("/public/cancel/{upc}/{quan}")
//    public String post(@PathVariable("upc") final String upc,@PathVariable("quan") final int quantity){
//        kafkaTemplate.send(TOPIC, new Order(upc, quantity, "CANCEL"));
//        return "CANCEL SUCCESS";
//    }


    @RequestMapping("/fetchAllItems")
    @ResponseBody
    public List<Products> getAll() {
        List<Products> pList = service.getAll();
        return pList;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/get/{upc}")
    public Map<String, Products> getProduct(@PathVariable String upc) {
        var response = new HashMap<String, Products>();
        var product = service.get(upc);
        response.put("product", product);
        return response;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    @ResponseBody
    public Map<String, Products> addProduct(@RequestBody Products p){
        var response = new HashMap<String, Products>();
        var product = service.createProduct(p);
        response.put("new product", product);
        return response;
    }


    @DeleteMapping("/delete/{upc}")
    @GetMapping
    public Map<String, Boolean> deleteProduct(@PathVariable String upc) {
        var response = new HashMap<String, Boolean>();
        var product = service.deleteByUPC(upc);
        response.put("deleted product", product);
        return response;
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/update")
    public Map<String, Products> updateProduct(@RequestBody Products p) {
        var response = new HashMap<String, Products>();
        var product = service.updateProduct(p);
        response.put("updated", product);
        return response;
    }



}
