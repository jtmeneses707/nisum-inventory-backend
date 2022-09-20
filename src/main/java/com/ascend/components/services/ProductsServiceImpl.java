package com.ascend.components.services;

import com.ascend.components.entities.Products;
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
    public Products createProduct(Products p){
        Products prod = repo.save(p);
        return prod;
    }

    @Override
    public boolean deleteItem(int upc) {
        try {
            repo.deleteById(upc);
            return true;
        } catch (Exception e) {
            throw e;  //may need to create a new Exception for more clarity when an exception is thrown.
        }
    }


}
