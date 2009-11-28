/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service.user;

import com.chinacnd.b2b.paper.dao.user.AdminUserDAO;
import com.chinacnd.b2b.paper.entities.user.AdminUser;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hadeslee
 */
public class AdminUserService {

    @Resource
    private AdminUserDAO adminUserDAO;

    @Transactional(readOnly = true)
    public AdminUser login(String username, String password) {
        return adminUserDAO.login(username, password);

    }
}
