package com.ascend.components.services;

import com.ascend.components.entities.Products;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    List<Products> getAll();

    Products createProduct(Products p);
}
