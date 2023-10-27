package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void insert()
    {
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setPid(0000100);
        cart.setNum(2);
        cart.setPrice(1000L);
        cartMapper.insert(cart);
    }
    @Test
    public void updateNumByCid()
    {
        cartMapper.updateNumByCid(1,4,"trc",new Date());
    }
    @Test
    public void findByUidAndPid(){
        Cart cart = cartMapper.findByUidAndPid(1 , 64);
        System.err.println(cart);
    }
    @Test
    public void findVOByUid()
    {
        System.out.println(cartMapper.findVOByUid(1));
    }
    @Test
    public void findByCid(){
        System.out.println(cartMapper.findByCid(1));
    }
    @Test
    public void findVOByCid(){
        Integer[] cids={1,2};
        System.out.println(cartMapper.findVOByCid(cids));
    }
}
