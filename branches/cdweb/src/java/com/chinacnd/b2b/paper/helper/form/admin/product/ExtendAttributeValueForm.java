/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.product;

import com.chinacnd.b2b.paper.entities.product.ExtendAttributeValue;
import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;

/**
 *
 * @author Hadeslee
 */
public class ExtendAttributeValueForm {

    private ExtendAttributeValue value = new ExtendAttributeValue();
    private Long extendAttributeId;

    public Long getExtendAttributeId() {
        return extendAttributeId;
    }

    public void setExtendAttributeId(Long extendAttributeId) {
        this.extendAttributeId = extendAttributeId;
    }

    public void setId(Long id) {
        value.setId(id);
    }

    public Long getId() {
        return value.getId();
    }

    public String getAttributeValue() {
        return value.getAttributeValue();
    }

    public void setAttributeValue(String s) {
        value.setAttributeValue(s);
    }
}
