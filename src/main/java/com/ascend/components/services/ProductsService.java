package com.ascend.components.services;

import com.ascend.components.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductsService {
    List<Product> getAll();

    Product get(String upc);

    Product createProduct(Product p);
}
