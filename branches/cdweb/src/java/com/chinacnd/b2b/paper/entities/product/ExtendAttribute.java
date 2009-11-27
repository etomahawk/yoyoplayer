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
 * 扩展属性表
 * @author roger
 */
@Entity
@Table(name = "ct_pro_extend_attribute")
@NamedQueries({
    @NamedQuery(name = "ExtendAttribute.findByName", query = "select e from ExtendAttribute e where e.name like :name"),
    @NamedQuery(name = "ExtendAttribute.checkCodeExist", query = "select e from ExtendAttribute e where e.id!=:id and e.code=:code")
})
public class ExtendAttribute extends IdEntity {

    @Column(name = "code", nullable = false, length = 32)
    private String code;//编码
    @Column(name = "name", nullable = false, length = 64)
    private String name;//名称
    @Column(name = "value_type", length = 32)
    @Enumerated(value = EnumType.STRING)
    private ValueType valueType;//值类型
    @Column(name = "max_length", nullable = false)
    private int maxLength;//最大长度
    @Column(name = "default_value")
    private String defaultValue;//默认值
    @Column(name = "is_enbaled", nullable = false)
    private boolean enabled;//是否启用
    @Column(name = "description", length = 4000)
    private String description;

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

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
