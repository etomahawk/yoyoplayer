package com.chinacnd.framework.util;

/**
 * @author Hades
 */
public class EnumUtils {

    public static <T extends Enum<T>> T toEnum(Class<T> enumType, String value, T defaultValue) {
        try {
            return Enum.valueOf(enumType, value);
        } catch (IllegalArgumentException e) {
            return defaultValue;
        }
    }
}
