/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.dao.product;

import com.chinacnd.b2b.paper.entities.product.ExtendAttribute;
import com.chinacnd.framework.db.Criteria;
import com.chinacnd.framework.db.EntityDAO;
import com.chinacnd.framework.db.OrderBy;
import com.chinacnd.framework.db.Page;
import com.chinacnd.framework.util.StringUtils;
import java.util.List;

/**
 *
 * @author Hadeslee
 */
public class ExtendAttributeDAO extends EntityDAO<ExtendAttribute> {

    public List<ExtendAttribute> getAllExtendAttributesByName(String name, Page page, OrderBy orderBy) {
        Criteria<ExtendAttribute> c = Criteria.of(ExtendAttribute.class);
        if (StringUtils.hasText(name)) {
            c.like("name", name);
        }
        if (orderBy != null) {
            c.orderBy(orderBy);
        }
        return findByCriteria(c, page);
    }

    public List<ExtendAttribute> getEnabledExtendAttributesByName(String name, Page page, OrderBy orderBy) {
        Criteria<ExtendAttribute> c = Criteria.of(ExtendAttribute.class);
        c.eq("enabled", true);
        if (StringUtils.hasText(name)) {
            c.like("name", name);
        }
        if (orderBy != null) {
            c.orderBy(orderBy);
        }
        return findByCriteria(c, page);
    }

    public boolean checkCodeExists(String code) {
        Criteria<ExtendAttribute> c = Criteria.of(ExtendAttribute.class);
        c.eq("code", code);
        return findByCriteria(c).size() > 0;
    }
}
