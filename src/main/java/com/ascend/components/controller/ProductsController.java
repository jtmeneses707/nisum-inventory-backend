package com.ascend.components.controller;

import com.ascend.components.entities.Products;
import com.ascend.components.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products") // <--- this good?
public class ProductsController {

    @Autowired
    ProductsService service;

    @RequestMapping("/fetchAllItems")
    @ResponseBody
    public List<Products> getAll() {
        List<Products> pList = service.getAll();
        return pList;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("get/{upc}")
    public Map<String, Products> getProduct(@PathVariable String upc) {
        var response = new HashMap<String, Products>();
        var product = service.get(upc);
        response.put("product", product);
        return response;
    }

    @PostMapping("create")
    @ResponseBody
    public Products addProduct(@RequestBody Products p){
        return service.createProduct(p);
    }
}
