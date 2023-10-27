package com.cy.store.mapper;

import com.cy.store.vo.CategoryVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTests {
    @Autowired
    private CategoryMapper categoryMapper;
    @Test
    public void selectALLCategories(){
        List<CategoryVO> categoryVOS = categoryMapper.selectALLCategories();
    }

    @Test
    public void selectFirstLevelCategory(Integer cid){
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories(cid);
    }
    @Test
    public void selectLowPriceCategory(Integer cid){
        List<CategoryVO> categoryVOS = categoryMapper.selectLowPriceCategories(cid);
    }
}
