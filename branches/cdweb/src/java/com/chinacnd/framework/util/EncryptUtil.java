package com.chinacnd.framework.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Wingel
 */
public class EncryptUtil {
    public static String byMD5(String string) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        byte[] bytes = string.getBytes();
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        messageDigest.update(bytes);
        byte[] md = messageDigest.digest();
        int j = md.length;
        char[] str = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = md[i];
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

//    public static void main(String[] args) {
//        System.out.print(EncryptUtil.byMD5("XX"));
//    }
}