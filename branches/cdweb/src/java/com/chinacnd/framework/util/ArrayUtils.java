package com.chinacnd.framework.util;

public class ArrayUtils {

    public static <T> T[] array(T... items) {
        return items;
    }

    public static String string(Object[] items, String split) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            if (i > 0) {
                builder.append(split);
            }
            builder.append(items[i]);
        }
        return builder.toString();
    }

    public static <T> boolean hasItem(T[] array) {
        return array != null && array.length > 0;
    }

    public static <T> boolean contains(T[] array, T target) {
        if (array == null) {
            return false;
        }
        for (T item : array) {
            if (item != null && item.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
