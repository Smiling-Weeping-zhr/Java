package com.cy.store.controller;

import com.cy.store.service.ICartService;
import com.cy.store.util.JsonResult;
import com.cy.store.util.JwtUtil;
import com.cy.store.vo.CartVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("carts")
@RestController
public class CartController extends BaseController{
    @Autowired
    private ICartService cartService;
    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer uid , Integer pid , Integer amount, String username){
        // String token = request.getHeader("token");
        // String user = JwtUtil.decodeUser(token);
        // String[] data = user.split(" " , 2);
        cartService.addToCart(uid,pid,amount,username);
        return new JsonResult<>(Okk);
    }
    @RequestMapping("sub_to_cart")
    public JsonResult<Void> subToCart(Integer uid , Integer pid , Integer amount , String username){
        cartService.subToCart(uid,pid,amount,username);
        return new JsonResult<>(Okk);
    }
    @RequestMapping("choose")
    public JsonResult<Void> ToChoose(Integer cid , boolean is_delete){
        cartService.ToChoose(cid,is_delete);
        return new JsonResult<>(Okk);
    }
    @RequestMapping("purchase")
    public JsonResult<List<CartVO>> ToPurchase(Integer uid){
        List<CartVO> list = cartService.getPurchase(uid);
        return new JsonResult<>(Okk , list);
    }
    @RequestMapping("settlement")
    public JsonResult<Long> ToSettle(Integer uid){
        long totalPrice = cartService.getTotalPrice(uid);
        return new JsonResult<>(Okk,totalPrice);
    }
    @RequestMapping({"" , "/"})
    public JsonResult<List<CartVO>> getVOByUid(Integer uid){
        // String token = request.getHeader("token");
        // String user = JwtUtil.decodeUser(token);
        // String[] data = user.split(" " , 2);
        List<CartVO> result = cartService.getVOByUid(uid);
        return new JsonResult<>(Okk , result);
    }
    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid ,Integer uid , String username ){
        // String token = request.getHeader("token");
        // String user = JwtUtil.decodeUser(token);
        // String[] data = token.split(" " , 2);
        // 还需要再改改，这里是传递的电话号码data【0】
        Integer data_num = cartService.addNum(cid , uid , username);
        return new JsonResult<>(Okk , data_num);
    }
    @RequestMapping("list")
    public JsonResult<List<CartVO>> getVOByCid(Integer[] cids , Integer uid){
        // String token = request.getHeader("token");
        // String user = JwtUtil.decodeUser(token);
        // String[] data = user.split(" " , 2);
        List<CartVO> result = cartService.getVOByCid(uid , cids);
        return new JsonResult<>(Okk , result);
    }
}
