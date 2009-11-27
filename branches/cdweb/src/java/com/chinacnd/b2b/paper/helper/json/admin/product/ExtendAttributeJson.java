/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

import com.chinacnd.b2b.paper.entities.product.ExtendAttribute;

/**
 *
 * @author Hadeslee
 */
public class ExtendAttributeJson {

    private ExtendAttribute attribute;

    public ExtendAttributeJson(ExtendAttribute attribute) {
        this.attribute = attribute;
    }

    public Long getId() {
        return attribute.getId();
    }

    public boolean isEnabled() {
        return attribute.isEnabled();
    }

    public String getValueType() {
        return attribute.getValueType().name();
    }

    public String getName() {
        return attribute.getName();
    }

    public int getMaxLength() {
        return attribute.getMaxLength();
    }

    public String getDescription() {
        return attribute.getDescription();
    }

    public String getDefaultValue() {
        return attribute.getDefaultValue();
    }

    public String getCode() {
        return attribute.getCode();
    }
}
