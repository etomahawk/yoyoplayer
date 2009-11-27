/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.dao.product;

import com.chinacnd.b2b.paper.entities.product.CoreAttribute;
import com.chinacnd.b2b.paper.entities.product.CoreAttributeType;
import com.chinacnd.framework.db.Criteria;
import com.chinacnd.framework.db.EntityDAO;
import com.chinacnd.framework.db.OrderBy;
import com.chinacnd.framework.db.Page;
import java.util.List;

/**
 *
 * @author Hadeslee
 */
public class CoreAttributeDAO extends EntityDAO<CoreAttribute> {

    public List<CoreAttribute> getCoreAttributeByType(CoreAttributeType type, Page page, OrderBy orderBy) {
        Criteria<CoreAttribute> c = Criteria.of(CoreAttribute.class);
        if (type != null) {
            c.eq("attributeType", type);
        }
        if (orderBy != null) {
            c.orderBy(orderBy);
        }
        return findByCriteria(c, page);
    }
}
