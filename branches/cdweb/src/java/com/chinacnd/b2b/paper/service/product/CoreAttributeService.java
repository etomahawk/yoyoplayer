/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service.product;

import com.chinacnd.b2b.paper.dao.product.CoreAttributeDAO;
import com.chinacnd.b2b.paper.entities.product.CoreAttribute;
import com.chinacnd.b2b.paper.entities.product.CoreAttributeType;
import com.chinacnd.b2b.paper.helper.form.admin.product.CoreAttributeForm;
import com.chinacnd.framework.db.OrderBy;
import com.chinacnd.framework.db.Page;
import java.util.List;
import javax.annotation.Resource;

/**
 *
 * @author Hadeslee
 */
public class CoreAttributeService {

    @Resource
    private CoreAttributeDAO coreAttributeDAO;

    public List<CoreAttribute> getCoreAttribute(CoreAttributeForm form) {
        CoreAttributeType type = CoreAttributeType.getCoreAttributeTypeByName(form.getAttributeType());
        Page page = Page.from(form);
        List<CoreAttribute> list = coreAttributeDAO.getCoreAttributeByType(type, page, OrderBy.from(form));
        form.setTotalSize(page.getTotalCount());
        return list;
    }
}
