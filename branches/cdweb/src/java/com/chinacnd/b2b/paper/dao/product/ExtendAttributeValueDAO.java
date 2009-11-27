/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.dao.product;

import com.chinacnd.b2b.paper.entities.product.ExtendAttributeValue;
import com.chinacnd.framework.db.EntityDAO;

/**
 *
 * @author Hadeslee
 */
public class ExtendAttributeValueDAO extends EntityDAO<ExtendAttributeValue> {

    public ExtendAttributeValue findById(Long id) {
        return super.get(id);
    }

    public void saveOrUpdate(ExtendAttributeValue value) {
        super.saveOrUpdate(value);
    }
}
