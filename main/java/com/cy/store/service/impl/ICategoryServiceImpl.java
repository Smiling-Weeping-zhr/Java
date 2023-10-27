package com.cy.store.service.impl;

import com.cy.store.entity.Category;
import com.cy.store.mapper.CategoryMapper;
import com.cy.store.service.ICategoryService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cy.store.controller.BaseController.Okk;

@Service
public class ICategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询分类列表（包含三个级别的分类）
     * @return
     */
    @Override
    public JsonResult<List<CategoryVO>> listCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectALLCategories();
        JsonResult<List<CategoryVO>> result = new JsonResult<>(Okk , categoryVOS);
        return result;
    }

    @Override
    public JsonResult<List<CategoryVO>> listCategories2(Integer parentId){
        List<CategoryVO> categoryVOS = categoryMapper.selectALLCategories2(parentId);
        return new JsonResult<>(Okk , categoryVOS);
    }
    /**
     * 查询一级分类，同时查询当前一级分类下销量最高的6个商品
     * @return
     */
    @Override
    public List<Category> listFirstLevel(Integer level){
        List<Category> category = categoryMapper.selectLevel(level);
        return category;
    }
    @Override
    public JsonResult<List<CategoryVO>> selectFistLevelCategories(Integer cid) {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories(cid);
        JsonResult<List<CategoryVO>> result = new JsonResult<>(Okk , categoryVOS);
        return result;
    }

    @Override
    public JsonResult<List<CategoryVO>> selectLowPriceCategories(Integer cid) {
        List<CategoryVO> categoryVOS = categoryMapper.selectLowPriceCategories(cid);
        JsonResult<List<CategoryVO>> result = new JsonResult<>(Okk , categoryVOS);
        return result;
    }

}
