package com.micropos.products.repository;


import com.micropos.products.model.Product;
import io.swagger.models.auth.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

//    public List<Product> allProducts();
//
//    public Product findProduct(String productId);

}