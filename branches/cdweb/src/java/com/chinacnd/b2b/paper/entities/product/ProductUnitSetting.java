/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.product;

import com.chinacnd.framework.db.IdEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *产品计量单位转换关系设置
 * @author roger
 */
@Entity
@Table(name = "ct_pro_product_unit_setting")
public class ProductUnitSetting extends IdEntity {

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;//商品
    @ManyToOne
    @JoinColumn(name = "unit")
    private MeasureUnit unit;//计量单位
    @Column(name = "is_mainunit")
    private boolean mainUnit;//是否主单位
    @Column(name = "quotiety")
    private double quotiety;//转换比例

    public boolean isMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(boolean mainUnit) {
        this.mainUnit = mainUnit;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuotiety() {
        return quotiety;
    }

    public void setQuotiety(double quotiety) {
        this.quotiety = quotiety;
    }

    public MeasureUnit getUnit() {
        return unit;
    }

    public void setUnit(MeasureUnit unit) {
        this.unit = unit;
    }
}
