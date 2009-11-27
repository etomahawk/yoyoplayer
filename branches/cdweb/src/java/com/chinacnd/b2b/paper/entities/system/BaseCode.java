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
 *基础代码
 * @author roger
 */
@Entity
@Table(name = "ct_sys_basecode")
public class BaseCode extends IdEntity {

    @Column(name = "code", length = 32, nullable = false)
    private String code;//代码编号
    @Column(name = "name")
    private String name;//代码名称
    @Column(name = "type", length = 32)
    @Enumerated(value = EnumType.STRING)
    private BaseCodeType type;//代码类型
    @Column(name = "description", length = 4000)
    private String description;//代码描述

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BaseCodeType getType() {
        return type;
    }

    public void setType(BaseCodeType type) {
        this.type = type;
    }
}
