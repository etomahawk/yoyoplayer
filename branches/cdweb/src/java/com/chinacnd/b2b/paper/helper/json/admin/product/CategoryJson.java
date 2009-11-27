/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

import com.chinacnd.b2b.paper.entities.product.Category;
import java.util.Date;

/**
 *
 * @author Hadeslee
 */
public class CategoryJson {

    private final Category category;
    public boolean hasExtendAttributes;//是否有扩展属性

    public CategoryJson(Category category) {
        this.category = category;
    }

    public boolean isHasExtendAttributes() {
        return hasExtendAttributes;
    }

    public void setHasExtendAttributes(boolean hasExtendAttributes) {
        this.hasExtendAttributes = hasExtendAttributes;
    }

    public Long getParentId() {
        Category parent = category.getParent();
        if (parent == null) {
            return -1L;
        } else {
            return parent.getId();
        }
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

    public Long getId() {
        return category.getId();
    }
}
