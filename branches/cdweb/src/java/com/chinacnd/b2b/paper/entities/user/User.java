/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.user;

import com.chinacnd.framework.db.IdEntity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *用户基本信息
 * @author roger
 */
@Entity
@Table(name = "ct_user_user")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class User extends IdEntity {

    @Column(name = "username", nullable = false, length = 32, updatable = false)
    private String username;//登录用户名
    @Column(name = "password", length = 32)
    private String password;//密码
    @Column(name = "fullname", nullable = false, length = 64)
    private String fullname;//用户全名
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "ct_user_user_role")
    private List<Role> assignedRoles;//被分派的角色

    public List<Role> getAssignedRoles() {
        return assignedRoles;
    }

    public void setAssignedRoles(List<Role> assignedRoles) {
        this.assignedRoles = assignedRoles;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
