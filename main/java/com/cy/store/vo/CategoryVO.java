package com.cy.store.vo;

import com.cy.store.entity.Category;
import com.cy.store.entity.Product;

import java.util.List;

public class CategoryVO {
    private Integer cid;
    private String cName;
    private Integer cLevel;
    private Integer parentId;
    private String cPic;

    @Override
    public String toString() {
        return "CategoryVO{" +
                "cid=" + cid +
                ", cName='" + cName + '\'' +
                ", cLevel=" + cLevel +
                ", parentId=" + parentId +
                ", cPic='" + cPic + '\'' +
                ", cIcon='" + cIcon + '\'' +
                ", categories=" + categories +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryVO that)) return false;

        if (getCid() != null ? !getCid().equals(that.getCid()) : that.getCid() != null) return false;
        if (getcName() != null ? !getcName().equals(that.getcName()) : that.getcName() != null) return false;
        if (getcLevel() != null ? !getcLevel().equals(that.getcLevel()) : that.getcLevel() != null) return false;
        if (getParentId() != null ? !getParentId().equals(that.getParentId()) : that.getParentId() != null)
            return false;
        if (getcPic() != null ? !getcPic().equals(that.getcPic()) : that.getcPic() != null) return false;
        if (getcIcon() != null ? !getcIcon().equals(that.getcIcon()) : that.getcIcon() != null) return false;
        if (getCategories() != null ? !getCategories().equals(that.getCategories()) : that.getCategories() != null)
            return false;
        return getProducts() != null ? getProducts().equals(that.getProducts()) : that.getProducts() == null;
    }

    @Override
    public int hashCode() {
        int result = getCid() != null ? getCid().hashCode() : 0;
        result = 31 * result + (getcName() != null ? getcName().hashCode() : 0);
        result = 31 * result + (getcLevel() != null ? getcLevel().hashCode() : 0);
        result = 31 * result + (getParentId() != null ? getParentId().hashCode() : 0);
        result = 31 * result + (getcPic() != null ? getcPic().hashCode() : 0);
        result = 31 * result + (getcIcon() != null ? getcIcon().hashCode() : 0);
        result = 31 * result + (getCategories() != null ? getCategories().hashCode() : 0);
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        return result;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    private String cIcon;
    // 实现首页类别显示
    private List<CategoryVO> categories;
    // 实现首页分类商品推荐
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcLevel() {
        return cLevel;
    }

    public void setcLevel(Integer cLevel) {
        this.cLevel = cLevel;
    }

    public Integer getParentLevel() {
        return parentId;
    }

    public void setParentLevel(Integer parentLevel) {
        this.parentId = parentLevel;
    }

    public String getcPic() {
        return cPic;
    }

    public void setcPic(String cPic) {
        this.cPic = cPic;
    }

    public String getcIcon() {
        return cIcon;
    }

    public void setcIcon(String cIcon) {
        this.cIcon = cIcon;
    }

    public List<CategoryVO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryVO> categories) {
        this.categories = categories;
    }
}
