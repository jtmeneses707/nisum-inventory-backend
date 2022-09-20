package com.ascend.components.services;

import com.ascend.components.entities.Product;
import com.ascend.components.exception.ItemNotFoundException;
import com.ascend.components.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductsRepository repo;

    @Override
    public List<Product> getAll(){
        List<Product> pList = repo.findAll();
        return pList;
    }

    @Override
    public Product get(String upc) {
        var match = repo.findById(upc);

        if (match.isEmpty()) {
           throw new ItemNotFoundException("Item " + upc + " not found in database.");
        }

        return match.get();
    }

    @Override
    public Product createProduct(Product p){
        Product prod = repo.save(p);
        return prod;
    }




}
