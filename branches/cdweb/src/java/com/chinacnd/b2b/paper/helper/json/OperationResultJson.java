/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.helper.json;

import java.util.Map;

/**
 * 一般AJAX请求操作的返回对象，用于指示
 * 此次操作是成功还是失败。
 * @author Hadeslee
 */
public class OperationResultJson {

    private Map<String, String> errors;//错误信息，KEY是input域的name,value是对应的错误信息
    private String message;
    private boolean success = true;
    private boolean timeout;

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isTimeout() {
        return timeout;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTimeout(boolean timeout) {
        this.timeout = timeout;
    }
}
