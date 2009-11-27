/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.user;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *总公司用户，待确定是否和分公司用户合并为一起
 * @author roger
 */
@Entity
@Table(name = "ct_user_admin")
@DiscriminatorValue("admin")
@NamedQueries({
    @NamedQuery(name = "AdminUser.login", query = "select a from AdminUser a where a.username=:username and a.password=:password")
})
public class AdminUser extends User {

    @Column(name = "address")
    private String address;//地址
    @Column(name = "description", length = 4000)
    private String description;//描述
    @Column(name = "email", length = 64)
    private String email;//邮箱地址
    @Column(name = "is_enbaled", nullable = false)
    private boolean enabled = true;//状态
    @Column(name = "fax", length = 32)
    private String fax;//传真
    @Column(name = "gender", length = 32)
    @Enumerated(value = EnumType.STRING)
    private Gender gender;//性别
    @Column(name = "postcode", length = 16)
    private String postcode;//邮编
    @Column(name = "telephone", length = 32)
    private String telephone;//联系电话

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
