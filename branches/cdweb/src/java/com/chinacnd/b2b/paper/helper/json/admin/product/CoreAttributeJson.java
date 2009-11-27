/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

import com.chinacnd.b2b.paper.entities.common.ValueType;
import com.chinacnd.b2b.paper.entities.product.CoreAttribute;
import com.chinacnd.b2b.paper.entities.product.CoreAttributeType;

/**
 *
 * @author Hadeslee
 */
public class CoreAttributeJson {

    private CoreAttribute coreAttribute;

    public CoreAttributeJson(CoreAttribute coreAttribute) {
        this.coreAttribute = coreAttribute;
    }

    public String getName() {
        return coreAttribute.getName();
    }

    public int getMaxLength() {
        return coreAttribute.getMaxLength();
    }

    public String getDescription() {
        return coreAttribute.getDescription();
    }

    public String getDefaultValue() {
        return coreAttribute.getDefaultValue();
    }

    public String getAttributeType() {
        CoreAttributeType type = coreAttribute.getAttributeType();
        if (type == null) {
            return "未分类";
        } else {
            return type.attributeName;
        }
    }

    public String getValueType() {
        ValueType type = coreAttribute.getValueType();
        if (type == null) {
            return "未分类";
        } else {
            return type.name();
        }
    }

    public String getCode() {
        return coreAttribute.getCode();
    }
}
