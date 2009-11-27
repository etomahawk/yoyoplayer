/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service.enterprise;

import com.chinacnd.b2b.paper.dao.enterprise.AreaDAO;
import com.chinacnd.b2b.paper.entities.enterprise.Area;
import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.form.admin.enterprise.AreaForm;
import com.chinacnd.framework.db.Page;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Genius
 */
public class AreaService {

    @Resource
    private AreaDAO areaDAO;

    /*
     *根据父AreaID取得子Area列表
     */
    @Transactional(readOnly = true)
    public List<Area> loadListByParentAreaID(Long areaID) {
        return areaDAO.loadListByParentAreaID(areaID);
    }

    @Transactional(readOnly = true)
    public List<Area> loadListByParentAreaID(Long areaID, AreaForm form) {
        Page page = new Page();
        page.setLimit(form.getLimit());
        page.setStart(form.getStart());
        List<Area> areaList = areaDAO.loadListByParentAreaID(areaID, page);
        form.setTotalSize(page.getPageCount());
        return areaList;
    }

    /*
     * 取得根节点Area列表
     */
    @Transactional(readOnly = true)
    public List<Area> loadRootList() {
        return areaDAO.loadRootList();
    }

    @Transactional(readOnly = true)
    public List<Area> loadRootList(AreaForm form) {
        Page page = new Page();
        page.setLimit(form.getLimit());
        page.setStart(form.getStart());
        List<Area> areaList = areaDAO.loadRootList(page);
        form.setTotalSize(page.getPageCount());
        return areaList;
    }

    /**
     * 保存Area
     * @param form
     */
    @Transactional
    public void saveArea(AreaForm form) throws ServiceException {
        if (areaDAO.getAreaCountByCode(form.getCode()) > 0) {
            throw new ServiceException("已存在该地区编码");
        }

        Area parentArea = areaDAO.get(form.getParentAreaID());
        Area area = new Area();
        area.setCode(form.getCode());
        area.setName(form.getName());
        area.setDescription(form.getDescription());
        //组装FullCode
        if (parentArea != null) {
            area.setFullCode(parentArea.getFullCode() + "_" + form.getCode());
        }
        else {
            //顶级地区
            area.setFullCode(form.getCode());
        }
        area.setParent(parentArea);
        areaDAO.save(area);
    }

    /*
     * 更新Area
     */
    @Transactional
    public void updateArea(AreaForm form){
        Area area = areaDAO.get(form.getId());
        area.setName(form.getName());
        area.setDescription(form.getDescription());
        areaDAO.save(area);
    }

    /*
     * 删除Area
     */
    @Transactional
    public void deleteArea(AreaForm form) throws ServiceException {
        String[] ids = form.getAreaIds().split(",");
        for (String id : ids) {
            if (loadListByParentAreaID(Long.valueOf(id)).size() > 0) {
                throw new ServiceException("该地区包含下级地区，不能删除");
            }
            areaDAO.delete(Long.valueOf(id));
        }
    }
}
