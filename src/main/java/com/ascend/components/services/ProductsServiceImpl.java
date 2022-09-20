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

}
