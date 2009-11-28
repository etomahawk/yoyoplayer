/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

import com.chinacnd.b2b.paper.entities.product.ProductUnitSetting;

/**
 *
 * @author Hadeslee
 */
public class ProductUnitSettingJson {

    private final ProductUnitSetting productUnitSetting;
    private final boolean enabled;//是否启用，有记录的就是启用的，否则就是没有启用的

    public ProductUnitSettingJson(ProductUnitSetting productUnitSetting, boolean enabled) {
        this.productUnitSetting = productUnitSetting;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Long getProductId() {
        return productUnitSetting.getProduct().getId();
    }

    public Long getMeasureUnitId() {
        return productUnitSetting.getUnit().getId();
    }

    public Long getId() {
        return productUnitSetting.getId();
    }

    public String getMeasureUnitName() {
        return productUnitSetting.getUnit().getName();
    }

    public boolean isMainUnit() {
        return productUnitSetting.isMainUnit();
    }

    public double getQuotiety() {
        return productUnitSetting.getQuotiety();
    }
}
