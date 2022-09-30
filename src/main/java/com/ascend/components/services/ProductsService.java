package com.ascend.components.services;

import com.ascend.components.entities.Products;

import java.util.List;

public interface ProductsService {
    List<Products> getAll();

    Products get(String upc);

    Products createProduct(Products p);

    boolean deleteByUPC(String upc);

    Products updateProduct(Products p);

    Products reserveStock(String upc, int quantity);

    List<Products> searchProducts(Products p);

    Products shipStock(String upc, int quantity);

    Products cancelStock(String upc, int quantity);



}