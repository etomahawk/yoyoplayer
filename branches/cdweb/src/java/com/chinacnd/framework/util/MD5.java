/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.framework.util;

import java.security.MessageDigest;

/**
 *
 * @author zongchuan.yu
 */
public class MD5 {

    /**
     * 生成一个32位长的MD5摘要字串。
     * 如果字符串是null，则返回null
     * 如果字符串是空，则返回空，其它的就计算其MD5码
     * @param source
     * @return 32位长的摘要字串
     */
    public static String digest(String source) {
        if (source == null) {
            return null;
        } else if (source.trim().equals("")) {
            return "";
        }
        StringBuilder dist = new StringBuilder();
        try {
            byte[] tmp = MessageDigest.getInstance("MD5").digest((source).getBytes());
            for (byte b : tmp) {
                dist.append(String.format("%02X", b));
            }
        } catch (Exception ex) {
            dist.append(String.format("%032d", System.currentTimeMillis()));
        }
        return dist.toString().toLowerCase();
    }

    public static void main(String[] args) {
        //those test are from RFC1321
        System.out.println(digest("admin"));
    }

    private static void testMD5(String source, String purposeDigest) {
        final String MyDigest = digest(source);
        System.out.println("source:" + source + "   digest:" + purposeDigest + " mydigest:" + MyDigest + " result:" + MyDigest.equals(purposeDigest));
    }
}
