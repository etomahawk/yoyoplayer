/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.enterprise;

import com.chinacnd.framework.db.IdEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 地区
 * @author roger
 */
@Entity
@Table(name = "ct_ent_area")
@NamedQueries({
    @NamedQuery(name = "Area.findByParentId", query = "select a from Area a where a.parent.id=:id"),
    @NamedQuery(name = "Area.findRootAreas", query = "select a from Area a where a.parent is null"),
    @NamedQuery(name = "Area.getAreaCountByCode", query = "select count(a) from Area a where a.code = :code")
})
public class Area extends IdEntity {

    @Column(name = "code", nullable = false, length = 32)
    private String code;//地区编码
    @Column(name = "name", length = 64)
    private String name;//地区名字
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Area parent;//上一级地区
    @Column(name = "description", length = 4000)
    private String description;//描述
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date")
    private Date lastUpdateDate;//最后更新日期
    @Column(name = "full_code")
    private String fullCode;//便于搜索，将从root至本身的编码以!拼接起来

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Area getParent() {
        return parent;
    }

    public void setParent(Area parent) {
        this.parent = parent;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getFullCode() {
        return fullCode;
    }

    public void setFullCode(String fullCode) {
        this.fullCode = fullCode;
    }
}
