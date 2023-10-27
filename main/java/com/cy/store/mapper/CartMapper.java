package com.cy.store.mapper;

import com.cy.store.entity.Cart;
import com.cy.store.vo.CartVO;

import java.util.Date;
import java.util.List;

public interface CartMapper {
    /**
     * 插入购物车的收据
     * @param cart 购物车数据
     * @return 受影响的行数
     */
    Integer insert(Cart cart);

    /**
     * 更新购物车某件商品的数量
     * @param cid 购物车数据id
     * @param num 更新的数量
     * @param modifiedUser 修改人
     * @param modifiedTime  修改时间
     * @return  受影响行数
     */
    Integer updateNumByCid(Integer cid ,
                           Integer num ,
                           String modifiedUser ,
                           Date modifiedTime);
    Integer subNumByCid(Integer cid ,
                        Integer num ,
                        boolean isDelete,
                        String modifiedUser ,
                        Date modifiedTime);

    Integer isChoose(Integer cid ,
                     boolean isDelete ,
                     String modifiedUser ,
                     Date modifiedTime);

    /**
     * 根据用户的id和商品的id来查询购物车的数据
     * @param uid 用户id
     * @param pid 商品id
     * @return
     */
    Cart findByUidAndPid(Integer uid , Integer pid);
    List<CartVO> findVOByUid(Integer uid);

    Cart findByCid(Integer cid);
    List<CartVO> findVOByCid(Integer[] cids);
    List<CartVO> findPurchase(Integer uid);
}
