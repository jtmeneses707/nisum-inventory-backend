package com.ascend.components.controller;

import com.ascend.components.entities.Products;
import com.ascend.components.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api") // <--- this good?
public class ProductsController {

    @Autowired
    ProductsService service;


    @PostMapping("/products/create")
    @ResponseBody
    public Products addProduct(@RequestBody Products p){
        Products response = service.createProduct(p);
        return response;
    }
}
