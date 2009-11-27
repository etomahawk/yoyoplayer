/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.enterprise;

import com.chinacnd.b2b.paper.entities.enterprise.Area;
import com.chinacnd.b2b.paper.entities.enterprise.Enterprise;
import com.chinacnd.b2b.paper.entities.enterprise.EnterpriseKind;
import com.chinacnd.b2b.paper.entities.enterprise.EnterpriseType;
import java.util.Date;

/**
 *
 * @author Genius
 */
public class EnterpriseJson {

    private Enterprise enterprise;

    public EnterpriseJson(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Long getId() {
        return enterprise.getId();
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

    public Long getLocation() {
        Area area = enterprise.getLocation();
        return area == null ? - 1 : area.getId();
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
