/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.product;

import com.chinacnd.b2b.paper.entities.product.Pulp;
import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;

/**
 *
 * @author Hadeslee
 */
public class PulpForm extends RequestRecordForm {

    private Pulp pulp = new Pulp();

    public void setId(Long id) {
        pulp.setId(id);
    }

    public Long getId() {
        return pulp.getId();
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        pulp.setThumbnailUrl(thumbnailUrl);
    }

    public void setDescription(String description) {
        pulp.setDescription(description);
    }

    public String getThumbnailUrl() {
        return pulp.getThumbnailUrl();
    }

    public String getDescription() {
        return pulp.getDescription();
    }
}
