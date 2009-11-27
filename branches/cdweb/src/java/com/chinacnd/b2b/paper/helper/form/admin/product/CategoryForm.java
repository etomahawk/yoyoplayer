/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.product;

import com.chinacnd.b2b.paper.entities.product.Category;
import com.chinacnd.b2b.paper.entities.product.CategoryType;
import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;
import java.util.Date;

/**
 *
 * @author Hadeslee
 */
public class CategoryForm extends RequestRecordForm {

    private Category category = new Category();
    private Long parentId;
    private String extendAttrbiteIds;
    private String deleteIds;

    public String getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(String deleteIds) {
        this.deleteIds = deleteIds;
    }

    public String getExtendAttrbiteIds() {
        return extendAttrbiteIds;
    }

    public void setExtendAttrbiteIds(String extendAttrbiteIds) {
        this.extendAttrbiteIds = extendAttrbiteIds;
    }

    public void setId(Long id) {
        category.setId(id);
    }

    public Long getId() {
        return category.getId();
    }

    public void setType(CategoryType type) {
        category.setType(type);
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setName(String name) {
        category.setName(name);
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        category.setLastUpdateDate(lastUpdateDate);
    }

    public void setFullCode(String fullCode) {
        category.setFullCode(fullCode);
    }

    public void setDescription(String description) {
        category.setDescription(description);
    }

    public void setCode(String code) {
        category.setCode(code);
    }

    public CategoryType getType() {
        return category.getType();
    }

    public Long getParentId() {
        return parentId;
    }

    public String getName() {
        return category.getName();
    }

    public Date getLastUpdateDate() {
        return category.getLastUpdateDate();
    }

    public String getFullCode() {
        return category.getFullCode();
    }

    public String getDescription() {
        return category.getDescription();
    }

    public String getCode() {
        return category.getCode();
    }
}
