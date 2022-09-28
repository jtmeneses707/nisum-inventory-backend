package com.ascend.components.services;

import com.ascend.components.entities.Products;
import com.ascend.components.exception.ItemNotFoundException;
import com.ascend.components.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
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
    public Products createProduct(Products p) {
        Products prod = repo.save(p);
        return prod;
    }

    @Override
    public Products updateProduct(Products p) {
        var match = repo.findById(p.getUPC());

        if (match.isEmpty()) {
            throw new ItemNotFoundException("Item " + p.getUPC() + " not found in database.");
        }

        return repo.save(p);
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

    //Kafka Stuff
    @Override
    public Products reserveStock(String upc, int quantity){
        var match = repo.findById(upc);

        if (match.isEmpty()) {
            throw new ItemNotFoundException("Item " + upc + " not found in database.");
        }

        Products prod = match.get();
        prod.setAvailableStock(prod.getAvailableStock()-quantity);
        prod.setReservedStock(prod.getReservedStock()+quantity);

        return repo.save(prod);
    }

    @Override
    public Products shipStock(String upc, int quantity){
        var match = repo.findById(upc);

        if (match.isEmpty()) {
            throw new ItemNotFoundException("Item " + upc + " not found in database.");
        }

        Products prod = match.get();
        prod.setReservedStock(prod.getReservedStock()-quantity);
        prod.setShippedStock(prod.getShippedStock()+quantity);

        return repo.save(prod);
    }

    @Override
    public Products cancelStock(String upc, int quantity){
        var match = repo.findById(upc);

        if (match.isEmpty()) {
            throw new ItemNotFoundException("Item " + upc + " not found in database.");
        }

        Products prod = match.get();
        prod.setReservedStock(prod.getReservedStock()-quantity);
        prod.setAvailableStock(prod.getAvailableStock()+quantity);

        return repo.save(prod);
    }

}
