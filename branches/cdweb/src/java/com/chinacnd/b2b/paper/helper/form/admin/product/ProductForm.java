/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.product;

import com.chinacnd.b2b.paper.entities.product.Product;
import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;

/**
 * TODO 此类可以适当的缩小范围，因为很多属性是不让编辑的
 * @author Hadeslee
 */
public class ProductForm extends RequestRecordForm {

    private Product product = new Product();
    private Long categoryId;

    public Long getId() {
        return product.getId();
    }

    public void setId(Long id) {
        product.setId(id);
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
