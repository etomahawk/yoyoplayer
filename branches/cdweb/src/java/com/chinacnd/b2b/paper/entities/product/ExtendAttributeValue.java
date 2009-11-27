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
 * 扩展属性值
 * @author roger
 */
@Entity
@Table(name = "t_pro_extend_attribute_value")
public class ExtendAttributeValue extends IdEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;//所对应的产品
    @ManyToOne(optional = false)
    @JoinColumn(name = "attribute_id")
    private ExtendAttribute attribute;//所对应的扩展属性
    @Column(name = "attribute_value")
    private String attributeValue;//属性的值

    public ExtendAttribute getAttribute() {
        return attribute;
    }

    public void setAttribute(ExtendAttribute attribute) {
        this.attribute = attribute;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String value) {
        this.attributeValue = value;
    }
}
