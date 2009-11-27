/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.product;

import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;

/**
 *
 * @author Hadeslee
 */
public class CoreAttributeForm extends RequestRecordForm {

    private String attributeType;//属性类型,基本，纸，浆，或者所有

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }
}
