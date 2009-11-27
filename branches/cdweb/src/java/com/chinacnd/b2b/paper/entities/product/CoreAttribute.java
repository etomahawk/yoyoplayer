/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.product;

import com.chinacnd.b2b.paper.entities.common.ValueType;
import com.chinacnd.framework.db.IdEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 商品基本属性,此表只读，初始化的时候把数据导进来
 * 以后基本上不可能会修改此表的内容
 * @author roger
 */
@Entity
@Table(name = "ct_pro_core_attribute")
@NamedQueries({
    @NamedQuery(name = "CoreAttribute.findByType", query = "select c from CoreAttribute c where c.attributeType=:type")
})
public class CoreAttribute extends IdEntity {

    @Column(name = "code", nullable = false, length = 32)
    private String code;//编码
    @Column(name = "name", nullable = false, length = 64)
    private String name;//名称
    @Column(name = "value_type", length = 32)
    @Enumerated(value = EnumType.STRING)
    private ValueType valueType;//值类型
    @Column(name = "max_length", nullable = false)
    private int maxLength;//长度
    @Column(name = "default_value")
    private String defaultValue;//默认值
    @Enumerated(value = EnumType.STRING)
    @Column(name = "attribute_type", length = 32)
    private CoreAttributeType attributeType;//公共属性的类型
    @Column(name = "description", length = 4000)
    private String description;//;描述信息
    @Column(name = "property_name", length = 64)
    private String propertyName;//对应实体类的属性名，在界面上不体现

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int length) {
        this.maxLength = length;
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

    public CoreAttributeType getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(CoreAttributeType attributeType) {
        this.attributeType = attributeType;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
