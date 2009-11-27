/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.action.admin;

import com.chinacnd.b2b.paper.entities.user.AdminUser;
import com.chinacnd.b2b.paper.entities.user.Gender;
import com.chinacnd.b2b.paper.helper.form.admin.LoginForm;
import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.b2b.paper.service.user.AdminUserService;
import com.chinacnd.b2b.paper.web.interceptor.NotNeedToLogin;
import com.chinacnd.framework.struts.BaseAction;
import com.chinacnd.framework.struts.ResultType;
import com.chinacnd.framework.struts.SessionContext;
import com.chinacnd.framework.util.MD5;
import com.opensymphony.xwork2.ModelDriven;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author Hadeslee
 */
@Results({
    @Result(name = "success", type = ResultType.json, params = {"root", "json", "excludeNullProperties", "true"})
})
@NotNeedToLogin
public class LoginAction extends BaseAction implements ModelDriven<LoginForm> {

    private LoginForm form = new LoginForm();
    @Resource
    private AdminUserService adminUserService;
    private OperationResultJson json = new OperationResultJson();

    //此方法用于建用户，测试用，
    @Action("add-user")
    public String addUser() {
        AdminUser adminUser = new AdminUser();
        adminUser.setAddress("中国厦门");
        adminUser.setEnabled(true);
        adminUser.setFullname("管理员");
        adminUser.setGender(Gender.MALE);
        adminUser.setUsername(form.getUsername());
        adminUser.setPassword(MD5.digest(form.getPassword()));
        adminUserService.saveAdminUser(adminUser);
        return "success";
    }

    @Action("login")
    public String login() {
        AdminUser adminUser = adminUserService.login(form.getUsername(), form.getPassword());
        if (adminUser == null) {
            json.setMessage("用户名或密码错误!");
            json.setSuccess(false);
        } else {
            json.setSuccess(true);
            SessionContext sessionContext = getSessionContext();
            sessionContext.setAdminUser(adminUser);
        }
        return "success";
    }

    @Action("logout")
    public String logout() {
        ServletActionContext.getRequest().getSession().invalidate();
        return "success";
    }

    public LoginForm getModel() {
        return form;
    }

    public OperationResultJson getJson() {
        return json;
    }
}
