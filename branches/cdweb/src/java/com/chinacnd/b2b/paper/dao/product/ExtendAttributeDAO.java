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

    public List<ExtendAttribute> getExtendAttributesByName(String name, Page page, OrderBy orderBy) {
        Criteria<ExtendAttribute> c = Criteria.of(ExtendAttribute.class);
        if (StringUtils.hasText(name)) {
            c.like("name", name);
        }
        if (orderBy != null) {
            c.orderBy(orderBy);
        }
        return findByCriteria(c, page);
    }

    public boolean checkCodeExists(Long id, String code) {
        Criteria<ExtendAttribute> c = Criteria.of(ExtendAttribute.class);
        if (id != null) {
            c.ne("id", id);
        }
        c.eq("code", code);
        return findByCriteria(c).size() > 0;
    }

    public void saveOrUpdate(ExtendAttribute extendAttribute) {
        super.saveOrUpdate(extendAttribute);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public ExtendAttribute findById(Long id) {
        return get(id);
    }
}
