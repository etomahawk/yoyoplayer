/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.interceptor;

import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.framework.struts.BaseAction;
import com.chinacnd.framework.struts.SessionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.lang.reflect.Method;
import org.apache.log4j.Logger;

/**
 *
 * @author Hadeslee
 */
public class NeedLoginInterceptor extends AbstractInterceptor {

    private static final Logger log = Logger.getLogger(NeedLoginInterceptor.class);

    public String intercept(ActionInvocation invocation) throws Exception {
        BaseAction targetAction = (BaseAction) invocation.getAction();
        if (notNeedToLoginForWholeClass(targetAction) && notNeedToLoginForWholeMethod(targetAction, invocation)) {
            SessionContext context = SessionContext.getSessionContext();
            if (context.getAdminUser() == null) {
                OperationResultJson json = new OperationResultJson();
                json.setTimeout(true);
                json.setSuccess(false);
                json.setMessage("当前会话超时，请重新登录!");
                targetAction.setJsonObject(json);
                return BaseAction.JSON_RESULT;
            }
        }
        return invocation.invoke();
    }

    private boolean notNeedToLoginForWholeClass(Object targetAction) {
        return targetAction.getClass().getAnnotation(NotNeedToLogin.class) == null;
    }

    private boolean notNeedToLoginForWholeMethod(Object targetAction, ActionInvocation invocation) {
        try {
            Method method = targetAction.getClass().getMethod(invocation.getProxy().getMethod());
            return method.getAnnotation(NotNeedToLogin.class) == null;
        } catch (Exception e) {
            log.warn("error while getting NotNeedToLogin annotation for action method", e);
            return true;
        }
    }
}
