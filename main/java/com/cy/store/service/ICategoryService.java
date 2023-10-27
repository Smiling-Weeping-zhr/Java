package com.cy.store.service;

import com.cy.store.entity.Category;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CategoryVO;

import java.util.List;

public interface ICategoryService {
    public JsonResult<List<CategoryVO>> listCategories();
    public JsonResult<List<CategoryVO>> listCategories2(Integer parentId);
    public List<Category> listFirstLevel(Integer level);
    public JsonResult<List<CategoryVO>> selectFistLevelCategories(Integer cid);
    public JsonResult<List<CategoryVO>> selectLowPriceCategories(Integer cid);
}
