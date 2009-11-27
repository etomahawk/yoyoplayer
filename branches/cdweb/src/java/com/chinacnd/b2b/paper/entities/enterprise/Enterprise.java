/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.enterprise;

import com.chinacnd.framework.db.IdEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 企业实体
 * @author roger
 */
@Entity
@Table(name = "ct_ent_enterprise")
@NamedQueries({
    @NamedQuery(name = "Enterprise.loadListByAreaFullCode", query = "select e from Enterprise e where e.location.fullCode like :fullCode")
})
public class Enterprise extends IdEntity {

    @Column(name = "code", nullable = false, length = 32)
    private String code;//编码
    @Column(name = "name", length = 64, nullable = false)
    private String name;//名称
    @Column(name = "ent_type", length = 32)
    @Enumerated(value = EnumType.STRING)
    private EnterpriseType type;//企业类型
    @Column(name = "ent_kind", length = 32)
    @Enumerated(value = EnumType.STRING)
    private EnterpriseKind kind;//如果企业类型是会员的话，则表示企业类型
    @JoinColumn(name = "location_id")
    @ManyToOne
    private Area location;//地区
    @Column(name = "address")
    private String address;//地址
    @Column(name = "postcode", length = 16)
    private String postcode;//邮编
    @Column(name = "link_man", length = 64)
    private String linkman;//联系人
    @Column(name = "telephone", length = 32)
    private String telephone;//电话
    @Column(name = "fax", length = 32)
    private String fax;//传真
    @Column(name = "email", length = 64)
    private String email;//EMAIL地址
    @Column(name = "description", length = 4000)
    private String description;//描述
    @Column(name = "is_enabled", nullable = false)
    private boolean enabled = true;//是否启用
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date")
    private Date lastUpdateDate;//更新日期 

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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public EnterpriseKind getKind() {
        return kind;
    }

    public void setKind(EnterpriseKind kind) {
        this.kind = kind;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public Area getLocation() {
        return location;
    }

    public void setLocation(Area location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public EnterpriseType getType() {
        return type;
    }

    public void setType(EnterpriseType type) {
        this.type = type;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
