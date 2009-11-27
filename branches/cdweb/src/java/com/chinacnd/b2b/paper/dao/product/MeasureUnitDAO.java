/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.dao.product;

import com.chinacnd.b2b.paper.entities.product.MeasureUnit;
import com.chinacnd.framework.db.Criteria;
import com.chinacnd.framework.db.EntityDAO;
import com.chinacnd.framework.db.OrderBy;
import com.chinacnd.framework.db.Page;
import java.util.List;

/**
 *
 * @author Hadeslee
 */
public class MeasureUnitDAO extends EntityDAO<MeasureUnit> {

    public void disableAllBenchmark() {
        updateByHQL("update MeasureUnit mu set mu.benchmark=false");
    }

    public void saveOrUpdate(MeasureUnit mu) {
        super.saveOrUpdate(mu);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public MeasureUnit findById(Long id) {
        return get(id);
    }

    public List<MeasureUnit> list(Page page, OrderBy orderBy) {
        Criteria<MeasureUnit> c = Criteria.of(MeasureUnit.class);
        if (orderBy != null) {
            c.orderBy(orderBy);
        }
        return findByCriteria(c, page);
    }

    public boolean checkCodeExists(String code) {
        return findByUniqueProperty("code", code) != null;
    }

    public boolean checkNameExists(Long id, String name) {
        Criteria<MeasureUnit> c = Criteria.of(MeasureUnit.class);
        if (id != null) {
            c.ne("id", id);
        }
        c.eq("name", name);
        return findByCriteria(c).size() > 0;
    }
}
