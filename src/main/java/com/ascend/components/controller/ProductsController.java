package com.ascend.components.controller;

import com.ascend.components.entities.Products;
import com.ascend.components.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/products") // <--- this good?
public class ProductsController {

  @Autowired
  ProductsService service;

  @RequestMapping("/fetchAllItems")
  @ResponseBody
  public List<Products> getAll() {
    List<Products> pList = service.getAll();
    return pList;
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/get/{upc}")
  public Map<String, Products> getProduct(@PathVariable String upc) {
    var response = new HashMap<String, Products>();
    var product = service.get(upc);
    response.put("product", product);
    return response;
  }


  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/create")
  @ResponseBody
  public Map<String, Products> addProduct(@RequestBody Products p) {
    var response = new HashMap<String, Products>();
    var product = service.createProduct(p);
    response.put("new product", product);
    return response;
  }


  @DeleteMapping("/delete/{upc}")
  @GetMapping
  public Map<String, Boolean> deleteProduct(@PathVariable String upc) {
    var response = new HashMap<String, Boolean>();
    var product = service.deleteByUPC(upc);
    response.put("deleted product", product);
    return response;
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping("/update")
  public Map<String, Products> updateProduct(@RequestBody Products p) {
    var response = new HashMap<String, Products>();
    var product = service.updateProduct(p);
    response.put("updated", product);
    return response;
  }


  /**
   * Search endpoint to search for specific criteria passed in request body.
   * Any combination of 3 criteria allowed (except all null):
   * upc substring, brand, and category.
   * Criteria are matched using an AND rather than an OR, meaning all matches returned in array match all criteria searched by.
   * All criteria are case-insensitive.
   *
   * @param req Request body with
   * @return List of all matches found.
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/search")
  public Map<String, List<Products>> searchProducts(@RequestBody Products req) {
    var matches = new HashMap<String, List<Products>>();
    if (req.getUPC() == null && req.getBrand() == null && req.getCategory() == null) {
      throw new IllegalArgumentException("Bad request. Check body format of " + req);
    }

    matches.put("matches", service.searchProducts(req));
    return matches;
  }

}