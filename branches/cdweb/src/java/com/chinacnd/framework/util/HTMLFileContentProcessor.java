/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.framework.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author zongchuan.yu
 */
public class HTMLFileContentProcessor implements TextFileContentProccessor {

    public static final String PATTERN_LINK = "<\\s*(a|link)[^>]+>";
    public static final String PATTERN_SRC = "<\\s*(img|script|input)[^>]+>";
    public static final String PATTERN_CSS_IMAGE = "url\\s*\\(\\s*[\"']?[^ \t\n\r\f\"<>]+";
    public static final String PATTERN_JAVASCRIPT_IMAGE = "backgroundImage\\s*=\\s*[\"']?[^ \t\n\r\f\"<>]+";
    public static final String PATTERN_BACKGROUND_IMAGE = "background\\s*=\\s*[\"']?[^ \t\n\r\f\"<>]+";
    private String rootURL;

    public HTMLFileContentProcessor(String rootURL) {
        this.rootURL = rootURL;
    }

    /**
     * 替换相对路径 replace link/css(href), img/javascript(src)
     * @param rootURL
     * @param content
     * @return
     */
    @Override
    public String proccess(String content) {
        String value = content;
        value = replaceLinks(PATTERN_LINK, rootURL, value);
        value = replaceLinks(PATTERN_SRC, rootURL, value);
        value = replaceLinks(PATTERN_JAVASCRIPT_IMAGE, rootURL, value);
        value = replaceLinks(PATTERN_BACKGROUND_IMAGE, rootURL, value);
        value = replaceCssImages(PATTERN_CSS_IMAGE, rootURL, value);
        return value;
    }

    private String replaceLinks(String pattern, String rootURL, String content) {
        Pattern p1, p2;
        Matcher m1, m2;
        String value, prefix, quote, urlPrefix, url, absoluteUrl;
        String tagName = "href";
        value = content;
        p1 = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        m1 = p1.matcher(value);
        while (m1.find()) {
            url = m1.group();
            if (url.toLowerCase().indexOf("http://") < 0 && // http:// prefix not
                    // found
                    url.toLowerCase().indexOf("https://") < 0 || // https:// prefix not
                    // found
                    (url.toLowerCase().indexOf("?") > 0 && // http:// prefix found but in
                    // url parameters
                    url.toLowerCase().indexOf("http", url.toLowerCase().indexOf("?")) > 0 && url.substring(0, url.indexOf("?")).indexOf("http") < 0)) {
                if (PATTERN_LINK.equals(pattern)) {
                    tagName = "href";
                } else if (PATTERN_SRC.equals(pattern)) {
                    tagName = "src";
                } else if (PATTERN_JAVASCRIPT_IMAGE.equals(pattern)) {
                    tagName = "backgroundImage";
                } else if (PATTERN_BACKGROUND_IMAGE.equals(pattern)) {
                    tagName = "background";
                }
                p2 = Pattern.compile(tagName + "\\s*=\\s*[\"']?",
                        Pattern.CASE_INSENSITIVE);
                m2 = p2.matcher(url);
                while (m2.find()) {
                    prefix = m2.group();
                    if (prefix.indexOf("\"") > 0) {
                        quote = tagName + "=\"";
                    } else if (prefix.indexOf("'") > 0) {
                        quote = tagName + "='";
                    } else {
                        quote = tagName + "=";
                    }
                    urlPrefix = quote + rootURL;
                    absoluteUrl = url.replace(prefix, urlPrefix);
                    if (url.indexOf(":/") > 0 || url.indexOf(":\\") > 0) { // absolute
                        // file system
                        // path
                        if (url.indexOf(":/") > 0) {
                            absoluteUrl = absoluteUrl.replace(absoluteUrl.substring(
                                    absoluteUrl.lastIndexOf(":") - 1, absoluteUrl.lastIndexOf("/") + 1), "");
                        } else {
                            absoluteUrl = absoluteUrl.replace(absoluteUrl.substring(
                                    absoluteUrl.lastIndexOf(":") - 1, absoluteUrl.lastIndexOf("\\") + 1), "");
                        }
                    }
                    int urlIndex = value.indexOf(url);
                    while (urlIndex > -1) {
                        value = value.replace(url, absoluteUrl);
                        urlIndex = value.indexOf(url, urlIndex + absoluteUrl.length());
                    }
                    // url = Pattern.quote(url);
                    // value = value.replaceAll(url, absoluteUrl);
                    value = value.replaceAll(rootURL + "#", "#");
                    value = Pattern.compile(rootURL + "mailto",
                            Pattern.CASE_INSENSITIVE).matcher(value).replaceAll("mailto");
                    break;
                }
            }
        }
        return value;
    }

    private String replaceCssImages(String pattern, String rootURL, String content) {
        Pattern p1, p2;
        Matcher m1, m2;
        String value, prefix, quote, urlPrefix, url, absoluteUrl;
        value = content;
        p1 = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        m1 = p1.matcher(value);
        while (m1.find()) {
            url = m1.group();
            if (url.toLowerCase().indexOf("http://") < 0 && // http:// prefix not
                    // found
                    url.toLowerCase().indexOf("https://") < 0 || // https:// prefix not
                    // found
                    (url.toLowerCase().indexOf("?") > 0 && // http:// prefix found but in
                    // url parameters
                    url.toLowerCase().indexOf("http", url.toLowerCase().indexOf("?")) > 0 && url.substring(0, url.indexOf("?")).indexOf("http") < 0)) {
                p2 = Pattern.compile("\\(\\s*[\"']?", Pattern.CASE_INSENSITIVE);
                m2 = p2.matcher(url);
                while (m2.find()) {
                    prefix = m2.group();
                    if (prefix.indexOf("\"") > 0) {
                        quote = "(\"";
                    } else if (prefix.indexOf("'") > 0) {
                        quote = "('";
                    } else {
                        quote = "(";
                    }
                    urlPrefix = quote + rootURL;
                    absoluteUrl = url.replace(prefix, urlPrefix);
                    if (url.indexOf(":/") > 0 || url.indexOf(":\\") > 0) { // absolute
                        // file system
                        // path
                        if (url.indexOf(":/") > 0) {
                            absoluteUrl = absoluteUrl.replace(absoluteUrl.substring(
                                    absoluteUrl.lastIndexOf(":") - 1, absoluteUrl.lastIndexOf("/") + 1), "");
                        } else {
                            absoluteUrl = absoluteUrl.replace(absoluteUrl.substring(
                                    absoluteUrl.lastIndexOf(":") - 1, absoluteUrl.lastIndexOf("\\") + 1), "");
                        }
                    }
                    url = Pattern.quote(url);
                    value = value.replaceAll(url, absoluteUrl);
                    break;
                }
            }
        }
        return value;
    }
}
