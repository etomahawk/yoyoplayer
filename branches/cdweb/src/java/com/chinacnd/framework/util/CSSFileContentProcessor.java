/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.framework.util;

/**
 *
 * @author zongchuan.yu
 */
public class CSSFileContentProcessor implements TextFileContentProccessor {

    private static final String KEY = "url\\(";
    private String rootURL;

    public CSSFileContentProcessor(String rootURL) {
        this.rootURL = rootURL;
    }

    public String proccess(String content) {
        return content.replaceAll(KEY, KEY + rootURL);
    }
}
