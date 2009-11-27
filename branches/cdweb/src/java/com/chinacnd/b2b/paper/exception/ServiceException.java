/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.exception;

/**
 * 业务异常超类，所有业务异常都要继承此类
 * 当前在业务方法中抛出此异常，需要在@Trainsaction中指定 rollback-for=ServiceException
 * @author Hadeslee
 */
public class ServiceException extends Exception {

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            return toString();
        } else {
            return message;
        }
    }
}

