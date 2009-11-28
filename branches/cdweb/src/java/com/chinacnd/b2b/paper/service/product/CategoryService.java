/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service.product;

import com.chinacnd.b2b.paper.dao.product.CategoryDAO;
import com.chinacnd.b2b.paper.dao.product.ExtendAttributeDAO;
import com.chinacnd.b2b.paper.entities.product.Category;
import com.chinacnd.b2b.paper.entities.product.ExtendAttribute;
import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.form.admin.product.CategoryForm;
import com.chinacnd.framework.db.OrderBy;
import com.chinacnd.framework.db.Page;
import com.chinacnd.framework.util.StringUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hadeslee
 */
public class CategoryService {

    @Resource
    private CategoryDAO categoryDAO;
    @Resource
    private ExtendAttributeDAO extendAttributeDAO;

    @Transactional(readOnly = true)
    public List<ExtendAttribute> getParentExtendAttributes(Long categoryId) {
        return categoryDAO.getParentAttributes(categoryId);
    }

    @Transactional(readOnly = true)
    public List<ExtendAttribute> getSelfExtendAttributes(Long categoryId) {
        return categoryDAO.getSelfExtendAttributes(categoryId);
    }

    @Transactional(readOnly = true)
    public List<Category> loadCategoryByParentId(CategoryForm form) {
        Page page = Page.from(form);
        OrderBy orderBy = OrderBy.from(form);
        List<Category> list = categoryDAO.findByParentId(form.getParentId(), page, orderBy);
        form.setTotalSize(page.getTotalCount());
        return list;
    }

    @Transactional(readOnly = true)
    public List<Category> loadCategoryByParentId(Long parentId) {
        return categoryDAO.loadCategoryByParentId(parentId);
    }

    @Transactional
    public void save(CategoryForm form) throws ServiceException {
        boolean nameExists = categoryDAO.checkNameExists(form.getId(), form.getName());
        if (nameExists) {
            throw new ServiceException("分类名称已经存在，请重新输入");
        }
        Category category = null;
        if (form.getId() == null || form.getId() <= 0) {
            boolean codeExists = categoryDAO.checkCodeExists(form.getCode());
            if (codeExists) {
                throw new ServiceException("分类编码已经存在，请重新输入");
            }
            category = new Category();
            Category parent = categoryDAO.findById(form.getParentId());
            parent.setLeaf(false);
            category.setParent(parent);
            category.setType(parent.getType());
            category.setCode(form.getCode());
            category.setName(form.getName());
            category.setDescription(form.getDescription());
            category.setLastUpdateDate(new Date());
            categoryDAO.saveOrUpdate(category);
            category.setFullCode(parent.getId() + "/" + category.getId());
        } else {
            category = categoryDAO.findById(form.getId());
            category.setName(form.getName());
            category.setDescription(form.getDescription());
            category.setLastUpdateDate(new Date());
        }
    }

    @Transactional
    public void saveCategoryAttributeAssoications(CategoryForm form) {
        Category category = categoryDAO.findById(form.getId());
        String[] temp = StringUtils.split(form.getExtendAttrbiteIds(), ",");
        List<ExtendAttribute> extendAttributes = new ArrayList<ExtendAttribute>();
        for (String id : temp) {
            extendAttributes.add(extendAttributeDAO.findById(Long.valueOf(id)));
        }
        category.setExtendAttributeList(extendAttributes);
        categoryDAO.saveOrUpdate(category);
    }

    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return categoryDAO.findById(id);
    }

    @Transactional
    public void deleteByIds(Long[] ids) throws ServiceException {
        List<Category> categorys = new ArrayList<Category>();
        Category parent = null;
        for (Long id : ids) {
            Category category = findById(id);
            if (parent == null) {
                parent = category.getParent();
            }
            //如果不是叶节点，则不让删
            if (category.isLeaf() == false) {
                throw new ServiceException("有子节点的分类不允许删除");
            }
            categorys.add(category);
        }
        for (Category category : categorys) {
            categoryDAO.delete(category);
        }
        if (parent != null &&
                categoryDAO.loadCategoryByParentId(parent.getId()).isEmpty()) {
            parent.setLeaf(true);
        }
    }
}
