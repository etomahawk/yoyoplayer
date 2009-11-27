/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.dao.user;

import com.chinacnd.b2b.paper.entities.user.AdminUser;
import com.chinacnd.framework.db.EntityDAO;
import com.chinacnd.framework.db.NamedQuery;
import com.chinacnd.framework.util.MD5;

/**
 *
 * @author Hadeslee
 */
public class AdminUserDAO extends EntityDAO<AdminUser> {

    public AdminUser login(String username, String password) {
        NamedQuery query = new NamedQuery("AdminUser.login");
        query.addParameter("username", username).addParameter("password", MD5.digest(password));
        return findUniqueResult(query);
    }

    public void saveAdminUser(AdminUser adminUser) {
        this.saveOrUpdate(adminUser);
    }
}
