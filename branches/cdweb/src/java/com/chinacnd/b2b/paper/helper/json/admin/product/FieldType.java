/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

/**
 *
 * @author Hadeslee
 */
public class FieldType {

    private String fieldLabel;//商品名
    private String fieldName;//paper.name
    private String xtype;//textfield
    private String value;//
    private boolean disabled;//是否禁用

    public FieldType() {
    }

    public FieldType(String fieldLabel, String fieldName, String xtype, String value) {
        this.fieldLabel = fieldLabel;
        this.fieldName = fieldName;
        this.xtype = xtype;
        this.value = value;
    }

    public FieldType(String fieldLabel, String fieldName, String xtype, String value, boolean disabled) {
        this.fieldLabel = fieldLabel;
        this.fieldName = fieldName;
        this.xtype = xtype;
        this.value = value;
        this.disabled = disabled;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getXtype() {
        return xtype;
    }

    public void setXtype(String xtype) {
        this.xtype = xtype;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
