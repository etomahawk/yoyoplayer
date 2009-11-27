/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json.admin.product;

import com.chinacnd.b2b.paper.entities.product.Pulp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hadeslee
 */
public class PulpJson {

    private final Pulp pulp;
    private final String actionName = "product-save-pulp-base-attributes";
    private List<FieldType> fields;

    public PulpJson(Pulp pulp) {
        this.pulp = pulp;
        initFields();
    }

    private void initFields() {
        fields = new ArrayList<FieldType>();
        fields.add(new FieldType("品牌", "pulp.brand", "textfield", pulp.getBrand(), true));
        fields.add(new FieldType("纤维原料", "pulp.fibresource", "textfield", pulp.getFibresource(), true));
        fields.add(new FieldType("制浆工艺", "pulp.pulpTechnics", "textfield", pulp.getPulpTechnics(), true));
        fields.add(new FieldType("漂白工艺", "pulp.bleachTechnics", "textfield", pulp.getBleachTechnics(), true));
        fields.add(new FieldType("等级", "pulp.grade", "textfield", pulp.getGrade(), true));
        fields.add(new FieldType("备注", "pulp.description", "textarea", pulp.getDescription(), false));
        fields.add(new FieldType("图片", "pulp.thumbnailUrl", "hidden", pulp.getThumbnailUrl(), false));
    }

    public String getActionName() {
        return actionName;
    }

    public List<FieldType> getFields() {
        return fields;
    }
}
