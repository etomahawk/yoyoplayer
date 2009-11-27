/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service.product;

import com.chinacnd.b2b.paper.dao.product.MeasureUnitDAO;
import com.chinacnd.b2b.paper.entities.product.MeasureUnit;
import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.form.admin.product.MeasureUnitForm;
import com.chinacnd.framework.db.OrderBy;
import com.chinacnd.framework.db.Page;
import com.chinacnd.framework.util.BeanUtils;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hadeslee
 */
public class MeasureUnitService {

    @Resource
    private MeasureUnitDAO measureUnitDAO;

    @Transactional(readOnly = true)
    public MeasureUnit findById(Long id) {
        return measureUnitDAO.findById(id);
    }

    @Transactional
    public void save(MeasureUnitForm form) throws ServiceException {
        if (measureUnitDAO.checkNameExists(form.getId(), form.getName())) {
            throw new ServiceException("名称已经存在，请重新输入");
        }
        MeasureUnit mu = null;
        //如果是新增，则要检查编码是否重复
        if (form.getId() == null || form.getId() <= 0) {
            if (measureUnitDAO.checkCodeExists(form.getCode())) {
                throw new ServiceException("编码已经存在，请重新输入");
            }
            mu = new MeasureUnit();
            BeanUtils.copyProperties(form, mu);
        }
        //如果是基准单位，则要同时启用，并且把所有的记录都设为非基准单位
        if (form.isBenchmark()) {
            if (form.isEnabled() == false) {
                throw new ServiceException("基准单位必须启用");
            }
            measureUnitDAO.disableAllBenchmark();
        }
        if (form.getId() != null && form.getId() > 0) {
            mu = measureUnitDAO.findById(form.getId());
            BeanUtils.copyProperties(form, mu, "code", "id");
        }
        measureUnitDAO.saveOrUpdate(mu);
    }

    @Transactional
    public void deleteById(Long id) {
        measureUnitDAO.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<MeasureUnit> list(MeasureUnitForm form) {
        Page page = Page.from(form);
        OrderBy orderBy = OrderBy.from(form);
        List<MeasureUnit> list = measureUnitDAO.list(page, orderBy);
        form.setTotalSize(page.getTotalCount());
        return list;
    }
}
