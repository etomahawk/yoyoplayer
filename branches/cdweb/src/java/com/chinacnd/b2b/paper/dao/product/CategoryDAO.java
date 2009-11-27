/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.dao.product;

import com.chinacnd.b2b.paper.entities.product.Category;
import com.chinacnd.b2b.paper.entities.product.CategoryType;
import com.chinacnd.b2b.paper.entities.product.ExtendAttribute;
import com.chinacnd.framework.db.Criteria;
import com.chinacnd.framework.db.EntityDAO;
import com.chinacnd.framework.db.NamedQuery;
import com.chinacnd.framework.db.OrderBy;
import com.chinacnd.framework.db.Page;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Hadeslee
 */
public class CategoryDAO extends EntityDAO<Category> {

    public List<ExtendAttribute> getParentAttributes(Long categoryId) {
        List<ExtendAttribute> list = new ArrayList<ExtendAttribute>();
        Category category = findById(categoryId);
        Category parent = category.getParent();
        while (parent != null) {
            list.addAll(parent.getExtendAttributeList());
        }
        return list;
    }

    public List<ExtendAttribute> getExtendAttributes(Long categoryId) {
        Category category = findById(categoryId);
        return category.getExtendAttributeList();
    }

    public List<ExtendAttribute> getAllExtendAttributes(Long categoryId) {
        List<ExtendAttribute> parentAttributes = getParentAttributes(categoryId);
        List<ExtendAttribute> selfAttributes = getExtendAttributes(categoryId);
        Set<ExtendAttribute> set = new HashSet<ExtendAttribute>();
        set.addAll(parentAttributes);
        set.addAll(selfAttributes);
        List<ExtendAttribute> all = new ArrayList<ExtendAttribute>();
        all.addAll(set);
        return all;
    }

    public Category findRootByType(CategoryType type) {
        NamedQuery nq = new NamedQuery("Category.findRootByType");
        nq.addParameter("type", type);
        return findUniqueResult(nq);
    }

    public List<Category> findByParentId(Long id, Page page, OrderBy orderBy) {
        Criteria<Category> c = Criteria.of(Category.class);
        c.alias("parent", "parent");
        c.eq("parent.id", id);
        if (orderBy != null) {
            c.orderBy(orderBy);
        }
        return findByCriteria(c, page);
    }

    public List<Category> loadCategoryByParentId(Long id) {
        NamedQuery nq = null;
        if (id == null || id <= 0) {
            nq = new NamedQuery("Category.findRoots");
        } else {
            nq = new NamedQuery("Category.findByParentId");
            nq.addParameter("id", id);
        }
        return findByNamedQuery(nq);
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public void delete(Category category) {
        super.delete(category);
    }

    public void saveOrUpdate(Category category) {
        super.saveOrUpdate(category);
    }

    public boolean checkCodeExists(String code) {
        Criteria<Category> c = Criteria.of(Category.class);
        c.eq("code", code);
        return findByCriteria(c).size() > 0;
    }

    public Category findById(Long id) {
        return get(id);
    }

    public boolean checkNameExists(Long id, String name) {
        Criteria<Category> c = Criteria.of(Category.class);
        if (id != null) {
            c.ne("id", id);
        }
        c.eq("name", name);
        return findByCriteria(c).size() > 0;
    }
}
