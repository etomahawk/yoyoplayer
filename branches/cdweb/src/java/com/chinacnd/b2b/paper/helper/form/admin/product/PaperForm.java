/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.form.admin.product;

import com.chinacnd.b2b.paper.entities.product.Paper;
import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;

/**
 * 目前纸张也只有两个属性可以编辑
 * 一个是商品图片
 * 一个是商品备注
 * @author Hadeslee
 */
public class PaperForm extends RequestRecordForm {

    private Paper paper = new Paper();

    public void setId(Long id) {
        paper.setId(id);
    }

    public Long getId() {
        return paper.getId();
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        paper.setThumbnailUrl(thumbnailUrl);
    }

    public void setDescription(String description) {
        paper.setDescription(description);
    }

    public String getThumbnailUrl() {
        return paper.getThumbnailUrl();
    }

    public String getDescription() {
        return paper.getDescription();
    }
    
}
