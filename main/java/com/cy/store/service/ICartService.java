package com.cy.store.service;

import com.cy.store.vo.CartVO;

import java.util.List;

public interface ICartService {
    /**
     * 将商品加入购物车
     * @param uid 用户id
     * @param pid 商品id
     * @param amount 新增的数量
     * @param username  用户名（修改者）
     */
    void addToCart(Integer uid , Integer pid , Integer amount , String username);
    void subToCart(Integer uid , Integer pid , Integer amount , String username);

    void ToChoose(Integer cid , boolean is_delete);
    List<CartVO> getVOByUid(Integer uid);
    List<CartVO> getPurchase(Integer uid);
    Long getTotalPrice(Integer uid);

    /**
     * 更新用户购物车数据的数量
     * @param uid
     * @param cid
     * @param username
     * @return 增加成功后的数量
     */
    Integer addNum(Integer cid , Integer uid , String username);
    List<CartVO> getVOByCid(Integer uid , Integer[] cids);
}
