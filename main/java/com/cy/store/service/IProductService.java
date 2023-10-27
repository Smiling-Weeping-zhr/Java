package com.cy.store.service;

import com.cy.store.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findHotList();
    List<Product> findCheepList();
    Product findById(Integer id);
    List<Product> findByTitle(String title);
    List<Product> selectTopCategory(Integer cid);
}
