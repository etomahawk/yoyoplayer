/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.enterprise;

import com.chinacnd.b2b.paper.entities.enterprise.Area;

/**
 *
 * @author Genius
 */
public class AreaJson {

    private Area area;

    public AreaJson(Area area) {
        this.area = area;
    }

    public void setId(long id) {
        area.setId(id);
    }

    public long getId() {
        return area.getId();
    }

    public String getParentId() {
        if (area.getParent() == null) {
            return "";
        } else {
            return String.valueOf(area.getParent().getId());
        }
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
