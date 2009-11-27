/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.product;

import com.chinacnd.b2b.paper.entities.product.MeasureUnit;
import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;

/**
 *
 * @author Hadeslee
 */
public class MeasureUnitForm extends RequestRecordForm {

    private MeasureUnit measureUnit = new MeasureUnit();

    public void setId(Long id) {
        measureUnit.setId(id);
    }

    public Long getId() {
        return measureUnit.getId();
    }

    public void setName(String name) {
        measureUnit.setName(name);
    }

    public void setEnabled(boolean enabled) {
        measureUnit.setEnabled(enabled);
    }

    public void setDescription(String description) {
        measureUnit.setDescription(description);
    }

    public void setCode(String code) {
        measureUnit.setCode(code);
    }

    public void setBenchmark(boolean benchmark) {
        measureUnit.setBenchmark(benchmark);
    }

    public boolean isEnabled() {
        return measureUnit.isEnabled();
    }

    public boolean isBenchmark() {
        return measureUnit.isBenchmark();
    }

    public String getName() {
        return measureUnit.getName();
    }

    public String getDescription() {
        return measureUnit.getDescription();
    }

    public String getCode() {
        return measureUnit.getCode();
    }
}
