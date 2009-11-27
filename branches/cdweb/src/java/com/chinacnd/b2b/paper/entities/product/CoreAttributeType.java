/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.product;

/**
 * 公共属性类型
 * @author roger
 */
public enum CoreAttributeType {

    COMMON("公共属性"), PAPER("纸张属性"), PULP("纸浆属性");
    public final String attributeName;

    private CoreAttributeType(String attributeName) {
        this.attributeName = attributeName;
    }

    public static CoreAttributeType getCoreAttributeTypeByName(String name) {
        for (CoreAttributeType type : CoreAttributeType.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }
}
