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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 贸易关系
 * @author roger
 */
@Entity
@Table(name = "ct_ent_trade_relation")
public class TradeRelationship extends IdEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "branch_id")
    private Enterprise branch;//分公司
    @ManyToOne(optional = false)
    @JoinColumn(name = "partner_id")
    private Enterprise partner;//对应企业
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expired_date")
    private Date expiredDate;//有效日期

    public Enterprise getBranch() {
        return branch;
    }

    public void setBranch(Enterprise branch) {
        this.branch = branch;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Enterprise getPartner() {
        return partner;
    }

    public void setPartner(Enterprise partner) {
        this.partner = partner;
    }
}
