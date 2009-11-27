/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.framework.db;

import com.chinacnd.b2b.paper.helper.form.RequestRecordForm;
import com.chinacnd.framework.util.StringUtils;

/**
 * 排序的对象
 * @author Hadeslee
 */
public class OrderBy {

    public static final String ASC = "asc";
    public static final String DESC = "desc";
    private final String property;//排序的字段名
    private Order order = Order.ASC;//升序还是降序

    public OrderBy(String property) {
        this.property = property;
    }

    public static OrderBy from(RequestRecordForm form) {
        if (StringUtils.hasText(form.getSort())) {
            OrderBy orderBy = new OrderBy(form.getSort());
            orderBy.setOrder(Order.getOrderByValue(form.getDir()));
            return orderBy;
        } else {
            return null;
        }
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProperty() {
        return property;
    }

    public static enum Order {

        ASC("asc"), DESC("desc");
        public final String value;

        private Order(String value) {
            this.value = value;
        }

        /**
         * 此方法返回Order是为了防止直接调用
         * valueOf方法当没有匹配的结果的时候出现异常
         * @param value 要匹配的值
         * @return 匹配到的枚举
         */
        public static Order getOrderByValue(String value) {
            for (Order order : Order.values()) {
                if (order.value.equalsIgnoreCase(value)) {
                    return order;
                }
            }
            return Order.ASC;
        }
    }
}
