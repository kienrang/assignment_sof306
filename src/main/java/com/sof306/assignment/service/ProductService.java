package com.sof306.assignment.service;

import java.util.List;

import com.sof306.assignment.entity.Product;

public interface ProductService {
    public List<Product> findAll();

    Product findById(Integer id);

    List<Product> findCategoryId(String cid);

    Product create(Product product);

    Product update(Product product);

    void delete(Integer id);
}
