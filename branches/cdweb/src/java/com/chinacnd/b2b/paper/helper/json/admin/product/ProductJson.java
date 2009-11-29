/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

import com.chinacnd.b2b.paper.entities.product.Product;
import java.util.Date;
import org.apache.struts2.json.annotations.JSON;

/**
 *
 * @author Hadeslee
 */
public class ProductJson {

    private final Product product;

    public ProductJson(Product product) {
        this.product = product;
    }

    public Long getId() {
        return product.getId();
    }

    public String getSupplierNumber() {
        return product.getSupplierNumber();
    }

    public String getSupplierName() {
        return product.getSupplierName();
    }

    public String getSupplierCode() {
        return product.getSupplierCode();
    }

    public String getNetCode() {
        return product.getNetCode();
    }
    @JSON(format="yyyy年MM月dd日HH:mm:ss")
    public Date getLastUpdateDate() {
        return product.getLastUpdateDate();
    }

    public String getGtinNumber() {
        return product.getGtinNumber();
    }

    public String getFullName() {
        return product.getFullName();
    }

    public String getCode() {
        return product.getCode();
    }
}
