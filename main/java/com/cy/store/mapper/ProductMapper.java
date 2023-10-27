package com.cy.store.mapper;

import com.cy.store.entity.Product;

import java.util.List;

public interface ProductMapper {
    List<Product> findHotList();
    List<Product> findCheepList();
    // 根据商品id来查询商品
    Integer insert(Product product);
    Product findById(Integer id);
    List<Product> findByTitle(String title);
    // 查询指定一级类别下销量最高的六个商品
    public List<Product> selectTopCategory(Integer cid);
    // 查询指定以及类别下价格最低的六个商品
    List<Product> selectTop1Category(Integer cid);
}
