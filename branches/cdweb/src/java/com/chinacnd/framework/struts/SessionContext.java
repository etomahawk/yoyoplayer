/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.framework.struts;

import com.chinacnd.b2b.paper.entities.user.AdminUser;
import com.opensymphony.xwork2.ActionContext;
import java.io.Serializable;
import java.util.Map;

/**
 * 所有需要放在session中的数据都应该放在此类中
 * 这样可以保证在session中只有一份数据
 * @author Hadeslee
 */
public class SessionContext implements Serializable {

    private static final long serialVersionUID = 20091122L;
    public static final String KEY_IN_SESSION = "__SessionContext__";
    //private ClientUser clientUser;//会员用户
    private AdminUser adminUser;//总公司用户

    public static SessionContext getSessionContext() {
        Map<String, Object> map = ActionContext.getContext().getSession();
        SessionContext sessionContext = (SessionContext) map.get(SessionContext.KEY_IN_SESSION);
        if (sessionContext == null) {
            sessionContext = new SessionContext();
            map.put(SessionContext.KEY_IN_SESSION, sessionContext);
        }
        return sessionContext;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

//    public ClientUser getClientUser() {
//        return clientUser;
//    }
//
//    public void setClientUser(ClientUser clientUser) {
//        this.clientUser = clientUser;
//    }
}
