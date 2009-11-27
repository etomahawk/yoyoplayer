package com.chinacnd.framework.util;

import java.util.List;

public class QLUtils {

    public static String replaceInToken(String tokenName, List<?> filterIds, String hql) {
        return hql.replace(tokenName, "(" + CollectionUtils.toDelimitedString(filterIds, ",") + ")");
    }

    public static String generateQuetionToken(int columnCount) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < columnCount; i++) {
            builder.append("?");
            if (i != columnCount - 1) {
                builder.append(",");
            }
        }
        return builder.toString();
    }
}
