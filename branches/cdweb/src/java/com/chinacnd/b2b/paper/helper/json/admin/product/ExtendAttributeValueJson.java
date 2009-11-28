/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

import com.chinacnd.b2b.paper.entities.product.ExtendAttributeValue;

/**
 *
 * @author Hadeslee
 */
public class ExtendAttributeValueJson {

    private final ExtendAttributeValue value;

    public ExtendAttributeValueJson(ExtendAttributeValue value) {
        this.value = value;
    }

    public Long getProductId() {
        return value.getProduct().getId();
    }

    public Long getExtendAttributeId() {
        return value.getAttribute().getId();
    }

    public Long getId() {
        return value.getId();
    }

    public String getAttributeLabel() {
        return value.getAttribute().getName();
    }

    public String getAttributeValue() {
        return value.getAttributeValue();
    }
}
