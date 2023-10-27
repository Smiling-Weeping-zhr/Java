package com.cy.store.entity;

public class Cart extends BaseEntity{
    private Integer cid;
    private Integer uid;
    private Integer pid;
    private Long price;
    private Integer num;
    private boolean isDelete;

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIs_delete(boolean isDelete) {
        this.isDelete = isDelete;
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

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", pid=" + pid +
                ", price=" + price +
                ", num=" + num +
                ", isDelete=" + isDelete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart cart)) return false;
        if (!super.equals(o)) return false;

        if (isIsDelete() != cart.isIsDelete()) return false;
        if (getCid() != null ? !getCid().equals(cart.getCid()) : cart.getCid() != null) return false;
        if (getUid() != null ? !getUid().equals(cart.getUid()) : cart.getUid() != null) return false;
        if (getPid() != null ? !getPid().equals(cart.getPid()) : cart.getPid() != null) return false;
        if (getPrice() != null ? !getPrice().equals(cart.getPrice()) : cart.getPrice() != null) return false;
        return getNum() != null ? getNum().equals(cart.getNum()) : cart.getNum() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCid() != null ? getCid().hashCode() : 0);
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getPid() != null ? getPid().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        result = 31 * result + (isIsDelete() ? 1 : 0);
        return result;
    }

}
