/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.dao.enterprise;

import com.chinacnd.b2b.paper.entities.enterprise.Enterprise;
import com.chinacnd.framework.db.EntityDAO;
import com.chinacnd.framework.db.NamedQuery;
import com.chinacnd.framework.db.Page;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Genius
 */
public class EnterpriseDAO extends EntityDAO<Enterprise> {

    /**
     * 根据Area的FullCode模糊查找Enterprise
     * @param areaFullCode
     * @param page
     * @return
     */
    public List<Enterprise> loadListByAreaFullCode(String areaFullCode, Page page) {
        NamedQuery nq = new NamedQuery("Enterprise.loadListByAreaFullCode");
        nq.addParameter("fullCode", areaFullCode + "%");
        return this.findByNamedQuery(nq, page);
    }

    /**
     * 查找�?��的Enterprise
     * @param page
     * @return
     */
    @Override
    public List<Enterprise> findAll(Page page) {
        return super.findAll(page);
    }

    /**
     * 取得Enterprise对象
     * @param id
     * @return
     */
    @Override
    public Enterprise get(Serializable id) {
        return super.get(id);
    }

    /**
     * 保存Enterprise
     * @param entity
     */
    @Override
    public void save(Object entity) {
        super.save(entity);
    }

    /**
     * 更新Enterprise
     * @param entity
     */
    @Override
    public void update(Enterprise entity) {
        super.update(entity);
    }

    /**
     * 根据ID删除Enterprise
     * @param id
     */
    public void delete(Serializable id) {
        super.deleteById(id);
    }
}
