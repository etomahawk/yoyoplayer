package com.chinacnd.framework.util;

/**
 * @author Hades
 */
public class Convert {

    public static double toDouble(String number) {
        if (!StringUtils.hasText(number)) {
            return 0;
        }
        return Double.parseDouble(number);
    }

    public static boolean toBoolean(String bool) {
        return "true".equals(bool);
    }

    public static int getInt(Integer i) {
        if (i == null) {
            return 0;
        } else {
            return i.intValue();
        }
    }

    public static boolean getBoolean(Boolean b) {
        if (b == null) {
            return false;
        } else {
            return b.booleanValue();
        }
    }
}
