package com.ascend.components.services;

import com.ascend.components.entities.Products;
import com.ascend.components.exception.ItemNotFoundException;
import com.ascend.components.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductsServiceImpl implements ProductsService {
  @Autowired
  ProductsRepository repo;

  @Override
  public List<Products> getAll() {
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
  public List<Products> searchProducts(Products p) {
//    System.out.println("To match:" + p);
    // Strict matcher -> Requires all criteria sent to be matched.
    // If any criteria below is null, then it won't be matched against.
    var matcher = ExampleMatcher.matchingAll()
        .withMatcher("UPC", ExampleMatcher.GenericPropertyMatchers.contains())
        .withMatcher("Brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
        .withMatcher("Category", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

    var example = Example.of(p, matcher);
//    System.out.println(example);

    return repo.findAll(example);
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


