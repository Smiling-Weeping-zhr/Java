package com.cy.store.service.impl;

import com.cy.store.entity.Cart;
import com.cy.store.entity.Product;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.ProductMapper;
import com.cy.store.service.ICartService;
import com.cy.store.service.ex.*;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {
    /** 购物车的业务层依赖于购物车的持久层以及商品的持久层*/
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    /** 一定要沟通好，amount是新增商品数量，还是新增商品和旧商品的总数 */
    @Override
    public void addToCart(Integer uid, Integer pid,
                          Integer amount, String username) {
        // 查询当前要添加的这个购物是否在表中已经存在
        Cart result = cartMapper.findByUidAndPid(uid , pid);
        Date date = new Date();
        if(result == null){   // 表示这个商品从来都没有添加到购物车中，则进行新增操作
            // 需要创建一个cart对象
            Cart cart = new Cart();
            // 补全数据：参数所传递过来的数据
            cart.setUid(uid);
            cart.setNum(amount);
            cart.setPid(pid);
            // 补全价格：价格来自商品中的数据
            Product product =  productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            // 补全四个日志：
            cart.setCreatedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedTime(date);
            cart.setModifiedUser(username);
            cart.setIs_delete(false);
            // 补全数据完成
            Integer rows = cartMapper.insert(cart);
            if(rows != 1){
                throw new InsertException("插入数据时产生未知的异常");
            }
        }else{              //表示当前商品在购物车中已经存在，则更新这条商品的num值
            Integer num = result.getNum() + amount;
            Integer rows = cartMapper.updateNumByCid(
                    result.getCid(),
                    num,
                    username,
                    date);
            if(rows != 1){
                throw new UpdateException("更新数据时产生未知异常");
            }
        }
    }

    @Override
    public void  subToCart(Integer uid ,  Integer pid ,Integer amount , String username) {
        // 查询当前要添加的这个购物是否在表中已经存在
        Cart result = cartMapper.findByUidAndPid(uid , pid);
        Date date = new Date();
        if(result == null){   // 表示这个商品从来都没有添加到购物车中，则进行新增操作
            // 需要创建一个cart对象
            Cart cart = new Cart();
            // 补全数据：参数所传递过来的数据
            cart.setUid(uid);
            cart.setNum(amount);
            cart.setPid(pid);
            // 补全价格：价格来自商品中的数据
            Product product =  productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            // 补全四个日志：
            cart.setCreatedUser(username);
            cart.setCreatedTime(date);
            cart.setModifiedTime(date);
            cart.setModifiedUser(username);
            // 补全数据完成
            Integer rows = cartMapper.insert(cart);
            if(rows != 1){
                throw new InsertException("插入数据时产生未知的异常");
            }
        }else{              //表示当前商品在购物车中已经存在，则更新这条商品的num值
            Integer num = result.getNum() - amount;
            boolean isDelete=false;
            if(num <= 0){
                num=0;
                isDelete=true;
            }
            Integer rows = cartMapper.subNumByCid(
                    result.getCid(),
                    num,
                    isDelete,
                    username,
                    date);
            if(rows != 1){
                throw new UpdateException("更新数据时产生未知异常");
            }
        }
    }

    @Override
    public Long getTotalPrice(Integer uid){
        List<CartVO> list = cartMapper.findPurchase(uid);
        long totalprice=0;
        for(CartVO cart : list){
            totalprice += cart.getNum()*cart.getPrice();
        }
        return  totalprice;
    }
    @Override
    public void ToChoose(Integer cid , boolean is_delete){
        Cart cart = cartMapper.findByCid(cid);
        Date date = new Date();
        if(cart==null){
            throw new UpdateException("该购物车不存在");
        }
        Integer rows = cartMapper.isChoose(cart.getCid() , is_delete , cart.getCreatedUser() , date);
        if(rows != 1){
            throw new UpdateException("更新数据时产生了未知异常");
        }
    }
    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findVOByUid(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if(result == null){
            throw new CartNotFoundException("用户数据不存在");
        }
        if(result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }
        Integer num = result.getNum()+1;
        Integer rows = cartMapper.updateNumByCid(cid , num , username , new Date());
        if(rows != 1){
            throw new UpdateException("更新数据失败");
        }
        // 返回新的购物车数据的总量
        return num;
    }

    @Override
    public List<CartVO> getVOByCid(Integer uid, Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCid(cids);
        Iterator<CartVO> it = list.iterator();
        while(it.hasNext()){
            CartVO cartVO = it.next();
            if(!cartVO.getUid().equals(uid)){ // 表示当前的数据不属于当前的用户
                // 从集合中移除这个元素
                list.remove(cartVO);
            }
        }
        return list;
    }
    @Override
    public List<CartVO> getPurchase(Integer uid){
        List<CartVO> list = cartMapper.findPurchase(uid);
        if(list == null){
            throw new UserNotFoundException("用户不存在或购物车为空");
        }
        return list;
    }
}
