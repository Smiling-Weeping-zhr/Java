package com.cy.store.vo;

import java.io.Serializable;
import java.util.List;

/** 表示的是购物车数据的VO类（Value Object）*/
public class CartVO implements Serializable {
    private Long price;
    private Integer num;
    private Integer cid ;
    private Boolean isDelete;
    private Integer uid ;
    private Integer pid ;
    private String image ;
    private String title ;
    private Long realPrice;
    private List<CartVO> Carts;

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public List<CartVO> getCarts() {
        return Carts;
    }

    public void setCarts(List<CartVO> carts) {
        Carts = carts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartVO cartVO)) return false;

        if (isDelete != cartVO.isDelete) return false;
        if (getPrice() != null ? !getPrice().equals(cartVO.getPrice()) : cartVO.getPrice() != null) return false;
        if (getNum() != null ? !getNum().equals(cartVO.getNum()) : cartVO.getNum() != null) return false;
        if (getCid() != null ? !getCid().equals(cartVO.getCid()) : cartVO.getCid() != null) return false;
        if (getUid() != null ? !getUid().equals(cartVO.getUid()) : cartVO.getUid() != null) return false;
        if (getPid() != null ? !getPid().equals(cartVO.getPid()) : cartVO.getPid() != null) return false;
        if (getImage() != null ? !getImage().equals(cartVO.getImage()) : cartVO.getImage() != null) return false;
        if (getTitle() != null ? !getTitle().equals(cartVO.getTitle()) : cartVO.getTitle() != null) return false;
        return getRealPrice() != null ? getRealPrice().equals(cartVO.getRealPrice()) : cartVO.getRealPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getPrice() != null ? getPrice().hashCode() : 0;
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        result = 31 * result + (getCid() != null ? getCid().hashCode() : 0);
        result = 31 * result + (isDelete ? 1 : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getPid() != null ? getPid().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getRealPrice() != null ? getRealPrice().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "price=" + price +
                ", num=" + num +
                ", cid=" + cid +
                ", isDelete=" + isDelete +
                ", uid=" + uid +
                ", pid=" + pid +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", realPrice=" + realPrice +
                '}';
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Long realPrice) {
        this.realPrice = realPrice;
    }
}
