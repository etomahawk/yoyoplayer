/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.user;

import com.chinacnd.framework.db.IdEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *角色
 * @author roger
 */
@Entity
@Table(name = "ct_user_role")
public class Role extends IdEntity {

    @Column(name = "code", length = 32)
    private String code;//编码
    @Column(name = "name", length = 64)
    private String name;//名称
    @Column(name = "is_enabled")
    private boolean enabled;//是否启用
    @Column(name = "description", length = 4000)
    private String description;//描述
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ct_user_role_function")
    private List<FunctionItem> functionItems;//所拥有的功能权限项

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<FunctionItem> getFunctionItems() {
        return functionItems;
    }

    public void setFunctionItems(List<FunctionItem> functionItems) {
        this.functionItems = functionItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
