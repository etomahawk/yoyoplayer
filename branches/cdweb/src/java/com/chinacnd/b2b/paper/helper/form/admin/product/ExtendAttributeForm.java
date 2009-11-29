/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.product;

import com.chinacnd.b2b.paper.entities.common.ValueType;
import com.chinacnd.b2b.paper.entities.product.ExtendAttribute;
import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;

/**
 *
 * @author Hadeslee
 */
public class ExtendAttributeForm extends RequestRecordForm {

    private ExtendAttribute extendAttribute = new ExtendAttribute();
    private String deleteIds;

    public ExtendAttributeForm() {
    }

    public String getDeleteIds() {
        return deleteIds;
    }

    public void setDeleteIds(String deleteIds) {
        this.deleteIds = deleteIds;
    }

    public ExtendAttribute getExtendAttribute() {
        return extendAttribute;
    }

    public void setId(Long id) {
        extendAttribute.setId(id);
    }

    public Long getId() {
        return extendAttribute.getId();
    }

    public void setValueType(ValueType valueType) {
        extendAttribute.setValueType(valueType);
    }

    public void setName(String name) {
        extendAttribute.setName(name);
    }

    public void setMaxLength(int length) {
        extendAttribute.setMaxLength(length);
    }

    public void setEnabled(boolean enabled) {
        extendAttribute.setEnabled(enabled);
    }

    public void setDescription(String description) {
        extendAttribute.setDescription(description);
    }

    public void setDefaultValue(String defaultValue) {
        extendAttribute.setDefaultValue(defaultValue);
    }

    public void setCode(String code) {
        extendAttribute.setCode(code);
    }

    public boolean isEnabled() {
        return extendAttribute.isEnabled();
    }

    public ValueType getValueType() {
        return extendAttribute.getValueType();
    }

    public String getName() {
        return extendAttribute.getName();
    }

    public int getMaxLength() {
        return extendAttribute.getMaxLength();
    }

    public String getDescription() {
        return extendAttribute.getDescription();
    }

    public String getDefaultValue() {
        return extendAttribute.getDefaultValue();
    }

    public String getCode() {
        return extendAttribute.getCode();
    }
}
