/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.dao.product;

import com.chinacnd.b2b.paper.entities.product.Product;
import com.chinacnd.framework.db.Criteria;
import com.chinacnd.framework.db.EntityDAO;
import com.chinacnd.framework.db.OrderBy;
import com.chinacnd.framework.db.Page;
import java.util.List;

/**
 *
 * @author Hadeslee
 */
public class ProductDAO extends EntityDAO<Product> {

    /**
     * 找到没有分类的产品列表
     * @return 没有分类的产品列表
     */
    public List<Product> findProductsWithoutCategory(Page page, OrderBy orderBy) {
        Criteria<Product> c = Criteria.of(Product.class);
        c.isNull("category");
        if (orderBy != null) {
            c.orderBy(orderBy);
        }
        return findByCriteria(c, page);
    }

    public List<Product> findByCategoryId(Long categoryId, Page page, OrderBy orderBy) {
        Criteria<Product> c = Criteria.of(Product.class);
        c.alias("category", "category");
        c.eq("category.id", categoryId);
        if (orderBy != null) {
            c.orderBy(orderBy);
        }
        return findByCriteria(c, page);
    }

    public Product findById(Long id) {
        return get(id);
    }

    public void saveOrUpdate(Product product) {
        super.saveOrUpdate(product);
    }
}
