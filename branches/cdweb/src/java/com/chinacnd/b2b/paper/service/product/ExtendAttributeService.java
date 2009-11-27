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
    public List<ExtendAttribute> getExtendAttributesByName(ExtendAttributeForm form) {
        String name = form.getName();
        Page page = Page.from(form);
        OrderBy orderBy = OrderBy.from(form);
        List<ExtendAttribute> list = extendAttributeDAO.getExtendAttributesByName(name, page, orderBy);
        form.setTotalSize(page.getTotalCount());
        return list;
    }

    @Transactional
    public void save(ExtendAttributeForm form) throws ServiceException {
        boolean codeExists = extendAttributeDAO.checkCodeExists(form.getId(), form.getCode());
        if (codeExists) {
            throw new ServiceException("属性编码已经存在，请重新输入");
        } else {
            extendAttributeDAO.saveOrUpdate(form.getExtendAttribute());
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
