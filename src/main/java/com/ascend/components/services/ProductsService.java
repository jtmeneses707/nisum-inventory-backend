package com.ascend.components.services;

import com.ascend.components.entities.Products;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductsService {
    List<Products> getAll();

    Products get(String upc);

    Products createProduct(Products p);

    boolean deleteByUPC(String upc);

    Products updateProduct(Products p);

    List<Products> searchProducts(Products p);




}
