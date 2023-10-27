package com.cy.store.controller;

import com.cy.store.entity.Product;
import com.cy.store.service.IProductService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController{
    @Autowired
    private IProductService productService;
    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList(){
        List<Product> data = productService.findHotList();
        return new JsonResult<List<Product>>(Okk , data);
    }
    @RequestMapping("cheap_list")
    public JsonResult<List<Product>> getCheepList()
    {
        List<Product> data = productService.findCheepList();
        return new JsonResult<List<Product>>(Okk , data);
    }
    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id){
        // 调用业务对象执行获取结果
        Product data = productService.findById(id);
        // 返回成功和数据
        return new JsonResult<Product>(Okk , data);
    }
    @RequestMapping("details")
    public JsonResult<List<Product>> getByTitle(String title){
        List<Product> data = productService.findByTitle(title);
        return new JsonResult<List<Product>>(Okk,data);
    }
}
