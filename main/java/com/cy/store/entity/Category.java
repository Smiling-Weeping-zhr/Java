package com.cy.store.entity;

import java.util.Objects;

public class Category {
    private Integer cid;
    private String cName;
    private Integer cLevel;
    private Integer parentId;
    private String cPic;
    private String cIcon;

    public Integer getcid() {
        return cid;
    }

    public void setcid(Integer cid) {
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentLevel(Integer parentLevel) {
        this.parentId = parentId;
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

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cName='" + cName + '\'' +
                ", cLevel=" + cLevel +
                ", parentLevel=" + parentId +
                ", cPic='" + cPic + '\'' +
                ", cIcon='" + cIcon + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;

        if (!Objects.equals(cid, category.cid)) return false;
        if (getcName() != null ? !getcName().equals(category.getcName()) : category.getcName() != null) return false;
        if (getcLevel() != null ? !getcLevel().equals(category.getcLevel()) : category.getcLevel() != null)
            return false;
        if (getParentId() != null ? !getParentId().equals(category.getParentId()) : category.getParentId() != null)
            return false;
        if (getcPic() != null ? !getcPic().equals(category.getcPic()) : category.getcPic() != null) return false;
        return getcIcon() != null ? getcIcon().equals(category.getcIcon()) : category.getcIcon() == null;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (getcName() != null ? getcName().hashCode() : 0);
        result = 31 * result + (getcLevel() != null ? getcLevel().hashCode() : 0);
        result = 31 * result + (getParentId() != null ? getParentId().hashCode() : 0);
        result = 31 * result + (getcPic() != null ? getcPic().hashCode() : 0);
        result = 31 * result + (getcIcon() != null ? getcIcon().hashCode() : 0);
        return result;
    }
}
