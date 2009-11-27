/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.product;

import com.chinacnd.framework.db.IdEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * 商品目录
 * @author roger
 */
@Entity
@Table(name = "ct_pro_category")
@NamedQueries({
    @NamedQuery(name = "Category.findByParentId", query = "select c from Category c where c.parent.id=:id"),
    @NamedQuery(name = "Category.findRoots", query = "select c from Category c where c.parent is null"),
    @NamedQuery(name = "Category.findRootByType", query = "select c from Category c where c.parent is null and c.type=:type")
})
public class Category extends IdEntity {

    @Column(name = "code", nullable = false, length = 32)
    private String code;//商品目录编码
    @Column(name = "name", nullable = false, length = 64)
    private String name;//名称
    @Column(name = "is_leaf", nullable = false)
    private boolean leaf = true;//是否是子节点，默认都是
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;//上一级目录
    @Column(name = "description", length = 4000)
    private String description;//描述
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "last_update_date")
    private Date lastUpdateDate;//最后更新日期
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ct_pro_category_extend")
    private List<ExtendAttribute> extendAttributeList;//对应的扩展属性
    @Column(name = "cat_type", nullable = false, length = 32)
    @Enumerated(value = EnumType.STRING)
    private CategoryType type;
    @Column(name = "full_code")
    private String fullCode;//便于搜索，如果目录编码不能体现其层级结构，则使用fullCode，将从root至本身的编码以!拼接起来

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ExtendAttribute> getExtendAttributeList() {
        return extendAttributeList;
    }

    public void setExtendAttributeList(List<ExtendAttribute> extendAttributeList) {
        this.extendAttributeList = extendAttributeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }
}
