/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.dao.enterprise;

import com.chinacnd.b2b.paper.entities.enterprise.Area;
import com.chinacnd.framework.db.EntityDAO;
import com.chinacnd.framework.db.NamedQuery;
import com.chinacnd.framework.db.Page;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Genius
 */
public class AreaDAO extends EntityDAO<Area> {

    public List<Area> loadListByParentAreaID(long parentAreaID) {
        NamedQuery nq = new NamedQuery("Area.findByParentId");
        nq.addParameter("id", parentAreaID);
        return this.findByNamedQuery(nq);
    }

    public List<Area> loadListByParentAreaID(long parentAreaID, Page page) {
        NamedQuery nq = new NamedQuery("Area.findByParentId");
        nq.addParameter("id", parentAreaID);
        return this.findByNamedQuery(nq, page);
    }

    public List<Area> loadRootList() {
        NamedQuery nq = new NamedQuery("Area.findRootAreas");
        return this.findByNamedQuery(nq);
    }

    public List<Area> loadRootList(Page page) {
        NamedQuery nq = new NamedQuery("Area.findRootAreas");
        return this.findByNamedQuery(nq, page);
    }

    public long getAreaCountByCode(String code) {
        NamedQuery nq = new NamedQuery("Area.getAreaCountByCode");
        nq.addParameter("code", code);
        return ((Number)findUniqueResult(nq)).longValue();
    }

    @Override
    public Area get(Serializable id) {
        return super.get(id);
    }

    @Override
    public void save(Object entity) {
        super.save(entity);
    }

    public void delete(long id) {
        super.deleteById(id);
    }


}
