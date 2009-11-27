/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.user;

import com.chinacnd.framework.db.IdEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CollectionOfElements;

/**
 *功能权限项
 * 可以分目录，只有叶子节点可以拥有actions
 * @author roger
 */
@Entity
@Table(name = "ct_user_function")
public class FunctionItem extends IdEntity {

    @Column(name = "code", length = 32)
    private String code;//编码
    @Column(name = "name", length = 64)
    private String name;//名称
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private FunctionItem parent;//上级目录节点
    @Column(name = "description", length = 4000)
    private String description;//描述
    @CollectionOfElements
    @JoinTable(name = "ct_user_function_action", joinColumns = @JoinColumn(name = "function_id"))
    @Column(name = "action_url", nullable = false)
    private List<String> actions;//对应web的form url

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

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

    public FunctionItem getParent() {
        return parent;
    }

    public void setParent(FunctionItem parent) {
        this.parent = parent;
    }
}
