/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service;

import com.chinacnd.b2b.paper.entities.user.AdminUser;
import com.chinacnd.b2b.paper.service.user.AdminUserService;
import com.chinacnd.framework.db.DataAccess;
import com.chinacnd.framework.util.MD5;
import com.chinacnd.integration.test.BaseTest;
import javax.annotation.Resource;
import org.junit.Test;

/**
 *
 * @author Hadeslee
 */
public class LoginServiceTest extends BaseTest {

    @Resource
    private AdminUserService loginService;
    @Resource
    private DataAccess dataAccess;

    @Test
    public void testLogin() {
        AdminUser user = new AdminUser();
        user.setUsername("hadeslee");
        user.setFullname("千里冰封");
        user.setPassword(MD5.digest("a12345"));
        dataAccess.save(user);
        Long id = user.getId();
        assertNotNull(id);
        AdminUser login = loginService.login("hadeslee", "a12345");
        assertNotNull(login);
        assertEquals(user.getFullname(), login.getFullname());
        assertEquals(user.getUsername(), login.getUsername());
        AdminUser notValid = loginService.login("hahaha", "23412414");
        assertNull(notValid);
    }
}
