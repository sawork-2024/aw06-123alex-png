package com.micropos.products.service;

import com.micropos.products.model.Product;

import java.util.List;

public interface ProductService {


    public List<Product> products();

    public Product getProduct(int id);

    public Product updateProductQuantity(Product product, int quantity);

    public Product randomProduct();
}
