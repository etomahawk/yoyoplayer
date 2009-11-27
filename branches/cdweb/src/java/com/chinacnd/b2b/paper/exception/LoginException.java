/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.exception;

/**
 *
 * @author Hadeslee
 */
public class LoginException extends ServiceException {

    public LoginException(Throwable cause) {
        super(cause);
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
