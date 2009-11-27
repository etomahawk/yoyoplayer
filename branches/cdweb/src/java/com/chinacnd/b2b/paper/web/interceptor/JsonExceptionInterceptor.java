/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.interceptor;

import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.framework.struts.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.log4j.Logger;

/**
 * 处理异常的拦截器，用于总公司和分公司，因为这两块是以JSON的形式
 * 前后台交互的，所以出了异常以后，不能像别的普通系统一样转到一个页面
 * 我们必须要返回一个JSON对象
 * @author Hadeslee
 */
public class JsonExceptionInterceptor extends AbstractInterceptor {

    private static Logger log = Logger.getLogger(JsonExceptionInterceptor.class);

    @Override
    public String intercept(ActionInvocation a) throws Exception {
        try {
            return a.invoke();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("拦截器拦截到异常", ex);
            handleException(a, ex);
            return BaseAction.JSON_RESULT;
        }
    }

    /**
     * 处理异常，把当前的异常信息封装到一个对象，然后
     * 让这个对象处理当前栈顶，并序列化成JSON，发送到
     * 前台去
     * @param a 当前action的调用上下文
     * @param e 发生的异常
     */
    private void handleException(ActionInvocation a, Exception e) {
        OperationResultJson json = new OperationResultJson();
        json.setMessage(e.getMessage() == null ? e.toString() : e.getMessage());
        json.setSuccess(false);
        BaseAction action = (BaseAction) a.getAction();
        action.setJsonObject(json);
    }
}
