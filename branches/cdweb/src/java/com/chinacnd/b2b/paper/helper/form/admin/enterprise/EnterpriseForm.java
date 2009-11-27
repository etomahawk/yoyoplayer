/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.enterprise;

import com.chinacnd.b2b.paper.entities.enterprise.Area;
import com.chinacnd.b2b.paper.entities.enterprise.Enterprise;
import com.chinacnd.b2b.paper.entities.enterprise.EnterpriseKind;
import com.chinacnd.b2b.paper.entities.enterprise.EnterpriseType;
import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;
import java.util.Date;

/**
 *
 * @author Genius
 */
public class EnterpriseForm extends RequestRecordForm {

    private Enterprise enterprise = new Enterprise();
    private String fullCode;
    private long areaID;
    private String enterpriseIds;

    public String getEnterpriseIds() {
        return enterpriseIds;
    }

    public void setEnterpriseIds(String enterpriseIds) {
        this.enterpriseIds = enterpriseIds;
    }

    public void setId(Long id) {
        enterprise.setId(id);
    }

    public Long getId() {
        return enterprise.getId();
    }

    public long getAreaID() {
        return areaID;
    }

    public void setAreaID(long areaID) {
        this.areaID = areaID;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }

    public void setType(EnterpriseType type) {
        enterprise.setType(type);
    }

    public void setTelephone(String telephone) {
        enterprise.setTelephone(telephone);
    }

    public void setPostcode(String postcode) {
        enterprise.setPostcode(postcode);
    }

    public void setName(String name) {
        enterprise.setName(name);
    }

    public void setLinkman(String linkman) {
        enterprise.setLinkman(linkman);
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        enterprise.setLastUpdateDate(lastUpdateDate);
    }

    public void setKind(EnterpriseKind kind) {
        enterprise.setKind(kind);
    }

    public void setFax(String fax) {
        enterprise.setFax(fax);
    }

    public void setEnabled(boolean enabled) {
        enterprise.setEnabled(enabled);
    }

    public void setEmail(String email) {
        enterprise.setEmail(email);
    }

    public void setDescription(String description) {
        enterprise.setDescription(description);
    }

    public void setCode(String code) {
        enterprise.setCode(code);
    }

    public void setAddress(String address) {
        enterprise.setAddress(address);
    }

    public boolean isEnabled() {
        return enterprise.isEnabled();
    }

    public EnterpriseType getType() {
        return enterprise.getType();
    }

    public String getTelephone() {
        return enterprise.getTelephone();
    }

    public String getPostcode() {
        return enterprise.getPostcode();
    }

    public String getName() {
        return enterprise.getName();
    }

    public String getLinkman() {
        return enterprise.getLinkman();
    }

    public Date getLastUpdateDate() {
        return enterprise.getLastUpdateDate();
    }

    public EnterpriseKind getKind() {
        return enterprise.getKind();
    }

    public String getFax() {
        return enterprise.getFax();
    }

    public String getEmail() {
        return enterprise.getEmail();
    }

    public String getDescription() {
        return enterprise.getDescription();
    }

    public String getCode() {
        return enterprise.getCode();
    }

    public String getAddress() {
        return enterprise.getAddress();
    }
}
