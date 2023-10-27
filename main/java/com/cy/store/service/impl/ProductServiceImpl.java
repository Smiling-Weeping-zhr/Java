package com.cy.store.service.impl;

import com.cy.store.entity.Product;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.IProductService;
import com.cy.store.service.ex.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findHotList() {
        List<Product> list = productMapper.findHotList();
        for(Product product : list)
        {
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            product.setModifiedUser(null);
        }
        return list;
    }

    @Override
    public List<Product> findCheepList() {
        List<Product> list = productMapper.findCheepList();
        for(Product product : list)
        {
            product.setModifiedUser(null);
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            product.setCreatedUser(null);
            product.setPriority(null);
        }
        return list;
    }

    @Override
    public Product findById(Integer id) {
        // 根据参数id调用私有方法执行查询，获取用户数据
        Product product = productMapper.findById(id);
        // 判断查询结果是否为null
        if(product == null)
        {
            // 是：抛出异常ProductNotFoundException
            throw new ProductNotFoundException("尝试访问的商品数据不存在");
        }
        // 将查询结果中的部分属性设置为null
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setModifiedTime(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        // 返回查询结果
        return product;
    }

    @Override
    public List<Product> findByTitle(String title) {

        List<Product> list = productMapper.findByTitle(title);
        // 该商品不存在
        if(list == null)
        {
            throw new ProductNotFoundException("尝试访问的商品不存在");
        }
        for(Product product : list)
        {
            product.setModifiedUser(null);
            product.setCreatedTime(null);
            product.setModifiedTime(null);
            product.setCreatedUser(null);
            product.setPriority(null);
        }
        return list;
    }

    @Override
    public List<Product> selectTopCategory(Integer cid) {
        return productMapper.selectTopCategory(cid);
    }
}
