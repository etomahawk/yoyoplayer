/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.product;

import com.chinacnd.b2b.paper.entities.product.ProductUnitSetting;

/**
 *
 * @author Hadeslee
 */
public class ProductUnitSettingForm {

    private ProductUnitSetting productUnitSetting = new ProductUnitSetting();
    private Long measureUnitId;
    private boolean enabled;//因为是批量设置，所以要多一个属性用于设置是否启用本计量单位？

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getMeasureUnitId() {
        return measureUnitId;
    }

    public void setMeasureUnitId(Long measureUnitId) {
        this.measureUnitId = measureUnitId;
    }

    public void setId(Long id) {
        productUnitSetting.setId(id);
    }

    public Long getId() {
        return productUnitSetting.getId();
    }

    public void setQuotiety(double quotiety) {
        productUnitSetting.setQuotiety(quotiety);
    }

    public void setMainUnit(boolean mainUnit) {
        productUnitSetting.setMainUnit(mainUnit);
    }

    public boolean isMainUnit() {
        return productUnitSetting.isMainUnit();
    }

    public double getQuotiety() {
        return productUnitSetting.getQuotiety();
    }
}
