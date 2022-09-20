package com.ascend.components.controller;

import com.ascend.components.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/products") // <-- this good?
public class ProductsController {

    @Autowired
    ProductsService service;
}
