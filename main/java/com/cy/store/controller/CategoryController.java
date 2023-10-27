package com.cy.store.controller;

import com.cy.store.entity.Category;
import com.cy.store.service.ICategoryService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("index")
@RestController
public class CategoryController extends BaseController{
    @Autowired
    private ICategoryService ICategoryService;
    @RequestMapping("first_category") // 商品分类查询接口
    public JsonResult<List<Category>> listFirstLevel(Integer level)
    {
        List<Category> list = ICategoryService.listFirstLevel(level);
        return new JsonResult<>(Okk,list);
    }

    // 查询一级分类输入0，查询一级分类下二级分类输入1
    @RequestMapping("all_category")
    public JsonResult<List<CategoryVO>> listAllCategories(Integer parentId){
        return ICategoryService.listCategories2(parentId);
    }
    @RequestMapping("list-recommends-priority") // 分类推荐商品（销量）
    public JsonResult<List<CategoryVO>> listRecommendProductByCategory(Integer cid){
        return ICategoryService.selectFistLevelCategories(cid);
    }
    @RequestMapping("list-recommends-price") // 分类推荐商品（价格）
    public JsonResult<List<CategoryVO>> listRecommendProductByPrice(Integer cid){
        return ICategoryService.selectLowPriceCategories(cid);
    }
}
