/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.system;

import com.chinacnd.framework.db.IdEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *系统参数
 * @author roger
 */
@Entity
@Table(name = "ct_sys_parameter")
public class Parameter extends IdEntity {

    @Column(name = "param_item", length = 64)
    @Enumerated(value = EnumType.STRING)
    private ParameterItem item;//参数条目
    @Column(name = "param_name", length = 64)
    private String name;//参数名称
    @Column(name = "param_value")
    private String value;//参数值

    public ParameterItem getItem() {
        return item;
    }

    public void setItem(ParameterItem item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
