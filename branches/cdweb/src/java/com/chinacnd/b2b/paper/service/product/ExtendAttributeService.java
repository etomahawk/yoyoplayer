/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service.product;

import com.chinacnd.b2b.paper.dao.product.ExtendAttributeDAO;
import com.chinacnd.b2b.paper.entities.product.ExtendAttribute;
import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.form.admin.product.ExtendAttributeForm;
import com.chinacnd.framework.db.OrderBy;
import com.chinacnd.framework.db.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hadeslee
 */
public class ExtendAttributeService {

    @Resource
    private ExtendAttributeDAO extendAttributeDAO;

    @Transactional(readOnly = true)
    public List<ExtendAttribute> getAllExtendAttributesByName(ExtendAttributeForm form) {
        String name = form.getName();
        Page page = Page.from(form);
        OrderBy orderBy = OrderBy.from(form);
        List<ExtendAttribute> list = extendAttributeDAO.getAllExtendAttributesByName(name, page, orderBy);
        form.setTotalSize(page.getTotalCount());
        return list;
    }

    @Transactional(readOnly = true)
    public List<ExtendAttribute> getEnabledExtendAttributesByName(ExtendAttributeForm form) {
        String name = form.getName();
        Page page = Page.from(form);
        OrderBy orderBy = OrderBy.from(form);
        List<ExtendAttribute> list = extendAttributeDAO.getEnabledExtendAttributesByName(name, page, orderBy);
        form.setTotalSize(page.getTotalCount());
        return list;
    }

    @Transactional
    public void save(ExtendAttributeForm form) throws ServiceException {
        //表示新增
        if (form.getId() == null || form.getId() <= 0) {
            boolean codeExists = extendAttributeDAO.checkCodeExists(form.getCode());
            if (codeExists) {
                throw new ServiceException("属性编码已经存在，请重新输入");
            }
            if (form.getMaxLength() <= 0) {
                throw new ServiceException("属性长度只允许输入正整数");
            }
            extendAttributeDAO.saveOrUpdate(form.getExtendAttribute());
        } else {//表示编辑
            ExtendAttribute extendAttribute = findById(form.getId());
            //只更新能编辑的，其它的都不更新
            extendAttribute.setDefaultValue(form.getDefaultValue());
            extendAttribute.setDescription(form.getDescription());
            extendAttribute.setEnabled(form.isEnabled());
            extendAttribute.setName(form.getName());
        }
    }

    @Transactional
    public void deleteByIds(Long[] ids) {
        for (Long id : ids) {
            extendAttributeDAO.deleteById(id);
        }
    }

    @Transactional(readOnly = true)
    public ExtendAttribute findById(Long id) {
        return extendAttributeDAO.findById(id);
    }
}
