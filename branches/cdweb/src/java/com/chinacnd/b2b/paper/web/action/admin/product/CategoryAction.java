/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.action.admin.product;

import com.chinacnd.b2b.paper.entities.product.Category;
import com.chinacnd.b2b.paper.entities.product.ExtendAttribute;
import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.form.admin.product.CategoryForm;
import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.b2b.paper.helper.json.TreeJson;
import com.chinacnd.b2b.paper.helper.json.admin.product.CategoryJson;
import com.chinacnd.b2b.paper.helper.json.admin.product.ExtendAttributeJson;
import com.chinacnd.b2b.paper.service.product.CategoryService;
import com.chinacnd.framework.struts.BaseAction;
import com.chinacnd.framework.util.StringUtils;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;

/**
 *
 * @author Hadeslee
 */
public class CategoryAction extends BaseAction implements ModelDriven<CategoryForm> {

    @Resource
    private CategoryService categoryService;
    private CategoryForm form = new CategoryForm();

    @Action(value = "category-list-parent-extend-attributes")
    public String listParentExtendAttributes() {
        List<ExtendAttribute> list = categoryService.getParentExtendAttributes(form.getId());
        List<ExtendAttributeJson> jsonList = new ArrayList<ExtendAttributeJson>();
        for (ExtendAttribute extendAttribute : list) {
            jsonList.add(new ExtendAttributeJson(extendAttribute));
        }
        setJsonList(jsonList);
        return JSON_RESULT;
    }

    @Action(value = "category-list-self-extend-attributes")
    public String listSelfExtendAttributes() {
        List<ExtendAttribute> list = categoryService.getSelfExtendAttributes(form.getId());
        List<ExtendAttributeJson> jsonList = new ArrayList<ExtendAttributeJson>();
        for (ExtendAttribute extendAttribute : list) {
            jsonList.add(new ExtendAttributeJson(extendAttribute));
        }
        setJsonList(jsonList);
        return JSON_RESULT;
    }

    @Deprecated
    @Action(value = "category-show-extend-attributes")
    //此方法只能看到自己的扩展属性，所以标志为过时
    public String listCategoryExtendAttributes() {
        Category category = categoryService.findById(form.getId());
        List<ExtendAttribute> extendAttributes = category.getExtendAttributeList();
        List<ExtendAttributeJson> jsonList = new ArrayList<ExtendAttributeJson>();
        for (ExtendAttribute extendAttribute : extendAttributes) {
            jsonList.add(new ExtendAttributeJson(extendAttribute));
        }
        setJsonList(jsonList);
        return JSON_RESULT;
    }

    @Action(value = "category-list")
    public String list() {
        List<Category> list = categoryService.loadCategoryByParentId(form);
        List<CategoryJson> jsonList = new ArrayList<CategoryJson>();
        for (Category category : list) {
            CategoryJson json = new CategoryJson(category);
            json.setHasExtendAttributes(category.getExtendAttributeList().size() > 0);
            jsonList.add(json);
        }
        setJsonList(jsonList, form.getTotalSize());
        return JSON_RESULT;
    }

    @Action(value = "category-load")
    public String loadTreeNodes() {
        List<Category> list = categoryService.loadCategoryByParentId(form.getParentId());
        List<TreeJson> trees = new ArrayList<TreeJson>();
        for (Category c : list) {
            TreeJson tree = new TreeJson();
            tree.setDescription(c.getDescription());
            tree.setId(String.valueOf(c.getId()));
            tree.setLeaf(c.isLeaf());
            tree.setText(c.getName());
            trees.add(tree);
        }
        setJsonTree(trees);
        return JSON_RESULT;
    }

    @Action(value = "category-save")
    public String save() {
        OperationResultJson json = new OperationResultJson();
        try {
            categoryService.save(form);
        } catch (ServiceException ex) {
            ex.printStackTrace();
            log.error(null, ex);
            json.setMessage(ex.getMessage());
            json.setSuccess(false);
        }
        setJsonObject(json);
        return JSON_RESULT;
    }

    @Action(value = "category-edit")
    public String edit() {
        Category category = categoryService.findById(form.getId());
        if (category == null) {
            OperationResultJson json = new OperationResultJson();
            json.setSuccess(false);
            json.setMessage("编辑的商品分类非法");
            setJsonObject(json);
        } else {
            setJsonObject(new CategoryJson(category));
        }
        return JSON_RESULT;
    }

    @Action(value = "category-delete")
    public String delete() {
        OperationResultJson json = new OperationResultJson();
        String[] temp = StringUtils.split(form.getDeleteIds(), ",");
        Long[] ids = new Long[temp.length];
        try {
            for (int i = 0; i < temp.length; i++) {
                ids[i] = Long.valueOf(temp[i]);
            }
            categoryService.deleteByIds(ids);
        } catch (ServiceException ex) {
            ex.printStackTrace();
            log.error(null, ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
        }
        setJsonObject(json);
        return JSON_RESULT;
    }

    @Action(value = "category-extend-attribute-save")
    public String saveCategoryExtendAttributes() {
        categoryService.saveCategoryAttributeAssoications(form);
        OperationResultJson json = new OperationResultJson();
        setJsonObject(json);
        return JSON_RESULT;
    }

    public CategoryForm getModel() {
        return form;
    }
}
