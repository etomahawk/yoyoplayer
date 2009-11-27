/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.enterprise;

import com.chinacnd.b2b.paper.entities.enterprise.Area;
import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;

/**
 *
 * @author Genius
 */
public class AreaForm extends RequestRecordForm {

    private Area area = new Area();
    private Long parentAreaID;
    private String areaIds;

    public String getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(String areaIds) {
        this.areaIds = areaIds;
    }

    public AreaForm() {
    }

    public Long getParentAreaID() {
        return parentAreaID;
    }

    public void setParentAreaID(Long parentAreaID) {
        this.parentAreaID = parentAreaID;
    }

    public void setId(Long id) {
        area.setId(id);
    }

    public Long getId() {
        return area.getId();
    }

    public void setName(String name) {
        area.setName(name);
    }

    public void setDescription(String description) {
        area.setDescription(description);
    }

    public void setCode(String code) {
        area.setCode(code);
    }

    public String getName() {
        return area.getName();
    }

    public String getDescription() {
        return area.getDescription();
    }

    public String getCode() {
        return area.getCode();
    }
}
