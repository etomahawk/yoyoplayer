/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.product;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 纸张
 * @author roger
 */
@Entity
@Table(name = "ct_pro_paper")
@DiscriminatorValue("Paper")
public class Paper extends Product {

    @Column(name = "product_name", nullable = false, length = 64)
    private String productName;//产品名称
    @Column(name = "brand", nullable = false, length = 64)
    private String brand;//品牌
    @Column(name = "grammage", nullable = false, length = 64)
    private String grammage;//克重
    @Column(name = "spec", nullable = false, length = 64)
    private String spec;//规格
    @Column(name = "grade", nullable = false, length = 64)
    private String grade;//等级

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrammage() {
        return grammage;
    }

    public void setGrammage(String grammage) {
        this.grammage = grammage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
