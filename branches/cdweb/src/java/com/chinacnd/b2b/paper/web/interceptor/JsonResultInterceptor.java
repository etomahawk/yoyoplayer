/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.interceptor;

import com.chinacnd.framework.struts.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import java.util.Map;

/**
 *
 * @author Hadeslee
 */
public class JsonResultInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        invocation.addPreResultListener(new PreResultListener() {

            public void beforeResult(ActionInvocation invocation, String result) {
                if (BaseAction.JSON_RESULT.equals(result)) {
                    Object map = ((BaseAction) invocation.getAction()).getJsonRoot();
                    invocation.getStack().set("__JSON_ROOT__", map);
                }
            }
        });
        String result = invocation.invoke();
        if (!invocation.isExecuted() && BaseAction.JSON_RESULT.equals(result)) {
            Object map = ((BaseAction) invocation.getAction()).getJsonRoot();
            invocation.getStack().set("__JSON_ROOT__", map);
        }
        return result;
    }
}
