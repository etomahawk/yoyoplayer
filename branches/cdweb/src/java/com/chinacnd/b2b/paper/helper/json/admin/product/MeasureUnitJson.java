/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

import com.chinacnd.b2b.paper.entities.product.MeasureUnit;

/**
 *
 * @author Hadeslee
 */
public class MeasureUnitJson {

    private final MeasureUnit measureUnit;

    public MeasureUnitJson(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
    }

    public Long getId() {
        return measureUnit.getId();
    }

    public boolean isBenchmark() {
        return measureUnit.isBenchmark();
    }

    public boolean isEnabled() {
        return measureUnit.isEnabled();
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
