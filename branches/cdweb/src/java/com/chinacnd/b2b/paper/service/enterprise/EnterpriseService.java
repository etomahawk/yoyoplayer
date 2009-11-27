/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service.enterprise;

import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.dao.enterprise.AreaDAO;
import com.chinacnd.b2b.paper.dao.enterprise.EnterpriseDAO;
import com.chinacnd.b2b.paper.entities.enterprise.Area;
import com.chinacnd.b2b.paper.entities.enterprise.Enterprise;
import com.chinacnd.b2b.paper.helper.form.admin.enterprise.EnterpriseForm;
import com.chinacnd.framework.db.Page;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Genius
 */
public class EnterpriseService {

    @Resource
    private EnterpriseDAO enterpriseDAO;
    @Resource
    private AreaDAO areaDAO;

    @Transactional(readOnly = true)
    public List<Enterprise> loadListByAreaFullCode(EnterpriseForm form) {
        Page page = new Page();
        List<Enterprise> entList = null;
        page.setLimit(form.getLimit());
        page.setStart(form.getStart());
        if (form.getAreaID() == -1) {
            //查找全部
            entList = enterpriseDAO.findAll(page);
        } else {
            Area area = areaDAO.get(form.getAreaID());
            entList = enterpriseDAO.loadListByAreaFullCode(area.getFullCode(), page);
        }
        form.setTotalSize(page.getTotalCount());

        return entList;
    }

    /**
     * 保存企业信息Enterprise
     * @param form
     * @throws ServiceException
     */
    @Transactional
    public void saveEnterprise(EnterpriseForm form) throws ServiceException {
        Area area = null;

        if(form.getAreaID() != -1) {
            area = areaDAO.get(form.getAreaID());

            if(area == null) {
                throw new ServiceException("地区信息为空！");
            }
        }

        Enterprise ent = new Enterprise();
        ent.setAddress(form.getAddress());
        ent.setCode(form.getCode());
        ent.setDescription(form.getDescription());
        ent.setEmail(form.getEmail());
        ent.setEnabled(form.isEnabled());
        ent.setFax(form.getFax());
        ent.setKind(form.getKind());
        ent.setLinkman(form.getLinkman());
        ent.setLocation(area);
        ent.setName(form.getName());
        ent.setPostcode(form.getPostcode());
        ent.setTelephone(form.getTelephone());
        ent.setType(form.getType());
        ent.setLastUpdateDate(new Date());

        enterpriseDAO.save(ent);
    }

    @Transactional
    public void updateEnterprise(EnterpriseForm form) throws ServiceException {
        Enterprise ent = enterpriseDAO.get(form.getId());
        if(ent == null) {
            throw new ServiceException("企业信息为空！");
        }

        ent.setAddress(form.getAddress());
        ent.setDescription(form.getDescription());
        ent.setEmail(form.getEmail());
        ent.setEnabled(form.isEnabled());
        ent.setFax(form.getFax());
        ent.setLinkman(form.getLinkman());
        ent.setName(form.getName());
        ent.setPostcode(form.getPostcode());
        ent.setTelephone(form.getTelephone());
        ent.setLastUpdateDate(new Date());

        enterpriseDAO.update(ent);
    }

    /*
     * 删除Enterprise
     */
    @Transactional
    public void deleteEnterprise(EnterpriseForm form) {
        String[] ids = form.getEnterpriseIds().split(",");
        for (String id : ids) {
            enterpriseDAO.delete(Long.valueOf(id));
        }
    }
}
