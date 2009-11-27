/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

import com.chinacnd.b2b.paper.entities.product.Paper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hadeslee
 */
public class PaperJson {

    private final Paper paper;
    private final String actionName = "product-save-paper-base-attributes";
    private List<FieldType> fields;

    public PaperJson(Paper paper) {
        this.paper = paper;
        initFields();
    }

    private void initFields() {
        fields = new ArrayList<FieldType>();
        fields.add(new FieldType("名称", "paper.productName", "textfield", paper.getProductName(), true));
        fields.add(new FieldType("品牌", "paper.brand", "textfield", paper.getBrand(), true));
        fields.add(new FieldType("克重", "paper.grammage", "textfield", paper.getGrammage(), true));
        fields.add(new FieldType("规格", "paper.spec", "textfield", paper.getSpec(), true));
        fields.add(new FieldType("等级", "paper.grade", "textfield", paper.getGrade(), true));
        fields.add(new FieldType("备注", "paper.description", "textarea", paper.getDescription(), false));
        fields.add(new FieldType("图片", "paper.thumbnailUrl", "hidden", paper.getThumbnailUrl(), false));
    }

    public String getActionName() {
        return actionName;
    }

    public List<FieldType> getFields() {
        return fields;
    }
}
