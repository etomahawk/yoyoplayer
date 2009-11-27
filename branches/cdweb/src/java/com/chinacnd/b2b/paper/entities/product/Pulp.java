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
 *
 * @author roger
 */
@Entity
@Table(name = "ct_pro_pulp")
@DiscriminatorValue("Pulp")
public class Pulp extends Product {

    @Column(name = "brand", nullable = false, length = 64)
    private String brand;//品牌
    @Column(name = "fibre_source", nullable = false)
    private String fibresource;//纤维原料
    @Column(name = "pulp_technics", nullable = false)
    private String pulpTechnics;//制浆工艺
    @Column(name = "bleach_technics", nullable = false)
    private String bleachTechnics;//漂白工艺
    @Column(name = "grade", nullable = false, length = 64)
    private String grade;//等级

    public String getBleachTechnics() {
        return bleachTechnics;
    }

    public void setBleachTechnics(String bleachTechnics) {
        this.bleachTechnics = bleachTechnics;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFibresource() {
        return fibresource;
    }

    public void setFibresource(String fibresource) {
        this.fibresource = fibresource;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPulpTechnics() {
        return pulpTechnics;
    }

    public void setPulpTechnics(String pulpTechnics) {
        this.pulpTechnics = pulpTechnics;
    }
}
