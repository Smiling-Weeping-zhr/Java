package com.cy.store.mapper;

import com.cy.store.entity.Category;
import com.cy.store.vo.CategoryVO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryMapper {
    // 链接查询商品类别
    public List<CategoryVO> selectALLCategories();
    // 子查询
    public List<CategoryVO> selectALLCategories2(Integer parentId);
    // 查询一级类别
    public List<Category> selectLevel(Integer level);
    public List<CategoryVO> selectFirstLevelCategories(Integer cid);
    public List<CategoryVO> selectLowPriceCategories(Integer cid);
}
