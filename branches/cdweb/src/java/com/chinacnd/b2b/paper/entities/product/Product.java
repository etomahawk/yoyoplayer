/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.product;

import com.chinacnd.framework.db.IdEntity;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 商品的父表
 * @author roger
 */
@Entity
@Table(name = "ct_pro_product")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("Product")
@NamedQueries({
    @NamedQuery(name = "Product.findProductsWithoutCategory", query = "select p from Product p where p.category is null")
})
public class Product extends IdEntity {

    @Column(name = "net_code", length = 32)
    private String netCode;//网上编码
    @Column(name = "code", nullable = false, length = 32)
    private String code;//产品编码
    @Column(name = "full_name", nullable = false)
    private String fullName;//产品全名
    @Column(name = "gtin_number", length = 32)
    private String gtinNumber;//GTIN编码
    @Column(name = "supplier_code", length = 32)
    private String supplierCode;//供应商编码
    @Column(name = "supplier_number", length = 32)
    private String supplierNumber;//供应商编号
    @Column(name = "supplier_name")
    private String supplierName;//供应商名称
    @Column(name = "thumbnail_url")
    private String thumbnailUrl;//产品图片
    @Column(name = "description", length = 4000)
    private String description;//描述
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date")
    private Date lastUpdateDate;//最后更新日期
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ExtendAttributeValue> extendValueList;//产品所对应的扩展属性列表
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;//所属分类，可能为空，则表示新导进来的产品
    @OneToMany(mappedBy = "product")
    private List<ProductUnitSetting> measureUnitSetting;//产品计量单位转换系数设置

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGtinNumber() {
        return gtinNumber;
    }

    public void setGtinNumber(String gtinNumber) {
        this.gtinNumber = gtinNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNetCode() {
        return netCode;
    }

    public void setNetCode(String netCode) {
        this.netCode = netCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierNumber() {
        return supplierNumber;
    }

    public void setSupplierNumber(String supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<ExtendAttributeValue> getExtendValueList() {
        return extendValueList;
    }

    public void setExtendValueList(List<ExtendAttributeValue> extendValueList) {
        this.extendValueList = extendValueList;
    }

    public List<ProductUnitSetting> getMeasureUnitSetting() {
        return measureUnitSetting;
    }

    public void setMeasureUnitSetting(List<ProductUnitSetting> measureUnitSetting) {
        this.measureUnitSetting = measureUnitSetting;
    }
}
