/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.product;

import com.chinacnd.framework.db.IdEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 计量单位
 * @author roger
 */
@Entity
@Table(name = "ct_pro_measure_unit")
public class MeasureUnit extends IdEntity {

    @Column(name = "code", nullable = false, length = 32)
    private String code;//计量单位编码
    @Column(name = "name", nullable = false, length = 64)
    private String name;//计量单位名字
    @Column(name = "is_benchmark", nullable = false)
    private boolean benchmark;//是否基准
    @Column(name = "is_enbaled", nullable = false)
    private boolean enabled = true;//是否启用
    @Column(name = "description", length = 4000)
    private String description;//描述

    public boolean isBenchmark() {
        return benchmark;
    }

    public void setBenchmark(boolean benchmark) {
        this.benchmark = benchmark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
