package com.cy.store.mapper;

import com.cy.store.entity.Product;
import com.cy.store.service.ex.InsertException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductMapperTests {
    @Autowired
    private ProductMapper productMapper;
    @Test
    public void insert()
    {
        Product product = new Product();
        product.setNum(2);
        product.setTitle("a");
        product.setCategoryId(0);
        product.setParentId(1);
        product.setPrice(1000L);
        product.setId(1);
        Integer rows = productMapper.insert(product);
        if(rows != 1){
            throw new InsertException("输入时产生未知错误");
        }
    }
    @Test
    public void findByTitle(){
        List<Product> list = productMapper.findByTitle("a");
        if(list == null)
            System.out.println("商品不存在");
        else
            System.out.println(list);
    }
    @Test
    public void selectTopCategory()
    {
        List<Product> selectTopCategory = productMapper.selectTopCategory(1);
    }
    @Test
    public void selectTop1Category(){
        List<Product> selectTop1Category = productMapper.selectTop1Category(1);
    }
}
