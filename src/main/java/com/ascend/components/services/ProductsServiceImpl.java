package com.ascend.components.services;

import com.ascend.components.entities.Products;
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
    public List<Products> getAll(){
        List<Products> pList = repo.findAll();
        return pList;
    }

    @Override
    public Products get(String upc) {
        var match = repo.findById(upc);

        if (match.isEmpty()) {
           throw new ItemNotFoundException("Item " + upc + " not found in database.");
        }

        return match.get();
    }

    @Override
    public Products createProduct(Products p){
        Products prod = repo.save(p);
        return prod;
    }

    @Override
    public boolean deleteByUPC(String upc) {
        try {
            repo.deleteById(upc);
            return true;
        } catch (Exception e) {
            throw new ItemNotFoundException("Item " + upc + " not found in database.");
        }
    }


}
